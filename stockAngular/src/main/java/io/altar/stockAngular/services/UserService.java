package io.altar.stockAngular.services;

import java.util.Collection;
import java.util.stream.Collectors;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.core.MultivaluedMap;

import io.altar.stockAngular.models.User;
import io.altar.stockAngular.models.User.Role;
import io.altar.stockAngular.models.DTOS.UserDTO;
import io.altar.stockAngular.repositories.UserRepository;
import io.altar.stockAngular.utils.PasswordUtils;

@RequestScoped
public class UserService extends EntityService<UserRepository, User> {

	@Inject
	StoreService SS;
	
	public void createUser(UserDTO userDTO) {

		User user = new User();

		String password = userDTO.getPassword();
		String[] hashCode = passwordToHashcode(password);

		user.setName(userDTO.getName());
		user.setEmail(checkEmailUnique(userDTO.getEmail()));
		user.setHashcode(hashCode[0]);
		user.setSalt(hashCode[1]);
		user.setRole(Role.valueOf(userDTO.getRole()));
		user.setStores(userDTO.getStores()
				.stream()
				.map(storeDTO -> SS.get(storeDTO.getId()))
				.collect(Collectors.toSet()));
		repository.addEntity(user);

	}
	
	public String checkEmailUnique(String email) {
		User user = repository.findUserByEmail(email);
		if (user != null) {
			throw new IllegalArgumentException(
					String.format("Email %s already exist.",email));
		}
		return email;
	}

	public User checkIfUserValid(UserDTO userDTO) {
		User user = repository.findUserByEmail(userDTO.getEmail());
		if (user == null) {
			throw new BadRequestException("Invalid Email/Password");
		}
		
		String key = user.getHashcode();
		String salt = user.getSalt();

		if (!PasswordUtils.verifyPassword(userDTO.getPassword(), key, salt)) {
			throw new BadRequestException("Invalid Email/Password");
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
	
	public Collection<User> get(MultivaluedMap<String, String> params) {
		return repository.get(params);
	}
}
