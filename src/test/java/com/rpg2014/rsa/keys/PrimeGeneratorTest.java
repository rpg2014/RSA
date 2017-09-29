package com.rpg2014.rsa.keys;

import java.math.BigInteger;
import java.util.ArrayList;

import org.junit.Test;

public class PrimeGeneratorTest {

//	@Test
//	public void testGeneratePrime() {
//		BigInteger big = PrimeGenerator.generatePrime(4096);
//		System.out.println(big);
//		System.out.println(big.toString().length());
//	}
	
	@Test
	public void testGeneratePrimes() {
		ArrayList<BigInteger> list = PrimeGenerator.generatePrimes(2048);
		BigInteger prime1 = list.get(0);
		BigInteger prime2 = list.get(1);
		BigInteger n = prime1.multiply(prime2);
		System.out.println(n.toByteArray().length*8);
				
	}
}
