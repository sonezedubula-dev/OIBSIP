import java.util.ArrayList;

public class Bank {

    private ArrayList<Account> accounts;

    public Bank() { accounts = new ArrayList<>();
    }

    // Adding an account k
    public void addAccount(Account account) {
        accounts.add(account);
    }

    // Finding an account using the account ID
    public Account findAccount(String accountId) {
        for (Account account : accounts) {
            if (account.getAccountId().equals(accountId)) {
                return account;
            }
        }

        return null;
    }

    //Finding an account using the user ID
    public Account findAccountByUserId(String userId) {
        for(Account account : accounts) {
            if(account.getUserId().equals(userId)) {
                return account;
            }
        }
        return null;
    }

    // Transferring money between two accounts
    public boolean transfer(Account sender, Account recipient, double amount) {

        if (amount <= 0 || sender.getBalance() < amount) {
            return false;
        }

        sender.withdraw(amount);
        recipient.deposit(amount);

        return true;
    }
}