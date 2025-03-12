package Vending;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import Food.Drinks;

public class DrinksMachine implements VendingMachine<Drinks> {

    public String machineIdentity;
    public Integer machineCapacity;
            
    public Map<Integer, Integer> drinkCountMap;
    public Map<Integer, Drinks> drinkMap;
    public Set<String> drinkSet;
            
    public DrinksMachine(String identity, Integer capacity) {
        this.machineIdentity = identity;
        this.machineCapacity = capacity;

        this.drinkCountMap = new HashMap<>();
        this.drinkMap = new HashMap<>();
        this.drinkSet = new HashSet<>();
    }

    /*
     * 
     * Adds 10 items if the vending machine does not exceeds capacity!
     * 
     */

    @Override
    public void addItems(Drinks foodItems) {
        System.out.println();
        
        if (this.drinkSet.contains(foodItems.getDrinkName())) {
            this.drinkCountMap.put(foodItems.getDrinkIdentity(), this.drinkCountMap.get(foodItems.getDrinkIdentity()) + 10);
            System.out.println("Drinks has been added to the drinks vending machine!");
        } else {
            if (this.machineCapacity.equals(drinkSet.size())) {
                System.out.println("No more drinks can be added to the drinks vending machine!");
            } else {
                this.drinkSet.add(foodItems.getDrinkName());
                this.drinkMap.put(foodItems.getDrinkIdentity(), foodItems);
                this.drinkCountMap.put(foodItems.getDrinkIdentity(), 10);
                System.out.println("Drinks has been added to the drinks vending machine!");
            }
        }

        System.out.println();
    }

    /*
     * 
     * Removes 1 item if the vending machine have the item!
     * 
     */

    @Override
    public Double removeItems(Integer buttonNumber) {
        System.out.println();

        if (!this.drinkMap.containsKey(buttonNumber)) {
            System.out.println("The drinks vending machine does not contains this drink!");
        } else {
            Drinks foodItems = this.drinkMap.get(buttonNumber);
            this.drinkCountMap.put(foodItems.getDrinkIdentity(), this.drinkCountMap.get(foodItems.getDrinkIdentity()) - 1);
            if (this.drinkCountMap.get(foodItems.getDrinkIdentity()) == 0) {
                this.drinkCountMap.remove(foodItems.getDrinkIdentity());
                this.drinkMap.remove(foodItems.getDrinkIdentity());
            }
            System.out.println("Here is your drink, please enjoy!");
            return foodItems.getDrinkPrice();
        }

        System.out.println();
        return 0.0;
    }

    /*
     * 
     * Shows the items present in the vending machine!
     * 
     */

    @Override
    public void show() {
        System.out.println();

        if (this.drinkSet.isEmpty()) {
            System.out.println("There are no items in the vending machine, sorry for the inconvinience!");
        } else {
            System.out.println("<----- DRINKS VENDING MACHINE ----->");
            System.out.println();
            for (Integer key: this.drinkMap.keySet()) {
                System.out.println(key + " : " + this.drinkMap.get(key).getDrinkName() + " : " + this.drinkCountMap.get(key));
            }
            System.out.println();
            System.out.println("<---------------------------------->");
        }

        System.out.println();
    }

}