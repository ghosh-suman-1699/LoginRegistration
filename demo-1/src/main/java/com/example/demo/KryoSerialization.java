package com.example.demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;


public class KryoSerialization {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		Student student = new Student(01,"suman ghosh",24);
		
		 Kryo kryo = new Kryo();
		 Output output=null;
		 Input input=null;
		 System.out.println("ok");
		 //serialization
		 try {
			output = new Output(new FileOutputStream("D:\\java\\New_folder\\Text.txt"));
			input = new Input(new FileInputStream("D:\\java\\New_folder\\Text.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 System.out.println("save");
		 kryo.writeObject(output, student);
		 output.close();
		 System.out.println("save");

		 //de-serialization
		 
		 Student readStudent = kryo.readObject(input, Student.class);
		 input.close();
		 System.out.println("Deserialized student: " + readStudent);

		//System.out.println("save");
	}

}
