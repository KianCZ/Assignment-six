

/*
 * Class: CMSC203 CRN 36406
 Program: Assignment 6
 Instructor: Farnaz Eivazi
 Summary of Description: customer objective with age and name
 Due Date: 5/4/2022
 Integrity Pledge: I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: Kian Charkhabi
 */
public class Customer {
	private int age;
	private String name;

	Customer(Customer c) {
		this.age = c.getAge();
		this.name = c.getName();
	}

	public Customer(String s, int i) {
		this.age = i;
		this.name = s;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String toString() {
		return "customer age " + age + " name " + name;
	}
}
