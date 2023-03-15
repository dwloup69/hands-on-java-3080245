package bank;

import javax.security.auth.login.LoginException;

public class Authenticator {
  
  public static Customer login(String userName, String password) throws LoginException
  {
    if (password.length() == 0)
    {
      System.out.println("Password is missing");
    }
    if (userName.length() == 0)
    {
      System.out.println("User name is missing");
    }

    Customer customer = DataSource.getCustomer(userName);
    if (customer == null)
    {
      throw new LoginException("User Name not found");
    }
    if (password.equals(customer.getPassword()))
    {
      customer.setAuthenticated(true);
      return customer;
    }
    else
    {
      throw new LoginException("Password is incorrect");
    }
   }

  public static void logout(Customer customer)
  {
    customer.setAuthenticated(false);
  }
}
