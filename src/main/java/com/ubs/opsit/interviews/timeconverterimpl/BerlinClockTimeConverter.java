package com.ubs.opsit.interviews.timeconverterimpl;

import java.util.Objects;
import java.util.Optional;

import com.ubs.opsit.interviews.TimeConverter;
import com.ubs.opsit.interviews.exception.IncorrectTimeFormatException;

public class BerlinClockTimeConverter implements TimeConverter {

	public static final String INPUT_TIME_DELIMITER=":";
	public static final char LIGHT_OFF_CONSTANT='O';
	public static final String NEW_LINE_DELIMITER="\r\n"; //This will be /n for unix & /r/n for windows
	
	private BerlinClockHoursConvertor berlinClockHoursConvertor;
	private BerlinClockMinutesConvertor berlinClockMinutesConvertor;
	private BerlinClockSecondsConvertor berlinClockSecondsConvertor;
			
	public BerlinClockTimeConverter() {
		berlinClockHoursConvertor = new BerlinClockHoursConvertor();
		berlinClockMinutesConvertor = new BerlinClockMinutesConvertor();
		berlinClockSecondsConvertor = new BerlinClockSecondsConvertor();
	}

	@Override
	public String convertTime(String aTime) throws IncorrectTimeFormatException {
		if(validateInputTime(aTime)) {
			String []inputTimeComponents = aTime.split(INPUT_TIME_DELIMITER);			
			String secondsConvertedToBerlinClockFormat = berlinClockSecondsConvertor.toSecondsFormat(inputTimeComponents[2]);
			String minutesConvertedToBerlinClockFormat = berlinClockMinutesConvertor.toMinutesFormat(inputTimeComponents[1]);
			String hoursConvertedToBerlinClockFormat = berlinClockHoursConvertor.toHoursFormat(inputTimeComponents[0]);
			StringBuilder timeInBerlinClockFormat = new StringBuilder();
			timeInBerlinClockFormat.append(secondsConvertedToBerlinClockFormat).append("\r\n").append(hoursConvertedToBerlinClockFormat).append("\r\n").append(minutesConvertedToBerlinClockFormat);
			return timeInBerlinClockFormat.toString();
		} else {
			throw new IncorrectTimeFormatException("Input Time Cannot be Converted Into Berlin Format");
		}
	}

	public boolean validateInputTime(String aTime) {
		if(Objects.isNull(aTime) || aTime.isEmpty() || checkIfInputTimeFormatIsInCorrect(aTime)) {
			return false;
		} else 
			return true;
	}

	public boolean checkIfInputTimeFormatIsInCorrect(String aTime) {
		String[] timeComponents = aTime.split(INPUT_TIME_DELIMITER);
		if (timeComponents.length != 3)
			return true;
		else
			return false;
	}
	
}
