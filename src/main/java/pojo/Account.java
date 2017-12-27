package pojo;

public class Account {

    private int idAccount;
    private String accountNumber;
    private int balance;
    private int credit;
    private int debet;
    private int idClient;

    public Account() {
    }

    public Account(int idAccount, String accountNumber, int balance, int credit, int debet, int idClient) {
        this.idAccount = idAccount;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.credit = credit;
        this.debet = debet;
        this.idClient = idClient;
    }

    public int getIdAccount() {
        return idAccount;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public int getBalance() {
        return balance;
    }

    public int getCredit() {
        return credit;
    }

    public int getDebet() {
        return debet;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdAccount(int idAccount) {
        this.idAccount = idAccount;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public void setDebet(int debet) {
        this.debet = debet;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }
}
