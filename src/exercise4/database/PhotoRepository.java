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

  public static void update(int id, Photo newPhotoData) {
    Photo photo = find(id);

    if (photo != null) {
      // Find the user who owns the photo
      User user = UserRepository.find(photo.getUserId());

      // Update the photo details
      photo.setUploadDate(newPhotoData.getUploadDate());
      photo.setUrl(newPhotoData.getUrl());
      photo.setUserId(newPhotoData.getUserId());

      // Update the photo in the main photos list
      photos.set(id - 1, photo);

      // If the user exists and has this photo, update it in the user's photo list
      if (user != null) {
        List<Photo> userPhotos = user.getPhotos();
        for (int i = 0; i < userPhotos.size(); i++) {
          if (userPhotos.get(i).getId() == id) {
            userPhotos.set(i, photo);
            break;
          }
        }
      }
    }
  }

  public static void delete(int id) {
    Photo photo = find(id);

    if (photo != null) {
      User user = UserRepository.find(photo.getUserId());
      if (user != null) user.getPhotos().remove(photo);

      photos.remove(photo);
    }
  }
}
