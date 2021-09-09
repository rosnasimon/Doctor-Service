package com.htc.doctorservice.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.htc.doctorservice.dao.DoctorRepository;
import com.htc.doctorservice.dto.DoctorDTO;
import com.htc.doctorservice.entity.Doctor;

@RestController
@RequestMapping("api/")
public class DoctorController {

	@Autowired
	private DoctorRepository repository;
	
	@GetMapping(value = "doctors", produces = MediaType.APPLICATION_JSON_VALUE)
    public List < Doctor > getDoctors() {
        return this.repository.findAll();
    }
	
	@PostMapping(value = "doctors", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Doctor createDoctor(@Valid @RequestBody DoctorDTO doc) {
	      System.out.println("Creating Doctor: " + doc.getDoctorName() + "...");
	      Doctor doctor=new Doctor(doc.getDoctorName(), doc.getSpecialization(), doc.getExperiene(), doc.getMobile());
	      return repository.save(doctor);
	}

	@GetMapping(value = "/doctors/{doctorId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Doctor> getDoctorByID(@PathVariable("doctorId") Long doctorId) {
      System.out.println("Get Doctor by id...");
   
      Optional<Doctor> doctorData = repository.findById(doctorId);
      if (doctorData.isPresent()) {
        return new ResponseEntity<>(doctorData.get(), HttpStatus.OK);
      } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
    }
	
	@PutMapping(value = "/doctors/{doctorId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Doctor> updateDoctor(@PathVariable("doctorId") Long doctorId, @RequestBody Doctor doctor) {
      System.out.println("Update doctor with ID = " + doctorId + "...");
   
      Optional<Doctor> doctorData = repository.findById(doctorId);
      if (doctorData.isPresent()) {
    	Doctor savedDoctor = doctorData.get();
    	savedDoctor.setExperiene(doctor.getExperiene());
    	savedDoctor.setMobile(doctor.getMobile());
    	
    	Doctor updatedDoctor = repository.save(savedDoctor);
        return new ResponseEntity<>(updatedDoctor, HttpStatus.OK);
      } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
    }

    
    @DeleteMapping("/doctors/{doctorId}")
    public ResponseEntity<String> deleteDoctor(@PathVariable("doctorId") Long doctorId) {
      System.out.println("Delete Doctor with ID = " + doctorId + "...");
   
      try {
        repository.deleteById(doctorId);
      } catch (Exception e) {
        return new ResponseEntity<>("Failed to delete!", HttpStatus.EXPECTATION_FAILED);
      }
   
      return new ResponseEntity<>("Doctor has been deleted!", HttpStatus.OK);
    }
}
