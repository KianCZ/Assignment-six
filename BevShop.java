

/*
 * Class: CMSC203 CRN 36406
 Program: Assignment 6
 Instructor: Farnaz Eivazi
 Summary of Description: Uses all the prior classes to create a shop that can calculate total profits and keep track of orders
 Due Date: 5/4/2022
 Integrity Pledge: I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: Kian Charkhabi
 */
import java.util.ArrayList;

public class BevShop implements BevShopInterfce {
	int ord = 0;
	private int currentOrder;
	private int alcoD=0;
	private ArrayList<Order> ords = new ArrayList<Order>();

	@Override
	public boolean validTime(int time) {
		if (time >= MIN_TIME && time <= MAX_TIME) {
			return true;
		}
		return false;
	}

	@Override
	public boolean validAge(int age) {
		if (age > MIN_AGE_FOR_ALCOHOL) {
			return true;
		}
		return false;
	}

	public void startNewOrder(int time, DAY day, String customerName, int customerAge) {
		alcoD=0;
		ord++;
		currentOrder = ords.size();
		ords.add(currentOrder, new Order(ord, day, new Customer(customerName, customerAge)));
		ords.get(currentOrder).setOrderNo(ord);
		ords.get(currentOrder).setTime(time);

	}

	public void processAlcoholOrder(String bevName, SIZE size) {
		ords.get(currentOrder).addNewBeverage(bevName, size);
		alcoD++;
	}

	public void processCoffeeOrder(String bevName, SIZE size, boolean extraShot, boolean extraSyrup) {
		ords.get(currentOrder).addNewBeverage(bevName, size, extraShot, extraSyrup);
	}

	public void processSmoothieOrder(String bevName, SIZE size, int numOfFruits, boolean addProtien) {
		ords.get(currentOrder).addNewBeverage(bevName, size, numOfFruits, addProtien);
	}

	public Order getCurrentOrder() {
		return ords.get(currentOrder);
	}

	public double totalMonthlySale() {
		double t = 0;
		for (int i = 0; i < ords.size(); i++) {
			t += ords.get(i).calcOrderTotal();
		}
		return t;
	}

	public int getNumOfAlcoholDrink() {
		return alcoD;
	}

	public int totalNumOfMonthlyOrders() {
		return ords.size();
	}

	public int findOrder(int orderNo) {
		for (int i = 0; i < ords.size(); i++) {
			if (ords.get(i).getOrderNo() == orderNo) {
				return i;
			}
		}
		return -1;
	}

	public boolean eligibleForMore() {
		if (alcoD < MAX_ORDER_FOR_ALCOHOL) {
			return true;
		}
		return false;
	}

	public double totalOrderPrice(int orderNo) {
		return ords.get(findOrder(orderNo)).calcOrderTotal();
	}

	public boolean isMaxFruit(int i) {
		if (i > MAX_FRUIT) {
			return true;
		}
		return false;
	}

	public String toString() {
		String s = "";
		for (int i = 0; i < ords.size(); i++) {
			s += ords.get(i).toString() + "\n";
		}
		return s + "total monthly sales " + totalMonthlySale();
	}

	public int getMaxOrderForAlcohol() {
		return MAX_ORDER_FOR_ALCOHOL;
	}

	public int getMinAgeForAlcohol() {
		return MIN_AGE_FOR_ALCOHOL;
	}

	@Override
	public void sortOrders() {
		int s = 0;
		Order o;
		for (int i = 0; i < ords.size(); i++) {
			for (int f = 0; f < ords.size(); f++) {
				if (ords.get(i).getOrderNo() < ords.get(f).getOrderNo()) {
					o = ords.get(i);
					ords.remove(ords.get(i));
					ords.add(i, ords.get(f));
					ords.add(f, o);
				}
			}
		}
	}

	@Override
	public Order getOrderAtIndex(int index) {
		return ords.get(index);
	}
}
