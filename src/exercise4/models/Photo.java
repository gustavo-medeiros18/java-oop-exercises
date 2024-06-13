package exercise4.models;

import java.util.Date;

public class Photo {
  private final Integer id;
  private String url;
  private Date uploadDate;
  private int userId;

  public Photo(int id, String url, Date uploadDate, int userId) {
    this.id = id;
    this.url = url;
    this.uploadDate = uploadDate;
    this.userId = userId;
  }

  public Photo(String url, Date uploadDate, int userId) {
    this.id = null;
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

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public void setUploadDate(Date uploadDate) {
    this.uploadDate = uploadDate;
  }

  public void setUrl(String url) {
    this.url = url;
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