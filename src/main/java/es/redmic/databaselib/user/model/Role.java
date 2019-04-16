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
