package exercise2;

public class Comment {
  private final String text;

  public Comment(String text) {
    this.text = text;
  }

  @Override
  public String toString() {
    return "Comment{" +
        "text='" + text + '\'' +
        '}';
  }
}
