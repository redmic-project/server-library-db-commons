package es.redmic.databaselib.common.repository;

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
