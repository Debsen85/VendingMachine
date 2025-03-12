import Vending.VendingMachine;

import java.util.Scanner;

import Food.Drinks;
import Food.FoodItems;
import Food.Snacks;
import Vending.DrinksMachine;
import Vending.SnacksMachine;

public class App {
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static void main(String[] args) throws Exception {
        System.out.println();

        VendingMachine drinkVendingMachine = new DrinksMachine("Machine-A", 10);
        VendingMachine snackVendingMachine = new SnacksMachine("Machine-B", 10);

        FoodItems[] drinks = new FoodItems[11];

        drinks[0] = new Drinks("Coca-Cola", "Coca-Cola Company", 201, 35.00);
        drinks[1] = new Drinks("Pepsi", "PepsiCo", 202, 30.00);
        drinks[2] = new Drinks("Sprite", "Coca-Cola Company", 203, 28.00);
        drinks[3] = new Drinks("Fanta", "Coca-Cola Company", 204, 30.50);
        drinks[4] = new Drinks("Mountain Dew", "PepsiCo", 205, 32.00);
        drinks[5] = new Drinks("Red Bull", "Red Bull GmbH", 206, 110.00);
        drinks[6] = new Drinks("Monster", "Monster Beverage", 207, 120.00);
        drinks[7] = new Drinks("Minute Maid", "Coca-Cola Company", 208, 45.00);
        drinks[8] = new Drinks("Appy Fizz", "Parle Agro", 209, 35.00);
        drinks[9] = new Drinks("Bisleri", "Bisleri International", 210, 20.00);
        drinks[10] = new Drinks("Tropicana", "PepsiCo", 211, 50.00);

        for (FoodItems drink: drinks) {
            drinkVendingMachine.addItems(drink);
        }

        FoodItems[] snacks = new FoodItems[11];

        snacks[0] = new Snacks("Lays", "PepsiCo", 101, 25.50);
        snacks[1] = new Snacks("Oreo", "Mondelez", 102, 30.00);
        snacks[2] = new Snacks("KitKat", "Nestlé", 103, 40.75);
        snacks[3] = new Snacks("Pringles", "Kellogg's", 104, 50.00);
        snacks[4] = new Snacks("Doritos", "PepsiCo", 105, 35.20);
        snacks[5] = new Snacks("Cheetos", "PepsiCo", 106, 28.90);
        snacks[6] = new Snacks("Chips Ahoy", "Mondelez", 107, 45.50);
        snacks[7] = new Snacks("Munch", "Nestlé", 108, 32.80);
        snacks[8] = new Snacks("Biscuit", "Britannia", 109, 20.00);
        snacks[9] = new Snacks("Tata Salt", "Tata", 110, 15.40);
        snacks[10] = new Snacks("5 Star", "Cadbury", 111, 25.00);

        for (FoodItems snack: snacks) {
            snackVendingMachine.addItems(snack);
        }

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter your choice food item :");
        System.out.println("1 for drinks.");
        System.out.println("2 for snacks.");
        System.out.println("Anything else for exit.");
        System.out.println();

        int choice = scanner.nextInt(), choose = 0;
        
        System.out.println("Please enter an amount!!");

        int amount = scanner.nextInt();

        boolean flag = true;

        if (choice == 1) {
            while (flag == true) {
                System.out.println();

                drinkVendingMachine.show();
                System.out.print("Please choose : ");
                choose = scanner.nextInt();
                double price = drinkVendingMachine.removeItems(choose);
                if (price > amount) {
                    System.out.println("You do not have sufficient balance!");
                } else {
                    amount -= price;
                    System.out.println("Item queued!");
                }

                System.out.println();
                System.out.print("Do you want to continue ? (Y/N)");
                String check = scanner.next();
                if (check.equals("N")) {
                    flag = false;
                }
                System.out.println();
            }
        } else if (choice == 2) {
            while (flag == true) {
                System.out.println();

                snackVendingMachine.show();
                System.out.print("Please choose : ");
                choose = scanner.nextInt();
                double price = snackVendingMachine.removeItems(choose);
                if (price > amount) {
                    System.out.println("You do not have sufficient balance!");
                } else {
                    amount -= price;
                }

                System.out.println();
                System.out.print("Do you want to continue ? (Y/N)");
                String check = scanner.next();
                if (check.equals("N")) {
                    flag = false;
                }
                System.out.println();
            }
        }

        System.out.println();
        System.out.println("Here is your balance : " + amount);
        System.out.println("Thank you for our vending machine, hope you had a great time!");
        System.out.println();
        
        scanner.close();
        System.out.println();
    }
}
