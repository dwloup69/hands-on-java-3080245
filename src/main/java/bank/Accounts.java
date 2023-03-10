package bank;

public class Accounts {
  private int id;
  private double balance;
  private String accountType;

  public Accounts(int id, Double balance, String accountType)
  {
    setId(id);
    setBalance(balance);
    setAccountType(accountType);
  }

  public int getId() {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Double getBalance() {
    return this.balance;
  }

  public void setBalance(Double balance) {
    this.balance = balance;
  }

  public String getAccountType() {
    return this.accountType;
  }

  public void setAccountType(String accountType) {
    this.accountType = accountType;
  }

}
