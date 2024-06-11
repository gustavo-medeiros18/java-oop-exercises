package exercise4.models;

import java.util.Date;

public class Photo {
  private final int id;
  private String url;
  private Date uploadDate;
  private int userId;

  public Photo(int id, String url, Date uploadDate, int userId) {
    this.id = id;
    this.url = url;
    this.uploadDate = uploadDate;
    this.userId = userId;
  }

  public int getId() {
    return id;
  }

  public String getUrl() {
    return url;
  }

  public Date getUploadDate() {
    return uploadDate;
  }

  public int getUserId() {
    return userId;
  }

  @Override
  public String toString() {
    return "Photo{" +
        "id=" + id +
        ", url='" + url + '\'' +
        ", uploadDate=" + uploadDate +
        ", userId=" + userId +
        '}';
  }
}