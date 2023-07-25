package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Appointment;
import com.example.demo.repository.AppointmentRepo;

import jakarta.persistence.EntityNotFoundException;

@Service
public class AppointmentService {
   
	@Autowired
	private  AppointmentRepo appointmentRepository;

//    @Autowired
//    public AppointmentService(AppointmentRepo appointmentRepository) {
//        this.appointmentRepository = appointmentRepository;
//    }

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    public Appointment getAppointmentById(Long id) {
        return appointmentRepository.findById(id).orElse(null);
    }

    public Appointment saveAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    public void deleteAppointmentById(Long id) {
        appointmentRepository.deleteById(id);
    }
    
    // Custom Method to Get Appointments by Doctor ID
    public List<Appointment> getAppointmentsByDoctorId(Long doctorId) {
        return appointmentRepository.findByDoctorId(doctorId);
    }
    
    // Custom Method to Get Appointments by Doctor ID
    public List<Appointment> getAppointmentsByDoctorName(String name) {
        return appointmentRepository.findByDoctorName(name);
    }


}
