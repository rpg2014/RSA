package com.rpg2014.rsa;

import java.math.BigInteger;

import com.rpg2014.rsa.conversions.DataConversions;
import com.rpg2014.rsa.keys.GenerateKey;
import com.rpg2014.rsa.keys.RSAKey;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    	
//    	String str = "hello";
//    	BigInteger in = DataConversions.StringToInt(str);
//    	System.out.println("number: "+in.toString());
//    	String out = DataConversions.IntToString(in, str.length());
//    	System.out.println(out);
    	
    	RSAKey keypair = GenerateKey.generateKey(2048);
    	String str = "The FitnessGram Pacer Test is a multistage aerobic capacity test that progressively gets more difficult as it continues. The 20 meter pacer test will begin in 30 seconds. Line up at the start. ";
    	System.out.println(str.length());
		String in = RSA.encrypt(str, keypair);
		System.out.println(in);
		
		String out = RSA.decrypt(in, keypair);
		System.out.println("out: "+out);
		
		
		
    }
}
