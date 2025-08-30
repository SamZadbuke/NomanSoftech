package com.nomansoftech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nomansoftech.entities.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer>{

	@Query("SELECT a FROM Admin a WHERE a.email = :email")
	Admin findAdminByEmail(String email);
	
	

}
