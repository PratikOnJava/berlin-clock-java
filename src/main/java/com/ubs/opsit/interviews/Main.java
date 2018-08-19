package com.ubs.opsit.interviews;

import com.ubs.opsit.interviews.timeconverterimpl.BerlinClockTimeConverter;

public class Main {

	public static void main(String s[]) {
		TimeConverter timeConverter = new BerlinClockTimeConverter();
		System.out.println(timeConverter.convertTime("10:16:12"));
	}
}
