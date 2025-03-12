package Vending;

public interface VendingMachine<T>  {

    public void addItems(T foodItems);
    public Double removeItems(Integer buttonNumber);
    public void show();

}