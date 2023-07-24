package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Patient;
import com.example.demo.repository.PatientRepo;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PatientService {
	
	@Autowired
	private  PatientRepo patientRepository;

//    @Autowired
//    public PatientService(PatientRepo patientRepository) {
//        this.patientRepository = patientRepository;
//    }

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Patient getPatientById(Long id) {
        return patientRepository.findById(id).orElse(null);
    }

    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public void deletePatientById(Long id) {
        patientRepository.deleteById(id);
    }
    
    public List<Patient> getPatientsByName(String name) {
        return patientRepository.findByName(name);
    }

}
