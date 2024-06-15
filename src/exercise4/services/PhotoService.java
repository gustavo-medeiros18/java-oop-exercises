package exercise4.services;

import exercise4.database.PhotoRepository;
import exercise4.database.UserRepository;
import exercise4.exceptions.InvalidUrlException;
import exercise4.exceptions.UserNotFoundException;
import exercise4.models.Photo;
import exercise4.models.User;
import exercise4.strategies.ValidationStrategy;

import java.util.List;

public class PhotoService {
  private final ValidationStrategy validator;

  public PhotoService(ValidationStrategy validator) {
    this.validator = validator;
  }

  public Photo create(Photo photo) {
    if (this.validator.isValid(photo.getUrl()))
      throw new InvalidUrlException("URL is invalid!");

    User user = UserRepository.find(photo.getUserId());
    if (user == null) throw new UserNotFoundException("User not found!");

    PhotoRepository.add(photo);
    return photo;
  }

  public List<Photo> index() {
    return PhotoRepository.all();
  }

  public Photo show(int id) {
    return PhotoRepository.find(id);
  }

  public void update(int id, Photo newPhotoData) {
    if (this.validator.isValid(newPhotoData.getUrl()))
      throw new InvalidUrlException("URL is invalid!");

    User user = UserRepository.find(newPhotoData.getUserId());
    if (user == null) throw new UserNotFoundException("User not found!");

    PhotoRepository.update(id, newPhotoData);
  }

  public void remove(int id) {
    PhotoRepository.delete(id);
  }
}
