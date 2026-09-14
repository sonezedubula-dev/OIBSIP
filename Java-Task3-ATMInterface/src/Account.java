import java.util.ArrayList;

public class Account {
    private String accountId;
    private String userName;
    private String pin;
    private double balance;

    private ArrayList<Transaction> transactions;

    public Account(String accountId, String userName, String pin, double balance) {
        this.accountId = accountId;
        this.userName = userName;
        this.pin = pin;
        this.balance = balance;
        this.transactions = new ArrayList<>();
    }

    public String getAccountId() {
        return accountId;
    }

    public String getUserId() {
        return userName;
    }

    public String getPin() {
        return pin;
    }

    public double getBalance() {
        return balance;
    }
    //Deposit money
    public void deposit(double amount) {
        balance +=amount;
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public void addTransaction( Transaction transaction) {
        transactions.add(transaction);
    }
    public ArrayList<Transaction>getTransactions() {
        return transactions;
    }
}