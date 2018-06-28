package es.redmic.databaselib.user.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import es.redmic.databaselib.user.model.UserDetailsImpl;

@Repository
public interface UserLoginRepository extends CrudRepository<UserDetailsImpl, Long> {

	UserDetailsImpl findByEmail(String email);

	UserDetailsImpl findByTokenConfirmation(String token);

}
