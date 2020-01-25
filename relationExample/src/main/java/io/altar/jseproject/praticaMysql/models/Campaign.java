package io.altar.jseproject.praticaMysql.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Campaign extends Entity_ {

	private static final long serialVersionUID = 1L;

	private String name;
	@OneToMany(mappedBy = "campaign")
	private List<Subscription> Subscriptions;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Subscription> getSubscriptions() {
		return Subscriptions;
	}

	public void setSubscriptions(List<Subscription> subscriptions) {
		Subscriptions = subscriptions;
	}

}