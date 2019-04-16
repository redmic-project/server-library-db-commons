package es.redmic.databaselib.common.repository;

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

import java.io.Serializable;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.QuerydslJpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import es.redmic.databaselib.common.model.SuperModel;

@NoRepositoryBean
public class BaseRepositoryImpl<TModel extends SuperModel, TKey extends Serializable>
		extends QuerydslJpaRepository<TModel, TKey>
		implements BaseRepository<TModel, TKey> {

	private EntityManager entityManager;

	public BaseRepositoryImpl(JpaEntityInformation<TModel, TKey> domainClass,
			EntityManager entityManager) {
		super(domainClass, entityManager);
		this.entityManager = entityManager;
	}

	@Override
	public void refresh(TModel entity) {
		this.entityManager.refresh(entity);
	}

	@Override
	public TModel merge(TModel entity) {
		return this.entityManager.merge(entity);
	}
}
