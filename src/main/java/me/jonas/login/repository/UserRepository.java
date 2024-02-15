package me.jonas.login.repository;

import me.jonas.login.model.User;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<User, String> {



}
