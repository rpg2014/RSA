package com.rpg2014.rsa.keys;

import java.io.Serializable;
import java.math.BigInteger;

public class PublicKey implements Serializable{
	
	private BigInteger n;
	private BigInteger e;
	/**
	 * @param n
	 * @param e
	 */
	public PublicKey(BigInteger n, BigInteger e) {
		this.n = n;
		this.e = e;
				
	}
	
	public BigInteger getE() {
		return e;
		
	}
	public BigInteger getN() {
		return n;
	}
	
	public String toString() {
		return "n = " + n.toString().substring(0, 5)+"... | e = "+ e.toString().substring(0, 5);
	}
}
