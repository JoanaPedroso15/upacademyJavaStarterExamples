package io.altar.stockAngular.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({ @NamedQuery(name = Store.GET_ALL_STORES, query = "SELECT s FROM Store s"),
		@NamedQuery(name = Store.GET_ALL_STORES_IDS, query = "SELECT s.id FROM Store s"),
		@NamedQuery(name = Store.GET_STORES_COUNT, query = "SELECT COUNT(s.id) FROM Store s") })
public class Store extends Entity_ {

	public static final String GET_ALL_STORES = "getAllStores";
	public static final String GET_ALL_STORES_IDS = "getAllStoresIds";
	public static final String GET_STORES_COUNT = "getStoresCount";

	private static final long serialVersionUID = 1L;

	private String name;
	@ManyToMany(mappedBy = "stores", fetch = FetchType.EAGER)
	private Set<User> users = new HashSet<>();

	public static String getClassName() {
		return "Store";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "Store [name=" + name + ", users=" + users + "]";
	}

	
}
