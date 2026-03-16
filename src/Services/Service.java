package Services;

import Payments.Card;
import Payments.Cash;
import Payments.Payment;
import Payments.Wallet;
import Users.Customer;
import Users.ServiceProvider;
import Feedback.Feedback;

public class Service {
    private int reqId;
    private String date;
    private double baseCost;
    private String status;
    private Customer customer;
    private ServiceProvider serviceProvider;
    private Feedback feedback;
    private String type;
    private Payment payment;
    private boolean doProceed;
    private boolean isAssigned;

    public Service(int reqId, String date, double baseCost, Customer placedBy, String status, String type){
        checkPayment(reqId, date, baseCost, placedBy, status, type );
    }

    private void checkPayment(int reqId, String date, double baseCost, Customer placedBy, String status, String type){
        boolean check = placedBy.OnPayment(baseCost);
        if(check){
            this.reqId = reqId;
            this.baseCost = baseCost;
            this.date = date;
            this.customer = placedBy;
            this.status = status;
            this.type = type;
            doProceed = true;
        } else {
            System.out.println("Can not proceed the request due to insufficient balance");
            doProceed = false;
            return;
        }
    }

    public void setPayment(Payment payment){
        this.payment = payment;
        this.payment.getMethod(baseCost);
    }

    public boolean getDoProceed(){
        return doProceed;
    }

    public String getType(){
        return type;
    }
    public void assignedTo(ServiceProvider serviceProvider){
        if(serviceProvider.getSkillType() != type){
            System.out.println(serviceProvider.getName() +" Service provider skills are not aligned with the service");
            isAssigned = false;
            return;
        }
        this.serviceProvider = serviceProvider;
        isAssigned = true;
        System.out.println(serviceProvider.getName() +" Service provider is assigned to the service of " + type);
    }
    public boolean getIsAssigned(){
        return isAssigned;
    }
    public void addFeedback(int id, String comment, int rating){
        if(this.status == "Completed"){
            this.feedback = new Feedback(id, rating, comment);
        } else {
            System.out.println("Only Completed Request do have feedback");
        }
    }
    public void changeStatus(String status){
        if(status == "Cancelled" && this.status != "Pending"){
            System.out.println("Only Pending requests can be cancelled");
            return;
        }
        this.status = status;
    }
    public int getReqId(){
        return reqId;
    }
    public String getDate(){
        return date;
    }
    public double getBaseCost(){
        return baseCost;
    }
    public String getStatus(){
        return status;
    }
    public Customer getCustomer(){
        return customer;
    }
    public ServiceProvider getServiceProvider(){
        return serviceProvider;
    }
    public void getFeedback(){
        System.out.println("Rating is: " + feedback.getRating());
        System.out.println("Comment is: " + feedback.getComment());
    }
}
