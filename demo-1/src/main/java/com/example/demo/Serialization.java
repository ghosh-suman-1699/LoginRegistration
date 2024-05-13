package com.example.demo;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Serialization {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student s1 =new Student(1, "suman ghosh", 22);
		Student s3 =new Student(2, "sumit ghosh", 12);
		String fileName ="D:\\java\\New_folder\\Text.txt";
		
		try {
			
			FileOutputStream fos=new FileOutputStream(fileName);
			ObjectOutputStream os=new ObjectOutputStream(fos);
			os.writeObject(s1);
			os.close();
			fos.close();
			
			System.out.println("saved");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
