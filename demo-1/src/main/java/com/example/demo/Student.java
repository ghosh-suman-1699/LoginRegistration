package com.example.demo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Student  implements Serializable {
	
	  public Student() {
	        // No-argument constructor
	  }
	
        private int id;
        private String name;
        private int age;

        // Empty constructor for Kryo serialization
       // public Student() {}

        public Student(int id, String name, int age) {
            this.id = id;
            this.name = name;
            this.age = age;
        }

        // toString() method for printing the student object
        @Override
        public String toString() {
            return "Student{" +"id=" + id +", name='" + name + '\'' +", age=" + age +'}';
      }
}
