package bank;

public class Customer {
  private int id;
  private String Name;
  private String UserName;
  private String Password;
  private int AccountId;

  public Customer(int id, String name, String userName, String password, int accountId)
  {
    setId(id);
    setName(name);
    setUserName(userName);
    setPassword(password);
    setAccountId(accountId);
  }
  
  public int getId() {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return this.Name;
  }

  public void setName(String Name) {
    this.Name = Name;
  }

  public String getUserName() {
    return this.UserName;
  }

  public void setUserName(String UserName) {
    this.UserName = UserName;
  }

  public String getPassword() {
    return this.Password;
  }

  public void setPassword(String Password) {
    this.Password = Password;
  }

  public int getAccountId() {
    return this.AccountId;
  }

  public void setAccountId(int AccountId) {
    this.AccountId = AccountId;
  }
  
}
