package de.fiducia.security.security;

import org.springframework.data.repository.CrudRepository;

import de.fiducia.security.security.models.User;


public interface UserRepository extends CrudRepository<User, String>{

}
