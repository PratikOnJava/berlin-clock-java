package com.ubs.opsit.interviews.timeconverterimpl;

import com.ubs.opsit.interviews.enums.LampColor;
import com.ubs.opsit.interviews.exception.IncorrectTimeFormatException;
import com.ubs.opsit.interviews.timeconverterimpl.BerlinClockTimeConverter;

public class BerlinClockMinutesConvertor {
	
	public String toMinutesFormat(String minutes) throws IncorrectTimeFormatException{
		if(validateInputMinutes(minutes)) {
			throw new IncorrectTimeFormatException("Minutes Format is incorrect");
		} else {
			int minutesValue = Integer.parseInt(minutes);
			//quotient is the number of lights which will be on from 1 row of the two minutes rows
			int quotient = minutesValue/5;
			//remainder is the number of lights which will be on from 2 row of the two minutes rows
			int remainder = minutesValue%5;			
			StringBuilder stringBuilder1 = new StringBuilder();
			StringBuilder stringBuilder2 = new StringBuilder();
			for(int i=0;i<quotient;i++) {
				if(validateMinuteIsAMultipleOfThree(i) == 0) {
					stringBuilder1.append(LampColor.RED.getColor());
				} else {
					stringBuilder1.append(LampColor.YELLOW.getColor());
				}
			}
			String firstRow = (String.format("%1$-"+11+"s", stringBuilder1.toString()).replace(' ', BerlinClockTimeConverter.LIGHT_OFF_CONSTANT));					
			for(int j =0 ;j <remainder;j++) {
				stringBuilder2.append(LampColor.YELLOW.getColor());
			}
			String secondRow = (String.format("%1$-"+4+"s", stringBuilder2.toString()).replace(' ', BerlinClockTimeConverter.LIGHT_OFF_CONSTANT));
			return firstRow.concat("\r\n").concat(secondRow);
		}
	}

	private int validateMinuteIsAMultipleOfThree(int i) {
		return (i + 1) % 3;
	}

	private boolean validateInputMinutes(String minutes) {
		return minutes.contains(".") || Integer.parseInt(minutes) < 0 || Integer.parseInt(minutes) > 60;
	}

}
