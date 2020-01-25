package io.altar.jseproject.praticaMysql.services;

import javax.enterprise.context.RequestScoped;

import io.altar.jseproject.praticaMysql.models.Campaign;
import io.altar.jseproject.praticaMysql.repositories.CampaignRepository;

@RequestScoped
public class CampaignService extends EntityService<CampaignRepository, Campaign> {

}
