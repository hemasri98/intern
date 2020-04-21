package com.springAnnotation;

import org.springframework.stereotype.Component;

@Component("thatSillyCoach")
public class TennisCoach implements ICoach {

	@Override
	public String getDailyWorkout() {
		
		return "Practice";
	}

}
