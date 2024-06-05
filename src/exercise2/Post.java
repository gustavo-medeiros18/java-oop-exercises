package exercise2;

import java.util.Date;
import java.util.List;

public class Post {
  private final Date moment;
  private final String title;
  private final String content;
  private final Integer likes;
  private final List<Comment> comments;

  public Post(Date moment, String title, String content, Integer likes, List<Comment> comments) {
    this.moment = moment;
    this.title = title;
    this.content = content;
    this.likes = likes;
    this.comments = comments;
  }

  @Override
  public String toString() {
    return "Post{" +
        "moment=" + moment +
        ", title='" + title + '\'' +
        ", content='" + content + '\'' +
        ", likes=" + likes +
        ", comments=" + comments.toString() +
        '}';
  }
}
