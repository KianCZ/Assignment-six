

/*
 * Class: CMSC203 CRN 36406
 Program: Assignment 6
 Instructor: Farnaz Eivazi
 Summary of Description: Beverage that keeps track of cost and if alcohol can be consumed on this day
 Due Date: 5/4/2022
 Integrity Pledge: I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: Kian Charkhabi
 */
public class Alcohol extends Beverage {
	private boolean alco;
	private final double cos = .6;

	Alcohol(String n, TYPE string, SIZE medium) {
		super(n, string, medium);
	}

	public Alcohol(String n, SIZE s, boolean b) {
		super(n, TYPE.ALCOHOL, s);
		this.alco = b;
	}

	public boolean getAlco() {
		return alco;
	}

	public void setAlco(boolean alco) {
		this.alco = alco;
	}

	@Override
	public double calcPrice() {
		double a = 0;
		if (getSize() == SIZE.LARGE) {
			a += 2;
		}
		if (getSize() == SIZE.MEDIUM) {
			a++;
		}
		if (alco) {
			a += this.cos;
		}
		return getBasePrice() + a;
	}

	public String toString() {
		String s = " is not offered on the weekend ";
		if (alco) {
			s = " is offered on the weekend ";
		}
		return super.toString() + s + " costs " + calcPrice();
	}

}
