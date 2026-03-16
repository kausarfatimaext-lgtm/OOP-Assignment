package Users;

import Services.Service;

import java.util.ArrayList;

public class Customer extends User {
    private String address;
    private long walletBalance;
    private ArrayList<Service> services = new ArrayList();

    public Customer(int id, String name, String phoneNo, String email, String address, long walletBalance){
        super(id, name, phoneNo, email);
        this.address = address;
        this.walletBalance = walletBalance;
    }

    public String getAddress(){
        return address;
    }
    public long getWalletBalance(){
        return walletBalance;
    }
    public void addServices(Service service){
        this.services.add(service);
    }
    public void getServicesHistory(){
        for (Service service : services) {
            System.out.println("Service Name: " + service.getType());
            System.out.println("Service Status: " + service.getStatus());
            System.out.println("Service Cost: " + service.getBaseCost());
            System.out.println("Service ServiceProvider: " + service.getServiceProvider().getName());
        }
    }
    public boolean OnPayment(double amount){
        if(amount > walletBalance){
            System.out.println("Wallet Balance is less than required amount");
            return false;
        }else{
            walletBalance -= (long) amount;
            return true;
        }
    }
    @Override
    public void getUserInfo(){
        System.out.println("Name of User: " + getName());
        System.out.println("Phone No of User: " + getPhoneNo());
        System.out.println("Email account of User: " + getEmail());
        System.out.println("Address of User: " + address);
        System.out.println("Wallet Balance of User: " + walletBalance);
        System.out.println("       --------------------------------------------------");
    }
}
