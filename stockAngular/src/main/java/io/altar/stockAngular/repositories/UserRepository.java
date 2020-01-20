package io.altar.stockAngular.repositories;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.ws.rs.core.MultivaluedMap;

import io.altar.stockAngular.models.User;
import io.altar.stockAngular.models.User.Role;
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
		return entityManager.createNamedQuery(User.GET_USER_BY_EMAIL, User.class).setParameter("email", email)
				.getResultList().stream().findFirst().orElse(null);
	}

	public List<User> get(MultivaluedMap<String, String> params) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<User> cq = cb.createQuery(User.class);
		Root<User> root = cq.from(User.class);

		List<Predicate> predicates = new ArrayList<Predicate>();
		Iterator<String> it = params.keySet().iterator();
		while (it.hasNext()) {
			String paramKey = (String) it.next();
			String paramValue = params.getFirst(paramKey);
			if (paramKey.equals("role")) {
				predicates.add(cb.equal(root.get(paramKey), Role.valueOf(paramValue)));
			} else {
				predicates.add(cb.equal(root.get(paramKey), paramValue));
			}
		}
		cq.where(predicates.toArray(new Predicate[] {}));

		TypedQuery<User> query = entityManager.createQuery(cq);
		return query.getResultList();
	}
}
