package com.example.demo.exceptions.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CheckedExceptionCreaterTest {

	static String fileName = "readMe.TEXT1";

	public static void main(String[] args) throws IncorrectFileNameException {

		try (Scanner file = new Scanner(new File(fileName))) {
			if (file.hasNextLine()) {
				System.out.println(file.nextLine());
			}
		} catch (FileNotFoundException ex) {
			/**
			 * The code above is a classic way of handling Java checked exceptions. While
			 * the code throws FileNotFoundException, it’s not clear what the exact cause is
			 * — whether the file does not exist or the file name is invalid.
			 */
			if(!correctFileName(fileName)) {
				throw new IncorrectFileNameException("Incorrect filename : " + fileName, ex );
			}
		}
	}
	
	public static boolean correctFileName(String fileName) {
		if(fileName.equalsIgnoreCase("readMe.TEXT")) {
			return true;
		}else {
			return false;
		}
	}
	
}
