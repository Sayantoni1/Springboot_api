package com.springrest.springrest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import com.springrest.springrest.entities.Training;
import com.springrest.springrest.services.TrainingService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import java.util.List;


@RestController
public class MyController {
	@Autowired
	private TrainingService trainingSerivice;
	//Method to get all the Training.
	@GetMapping("/trainings")
	public List<Training> getTrainings(){
		
		return this.trainingSerivice.getTrainings();
		
	}
	
	//Get Single Training.
	@GetMapping("/trainings/{trainingId}")
	public Training getTraining(@PathVariable String trainingId) {
		return this.trainingSerivice.getTraining(Long.parseLong(trainingId));
	}
	
	//To add Training.
	@PostMapping("/trainings")
	public Training addTraining(@RequestBody Training training) 
	{
		return this.trainingSerivice.addTraining(training);
	}
	
	//To update Training.
	@PutMapping("/trainings")
	public Training updateTraining(@RequestBody Training training)
	{
		return this.trainingSerivice.updateTraining(training);
	}
	
	//To delete Training
	@DeleteMapping("/trainings/{trainingId}")
	public ResponseEntity<HttpStatus> deleteTraining(@PathVariable String trainingId){
		try {
			this.trainingSerivice.deleteTraining(Long.parseLong(trainingId));
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
		
	
}
