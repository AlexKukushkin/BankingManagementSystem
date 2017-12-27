package pojo;

public class ClientTransaction {
    private int id;
    private int idTransaction;
    private int idClient;
    private String transactionDate;
    private String transactionTime;

    public ClientTransaction() {
    }

    public ClientTransaction(int id, int idTransaction, int idClient, String transactionDate, String transactionTime) {
        this.id = id;
        this.idTransaction = idTransaction;
        this.idClient = idClient;
        this.transactionDate = transactionDate;
        this.transactionTime = transactionTime;
    }

    public int getId() {
        return id;
    }

    public int getIdTransaction() {
        return idTransaction;
    }

    public int getIdClient() {
        return idClient;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public String getTransactionTime() {
        return transactionTime;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdTransaction(int idTransaction) {
        this.idTransaction = idTransaction;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public void setTransactionTime(String transactionTime) {
        this.transactionTime = transactionTime;
    }
}