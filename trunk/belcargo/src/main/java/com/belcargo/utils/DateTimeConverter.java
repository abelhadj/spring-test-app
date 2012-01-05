package com.belcargo.utils;

import java.util.TimeZone;

public class DateTimeConverter extends javax.faces.convert.DateTimeConverter {
	public static final String CONVERTER_ID = "com.belcargo.utils.DateTimeConverter";

	public DateTimeConverter() {
		setTimeZone(TimeZone.getDefault());
		setPattern("dd/MM/yyyy");
	}

}
