import java.util.ArrayList;

public class BookReviews {




    public static ArrayList<String> userReviews = new ArrayList<String>();


    public static void leaveReview(int id, String comment) {


        String review = "ID "+ id + ":   " + comment;

        userReviews.add(review);


    }
}
