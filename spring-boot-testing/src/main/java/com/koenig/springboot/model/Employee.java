package com.koenig.springboot.model;



import org.springframework.boot.autoconfigure.web.WebProperties.Resources.Chain.Strategy;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "employees")
public class Employee {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name="first_name",nullable = false)
	private String firstName;
	@Column(name="last_name",nullable = false)
	private String lastName;
	@Column(nullable = false)
	private String email;
	
}
