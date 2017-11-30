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
    	
    	RSAKey keypair = GenerateKey.generateKey(64);
    	String str = "h";
    	System.out.println(str.length());
		String in = RSA.encrypt(str, keypair);
		System.out.println(in);
		
		String out = RSA.decrypt(in, keypair);
		System.out.println(out);
		
		
		
    }
}
