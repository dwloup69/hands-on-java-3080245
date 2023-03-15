package bank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataSource {

  public static Connection connect() {
    String dbFile = "jdbc:sqlite:resources/bank.db";
    Connection connection = null;
    try {
      connection = DriverManager.getConnection(dbFile);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return connection;
  }

  public static Accounts getAccount(Integer account_id)
  {
 
    String query = "SELECT * FROM accounts WHERE id = ?";

    Accounts accounts = null;

    try (Connection connection = connect();
    PreparedStatement statement = connection.prepareStatement(query))
    {
      statement.setInt(1, account_id);
      try (ResultSet results = statement.executeQuery())
      {
        accounts = new Accounts(results.getInt("id"), results.getDouble("balance"), results.getString("Type"));
      }
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    return accounts;
  }

  public static Customer getCustomer(String userName) {
    String query = "SELECT * FROM customers WHERE username = ?";
    Customer customer = null;

    try (Connection connection = connect();
    PreparedStatement statement = connection.prepareStatement(query))
    {
      statement.setString(1, userName);
      try (ResultSet results = statement.executeQuery())
      {
        customer = new Customer(results.getInt("id"), 
        results.getString("name"), 
        results.getString("username"), 
        results.getString("password"), 
        results.getInt("account_id"));
      }
    } catch (SQLException e)
    {
      e.printStackTrace();
    }

    return customer;
  }

  public static void updateBalance(double balance, int id)
  {
    String query = "UPDATE account SET balance ? WHERE id = ?";
    try (Connection connection = connect();
        PreparedStatement statement = connection.prepareStatement(query))
    {
      statement.setDouble(1, balance);
      statement.setInt(2, id);
      statement.executeUpdate(query);
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }

  }
}
