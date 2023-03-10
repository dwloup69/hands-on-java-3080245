package bank;

public class Accounts {
  private int id;
  private int accountId;
  private String accountType;

  public Accounts(int id, int accountId, String accountType)
  {
    setId(id);
    setAccountId(accountId);
    setAccountType(accountType);
  }
  
  public int getId() {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getAccountId() {
    return this.accountId;
  }

  public void setAccountId(int accountId) {
    this.accountId = accountId;
  }

  public String getAccountType() {
    return this.accountType;
  }

  public void setAccountType(String accountType) {
    this.accountType = accountType;
  }

}
