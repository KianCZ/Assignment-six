
/*
 * Class: CMSC203 CRN 36406
 Program: Assignment 6
 Instructor: Farnaz Eivazi
 Summary of Description: Beverage that keeps track of number of fruits and whether theres protein powder
 Due Date: 5/4/2022
 Integrity Pledge: I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: Kian Charkhabi
 */
public class Smoothie extends Beverage {
	private int numOfFruits;
	private boolean pow;
	private final double fruitC = .5;
	private final double powC = 1.5;

	Smoothie(String n, TYPE t, SIZE s) {
		super(n, t, s);
	}

	public Smoothie(String n, SIZE medium, int i, boolean b) {
		super(n, TYPE.SMOOTHIE, medium);
		this.numOfFruits = i;
		this.pow = b;
	}

	public int getNumOfFruits() {
		return numOfFruits;
	}

	public void setNumOfFruits(int nFruit) {
		this.numOfFruits = nFruit;
	}

	public boolean getAddProtein() {
		return pow;
	}

	public boolean getAddProtien() {
		return pow;
	}

	public String toString() {
		String s = " has " + numOfFruits + " fruits ";
		if (pow) {
			s += "also has protein ";
		} else {
			s += "doesn't have protein";
		}
		return super.toString() + s + " costs " + calcPrice();
	}

	@Override
	public double calcPrice() {
		double a = 0;
		if (getAddProtein()) {
			a = powC;
		}
		if (getSize() == SIZE.LARGE) {
			a += 2;
		}
		if (getSize() == SIZE.MEDIUM) {
			a++;
		}
		return getBasePrice() + (fruitC * getNumOfFruits() + a);
	}

}
