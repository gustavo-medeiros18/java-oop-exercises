package exercise4.services;

import exercise4.database.PhotoRepository;
import exercise4.models.Photo;
import exercise4.strategies.ValidationStrategy;

import java.util.List;

public class PhotoService {
  private ValidationStrategy validator;

  public PhotoService(ValidationStrategy validator) {
    this.validator = validator;
  }

  public Photo create(Photo photo) {
    if (!this.validator.isValid(photo.getUrl())) {
      System.out.println("URL is invalid!");
      return null;
    }

    PhotoRepository.add(photo);

    return photo;
  }

  public List<Photo> index() {
    return PhotoRepository.all();
  }

  public Photo show(int id) {
    return PhotoRepository.find(id);
  }

  public void remove(int id) {
    PhotoRepository.delete(id);
  }
}
