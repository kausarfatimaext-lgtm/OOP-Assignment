import Payments.Card;
import Payments.Cash;
import Payments.Payment;
import Payments.Wallet;
import Services.DeviceRepair;
import Services.FoodDelivery;
import Services.HomeCleaning;
import Users.Customer;
import Users.ServiceProvider;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    Customer ali = new Customer(1, "Ali", "034527876376", "ali@gmail.com", "Lahore", 300);
    Customer Aisha = new Customer(2, "Aisha", "03452657352", "aisha@gmail.com", "Sialkot", 5000);

    ServiceProvider zubair = new ServiceProvider(1, "Zubair", "034542364623", "zubair@gmail.com", "Device Repair");
    ServiceProvider ahmad = new ServiceProvider(2, "Ahmad", "034536728387", "ahmad@gmail.com", "Food Delivery");
    ServiceProvider aliha = new ServiceProvider(3, "Aliha", "034509203909", "aliha@gmail.com", "Home Cleaning");

    FoodDelivery foodDelivery= new FoodDelivery(1, "12/4/2026", 400, ali, "ASSIGNED", "ABC", 40);
    HomeCleaning homeCleaning1= new HomeCleaning(2, "12/4/2026", 400, Aisha, "ASSIGNED", 45, 4);
    HomeCleaning homeCleaning2= new HomeCleaning(3, "12/4/2026", 400, Aisha, "ASSIGNED", 45, 4);

    if(foodDelivery.getDoProceed()){
        Card card = new Card();
        foodDelivery.setPayment(card);
        ali.addServices(foodDelivery);
    }

    if(homeCleaning1.getDoProceed()){
        Cash cash = new Cash();
        homeCleaning1.setPayment(cash);
        Aisha.addServices(homeCleaning1);
    }

    if(homeCleaning2.getDoProceed()){
        Wallet wallet = new Wallet();
        homeCleaning2.setPayment(wallet);
        Aisha.addServices(homeCleaning2);
    }

    if(foodDelivery.getDoProceed()){
        foodDelivery.assignedTo(ahmad);
        ahmad.assignService(foodDelivery);
    } else {
        System.out.println("Request did not proceed");
    }

    if(homeCleaning1.getDoProceed()){
        homeCleaning1.assignedTo(aliha);
        aliha.assignService(homeCleaning1);
    } else {
        System.out.println("Request did not proceed");
    }

    if(homeCleaning2.getDoProceed()){
        homeCleaning2.assignedTo(ahmad);
        ahmad.assignService(homeCleaning2);
    } else {
        System.out.println("Request did not proceed");
    }

    foodDelivery.changeStatus("CANCELLED");
    homeCleaning1.changeStatus("COMPLETED");
    homeCleaning1.addFeedback(1, "Service are good", 4);
    homeCleaning1.getFeedback();

    ahmad.getServicesBySkill("Food Delivery");
    aliha.getServicesBySkill("Home Cleaning");
}
