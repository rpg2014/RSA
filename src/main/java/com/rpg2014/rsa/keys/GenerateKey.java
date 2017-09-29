package com.rpg2014.rsa.keys;

import java.math.BigInteger;
import java.util.ArrayList;

/**
 * @author rpg2014
 *
 */
public class GenerateKey {

	
	
	/**
	 * @param bitLength
	 * might need to change return type
	 */
	public static RSAKey generateKey(int bitLength) {
		ArrayList<BigInteger> primes = PrimeGenerator.generatePrimes(bitLength/2);
		BigInteger n = calculateModulous(primes.get(0),primes.get(1));
		BigInteger lambda = lcm(primes.get(0).subtract(new BigInteger("1")),primes.get(1).subtract(new BigInteger("1")));
		BigInteger e = new BigInteger("65537"); // this is  commmon practice
		BigInteger d = calculateD(e,lambda);
		return buildKey(n,e,d);
		
	}
	
	
	private static RSAKey buildKey(BigInteger n, BigInteger e, BigInteger d) {
		PublicKey pubkey = new PublicKey(n,e);
		PrivateKey priKey = new PrivateKey(n,d);
		RSAKey key = new RSAKey(pubkey,priKey);
		return key;
	}
	
	private static BigInteger calculateD(BigInteger e, BigInteger lambda) {
		return e.modInverse(lambda);
	}

	/**
	 * @param p
	 * @param q
	 * @return the modulous n
	 */
	private static BigInteger calculateModulous(BigInteger p, BigInteger q) {
		return p.multiply(q);
	}
	
	
	private static BigInteger gcd(BigInteger a, BigInteger b)
	{
	    return a.gcd(b);
	}

	private static BigInteger lcm(BigInteger a, BigInteger b)
	{
	    return a.multiply((b.divide(gcd(a, b))));
	}
}
