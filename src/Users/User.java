package Users;

public abstract class User {
    private int id;
    private String name;
    private String phoneNo;
    private String email;

    public User(int id, String name, String phoneNo, String email){
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNo = phoneNo;
    }

    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getPhoneNo(){
        return phoneNo;
    }
    public String getEmail(){
        return email;
    }
    public void getUserInfo(){
        System.out.println("Name of User: " + name);
        System.out.println("Phone No of User: " + phoneNo);
        System.out.println("Email account of User: " + email);
    }
}
