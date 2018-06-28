package es.redmic.databaselib.user.model;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import javax.validation.constraints.NotEmpty;
import org.springframework.security.core.GrantedAuthority;

import es.redmic.databaselib.common.model.LongModel;

@Entity
@Table(name = "role", schema = "app")
@NamedQuery(name = "Role.findAll", query = "SELECT r FROM Role r")
public class Role extends LongModel implements GrantedAuthority {

	private static final long serialVersionUID = 1L;

	@NotEmpty
	private String name;

	@Override
	public String getAuthority() {
		return name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
