package es.redmic.databaselib.user.model;

/*-
 * #%L
 * DB Commons
 * %%
 * Copyright (C) 2019 REDMIC Project / Server
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import es.redmic.databaselib.common.model.LongModel;

@Entity
@Table(name = "user", schema = "app")
@NamedQuery(name = "UserDetailsImpl.findAll", query = "SELECT u FROM UserDetailsImpl u")
public class UserDetailsImpl extends LongModel {

	@NotEmpty
	@Column(unique = true, nullable = false)
	private String email;

	@NotEmpty
	private Boolean enable;

	@Column(name = "lastname")
	private String lastName;

	private String name;

	@NotEmpty
	private String password;

	@Column(name = "tokenconfirmation")
	private String tokenConfirmation;

	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime", parameters = {
			@Parameter(name = "databaseZone", value = "jvm"), @Parameter(name = "javaZone", value = "jvm") })
	private DateTime datelastaccess;

	@ManyToOne
	@JoinColumn(name = "role")
	// TODO Cambiar el nombre a roleid cuando se cambie en la base de datos
	private Role roles;

	public UserDetailsImpl() {
		super();
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getEnable() {
		return this.enable;
	}

	public void setEnable(Boolean enable) {
		this.enable = enable;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTokenConfirmation() {
		return this.tokenConfirmation;
	}

	public void setTokenConfirmation(String tokenConfirmation) {
		this.tokenConfirmation = tokenConfirmation;
	}

	public DateTime getDateLastAccess() {
		return this.datelastaccess;
	}

	public void setDateLastAccess(DateTime dateLastAccess) {
		this.datelastaccess = dateLastAccess;
	}

	public Role getRole() {
		return this.roles;
	}

	@JsonIgnore
	public Set<Role> getRoles() {
		Set<Role> wrappRoles = new HashSet<Role>();
		wrappRoles.add(this.roles);
		return wrappRoles;
	}

	public void setRole(Set<Role> wrappRoles) {
		if (wrappRoles.isEmpty()) {
			this.roles = null;
		} else {
			this.roles = (Role) wrappRoles.toArray()[0];
		}
	}
}
