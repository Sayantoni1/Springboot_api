package com.springrest.springrest.services;

import java.util.List;

import com.springrest.springrest.entities.Training;


public interface TrainingService {
	
	public List<Training> getTrainings();
	
	public Training getTraining(long trainingId);
	
	public Training addTraining(Training training);
	
	public Training updateTraining(Training training);
	
	public void deleteTraining(long parseLong);
	
	
}
