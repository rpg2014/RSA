package com.rpg2014.rsa.conversions;

import java.math.BigInteger;

import org.junit.Test;

public class DataConversionTest {

	
	@Test
	public void testToAndFrom() {
		String str = "Hello";
		BigInteger in = DataConversions.StringToInt(str);
		String end = DataConversions.IntToString(in, str.length());
	}
}
