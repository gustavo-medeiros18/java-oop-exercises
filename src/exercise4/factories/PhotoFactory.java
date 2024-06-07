package exercise4.factories;

import exercise4.models.Photo;
import java.util.Date;

public class PhotoFactory {
  private static int idCount = 0;

  public static Photo create(String url, Date uploadDate, int userId) {
    return new Photo(++idCount, url, uploadDate, userId);
  }
}
