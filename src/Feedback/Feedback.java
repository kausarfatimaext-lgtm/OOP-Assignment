package Feedback;

public class Feedback {
    private int id;
    private int rating;
    private String comment;
    public Feedback(int id, int rating, String comment){
        this.id = id;
        this.rating = rating;
        this.comment = comment;
    }

    public int getId(){
        return id;
    }
    public int getRating(){
        return rating;
    }
    public String getComment(){
        return comment;
    }
}
