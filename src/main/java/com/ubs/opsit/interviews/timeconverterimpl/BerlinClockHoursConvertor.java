package com.ubs.opsit.interviews.timeconverterimpl;

import com.ubs.opsit.interviews.enums.LampColor;
import com.ubs.opsit.interviews.exception.IncorrectTimeFormatException;

public class BerlinClockHoursConvertor {
	
	public String toHoursFormat(String hour) throws IncorrectTimeFormatException {
		if(isHourFormatInValid(hour)) {
			throw new IncorrectTimeFormatException("Hour Format is incorrect");
		} else {			
			int hoursInInt = Integer.parseInt(hour);
			//quotient gives the number of light ON from 1 row of the two rows of hours
			int quotient = hoursInInt/5;
			//remainder gives the number of light ON from 2 row of the two rows of hours
			int remainder = hoursInInt%5;
			StringBuilder stringBuilder1 = new StringBuilder();
			StringBuilder stringBuilder2 = new StringBuilder();
			for(int i=0;i<quotient;i++) {
				stringBuilder1.append(LampColor.RED.getColor());
			} 
			String firstRow = (String.format("%1$-"+4+"s", stringBuilder1.toString()).replace(' ', BerlinClockTimeConverter.LIGHT_OFF_CONSTANT));
			for(int i=0;i<remainder;i++) {
				stringBuilder2.append(LampColor.RED.getColor());
			}
			String secondRow = (String.format("%1$-"+4+"s", stringBuilder2.toString()).replace(' ', BerlinClockTimeConverter.LIGHT_OFF_CONSTANT));
			return firstRow.concat("\r\n").concat(secondRow);
		}
	}

	private boolean isHourFormatInValid(String hour) {
		return hour.contains(".") || Integer.parseInt(hour)<0 || Integer.parseInt(hour)>24;
	}
}
