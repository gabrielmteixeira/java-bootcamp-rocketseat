package br.com.gabrielmteixeira.todolist.user;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import lombok.Data;

@Data // Set getters and setters to all attributes
@Entity(name = "tb_users") // Defining this model as a database table
public class UserModel {

  @Id // defines this attribute as the id of the table
  @GeneratedValue(generator = "UUID") // generate new id's for new table entries automatically
  private UUID id; // primary key of the database (non-sequencial primary key)

  @Column(name = "username", unique = true) // can be used to set a diferent name for the table corresponding to the attribute below
  private String username;
  private String name;
  private String password;

  @CreationTimestamp
  private LocalDateTime createdAt;
}
