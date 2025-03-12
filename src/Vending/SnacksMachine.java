package Vending;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import Food.Snacks;

public class SnacksMachine implements VendingMachine<Snacks> {

    public String machineIdentity;
    public Integer machineCapacity;
            
    public Map<Integer, Integer> snackCountMap;
    public Map<Integer, Snacks> snackMap;
    public Set<String> snackSet;
            
    public SnacksMachine(String identity, Integer capacity) {
        this.machineIdentity = identity;
        this.machineCapacity = capacity;

        this.snackCountMap = new HashMap<>();
        this.snackMap = new HashMap<>();
        this.snackSet = new HashSet<>();
    }

    /*
     * 
     * Adds 10 items if the vending machine does not exceeds capacity!
     * 
     */

    @Override
    public void addItems(Snacks foodItems) {
        System.out.println();
        
        if (this.snackSet.contains(foodItems.getSnackName())) {
            this.snackCountMap.put(foodItems.getSnackIdentity(), this.snackCountMap.get(foodItems.getSnackIdentity()) + 10);
            System.out.println("Drinks has been added to the drinks vending machine!");
        } else {
            if (this.machineCapacity.equals(snackSet.size())) {
                System.out.println("No more drinks can be added to the drinks vending machine!");
            } else {
                this.snackSet.add(foodItems.getSnackName());
                this.snackMap.put(foodItems.getSnackIdentity(), foodItems);
                this.snackCountMap.put(foodItems.getSnackIdentity(), 10);
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

        if (!this.snackMap.containsKey(buttonNumber)) {
            System.out.println("The drinks vending machine does not contains this drink!");
        } else {
            Snacks foodItems = this.snackMap.get(buttonNumber);
            this.snackCountMap.put(foodItems.getSnackIdentity(), this.snackCountMap.get(foodItems.getSnackIdentity()) - 1);
            if (this.snackCountMap.get(foodItems.getSnackIdentity()) == 0) {
                this.snackCountMap.remove(foodItems.getSnackIdentity());
                this.snackMap.remove(foodItems.getSnackIdentity());
            }
            System.out.println("Here is your drink, please enjoy!");
            return foodItems.getSnackPrice();
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

        if (this.snackSet.isEmpty()) {
            System.out.println("There are no items in the vending machine, sorry for the inconvinience!");
        } else {
            System.out.println("<----- DRINKS VENDING MACHINE ----->");
            System.out.println();
            for (Integer key: this.snackMap.keySet()) {
                System.out.println(key + " : " + this.snackMap.get(key).getSnackName() + " : " + this.snackCountMap.get(key));
            }
            System.out.println();
            System.out.println("<---------------------------------->");
        }

        System.out.println();
    }

}