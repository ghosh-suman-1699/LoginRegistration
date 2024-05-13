package com.example.demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

public class Kryo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student stu=new Student(1,"suman ghosh", 24);
		Kryo kryo=new Kryo();
		kryo.register(Student.class);
		
		Output output=null;
		Input input=null;
	    try {
	    	output = new Output(new FileOutputStream("D:\\java\\New_folder\\Txet.txt"));
			input = new Input(new FileInputStream("D:\\\\java\\\\New_folder\\\\Txet.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    kryo.writeObject(output,stu);
	    output.close();
	    
	    kryo.writeObject(input, stu);
	    input.close();
	    
	    assertEquals(readstu.this.name(), "suman ghosh");


}
