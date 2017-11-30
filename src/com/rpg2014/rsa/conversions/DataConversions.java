package com.rpg2014.rsa.conversions;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.rpg2014.rsa.types.IntegerToLargeException;

public class DataConversions {
	private static BigInteger twofiftysix = new BigInteger("256");
	
	public static BigInteger StringToInt(String m) {
		// byte[] bytes = (m.getBytes());
		
		
		// BigInteger sum = new BigInteger("0");
		// int i = 0;
		// for (byte b:bytes) {
		// 	Byte by = new Byte(b);
		// 	BigInteger byteVal = new BigInteger(Integer.toString(by.intValue()));
		// 	sum = sum.add(byteVal.multiply(twofiftysix.pow(i) ));
		// 	i++;
		// }
		// return sum;
		String bigInteger = "";
		for( int i =0 ;i<m.length(); i++){
			String num = String.valueOf((int)m.charAt(i));
			
			if (num.length()<3) {
				int zerosToAdd = 3-num.length();
				num = addZeros(zerosToAdd,num);
				
			}
			
			bigInteger+= num;
		}
		
		return new BigInteger(bigInteger);

	}
	
	
	public static String IntToString(BigInteger num, int length) {
		String number = num.toString();
		int zerosMissing= number.length()%3;
		//number = addZeros(zerosMissing,number);
		
		String message = "";
		for(int i = 0 ; i<length;i+=1) {
			char c= (char) Integer.parseInt(number.substring(0, 3));
			
			message += c;
			number = number.substring(3,number.length());
		}
		return message;
	}
	
	private static String addZeros(int zerosToAdd,String number) {
		for(int k =0; k<zerosToAdd; k++) {
			number = "0"+number;
			
		}
		return number;
	}
	
	
	private static byte[] listToArray(ArrayList<Byte> list) {
		byte[] result = new byte[list.size()];
		for(int i = 0; i < list.size(); i++) {
		    result[i] = list.get(i).byteValue();
		}
		return result;
	}
}
