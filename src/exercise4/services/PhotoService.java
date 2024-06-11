package exercise4.services;

import exercise4.database.PhotoRepository;
import exercise4.factories.PhotoFactory;
import exercise4.models.Photo;
import exercise4.strategies.ValidationStrategy;

import java.util.Date;

public class PhotoService {
  private ValidationStrategy validator;

  public PhotoService(ValidationStrategy validator) {
    this.validator = validator;
  }

  public Photo create(String url, Date uploadDate, int userId) {
    if (!this.validator.isValid(url)) {
      System.out.println("URL is invalid!");
      return null;
    }

    Photo photo = PhotoFactory.create(url, uploadDate, userId);
    PhotoRepository.add(photo);

    return photo;
  }
}
