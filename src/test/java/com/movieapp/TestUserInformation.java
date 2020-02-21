package com.movieapp;

import java.util.ArrayList;
import java.util.Scanner;

import org.apache.poi.util.SystemOutLogger;

import com.movieapp.dao.UserInformationDAO;
import com.movieapp.dao.impl.SendMailSSL;
import com.movieapp.dao.impl.UserInformationImpl;
import com.movieapp.model.UserInformation;

public class TestUserInformation {

	public static void main(String[] args) throws Exception {

		// testAddUsers();
		// testDeleteUsers();
		testLoginCheck();

	}

	private static void testAddUsers() throws Exception {

		ArrayList<UserInformation> list = new ArrayList<UserInformation>();

		UserInformation ui = new UserInformation();

		ui.setUserName("Dinesh");
		ui.setEmailId("d@gmail.com");
		ui.setEpassword("din");
		ui.setMobileNum(8056581020l);
		ui.setGender("male");

		UserInformation ui1 = new UserInformation();

		ui1.setUserName("sheshu");
		ui1.setEmailId("sheshu@gmail.com");
		ui1.setEpassword("she");
		ui1.setMobileNum(7708939337l);
		ui1.setGender("female");

		list.add(ui);
		list.add(ui1);

		UserInformationImpl obj = new UserInformationImpl();
		for (UserInformation UI : list) {
			obj.addUserInformation(UI);
		}
	}

	private static void testDeleteUsers() throws Exception {
		UserInformationImpl obj = new UserInformationImpl();
		obj.deleteUserInformation(11164);
	}

	private static void testLoginCheck() throws Exception {

		UserInformationImpl obj = new UserInformationImpl();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Email Id:");
		String emailId = sc.next();
		System.out.println("Enter Password:");
		String epassword = sc.next();

		try {
			Integer str = obj.login(emailId, epassword);
			if (str == null) {
				testForgetPassword(emailId);
			} else {
				System.out.println("login success");
			}

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	private static void testForgetPassword(String email) throws Exception {

		Scanner sc = new Scanner(System.in);

		SendMailSSL.sendEmail(email);
		System.out.println("Your OTP is send to your Mail");
		System.out.println("Enter Your OTP:");
		String otp = sc.nextLine();

		String otp1 = SendMailSSL.emailOTP();

		if (otp1.equals(otp)) {
			System.out.println("Enter new password");
			String pass = sc.next();
			UserInformationImpl im = new UserInformationImpl();

			boolean password = im.updatePassword(email, pass);
			System.out.println("Your Password is Sucessfully Changed" + password + "" + email);

		} else
			System.out.println("Wrong OTP!");
	}

}
