package com.rpg2014.rsa.keys;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Random;

public class PrimeGenerator {
	
	public static ArrayList<BigInteger> generatePrimes(int bitLength){
		ArrayList<BigInteger> primes = new ArrayList<BigInteger>();
		BigInteger p = new BigInteger("0");
		BigInteger q = new BigInteger("0");
		int count = 0;
		do {
//			System.out.println("generating prime set numbeer: "+ count+1);
			p = generatePrime(bitLength);
			q = generatePrime(bitLength);
			count++;
		}while(p.equals(q) && getLengthDiff(p,q)>2);
		primes.add(p);
		primes.add(q);
		return primes;
		
	}
	
	
	protected static BigInteger generatePrime(int bitlength) {
		SecureRandom rand = new SecureRandom();
		
		
		BigInteger prime = BigInteger.probablePrime(bitlength, rand);
		return prime;
	}
	
	protected static int getLengthDiff(BigInteger p, BigInteger q) {
		return Math.abs(p.toString().length()-q.toString().length());
	}
}
