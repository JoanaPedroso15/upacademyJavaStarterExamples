package io.altar.stockAngular.services;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.BadRequestException;

import io.altar.stockAngular.models.User;
import io.altar.stockAngular.models.DTOS.UserDTO;
import io.altar.stockAngular.models.User.Role;
import io.altar.stockAngular.repositories.UserRepository;
import io.altar.stockAngular.utils.PasswordUtils;

@RequestScoped
public class UserService extends EntityService<UserRepository, User, UserDTO> {

	public void createUser(UserDTO userDTO) {

		User user = new User();

		String password = userDTO.getPassword();
		String[] hashCode = passwordToHashcode(password);

		user.setName(userDTO.getName());
		user.setEmail(userDTO.getEmail());
		user.setHashcode(hashCode[0]);
		user.setSalt(hashCode[1]);
		user.setRole(Role.valueOf(userDTO.getRole()));
		repository.addEntity(user);

	}

	public User checkIfUserValid(UserDTO userDTO) throws Exception {
		User user = repository.findUserByEmail(userDTO.getEmail());
		if (user == null) {
			throw new IllegalArgumentException(
					String.format("No %s with Email [%s].",getEntityClassName() ,userDTO.getEmail()));
		}
		
		String key = user.getHashcode();
		String salt = user.getSalt();

		if (!PasswordUtils.verifyPassword(userDTO.getPassword(), key, salt)) {
			throw new BadRequestException("Invalid Password");
		}

		return user;
	}

	private String[] passwordToHashcode(String password) {
		String salt = PasswordUtils.generateSalt(50).get();
		String key = PasswordUtils.hashPassword(password, salt).get();
		String[] result = { key, salt };
		return result;
	}

	@Override
	protected String getEntityClassName() {
		return User.getClassName();
	}

	@Override
	protected boolean canDelete(User entity) {
		// TODO Auto-generated method stub
		return true;
	}
}
