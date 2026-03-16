package Services;

import Users.Customer;

public class HomeCleaning extends Service{
    private double areaSqFeet;
    private int noOfRooms;

    public HomeCleaning(int reqId, String date, double baseCost, Customer placedBy, String status, double areaSqFeet, int noOfRooms){
        super(reqId, date, baseCost, placedBy, status, "Home Cleaning");
        this.areaSqFeet = areaSqFeet;
        this.noOfRooms = noOfRooms;
    }

    public double getAreaSqFeet(){
        return areaSqFeet;
    }
    public int getNoOfRooms(){
        return noOfRooms;
    }
}
