package Food;

public class Snacks implements FoodItems {

    String snackName;
    String snackBrand;
    Integer snackIdentity;
    Double snackPrice;

    public Snacks(String name, String brand, Integer identity, Double price) {
        this.snackName = name;
        this.snackBrand = brand;
        this.snackIdentity = identity;
        this.snackPrice = price;

        //greeting();
    }

    public String getSnackName() {
        return this.snackName;
    }

    public String getSnackBrand() {
        return this.snackBrand;
    }

    public Integer getSnackIdentity() {
        return this.snackIdentity;
    }

    public Double getSnackPrice() {
        return this.snackPrice;
    }

    @Override
    public void greeting() {
        System.out.println();
        System.out.println("Hello Sir/Madam this is the Snacks Machine!");
        System.out.println();
    }
    
}
