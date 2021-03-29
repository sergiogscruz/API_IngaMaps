package com.tourism.tourism.configuration.security;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Password {
	public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		CharSequence a = passwordEncoder.encode("123456");
		String b = passwordEncoder.encode("123456");

		System.out.println(a);
		System.out.println(b);
	}
}
