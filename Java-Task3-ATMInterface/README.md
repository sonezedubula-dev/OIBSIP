# 🏧 Java ATM Interface

A console-based **ATM Banking System** developed in Java as part of the Oasis Infobyte Java Development Internship.

The application simulates common ATM operations while demonstrating **Object-Oriented Programming (OOP), collections, input validation, exception handling, and transaction management**.

##  Features✨

*  User authentication using Username, user ID and PIN🔐
* Three-attempt login protection  🚫
* Check account balance 💰
* Deposit money 💵
*  Withdraw money 💸
* Transfer money between accounts 🔄
* Transaction history 📜
* Insufficient funds validation⚠️
*  Invalid input handling❌
* Support for multiple bank accounts🏦

##  Technologies Used🛠️

* **Java**
* **IntelliJ IDEA**
* **Java Collections Framework**
* **Object-Oriented Programming**
* **Git & GitHub**

##  Project Structure🧱

```text
Java-Task3-ATMInterface/
│
├── src/
│   ├── Account.java
│   ├── ATM.java
│   ├── Bank.java
│   ├── Main.java
│   └── Transaction.java
│
├── Screenshots/
│   ├── 1. Successful Login.png
│   ├── 2. ATM Main Menu.png
│   ├── 3. Check Balance.png
│   ├── 4. Successful Deposit.png
│   ├── 5. Successful Withdrawal.png
│   ├── 6. Successful Transfer.png
│   ├── 7. Transaction History.png
│   └── 8. Insufficient Funds.png
│
├── .gitignore
└── README.md
```

##  OOP Design🧩

The application is divided into separate classes, with each class responsible for a specific part of the system:

Main : Starts the application and creates sample accounts.
ATM: Handles the login, menu navigation and ATM operations.
Bank: Manages the accounts and transfers.
Account: Stores the account information, balance and transaction history.
Transaction: Represents individual banking transactions.

## 🔄 ATM Operations

### Login

Users authenticate using their User ID and PIN. The system allows a maximum of three login attempts.

### Deposit

Users can deposit money into their account. The system validates the amount and records the transaction.

### Withdrawal

Users can withdraw money when sufficient funds are available. Invalid amounts and insufficient funds are handled safely.

### Transfer

Users can transfer money to another account using the recipient's account ID. Both accounts receive a corresponding transaction record.

### Transaction History

All successful deposits, withdrawals and transfers are stored and displayed through the transaction history feature.

## ️ Validation & Error Handling🛡

The application handles several invalid situations, including:

* Invalid login credentials
* Too many login attempts
* Negative or zero transaction amounts
* Non-numeric input
* Insufficient account balance
* Invalid recipient account
* Transfers to the user's own account

## What I learned📚 

Through this project, I strengthened my practical understanding of:

* Java Object-Oriented Programming
* Classes and objects
* Encapsulation
* ArrayLists and collections
* Exception handling
* Input validation
* Modular application design
* Git and GitHub version control

## Author 👨‍💻

**Soneze Dubula**
BSc Information Technology – Software Engineering

Developed as part of the **Oasis Infobyte Java Development Internship**.
