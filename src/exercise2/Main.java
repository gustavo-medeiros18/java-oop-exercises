package exercise2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
  public static void main(String[] args) throws ParseException {
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    Date post1Date = formatter.parse("21/06/2018 13:05:44");
    Date post2Date = formatter.parse("28/07/2018 23:14:19");

    Comment comment1 = new Comment("Have a nice trip");
    Comment comment2 = new Comment("Wow that's awesome!");
    Comment comment3 = new Comment("Good night");
    Comment comment4 = new Comment("May the Force be with you");

    List<Comment> post1Comments = new ArrayList<>();
    post1Comments.add(comment1);
    post1Comments.add(comment2);

    List<Comment> post2Comments = new ArrayList<>();
    post2Comments.add(comment3);
    post2Comments.add(comment4);

    Post post1 = new Post(
        post1Date,
        "Traveling to New Zealand",
        "I'm going to visit this wonderful country!",
        12,
        post1Comments
    );

    Post post2 = new Post(
        post2Date,
        "Good night ",
        "I'm going to visit this wonderful country!",
        12,
        post2Comments
    );

    System.out.println(post1);
    System.out.println(post2);
  }
}
