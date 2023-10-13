package br.com.gabrielmteixeira.todolist.user;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;


// JpaRepository<T, ID> receives two generators, beeing the first one the model of the entity and the second the type of Id
public interface IUserRepository extends JpaRepository<UserModel, UUID>{
  // JPA automatically undertads that it has to do a "select" in the database, searching in the column "username"
  UserModel findByUsername(String username);
}
