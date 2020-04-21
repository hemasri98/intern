package com.assignment.services.implementation;
import org.springframework.stereotype.Service;
import com.assignment.services.FortuneService;

@Service
public class HappyFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "Today is my lucky day";
	}

}
