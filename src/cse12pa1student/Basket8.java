package cse12pa1student;

import java.util.ArrayList;
import java.util.Arrays;

public class Basket8 implements Basket {

    public Basket8() {
        this.items = new ArrayList<ArrayList<Item>>();
    }

    ArrayList<ArrayList<Item>> items;

    @Override
    public int count() {
        int count = 0;
        for (int i = 1; i < this.items.size(); i++) {
            count += this.items.get(i).size() * i;
        }
        return count;
    }

    @Override
    public int countItem(Item i) {
        for (int j = 0; j < this.items.size(); j++) {
            if (this.items.get(j).contains(i))
                return j;
        }
        return 0;
    }

    @Override
    public int totalCost() {
        int totalCost = 0;
        for (int i = 1; i < this.items.size(); i++) {
            for (Item item : this.items.get(i)) {
                totalCost += item.priceInCents * i;
            }
        }
        return totalCost;
    }

    @Override
    public void addToBasket(Item i) {
        // This is a list of lists. Each index has a list
        // Index 1 is the list where the last new item added will be in

        // Start with index 1. This basket never uses index 0
        // For each index in outer list, search for item...
        for (int j = 1; j < this.items.size(); j++) {
            // If item exists in sublist...
            if (this.items.get(j).contains(i)) {
                // Remove item from sublist...
                this.items.get(j).remove(i);
                // Then reinsert item in the NEXT sublist after next item
                // (Make a new sublist after if necessary)
                if (j + 1 == this.items.size()) {
                    ArrayList<Item> temp = new ArrayList<Item>();
                    temp.add(i);
                    this.items.add(temp);
                } else{
                    this.items.get(j + 1).add(i);
                }
                return;
                // So basically, if an item is found, move it to the next sublist
            }
        }
        // We reach this point only if item is brand new (has not been found)
        // Make sure the list has a sublist at index 1
        while(this.items.size() <= 1)
            this.items.add(new ArrayList<Item>());
        // Add item to beginning, if item is new
        this.items.get(1).add(i);
    }

    @Override
    public boolean removeFromBasket(Item i) {
        for (int j = 1; j < this.items.size(); j++) {
            if (this.items.get(j).contains(i)) {
                this.items.get(j).remove(i);
                this.items.get(j - 1).add(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean removeAllFromBasket(Item i) {
        for (int j = 1; j < this.items.size(); j++) {
            if (this.items.get(j).contains(i))
                return this.items.get(j).remove(i);
        }
        return false;
    }

    @Override
    public void empty() {
        this.items.clear();
    }
}
