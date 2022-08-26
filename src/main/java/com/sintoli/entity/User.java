package com.sintoli.entity;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="tbl_users")

public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
      private long id;

	@NotBlank(message="Please Enter name")
	private String name;
	
	@NotNull(message="Please enter  email")
	@Email(message="Please Enter valid email")
	@Column(unique=true)
	private String email;
	
	@NotNull(message="Please Enter Password")
	@Size(min=5, message="Password should be atleast 5 character")
	@JsonIgnore
	private String password;
	
	private Long age;
	
	
	@Column(name="crated_at",nullable=false, updatable=false)
	@CreationTimestamp
	private Timestamp createdAt;

	@Column(name="updated_at")
	@UpdateTimestamp
	private Timestamp updatedAt;

}
