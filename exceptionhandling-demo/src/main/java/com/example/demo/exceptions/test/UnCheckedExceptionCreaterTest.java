package com.example.demo.exceptions.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Optional;
import java.util.Scanner;

public class UnCheckedExceptionCreaterTest {

	static String fileName = "readMe.XML";
	
	public static void main(String[] args) {
		
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
			if(!correctFileExt(fileName)) {
				throw new IncorrectFileExtensionException("Incorrect file extension : " + fileName, ex);
			}
		}
	}
	
	
	public static boolean correctFileExt(String fileName) {
		Optional<String> ext = getExtensionByStringHandling(fileName);
		if(ext.get().equalsIgnoreCase("TEXT")) {
			return true;
		}else {
			return false;
		}
	}
	
	public static Optional<String> getExtensionByStringHandling(String filename) {
	    return Optional.ofNullable(filename)
	      .filter(f -> f.contains("."))
	      .map(f -> f.substring(filename.lastIndexOf(".") + 1));
	}
}
