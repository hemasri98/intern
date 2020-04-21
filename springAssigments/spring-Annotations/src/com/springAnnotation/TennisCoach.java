package com.springAnnotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements ICoach {
	
	@Autowired 
	@Qualifier("happyFortuneService")
	private FortuneService fortuneservice;
	
	public TennisCoach() {
		System.out.println("Inside Constructor: TennisCoach");
	}
	
	@Autowired
	@Qualifier("happyFortuneService")
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("Inside method: setFortuneService");
		this.fortuneservice = fortuneService;
	}
	

	public FortuneService getFortuneService() {
		System.out.println("Inside method: getFortuneService");
		return fortuneservice;
	}
	

	@Override
	public String getDailyWorkout() {
		return "Practice";
	}

	@Override
	public String getDailyFortune() {
		return fortuneservice.getFortune();
	}
	
}
