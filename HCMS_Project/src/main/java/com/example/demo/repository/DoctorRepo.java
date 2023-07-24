package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Doctor;
import com.example.demo.entity.Patient;

@Repository
public interface DoctorRepo extends JpaRepository<Doctor, Long> {

//	List<Doctor> findBySpecializationIgnoreCase(String specialization);
	// List<Doctor> findBySpecialization(String specialization);

	List<Doctor> findBySpecialization(String specialization);
	List<Doctor> findByName(String name);

}
