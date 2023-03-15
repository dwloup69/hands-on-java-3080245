package bank;

import bank.exception.AmountException;

public class Accounts {
  private int id;
  private double balance;
  private String accountType;

  public Accounts(int id, double balance, String accountType)
  {
    setId(id);
    setBalance(balance);
    setAccountType(accountType);
  }

  public void deposit(double amount) throws AmountException
  {
    if (amount <= 0)
    {
      throw new AmountException("Minimum deposit is 1.00");
    }

    double newBalance = balance + amount;
    this.setBalance(newBalance);
    DataSource.updateBalance(newBalance, id);
  }

  public void withdraw(double amount) throws AmountException
  {
    if (amount <= 0) {
      throw new AmountException("Minimum withdrawal amount must be greater than 0.");
    }
    else if (amount > getBalance())
    {
      throw new AmountException("You do not have sufficient funds to withdraw " + amount);
    }

    double newBalance = balance - amount;
    this.setBalance(newBalance);
    // DataSource.updateBalance(newBalance, id);
  }

  public int getId() {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public double getBalance() {
    return this.balance;
  }

  public void setBalance(double balance) {
    this.balance = balance;
  }

  public String getAccountType() {
    return this.accountType;
  }

  public void setAccountType(String accountType) {
    this.accountType = accountType;
  }

}
