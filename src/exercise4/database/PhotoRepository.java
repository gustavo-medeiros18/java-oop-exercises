package exercise4.database;

import exercise4.exceptions.PhotoNotFoundException;
import exercise4.exceptions.UserNotFoundException;
import exercise4.models.Photo;
import exercise4.models.User;

import java.util.ArrayList;
import java.util.List;

public class PhotoRepository {
  private static int idCount = 1;
  static List<Photo> photos = new ArrayList<>();

  public static void add(Photo photo) {
    photo.setId(idCount++);
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

    if (photo == null)
      throw new PhotoNotFoundException("Photo with id " + id + " not found.");

    User oldUser = UserRepository.find(photo.getUserId());
    if (oldUser == null)
      throw new UserNotFoundException("User with id " + photo.getUserId() + " not found.");

    photo.setUploadDate(newPhotoData.getUploadDate());
    photo.setUrl(newPhotoData.getUrl());

    if (photo.getUserId() != newPhotoData.getUserId()) {
      oldUser.getPhotos().remove(photo);

      User newUser = UserRepository.find(newPhotoData.getUserId());
      if (newUser == null)
        throw new UserNotFoundException("User with id " + newPhotoData.getUserId() + " not found.");

      newUser.getPhotos().add(photo);
      photo.setUserId(newPhotoData.getUserId());
    }

    photos.set(id - 1, photo);
  }

  public static void delete(int id) {
    Photo photo = find(id);

    if (photo == null)
      throw new PhotoNotFoundException("Photo with id " + id + " not found.");
    else {
      User user = UserRepository.find(photo.getUserId());
      if (user != null) user.getPhotos().remove(photo);

      photos.remove(photo);
    }
  }
}
