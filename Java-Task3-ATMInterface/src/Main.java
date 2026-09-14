public class Main {
    public static void main(String[] args) {

        //Creating the bank
        Bank bank = new Bank();

        //Creating accounts and adding them to the bank
        Account account1 = new Account("0001", "Soso", "1234",  5000.00);
        Account account2 = new Account("0002", "Diddy", "0302", 10000.89);

        bank.addAccount(account1);
        bank.addAccount(account2);

        ATM atm = new ATM(bank);

        System.out.println();
        System.out.println("         \uD83C\uDFE6\uD83C\uDFE6\uD83C\uDFE6\uD83C\uDFE6\uD83C\uDFE6\uD83C\uDFE6\uD83C\uDFE6\uD83C\uDFE6\uD83C\uDFE6\uD83C\uDFE6\uD83C\uDFE6\uD83C\uDFE6\uD83C\uDFE6");
        System.out.println("            WELCOME TO THE ATM\uD83C\uDFE7 ");
        System.out.println("         \uD83C\uDFE6\uD83C\uDFE6\uD83C\uDFE6\uD83C\uDFE6\uD83C\uDFE6\uD83C\uDFE6\uD83C\uDFE6\uD83C\uDFE6\uD83C\uDFE6\uD83C\uDFE6\uD83C\uDFE6\uD83C\uDFE6\uD83C\uDFE6\uD83C\uDFE6");

        //Login
        Account loggedInAccount = atm.login();
        if(loggedInAccount !=null) {
            atm.showMenu(loggedInAccount);
        }
        System.out.println();
        System.out.println("ATM session ended.");

    }
}