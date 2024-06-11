package exercise4.controllers;

import exercise4.factories.PhotoFactory;
import exercise4.models.Photo;
import exercise4.services.PhotoService;
import exercise4.strategies.UrlValidation;

import java.util.Date;

public class PhotoController {
  private static final PhotoService photoService =
      new PhotoService(new UrlValidation());

  public static Photo createPhoto(String url, Date uploadDate, int userId) {
    return photoService.create(url, uploadDate, userId);
  }
}
