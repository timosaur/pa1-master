package cse12pa1student;

import java.util.Collection;
import java.util.Arrays;

import static org.junit.Assert.*;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class BasketTest {

	public static Collection<Object[]> BAGNUMS =
			Arrays.asList(new Object[][] { {0}, {1}, {2}, {3}, {4}, {5}, {6}, {7}, {8}, {9}, {10}, {11}, {12} });
	private int bagType;

	public BasketTest(int bagType) {
		super();
		this.bagType = bagType;
	}

	@Parameterized.Parameters(name = "Basket{index}")
	public static Collection<Object[]> bags() {
		return BAGNUMS;
	}
	
	private Basket makeBasket() {
		switch(this.bagType) {
			case 0: return new Basket0();
			case 1: return new Basket1();
			case 2: return new Basket2();
			case 3: return new Basket3();
			case 4: return new Basket4();
			case 5: return new Basket5();
			case 6: return new Basket6();
			case 7: return new Basket7();
			case 8: return new Basket8();
			case 9: return new Basket9();
			case 10: return new Basket10();
			case 11: return new Basket11();
			case 12: return new Basket12();
		}
		return null;
	}
/*
	@Test
	public void addedHasCount0() {
		Basket basketToTest = makeBasket();
		assertEquals(0, basketToTest.count());
	}
*/
	@Test
	public void addedHasCount1() {
		Basket basketToTest = makeBasket();

		Item i = new Item("Shampoo", 5);
		basketToTest.addToBasket(i);
		assertEquals(1, basketToTest.count());
		assertEquals(1, basketToTest.countItem(i));
	}

	@Test
	public void addedPartialDupCounts() {
		Basket basketToTest = makeBasket();

		Item i = new Item("Shampoo", 5);
		Item j = new Item("Shampoo", 5);
		Item k = new Item("Soap", 4);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(j);
		basketToTest.addToBasket(k);
		assertEquals(3, basketToTest.count());
		assertEquals(2, basketToTest.countItem(i));
		assertEquals(2, basketToTest.countItem(j));
		assertEquals(1, basketToTest.countItem(k));
	}

	@Test
	public void addedDupHasCount3() {
		Basket basketToTest = makeBasket();

		Item i = new Item("Shampoo", 5);
		Item j = new Item("Shampoo", 5);
		Item k = new Item("Shampoo", 5);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(j);
		basketToTest.addToBasket(k);
		assertEquals(3, basketToTest.count());
		assertEquals(3, basketToTest.countItem(i));
	}

	@Test
	public void over1000Items() {
		Basket basketToTest = makeBasket();

		Item i = new Item("Shampoo", 5);
		for(int k =0;k<1001;k++){
			basketToTest.addToBasket(i);
		}
		assertEquals(1001, basketToTest.count());
	}

	@Test
	public void emptyAddAgain() {
		Basket basketToTest = makeBasket();

		Item i = new Item("Shampoo", 5);
		Item k = new Item("Soap", 5);
		Item h = new Item("Shampoo", 5);
		basketToTest.addToBasket(i);
		basketToTest.empty();
		basketToTest.addToBasket(k);
		basketToTest.empty();
		basketToTest.addToBasket(h);
		assertEquals(1, basketToTest.count());
	}
	@Test
	public void totalPrice() {
		Basket basketToTest = makeBasket();
		Item i = new Item("Shampoo", 5);
		basketToTest.addToBasket(i);
		assertEquals(5, basketToTest.totalCost());
	}
	@Test
	public void addRemoveTotalPrice() {
		Basket basketToTest = makeBasket();
		Item i = new Item("Shampoo", 5);
		Item k = new Item("Soap", 5);
		Item h = new Item("Shampoo", 5);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(k);
		basketToTest.removeFromBasket(i);
		basketToTest.addToBasket(h);
		assertEquals(10, basketToTest.totalCost());
	}
	@Test
	public void removeFirstInstance() {
		Basket basketToTest = makeBasket();
		Item i = new Item("Shampoo", 3);
		Item j = new Item("Shampoo", 4);
		Item k = new Item("Shampoo", 5);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(j);
		basketToTest.addToBasket(k);
		basketToTest.removeFromBasket(i);
		assertEquals(9, basketToTest.totalCost());
	}
	@Test
	public void countLastItem() {
		Basket basketToTest = makeBasket();
		Item i = new Item("Shampoo", 5);
		basketToTest.addToBasket(i);
		assertEquals(1, basketToTest.countItem(i));
	}

	@Test
	public void removeItemTwice() {
		Basket basketToTest = makeBasket();
		Item i = new Item("Shampoo", 5);
		Item j = new Item("Shampoo", 5);
		Item k = new Item("Shampoo", 5);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(k);
		basketToTest.addToBasket(j);
		basketToTest.removeFromBasket(i);
		basketToTest.removeFromBasket(k);
		assertEquals(1, basketToTest.countItem(i));
	}



}
