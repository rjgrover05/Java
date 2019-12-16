package com.rj.test;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 
 * @author raj
 *
 */
public class SendMailApplication {

	public static void sendMail(String emailAddress, String message, String[][] friendsArray) {
		Set<String> emailSet = new LinkedHashSet<String>();
		emailSet.add(emailAddress.trim().toLowerCase());
		for (int i = 0; i < friendsArray.length; i++) {
			emailSet.add(friendsArray[i][0]);
			for (int j = 0; j < friendsArray[i].length; j++) {
				if (j == 1) {
					String[] emailArr = friendsArray[i][j].split(",");
					for (String email : emailArr) {
						emailSet.add(email.trim().toLowerCase());
					}
				}
			}
		}

		emailSet.stream().forEach(e -> System.out.println("Mail Successfully send to: " + e));
	}

	public static void main(String[] args) {
		String[][] friendsArray = new String[][] {
				{ "rahul@test.com", "rajat@test.com, rashmi@test.com, vinod@test.com" },
				{ "vineet@test.com", " ajay@test.com, rajat@test.com, rahul@test.com " },
				{ "vinod@test.com", "rahul@test.com, nitin@test.com, vineet@test.com" } };
		Scanner scanner = new Scanner(System.in);
		String emailAddress = scanner.nextLine();
		SendMailApplication.sendMail(emailAddress.trim().toLowerCase(), "Hi.....", friendsArray);
		scanner.close();
	}
}
