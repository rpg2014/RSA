package com.rpg2014.rsa.keys;

import java.io.Serializable;
import java.math.BigInteger;

public class PrivateKey implements Serializable{

	private BigInteger n;
	private BigInteger d;
	/**
	 * @param n
	 * @param d
	 */
	public PrivateKey(BigInteger n, BigInteger d) {
		this.n = n;
		this.d = d;
				
	}
	
	public BigInteger getD() {
		return d;
		
	}
	public BigInteger getN() {
		return n;
	}
	
	public String toString() {
		return "n = " + n.toString().substring(0, 5)+"... | d = "+ d.toString().substring(0, 5)+"...";
	}
}
