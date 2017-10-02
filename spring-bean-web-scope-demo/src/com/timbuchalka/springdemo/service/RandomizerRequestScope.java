package com.timbuchalka.springdemo.service;

public class RandomizerRequestScope {
	private int randomNumber = 5;
	
	public int getRandomNumber() {
		return randomNumber;
	}
	
	public void generateRandomNumber() {
		 this.randomNumber = (int) (Math.random() * 99999);
	}
	
	// Request scope creates another object on every refresh

}
