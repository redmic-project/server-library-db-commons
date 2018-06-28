package es.redmic.databaselib.user.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import es.redmic.databaselib.user.model.ClientDetailsImpl;

@Repository
public interface ClientLoginRepository extends CrudRepository<ClientDetailsImpl, Long> {

	ClientDetailsImpl findByClientId(String clientId);

}
