package exercise4.controllers;

import exercise4.models.Photo;
import exercise4.services.PhotoService;
import exercise4.strategies.UrlValidation;

import java.util.Date;
import java.util.List;

public class PhotoController {
  private static final PhotoService photoService =
      new PhotoService(new UrlValidation());

  public static Photo create(Photo photo) {
    return photoService.create(photo);
  }

  public static List<Photo> index() {
    return photoService.index();
  }

  public static Photo show(int id) {
    return photoService.show(id);
  }
}
