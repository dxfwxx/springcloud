package com.test.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author dxf@choicesoft.com.cn
 * @data
 */
public class DateTest {
	public static void main(String[] args) throws ParseException {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String dateString = simpleDateFormat.format(date);
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(simpleDateFormat.parse(simpleDateFormat.format(date)));
//		calendar.add(Calendar.DAY_OF_MONTH, -12);
//		calendar.add(Calendar.MONTH, -11);
		System.out.println(calendar.getTime());
		System.out.println(sdf.parse(dateString).compareTo(calendar.getTime()));
		System.out.println(simpleDateFormat.format(calendar.getTime()));
	}
}
