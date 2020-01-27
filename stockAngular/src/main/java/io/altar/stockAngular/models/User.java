package io.altar.stockAngular.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@NamedQueries({ @NamedQuery(name = User.GET_ALL_USERS, query = "SELECT u FROM User u"),
		@NamedQuery(name = User.GET_ALL_USERS_IDS, query = "SELECT u.id FROM User u"),
		@NamedQuery(name = User.GET_USERS_COUNT, query = "SELECT COUNT(u.id) FROM User u"),
		@NamedQuery(name = User.GET_USER_BY_EMAIL, query = "SELECT u FROM User u WHERE u.email=:email") })
public class User extends Entity_ {

	public enum Role {
		ADMIN, SUPERUSER, USER
	}

	public static final String GET_ALL_USERS = "getAllUsers";
	public static final String GET_ALL_USERS_IDS = "getAllUsersIds";
	public static final String GET_USERS_COUNT = "getUsersCount";
	public static final String GET_USER_BY_EMAIL = "getByEmail";

	private static final long serialVersionUID = 1L;

	@Column(nullable = false)
	private String name;
	@Column(unique = true, nullable = false)
	private String email;
	@Column(nullable = false)
	private String hashcode;
	@Column(nullable = false)
	private String salt;
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Role role;
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.EAGER)
	@JoinTable(name = "user_store",
	    joinColumns = @JoinColumn(name = "users_id"),
	    inverseJoinColumns = @JoinColumn(name = "stores_id")
	)
	@JsonIgnoreProperties("questions")
	private Set<Store> stores = new HashSet<>();

	public static String getClassName() {
		return "User";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHashcode() {
		return hashcode;
	}

	public void setHashcode(String hashcode) {
		this.hashcode = hashcode;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Set<Store> getStores() {
		return stores;
	}

	public void addStore(Store store) {
		this.stores.add(store);
	}

	public void setStores(Set<Store> stores) {
		this.stores = stores;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", email=" + email + ", hashcode=" + hashcode + ", salt=" + salt + ", role="
				+ role + ", stores=" + stores.size() + "]";
	}
}
