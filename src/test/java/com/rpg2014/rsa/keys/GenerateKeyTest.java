package com.rpg2014.rsa.keys;

import java.math.BigInteger;

import org.junit.Test;

public class GenerateKeyTest {
	@Test
	public void generateKeyTest() {
		RSAKey key = GenerateKey.generateKey(4096);
		System.out.println(key.toString());
	}
}
