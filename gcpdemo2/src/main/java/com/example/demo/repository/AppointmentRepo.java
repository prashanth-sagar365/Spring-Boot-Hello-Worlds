package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Appointment;
import com.example.demo.entity.Doctor;

@Repository
public interface AppointmentRepo extends JpaRepository<Appointment, Long>{

//	List<Appointment> findByDoctorId(Long doctorId);
//
//	List<Appointment> findByPatientId(Long patientId);
	
	List<Appointment> findByDoctorId(Long doctorId);
	List<Appointment> findByDoctorName(String name);

}
