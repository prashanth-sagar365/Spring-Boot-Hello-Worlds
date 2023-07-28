package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Doctor;
import com.example.demo.repository.DoctorRepo;

import jakarta.persistence.EntityNotFoundException;

@Service
public class DoctorService {
	 @Autowired
	private  DoctorRepo doctorRepository;

//    @Autowired
//    public DoctorService(DoctorRepo doctorRepository) {
//        this.doctorRepository = doctorRepository;
//    }

    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    public Doctor getDoctorById(Long id) {
        return doctorRepository.findById(id).orElse(null);
    }

    public Doctor saveDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public void deleteDoctorById(Long id) {
        doctorRepository.deleteById(id);
    }
    
 // Custom Method to Get Doctors by Specialization
    public List<Doctor> getDoctorsBySpecialization(String specialization) {
        return doctorRepository.findBySpecialization(specialization);
    }
    
 // Custom Method to Get Doctors by Specialization
    public List<Doctor> getDoctorsByName(String name) {
        return doctorRepository.findByName(name);
    }


}
