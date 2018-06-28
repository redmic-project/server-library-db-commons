package es.redmic.databaselib.common.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import es.redmic.databaselib.common.model.SuperModel;

@NoRepositoryBean
public interface BaseRepository<TModel extends SuperModel, TKey extends Serializable>
		extends JpaRepository<TModel, TKey>, QuerydslPredicateExecutor<TModel> {

	void refresh(TModel model);

	TModel merge(TModel entity);
}
