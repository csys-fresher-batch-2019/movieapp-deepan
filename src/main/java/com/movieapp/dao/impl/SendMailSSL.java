package com.movieapp.dao.impl;

import java.io.IOException;
import java.util.Random;

public class SendMailSSL {
	public static String otp = null;

	public static String generatorOTP(int length) {
		Random rnd = new Random();
		int number = rnd.nextInt(999999);
		otp = String.format("%06d", number);
		return (otp);

	}

	public static String emailOTP() {

		return otp;

	}

	public static void sendEmail(String email) throws IOException {
		otp = generatorOTP(4);
		SendMail.send("payrollmavenproject@gmail.com", "Pass1234*", email, "Password Reset Request", "Hello user", otp);
		emailOTP();
	}

}
