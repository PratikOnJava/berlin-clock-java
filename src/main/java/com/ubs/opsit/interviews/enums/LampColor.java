package com.ubs.opsit.interviews.enums;

public enum LampColor {

	RED("R"),
	YELLOW("Y");
	
	private String color;

	private LampColor(String color) {
		this.color = color;
	}

	public String getColor() {
		return color;
	}
	
}
