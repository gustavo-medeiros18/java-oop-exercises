package exercise8.application;

import exercise8.db.DB;

import java.sql.Connection;
import java.sql.SQLException;

public class Program {
  public static void main(String[] args) throws SQLException {
    Connection conn = DB.getConnection();

    DB.closeConnection();
  }
}
