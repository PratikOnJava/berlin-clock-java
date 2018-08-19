package com.ubs.opsit.interviews.timeconverterimpl;

import com.ubs.opsit.interviews.enums.LampColor;
import com.ubs.opsit.interviews.exception.IncorrectTimeFormatException;

public class BerlinClockSecondsConvertor {	

	public String toSecondsFormat(String seconds) throws IncorrectTimeFormatException {
		if(validateInputSeconds(seconds)) {
			throw new IncorrectTimeFormatException("Seconds Value Entered is Incorrect");
		}
		else {
			int secondsInInt = Integer.parseInt(seconds);
			if(isSecondsEvenNumber(secondsInInt)) {
				return LampColor.YELLOW.getColor();
			} else {
				return String.valueOf(BerlinClockTimeConverter.LIGHT_OFF_CONSTANT);
			}
		}		
	}

	private boolean validateInputSeconds(String seconds) {
		return seconds.contains(".") || Integer.parseInt(seconds) < 0 || Integer.parseInt(seconds) > 60;
	}

	private boolean isSecondsEvenNumber(int temp) {
		return temp % 2 == 0;
	}

}
