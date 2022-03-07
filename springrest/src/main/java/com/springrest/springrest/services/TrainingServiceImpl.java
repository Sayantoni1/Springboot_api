package com.springrest.springrest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.function.Function;
import com.springrest.springrest.entities.Training;

@Service
public class TrainingServiceImpl implements TrainingService {
	
	List<Training> list;
	
	public TrainingServiceImpl() {
		
		list = new ArrayList<>();
		list.add(new Training(145,"JAVA Core","This course contains basics of JAVA"));
		list.add(new Training(146,"Spring Boot","This course contains basics of Spring Boot"));
		
		
	}
	@Override
	public List<Training> getTrainings() {
		return list;
	}
	@Override
	public Training getTraining(long trainingId) {
		
		Training t = null;
		for(Training training:list) {
			if(training.getId()==trainingId) 
			{
				t=training;
				break;
			}
		}
		
		return t;
	}
	@Override
	public Training addTraining(Training training) {
		list.add(training);
		return training;
	}
	
	@Override
	public Training updateTraining(Training training) {
		list.forEach(e ->{
			if(e.getId()==training.getId()) {
				e.setTitle(training.getTitle());
				e.setDescription(training.getDescription());
				}
			});
			return training;
	}
	@Override
	public void deleteTraining(long parseLong) {
		list=this.list.stream().filter(e->e.getId()!=parseLong).collect(Collectors.toList());
		
	}
	

}
