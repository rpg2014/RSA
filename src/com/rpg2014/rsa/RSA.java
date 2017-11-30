package com.rpg2014.rsa;

import java.math.BigInteger;
import java.util.Base64;

import com.rpg2014.rsa.conversions.DataConversions;
import com.rpg2014.rsa.keys.RSAKey;

public class RSA {

	
	
	
	public static String encrypt(String message,RSAKey keyPair) {
		
		BigInteger number = DataConversions.StringToInt(message);
		System.out.println("number before encrypt: " +number.toString());
		number =number.modPow(keyPair.getPublicKey().getE(), keyPair.getPublicKey().getN());
		System.out.println("number after encrypt: " +number.toString());
		
		
		String encrypted =  DataConversions.IntToString(number, message.length());
		System.out.println("before base64: "+encrypted);
		return Base64.getEncoder().encodeToString(encrypted.getBytes());
	}
	
	
	public static String decrypt(String message, RSAKey keyPair) {
		message = new String(Base64.getDecoder().decode(message.getBytes()));
		System.out.println("after base64 :" +message);
		BigInteger number = DataConversions.StringToInt(message);
		System.out.println("number before decrypt: " +number.toString());
		number = number.modPow(keyPair.getPrivateKey().getD(), keyPair.getPrivateKey().getN());
		System.out.println("number after decrypt: " +number.toString());
		
		String decrypted = DataConversions.IntToString(number, message.length());
		return decrypted;
	}
}
