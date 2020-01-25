package io.altar.jseproject.praticaMysql.services;

import javax.enterprise.context.RequestScoped;

import io.altar.jseproject.praticaMysql.models.Subscription;
import io.altar.jseproject.praticaMysql.repositories.SubscriptionRepository;

@RequestScoped
public class SubscriptionService extends EntityService<SubscriptionRepository, Subscription> {

}
