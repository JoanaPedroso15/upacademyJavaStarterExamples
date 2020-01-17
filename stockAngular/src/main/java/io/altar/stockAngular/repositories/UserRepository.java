package io.altar.stockAngular.repositories;

import javax.enterprise.context.ApplicationScoped;

import io.altar.stockAngular.models.User;
import io.altar.stockAngular.models.DTOS.UserDTO;

@ApplicationScoped
public class UserRepository extends EntityRepository<User, UserDTO> {

	@Override
	protected Class<User> getEntityClass() {
		return User.class;
	}

	@Override
	protected String getAllEntities() {
		return User.GET_ALL_USERS;
	}
	
	@Override
	protected String getAllEntitiesIds() {
		return User.GET_ALL_USERS_IDS;
	}
	
	@Override
	protected String getEntitiesCount() {
		return User.GET_USERS_COUNT;
	}

	public User findUserByEmail(String email) {
		return entityManager.createNamedQuery(User.GET_USER_BY_EMAIL, User.class)
				.setParameter("email", email)
				.getResultList().stream().findFirst().orElse(null);
	}
}
