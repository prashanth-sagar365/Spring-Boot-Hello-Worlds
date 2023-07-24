package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Appointment;
import com.example.demo.entity.Doctor;
import com.example.demo.entity.Patient;
import com.example.demo.service.AppointmentService;
import com.example.demo.service.DoctorService;
import com.example.demo.service.PatientService;

import java.util.List;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {
     
	 @Autowired
	 private  AppointmentService appointmentService;
	 @Autowired
	 private  PatientService patientService;
	 @Autowired
	 private  DoctorService doctorService;
		/*
		 * @Autowired public AppointmentController(AppointmentService
		 * appointmentService, PatientService patientService, DoctorService
		 * doctorService) { this.appointmentService = appointmentService;
		 * this.patientService = patientService; this.doctorService = doctorService; }
		 */

	    @GetMapping("/")
	    public List<Appointment> getAllAppointments() {
	        return appointmentService.getAllAppointments();
	    }

	    @GetMapping("/{id}")
	    public Appointment getAppointmentById(@PathVariable Long id) {
	        return appointmentService.getAppointmentById(id);
	    }

	    @PostMapping("/")
	    public Appointment createAppointment(@RequestBody Appointment appointment) {
	        // Assuming the patient and doctor IDs are provided in the request body
	        Patient patient = patientService.getPatientById(appointment.getPatient().getId());
	        Doctor doctor = doctorService.getDoctorById(appointment.getDoctor().getId());

	        if (patient == null || doctor == null) {
	            // Handle invalid patient or doctor ID
	            throw new IllegalArgumentException("Invalid patient or doctor ID.");
	        }

	        appointment.setPatient(patient);
	        appointment.setDoctor(doctor);
	        return appointmentService.saveAppointment(appointment);
	    }

	    @DeleteMapping("/{id}")
	    public void deleteAppointment(@PathVariable Long id) {
	        appointmentService.deleteAppointmentById(id);
	    }
	    
	    @GetMapping("/by-doctor-id/{doctorId}")
	    public List<Appointment> getAppointmentsByDoctorId(@PathVariable Long doctorId) {
	        return appointmentService.getAppointmentsByDoctorId(doctorId);
	    }
	    
	    @GetMapping("/getAppointmentsByDoctorName/{name}")
	    public List<Appointment> getAppointmentsByDoctorName(@PathVariable String name) {
	        return appointmentService.getAppointmentsByDoctorName(name);
	    }
	    
}