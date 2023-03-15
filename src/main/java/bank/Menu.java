package bank;

import java.util.Scanner;

import javax.security.auth.login.LoginException;

import bank.exception.AmountException;

public class Menu {
  
  private Scanner scanner;

  private Customer authenticateUser()
  {
    System.out.println("Please input your user name");
    String username = scanner.next();

    System.out.println("Please enter you password");
    String password = scanner.next();

    Customer customer = null;
    try
    {
      customer = Authenticator.login(username, password);
    }
    catch (LoginException e)
    {
      System.out.println("There was a error: " + e.getMessage() + ".");
    }

    return customer;
  }

  private void showMenu(Customer customer, Accounts account)
  {
    int selection = 0;

    while (selection != 4)
    {
      System.out.println("==========================================");
      System.out.println("Please select one of the following options");
      System.out.println(" ");
      System.out.println("1: Deposit");
      System.out.println(" ");
      System.out.println("2: Withdraw");
      System.out.println(" ");
      System.out.println("3: Check Balance");
      System.out.println(" ");
      System.out.println("4: Logout");
      System.out.println("==========================================");

      selection = scanner.nextInt();
      double amount = 0;

      switch (selection) 
      {
        case 1:
          {
            amount = makeDeposit(account);
            break;
          }
        case 2:
          {
            amount = makeWithdrawal(account);
            break;
          }
        case 3:
          {
            System.out.println(account.getBalance());
            break;
          }
        case 4:
          {
            Authenticator.logout(customer);
            System.out.println("Thank you. You have been succesfully logged out.");
            break;
          }
        default:
          {
            System.out.println("Please select one of the 4 options above.");
            break;
          }
      }

    }
  }

  private double makeDeposit(Accounts account)
  {
    System.out.println("How much do you wish to deposit?");
    Double depositAmount = scanner.nextDouble();
    try {
      account.deposit(depositAmount);
     
    } catch (AmountException e) {
      System.out.println(e.getMessage());
      System.out.println("Please try again");
    }
    return depositAmount;
  }
  
  private double makeWithdrawal(Accounts account)
  {
    System.out.println("How much do you wish to withdraw?");
    Double withdrawalAmount = scanner.nextDouble();
    
    try {
      account.withdraw(withdrawalAmount);
    } catch (AmountException e) {
      System.out.println(e.getMessage());
      System.out.println("Please try again");
    }
    
    return withdrawalAmount;
  }

  public static void main(String[] args)
  {
    System.out.println("Welcome to Globe Bank International");

    Menu menu = new Menu();

    menu.scanner = new Scanner(System.in);

    Customer customer = menu.authenticateUser();
    if (customer != null )
    {
      Accounts account = DataSource.getAccount(customer.getAccountId());
      menu.showMenu(customer, account);
    }

    menu.scanner.close();
  }
}
