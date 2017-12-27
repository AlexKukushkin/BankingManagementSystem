package pojo;

public class Transaction {

    private int idTransaction;
    private String transactionType;

    public Transaction() {
    }

    public Transaction(int idTransaction, String transactionType) {
        this.idTransaction = idTransaction;
        this.transactionType = transactionType;
    }

    public int getIdTransaction() {
        return idTransaction;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setIdTransaction(int idTransaction) {
        this.idTransaction = idTransaction;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }
}
