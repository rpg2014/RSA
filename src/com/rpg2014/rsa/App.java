package com.rpg2014.rsa;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.util.Scanner;

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
    	
    	File key = new File("key.ser");
    	RSAKey keypair;
    	if(key.exists()) {
    		try {
    		FileInputStream fileIn = new FileInputStream("key.ser");
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         keypair = (RSAKey) in.readObject();
	         in.close();
	         fileIn.close();
	      } catch (IOException i) {
	         i.printStackTrace();
	         return;
	      } catch (ClassNotFoundException c) {
	         System.out.println("Employee class not found");
	         c.printStackTrace();
	         return;
	      }
    	}else {
    		keypair = GenerateKey.generateKey(765);
    	}
    	String str = args[0];
//    	System.out.println(str.length());
		String in = RSA.encrypt(str, keypair);
		System.out.println("encrypted message: " +in);
		
		
		
		String out = RSA.decrypt(in, keypair);
		System.out.println("out: "+out);
		
		
		try {
			FileWriter scan = new FileWriter(new File("message.txt"));
			scan.write(in);
			scan.close();
			
			
			
	         FileOutputStream fileOut =
	         new FileOutputStream("key.ser");
	         ObjectOutputStream outStream = new ObjectOutputStream(fileOut);
	         outStream.writeObject(keypair);
	         outStream.close();
	         fileOut.close();
	         
	      } catch (IOException i) {
	         i.printStackTrace();
	      }
		
		
		
    }
}
