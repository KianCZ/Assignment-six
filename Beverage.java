

/*
 * Class: CMSC203 CRN 36406
 Program: Assignment 6
 Instructor: Farnaz Eivazi
 Summary of Description: Objecte that keeps track of size, type, and name of bevarage
 Due Date: 5/4/2022
 Integrity Pledge: I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: Kian Charkhabi
 */
public abstract class Beverage {
	private String bevName;
	private SIZE size;
	private TYPE type;
	private final double basePrice = 2;
	private final double sPrice = 1;

	Beverage(String n, TYPE string, SIZE medium) {
		this.bevName = n;
		this.type = string;
		this.size = medium;
	}

	public double getBasePrice() {
		return basePrice;
	}

	public double getsPrice() {
		return sPrice;
	}

	public String getBevName() {
		return bevName;
	}

	public void setBevName(String name) {
		this.bevName = name;
	}

	public SIZE getSize() {
		return size;
	}

	public void setSize(SIZE size) {
		this.size = size;
	}

	public TYPE getType() {
		return type;
	}

	public void setType(TYPE type) {
		this.type = type;
	}

	public abstract double calcPrice();

	public String toString() {
		return bevName + " size " + size;
	}

	public boolean equals(Beverage b) {
		if (b.getBevName().equals(this.getBevName()) && this.getType().equals(b.getType())
				&& this.getSize().equals(b.getSize())) {
			return true;
		}
		return false;
	}
}
