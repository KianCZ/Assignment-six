
import java.util.ArrayList;

/*
 * Class: CMSC203 CRN 36406
 Program: Assignment 6
 Instructor: Farnaz Eivazi
 Summary of Description: keeps track of one order and the related time, order number, and beverages
 Due Date: 5/4/2022
 Integrity Pledge: I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: Kian Charkhabi
 */
public class Order implements OrderInterface, Comparable {
	private int orderNo;
	private DAY day;
	private int time;

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public int getOrderTime() {
		return this.time;
	}

	public DAY getOrderDay() {
		return this.day;
	}

	private ArrayList<Beverage> bevs = new ArrayList<Beverage>();
	private Customer c;

	public Order(int i, DAY s, Customer c) {
		this.orderNo = i;
		this.day = s;
		this.c = c;
	}

	public int ranNum() {
		return (int) (Math.random() * 80000 + 10001);
	}

	public void addNewBeverage(String s, SIZE a, int i, boolean b) {
		Smoothie e = new Smoothie(s, a, i, b);
		bevs.add(e);
	}

	public void addNewBeverage(String s, SIZE a, boolean b, boolean b2) {
		Coffee e = new Coffee(s, a, b, b2);
		bevs.add(e);
	}

	public int getTotalItems() {
		return bevs.size();
	}

	@Override
	public int compareTo(Object o) {
		Order a = (Order) o;
		if (this.orderNo > a.orderNo) {
			return 1;
		}
		if (this.orderNo == a.orderNo) {
			return 0;
		}
		return -1;
	}

	@Override
	public boolean isWeekend() {
		if (day == DAY.SATURDAY || day == DAY.SUNDAY) {
			return true;
		}
		return false;
	}

	@Override
	public Beverage getBeverage(int i) {
		return bevs.get(i);
	}

	@Override
	public double calcOrderTotal() {
		double t = 0;
		for (int i = 0; i < bevs.size(); i++) {
			t += getBeverage(i).calcPrice();
		}
		return t;
	}

	public int getOrderNo() {
		return this.orderNo;
	}

	public void setOrderNo(int orderN) {
		this.orderNo = orderN;
	}

	public DAY getDay() {
		return this.day;
	}

	public void setDay(DAY day) {
		this.day = day;
	}

	public void setC(Customer c) {
		this.c = c;
	}

	@Override
	public int findNumOfBeveType(TYPE type) {
		int t = 0;
		for (int i = 0; i < bevs.size(); i++) {
			if (bevs.get(i).getType() == type) {
				t++;
			}
		}
		return t;
	}

	public Customer getCustomer() {
		Customer d = new Customer(c.getName(), c.getAge());
		return d;
	}

	@Override
	public void addNewBeverage(String s, SIZE a) {
		Alcohol e = new Alcohol(s, a, isWeekend());
		bevs.add(e);
	}

	public String toString() {
		String s = "";
		for (int i = 0; i < bevs.size(); i++) {
			s += getBeverage(i).toString() + "\n";
		}
		return "Order number " + getOrderNo() + " time " + getTime() + " on " + getDay() + " for customer "
				+ c.getName() + " beverages are\n" + s + "total cost " + calcOrderTotal();
	}
}
