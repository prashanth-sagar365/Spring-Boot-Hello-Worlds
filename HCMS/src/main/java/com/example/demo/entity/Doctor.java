package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="doctor_info")
public class Doctor {
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String name;
	    private String specialization;

	    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
	    private List<Appointment> appointments;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getSpecialization() {
			return specialization;
		}

		public void setSpecialization(String specialization) {
			this.specialization = specialization;
		}

//		public List<Appointment> getAppointments() {
//			return appointments;
//		}
//
//		public void setAppointments(List<Appointment> appointments) {
//			this.appointments = appointments;
//		}
	    
	    

	
	
	

}
