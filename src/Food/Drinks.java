package Food;

public class Drinks implements FoodItems {

    String drinkName;
    String drinkBrand;
    Integer drinkIdentity;
    Double drinkPrice;

    public Drinks(String name, String brand, Integer identity, Double price) {
        this.drinkName = name;
        this.drinkBrand = brand;
        this.drinkIdentity = identity;
        this.drinkPrice = price;

        //greeting();
    }

    public String getDrinkName() {
        return this.drinkName;
    }

    public String getDrinkBrand() {
        return this.drinkBrand;
    }

    public Integer getDrinkIdentity() {
        return this.drinkIdentity;
    }

    public Double getDrinkPrice() {
        return this.drinkPrice;
    }

    @Override
    public void greeting() {
        System.out.println();
        System.out.println("Hello Sir/Madam this is the Drinks Machine!");
        System.out.println();
    }
    
}
