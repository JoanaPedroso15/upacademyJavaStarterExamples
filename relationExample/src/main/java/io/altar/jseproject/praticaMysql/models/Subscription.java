package io.altar.jseproject.praticaMysql.models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Subscription extends Entity_ {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	private Product product;
	@ManyToOne
	private Campaign campaign;

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Campaign getCampaign() {
		return campaign;
	}

	public void setCampaign(Campaign campaign) {
		this.campaign = campaign;
	}

}
