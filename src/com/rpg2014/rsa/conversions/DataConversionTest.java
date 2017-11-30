package com.rpg2014.rsa.conversions;

import static org.junit.Assert.assertFalse;

import java.math.BigInteger;

import org.junit.Test;

public class DataConversionTest {

	
	@Test
	public void testToAndFrom() {
		String str = "Hello";
		BigInteger in = DataConversions.StringToInt(str);
		System.out.println(in);
		String end = DataConversions.IntToString(in, str.length());
		
	}
}
