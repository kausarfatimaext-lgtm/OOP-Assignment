package Payments;

public class Card implements Payment{
    @Override
    public void getMethod(double amount){
        System.out.println("Payment for the amount of " + amount + " is done via Card");
    }
}
