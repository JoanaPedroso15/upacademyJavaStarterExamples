package io.altar.jseproject.praticaMysql.repositories;

import javax.enterprise.context.ApplicationScoped;

import io.altar.jseproject.praticaMysql.models.Campaign;

@ApplicationScoped
public class CampaignRepository extends EntityRepository<Campaign> {
	
	@Override
	protected Class<Campaign> getEntityClass() {
		return Campaign.class;
	}
}
