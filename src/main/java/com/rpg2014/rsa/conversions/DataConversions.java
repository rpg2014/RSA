package com.rpg2014.rsa.conversions;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.rpg2014.rsa.types.IntegerToLargeException;

public class DataConversions {
	private static BigInteger twofiftysix = new BigInteger("256");
	
	public static BigInteger StringToInt(String m) {
		byte[] bytes = (m.getBytes());
		
		
		BigInteger sum = new BigInteger("0");
		int i = 0;
		for (byte b:bytes) {
			Byte by = new Byte(b);
			BigInteger byteVal = new BigInteger(Integer.toString(by.intValue()));
			sum = sum.add(byteVal.multiply(twofiftysix.pow(i) ));
			i++;
		}
		return sum;
	}
	
	
	public static String IntToString(BigInteger num, int length) {
		BigInteger len = new BigInteger(Integer.toString(length));
		if(len.compareTo(twofiftysix.pow(length))>0) {
			throw new IntegerToLargeException();
		}
		BigInteger sum = new BigInteger("0");
		//need to do the math thing, it think to convert it from base 10 to base 256
		
		
		String string = X.toString();
		ArrayList<Byte> bytes = new ArrayList<>();
		for (int i=0 ; i <= string.length()/8; i++) {
			bytes.add(Byte.valueOf(string.substring(i*8, i*8+8)));
		}
		byte[] bys = listToArray(bytes);
		return new String(bys);
	}
	
	
	private static byte[] listToArray(ArrayList<Byte> list) {
		byte[] result = new byte[list.size()];
		for(int i = 0; i < list.size(); i++) {
		    result[i] = list.get(i).byteValue();
		}
		return result;
	}
}
