package com.ubs.opsit.interviews.junit;

import org.junit.Test;

import com.ubs.opsit.interviews.TimeConverter;
import com.ubs.opsit.interviews.exception.IncorrectTimeFormatException;
import com.ubs.opsit.interviews.timeconverterimpl.BerlinClockTimeConverter;
import static org.junit.Assert.*;

public class JunitBerlinClockTimeConverter {
	
	TimeConverter timeConverter = new BerlinClockTimeConverter();
	@Test(expected=IncorrectTimeFormatException.class)
	public void testInputTimeNull() {
		timeConverter.convertTime(null);
	}
	
	@Test(expected=IncorrectTimeFormatException.class)
	public void testInputTimeEmptyString() {
		timeConverter.convertTime("");
	}
	
	@Test(expected=IncorrectTimeFormatException.class)
	public void testInputTimeInIncorrectFormatSecondsNotEntered() {
		timeConverter.convertTime("10:10");
	}

	@Test(expected=IncorrectTimeFormatException.class)
	public void testInputTimeInIncorrectFormatMinutesNotEntered() {
		timeConverter.convertTime("10:10");
	}
	
	@Test(expected=IncorrectTimeFormatException.class)
	public void testInputTimeInIncorrectFormatHoursNotEntered() {
		timeConverter.convertTime("10:10");
	}
	
	@Test(expected=IncorrectTimeFormatException.class)
	public void testInputTimeInIncorrectFormatHoursMoreThan24Entered() {
		timeConverter.convertTime("25:10:10");
	}
	
	@Test(expected=IncorrectTimeFormatException.class)
	public void testInputTimeInIncorrectFormatHoursLessThan0Entered() {
		timeConverter.convertTime("-2:10:10");
	}
	
	@Test(expected=IncorrectTimeFormatException.class)
	public void testInputTimeInIncorrectFormatHoursEnteredInDecimalFormat() {
		timeConverter.convertTime("10.35:10:10");
	}
	@Test(expected=IncorrectTimeFormatException.class)
	public void testInputTimeInIncorrectFormatMinutesMoreThan60Entered() {
		timeConverter.convertTime("10:61:10");
	}
	
	@Test(expected=IncorrectTimeFormatException.class)
	public void testInputTimeInIncorrectFormatMinutesLessThan0Entered() {
		timeConverter.convertTime("-2:10:10");
	}
	
	@Test(expected=IncorrectTimeFormatException.class)
	public void testInputTimeInIncorrectFormatMinutesInDecimalFormat() {
		timeConverter.convertTime("10:10.35:10");
	}
	
	@Test(expected=IncorrectTimeFormatException.class)
	public void testInputTimeInIncorrectFormatSecondsMoreThan60Entered() {
		timeConverter.convertTime("10:10:61");
	}
	
	@Test(expected=IncorrectTimeFormatException.class)
	public void testInputTimeInIncorrectFormatSecondsLessThan0Entered() {
		timeConverter.convertTime("10:10:-2");
	}
	
	@Test(expected=IncorrectTimeFormatException.class)
	public void testInputTimeInIncorrectFormatSecondsInDecimalFormat() {
		timeConverter.convertTime("10:10:10.35");
	}
	
	@Test
	public void testInputTimeAtBefore12Noon() {
		assertEquals("Y\r\nROOO\r\nRRRR\r\nYYOOOOOOOOO\r\nOOOO", timeConverter.convertTime("09:10:12"));
	}
	
	@Test
	public void testInputTimeAt12Noon() {
		assertEquals("Y\r\nRROO\r\nRROO\r\nOOOOOOOOOOO\r\nOOOO", timeConverter.convertTime("12:00:00"));
	}
	
	@Test
	public void testInputTimeAfter12Noon() {
		assertEquals("O\r\nRRRO\r\nOOOO\r\nYYROOOOOOOO\r\nOOOO", timeConverter.convertTime("15:15:15"));
	}
}
