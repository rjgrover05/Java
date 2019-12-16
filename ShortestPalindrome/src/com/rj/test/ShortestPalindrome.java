package com.rj.test;
import java.io.IOException;
import java.util.Scanner;
/**
 * 
 * @author raj
 *
 */
public class ShortestPalindrome {
    public static void main(String args[]) throws IOException  {
 
        Scanner scanner = new Scanner(System.in);
        System.out.println("Reading input from console using Scanner in Java ");
        System.out.println("Please enter your input: ");
        String input = scanner.nextLine();
		String temp = "";
        for(int i = 0 ,j= input.length() -1; i< (input.length() + temp.length())/2 ; i++,j--){
			if(input.charAt(i) != input.charAt(j)){
				j = j +1;
				temp = temp + input.charAt(i);
			}
		}
		StringBuffer sbf = new StringBuffer(temp);
		System.out.println(input+sbf.reverse());	
		
		scanner.close();
    }
}
 