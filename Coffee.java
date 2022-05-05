

/*
 * Class: CMSC203 CRN 36406
 Program: Assignment 6
 Instructor: Farnaz Eivazi
 Summary of Description: Coffee bevarge which calculates additional ingredients
 Due Date: 5/4/2022
 Integrity Pledge: I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: Kian Charkhabi
 */
public class Coffee extends Beverage {
	private boolean cShot;
	private boolean sShot;
	private final double exCost = .5;

	Coffee(String n, TYPE t, SIZE s) {
		super(n, t, s);
	}

	public Coffee(String s, SIZE a, boolean b, boolean c) {
		super(s, TYPE.COFFEE, a);
		this.cShot = b;
		this.sShot = c;
	}

	public boolean getExtraShot() {
		return cShot;
	}

	public boolean getExtraSyrup() {
		return sShot;
	}

	public String toString() {
		String f = " does not contain extra shot ";
		String c = " does not contain extra syrup ";
		if (getExtraShot()) {
			f = " contains extra shot ";
		}
		if (getExtraSyrup()) {
			c = " contain extra syrup ";
		}
		return super.toString() + f + c + " costs " + calcPrice();
	}

	@Override
	public double calcPrice() {
		double c = 0;
		if (getExtraShot()) {
			c += exCost;
		}
		if (getExtraSyrup()) {
			c += exCost;
		}
		if (getSize() == SIZE.LARGE) {
			c += 2;
		}
		if (getSize() == SIZE.MEDIUM) {
			c++;
		}
		return getBasePrice() + c;
	}

	public boolean equals(Coffee b) {
		if (super.equals(b) && b.getExtraShot() == this.getExtraShot() && b.getExtraShot() == this.getExtraSyrup()) {
			return true;
		}
		return false;
	}
}
