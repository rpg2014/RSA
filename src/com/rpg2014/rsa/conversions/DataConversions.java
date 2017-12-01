package com.rpg2014.rsa.conversions;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.rpg2014.rsa.types.IntegerToLargeException;

public class DataConversions {
	private static BigInteger twofiftysix = new BigInteger("256");
	
	
	//this method is correct.  not completly
	public static BigInteger StringToInt(String m) {
		 byte[] bytes = (m.getBytes());
		
//		System.out.println("num bytes = "+ bytes.length);
		 BigInteger sum = new BigInteger("0");
		 int i = bytes.length-1;
		 for (byte b:bytes) {
		 	Byte by = new Byte(b);
		 	BigInteger byteVal = new BigInteger(Integer.toString(by.intValue()));
		 	sum = sum.add(byteVal.multiply(twofiftysix.pow(i) ));
		 	i--;
		 }
		 return sum;
		
		
		
		

	}
	
	//convert number given to base 256 thentake those digits to be ascii values
	public static String IntToString(BigInteger num, int length) {
		if (num.compareTo(twofiftysix.pow(length))>=0) {
			throw new IntegerToLargeException();
		}
		
		
		
		ArrayList<Integer> integers = convertToBase256(num,length);
		String result = "";
		for(Integer i: integers) {
			result+= (char) i.intValue();
		}
		return result;
	}
	
	
	public static ArrayList<Integer> convertToBase256(BigInteger num, int length){
		String number = num.toString();
		int[] result = new int[length];
		BigInteger quotent = num.divide(twofiftysix);
		BigInteger remainder = num.mod(twofiftysix);
		result[length-1] =  remainder.intValue();
		
		for(int i = length-2;i>=0;i--) {
		
			remainder = quotent.mod(twofiftysix);
			quotent = quotent.divide(twofiftysix);
			
			result[i] =  remainder.intValue();
		}
		
		System.out.println(Arrays.toString(result));
		ArrayList<Integer> integers = new ArrayList<>();
		for(int i : result) {
			if(i!=0) {
				integers.add(i);
			}
		}
		return integers;
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
