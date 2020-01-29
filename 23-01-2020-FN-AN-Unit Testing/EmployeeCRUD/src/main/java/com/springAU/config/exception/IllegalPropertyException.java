package com.springAU.config.exception;

public class IllegalPropertyException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 545070388951463361L;
	String error;
	
	public IllegalPropertyException(String propertyName, String value) { // Exception thrown at wrong value entered
		// TODO Auto-generated constructor stub
		
		this.error = "The value of " + propertyName + " : " + value + " is Illegal.";
		System.out.println(this.error);
	}
	
	public String toString() {
		return this.error;
	}
}
