package com.tourism.tourism.configuration.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Password {
	public static void main(String[] args) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		CharSequence a = passwordEncoder.encode("123456");
		String b = passwordEncoder.encode("123456");

		System.out.println(a);
		System.out.println(b);
	}
}
