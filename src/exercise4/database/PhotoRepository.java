package exercise4.database;

import exercise4.models.Photo;
import exercise4.models.User;

import java.util.ArrayList;
import java.util.List;

public class PhotoRepository {
  static List<Photo> photos = new ArrayList<>();

  public static void add(Photo photo) {
    photos.add(photo);

    User user = UserRepository.find(photo.getUserId());

    if (user != null) user.getPhotos().add(photo);

  }

  public static Photo find(int id) {
    for (Photo photo : photos) {
      if (photo.getId() == id) {
        return photo;
      }
    }
    return null;
  }

  public static List<Photo> all() {
    return photos;
  }

  public static void delete(int id) {
    Photo photo = find(id);
    photos.remove(photo);
  }
}
