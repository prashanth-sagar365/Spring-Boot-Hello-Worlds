package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Doctor;
import com.example.demo.service.DoctorService;

@RestController
@RequestMapping("/doctors")
public class DoctorController {
	 @Autowired
	 private  DoctorService doctorService;

//	    @Autowired
//	    public DoctorController(DoctorService doctorService) {
//	        this.doctorService = doctorService;
//	    }

	    @GetMapping("/")
	    public List<Doctor> getAllDoctors() {
	        return doctorService.getAllDoctors();
	    }

	    @GetMapping("/{id}")
	    public Doctor getDoctorById(@PathVariable Long id) {
	        return doctorService.getDoctorById(id);
	    }

	    @PostMapping("/")
	    public Doctor createDoctor(@RequestBody Doctor doctor) {
	        return doctorService.saveDoctor(doctor);
	    }

	    @DeleteMapping("/{id}")
	    public void deleteDoctor(@PathVariable Long id) {
	        doctorService.deleteDoctorById(id);
	    }
	    
	    @GetMapping("/getDoctorsBySpecialization/{specialization}")
	    public List<Doctor> getDoctorsBySpecialization(@PathVariable String specialization) {
	        return doctorService.getDoctorsBySpecialization(specialization);
	    }
	    
	    @GetMapping("/getDoctorsByName/{specialization}")
	    public List<Doctor> getDoctorsByName(@PathVariable String name) {
	        return doctorService.getDoctorsByName(name);
	    }


}