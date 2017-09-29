package com.rpg2014.rsa.keys;

public class RSAKey {

	
	private PrivateKey privateKey;
	private PublicKey publicKey;
	
	/**
	 * @param p
	 * @param pr
	 */
	RSAKey(PublicKey p,PrivateKey pr){
		this.publicKey = p;
		this.privateKey = pr;
	}

	public PrivateKey getPrivateKey() {
		return privateKey;
	}

	public PublicKey getPublicKey() {
		return publicKey;
	}
	
	public String toString() {
		return "Public Key = " + publicKey.toString() + "\nPrivate Key = "+privateKey.toString();
	}
}
