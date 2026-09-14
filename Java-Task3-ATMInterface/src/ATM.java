import  java.util.Scanner;

public class ATM {

    private Bank bank;
    private Scanner scanner;

    public ATM(Bank bank) {
        this.bank = bank;
        this.scanner = new Scanner(System.in);
    }

    //Login
    public Account login() {

        System.out.println();
        System.out.println("=====================================");
        System.out.println("      \uD83C\uDFE7 ATM LOGIN      ");
        System.out.println("======================================");

        for (int attempts = 1; attempts <= 3; attempts++) {
            System.out.println("Enter Your Username:  ");
            String userId = scanner.nextLine();

            System.out.println("Enter your PIN: ");
            String pin = scanner.nextLine();


                Account account = bank.findAccountByUserId(userId);

                //Checking if account username and Pin are valid
                if (account != null && account.getPin().equals(pin)) {

                    System.out.println();
                    System.out.println("✅ Login successful!");
                    return account;
                }

            System.out.println("❌ Invalid Username or PIN. Please try again!");
            System.out.println("You have " + (3 - attempts) + "remaining!");
            System.out.println();
        }
        System.out.println("\uD83D\uDEAB Too many incorrect attempts.");
        System.out.println("Your account has been locked.");
        return null;

    }

    //Main ATM menu
    public void showMenu(Account account) {
        boolean running = true;

        while (running) {
            System.out.println();
            System.out.println("===========================================");
            System.out.println("║            ATM MENU \uD83C\uDFE7           ║");
            System.out.println("==========================================");
            System.out.println("║ 1. Transaction History\uD83D\uDCDC         ║");
            System.out.println("║ 2. Withdraw Cash\uD83D\uDCB8               ║");
            System.out.println("║ 3. Deposit\uD83D\uDCB5                     ║");
            System.out.println("║ 4. Transfer\uD83D\uDD04                    ║");
            System.out.println("║ 5. Check Balance\uD83D\uDCB0               ║");
            System.out.println("║ 6. Quit\uD83D\uDCF1                        ║");
            System.out.println("==========================================");

            System.out.println("Choose an option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    showTransactionHistory(account);
                    break;

                case "2":
                    withdrawCash(account);
                    break;

                case "3":
                    deposit(account);
                    break;

                case "4":
                    transfer(account);
                    break;

                case "5":
                    showBalance(account);
                    break;

                case "6":
                    System.out.println();
                    System.out.println("Thank you for using the ATM!\uD83D\uDC4B");
                    running = false;
                    break;

                default:
                    System.out.println(" Invalid Option ❌. Please choose from 1 - 6.");

            }
        }
    }

    //Checking the balance
    private void showBalance(Account account) {
        System.out.println();
        System.out.println(" Current Balance: R" + String.format("%.2f", account.getBalance()));
    }

    //Transaction History
    private void showTransactionHistory(Account account) {
        System.out.println();
        System.out.println("=========TRANSACTION HISTORY\uD83D\uDCDC========");

        if (account.getTransactions().isEmpty()) {
            System.out.println("No transactions available.");
        } else {
            int number = 1;

            for (Transaction transaction : account.getTransactions()) {
                System.out.println(number + "." + transaction);
                number++;
            }
        }
        System.out.println("===========================");
    }

    //Withdraw money
    private void withdrawCash(Account account) {
        System.out.println();
        System.out.println("==========WITHDRAW CASH\uD83D\uDCB8=========");
        System.out.println("Enter amount to withdraw: R");

        try {
            double amount = Double.parseDouble(scanner.nextLine());

            if (amount <= 0) {
                System.out.println(" Invalid withdrawal ❌");
                return;
            }

            if (amount > account.getBalance()) {
                System.out.println("INSUFFICIENT FUNDS ⚠\uFE0F");
                System.out.println("Available balance: R" + String.format("%.2f", account.getBalance()));
                return;
            }

            account.withdraw(amount);

            Transaction transaction = new Transaction("WITHDRAWAL", "Cash withdrawn", amount);

            account.addTransaction(transaction);

            System.out.println("Withdrawal Successful!✅");
            System.out.println("Amount withdrawn: R" + String.format("%.2f", amount));
            System.out.println("New balance: R" + String.format("%.2f", account.getBalance()));
        } catch (NumberFormatException e) {
            System.out.println("Invalid amount❌. Please enter a number");
        }
        System.out.println("======================================");

    }

    //Deposit money
    private void deposit(Account account) {
        System.out.println();
        System.out.println("========== DEPOSIT\uD83D\uDCB5 ==========");
        System.out.println("Enter amount to deposit: R");

        try {
            double amount = Double.parseDouble(scanner.nextLine());
            if (amount <= 0) {
                System.out.println("Amount must be greater than R0.");
                return;
            }

            account.deposit(amount);

            Transaction transaction = new Transaction("DEPOSIT", "Cash deposited", amount);

            account.addTransaction(transaction);

            System.out.println("Deposit successful!✅");
            System.out.println("Amount deposited: R" + String.format("%.2f", amount));
            System.out.println("New balance: R" + String.format("%.2f", account.getBalance()));
        } catch (NumberFormatException e) {
            System.out.println("Invalid amount❌. Please eneter a number.");
        }
        System.out.println("==========================================");
    }

    //Transferring money to another account
    private void transfer(Account account) {
        System.out.println();
        System.out.println("=============== TRANSFER\uD83D\uDD04 =============");
        System.out.println("Enter recipient account ID: ");
        String recipientId = scanner.nextLine();

        Account recipient = bank.findAccount(recipientId);

        if (recipient == null) {
            System.out.println("Recipient account not found.");
            return;
        }
        if (recipient.getAccountId().equals(account.getAccountId())) {
            System.out.println("You cannot transfer money to our own account.");
            return;
        }
        System.out.println("Enter amount to transfer: R");

        try {
            double amount = Double.parseDouble(scanner.nextLine());

            if (amount <= 0) {
                System.out.println("Amount must be greater than R0");
                return;
            }

            if (amount > account.getBalance()) {
                System.out.println("Insufficient funds❌");
                System.out.println("Available balance: R" + String.format("%.2f", account.getBalance()));
                return;
            }

            boolean successful = bank.transfer(account, recipient, amount);

            if (successful) {
               account.addTransaction(new Transaction("TRANSFER", "Transfer to account " + recipient.getAccountId(), amount));
               recipient.addTransaction(new Transaction("TRANSFER", "Received from account " +account.getAccountId(), amount));

                System.out.println("Transfer successful!✅");
                System.out.println("Amount transferred: R" + String.format("%.2f", amount));
                System.out.println("Recipient: " + recipient.getAccountId());
                System.out.println("New Balance: R" + String.format("%.2f", account.getBalance()));
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid amount❌. Please enter a number.");
        }
        System.out.println("============================");

    }
}