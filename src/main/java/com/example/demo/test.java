package com.example.demo;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;

public class test {

	public static void main(String[] args) {
		String timeStamp = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
		System.err.println(timeStamp);
		long monthsBetween = ChronoUnit.YEARS.between(YearMonth.from(LocalDate.parse("2016-09-30")),
				YearMonth.from(LocalDate.parse(timeStamp)));
		System.out.println(monthsBetween); // 3

		System.out.println(timeStamp); // 3

	}

}
