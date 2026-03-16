package Services;

import Users.Customer;

public class FoodDelivery extends Service{
    private String shopName;
    private double deliveryDistance;

    public FoodDelivery(int reqId, String date, double baseCost, Customer placedBy, String status, String shopName, double deliveryDistance){
        super(reqId, date, baseCost, placedBy, status, "Food Delivery");
        this.shopName = shopName;
        this.deliveryDistance = deliveryDistance;
    }

    public String getShopName(){
        return shopName;
    }
    public double getDeliveryDistance(){
        return deliveryDistance;
    }
}
