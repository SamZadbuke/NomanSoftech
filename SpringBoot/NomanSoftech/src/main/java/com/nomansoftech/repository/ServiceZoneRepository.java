package com.nomansoftech.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nomansoftech.entities.Admin;
import com.nomansoftech.entities.ServiceZone;
import com.nomansoftech.entities.User;

public interface ServiceZoneRepository  extends JpaRepository<ServiceZone, Integer>{

	Optional<ServiceZone> findByPincode(int pincode);

	
}
