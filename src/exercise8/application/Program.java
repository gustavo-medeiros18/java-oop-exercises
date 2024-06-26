package exercise8.application;

import exercise8.db.DB;
import exercise8.db.DbException;
import exercise8.db.DbIntegrityException;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Program {
  public static void main(String[] args) throws SQLException {
//    retrieveAllDepartments();
//    insertSeller();
//    insertDepartments();
//    updateSeller();
//    deleteDepartment();
    testTransactions();
  }

  private static void retrieveAllDepartments() {
    Connection conn = null;

    Statement st = null;
    ResultSet rs = null;

    try {
      conn = DB.getConnection();
      st = conn.createStatement();

      rs = st.executeQuery("SELECT * FROM department");

      while (rs.next()) {
        System.out.println(rs.getInt("Id") + ", " + rs.getString("Name"));
      }
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    } finally {
      DB.closeResultSet(rs);
      DB.closeStatement(st);
      DB.closeConnection();
    }
  }

  private static void insertSeller() {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    Connection conn = null;
    PreparedStatement st = null;

    try {
      conn = DB.getConnection();
      st = conn.prepareStatement(
          "INSERT INTO seller "
              + "(Name, Email, BirthDate, BaseSalary, DepartmentId) "
              + "VALUES "
              + "(?, ?, ?, ?, ?)",
          Statement.RETURN_GENERATED_KEYS
      );

      st.setString(1, "Carl Purple");
      st.setString(2, "carl@gmail.com");
      st.setDate(3, new Date(sdf.parse("22/04/1985").getTime()));
      st.setDouble(4, 3000.0);
      st.setInt(5, 4);

      int rowsAffected = st.executeUpdate();
      if (rowsAffected > 0) {
        ResultSet rs = st.getGeneratedKeys();

        while (rs.next())
          System.out.println("Done! Id = " + rs.getInt(1));

        DB.closeResultSet(rs);
      } else
        System.out.println("No rows affected!");
    } catch (SQLException | ParseException e) {
      System.out.println(e.getMessage());
    } finally {
      DB.closeStatement(st);
      DB.closeConnection();
    }
  }

  private static void insertDepartments() {
    Connection conn = null;
    PreparedStatement st = null;

    try {
      conn = DB.getConnection();
      st = conn.prepareStatement(
          "INSERT INTO department (Name) VALUES (?), (?)",
          Statement.RETURN_GENERATED_KEYS
      );

      st.setString(1, "D1");
      st.setString(2, "D2");

      int rowsAffected = st.executeUpdate();
      if (rowsAffected > 0) {
        ResultSet rs = st.getGeneratedKeys();

        while (rs.next())
          System.out.println("Done! Id = " + rs.getInt(1));

        DB.closeResultSet(rs);
      } else
        System.out.println("No rows affected!");
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    } finally {
      DB.closeStatement(st);
      DB.closeConnection();
    }
  }

  private static void updateSeller() {
    Connection conn = null;
    PreparedStatement st = null;

    try {
      conn = DB.getConnection();
      st = conn.prepareStatement(
          "UPDATE seller "
              + "SET BaseSalary = BaseSalary + ? "
              + "WHERE "
              + "(DepartmentId = ?)"
      );

      st.setDouble(1, 200.0);
      st.setInt(2, 2);

      int rowsAffected = st.executeUpdate();
      System.out.println("Done! Rows affected: " + rowsAffected);
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    } finally {
      DB.closeStatement(st);
      DB.closeConnection();
    }
  }

  private static void deleteDepartment() {
    Connection conn = null;
    PreparedStatement st = null;

    try {
      conn = DB.getConnection();
      st = conn.prepareStatement(
          "DELETE FROM department "
              + "WHERE "
              + "Id = ?"
      );

      st.setInt(1, 2);

      int rowsAffected = st.executeUpdate();
      System.out.println("Done! Rows affected: " + rowsAffected);
    } catch (SQLException e) {
      throw new DbIntegrityException(e.getMessage());
    } finally {
      DB.closeStatement(st);
      DB.closeConnection();
    }
  }

  private static void testTransactions() {
    Connection conn = null;
    Statement st = null;

    try {
      conn = DB.getConnection();
      st = conn.createStatement();

      conn.setAutoCommit(false);

      int rows1 = st.executeUpdate("UPDATE seller SET BaseSalary = 2000 WHERE DepartmentId = 1");

      if (true)
        throw new SQLException("Fake error");

      int rows2 = st.executeUpdate("UPDATE seller SET BaseSalary = 2000 WHERE DepartmentId = 2");

      conn.commit();
      System.out.println("rows1: " + rows1);
      System.out.println("rows2: " + rows2);
    } catch (SQLException e) {
      try {
        conn.rollback();

        throw new DbException("Transaction rolled back! Caused by: " + e.getMessage());
      } catch (SQLException ex) {
        throw new DbException(ex.getMessage());
      }
    }
  }
}
