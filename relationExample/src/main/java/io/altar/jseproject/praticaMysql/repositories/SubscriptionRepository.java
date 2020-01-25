package io.altar.jseproject.praticaMysql.repositories;

import javax.enterprise.context.ApplicationScoped;

import io.altar.jseproject.praticaMysql.models.Subscription;

@ApplicationScoped
public class SubscriptionRepository extends EntityRepository<Subscription> {

	@Override
	protected Class<Subscription> getEntityClass() {
		return Subscription.class;
	}
}