package ATM;

import java.util.Scanner;

//------- Bank Account Class -------
class BankAccount {
 private double balance;

 public BankAccount(double balance) {
     this.balance = balance;
 }

 public void deposit(double amount) {
     balance += amount;
     System.out.println("₹" + amount + " deposited successfully.");
 }

 public void withdraw(double amount) {
     if (amount > balance) {
         System.out.println("❌ Insufficient balance! Withdrawal failed.");
     } else if (amount <= 0) {
         System.out.println("❌ Enter a valid amount.");
     } else {
         balance -= amount;
         System.out.println("₹" + amount + " withdrawn successfully.");
     }
 }

 public double getBalance() {
     return balance;
 }
}

//------- ATM Class -------
class ATM {
 private BankAccount account;

 public ATM(BankAccount account) {
     this.account = account;
 }

 public void showMenu() {
     Scanner sc = new Scanner(System.in);
     int choice;

     do {
         System.out.println("\n===== ATM MENU =====");
         System.out.println("1. Check Balance");
         System.out.println("2. Deposit Money");
         System.out.println("3. Withdraw Money");
         System.out.println("4. Exit");
         System.out.print("Choose an option: ");
         choice = sc.nextInt();

         switch (choice) {
             case 1:
                 System.out.println("Your Balance: ₹" + account.getBalance());
                 break;

             case 2:
                 System.out.print("Enter amount to deposit: ");
                 double depAmount = sc.nextDouble();
                 account.deposit(depAmount);
                 break;

             case 3:
                 System.out.print("Enter amount to withdraw: ");
                 double wdAmount = sc.nextDouble();
                 account.withdraw(wdAmount);
                 break;

             case 4:
                 System.out.println("Thank you for using the ATM 😊");
                 break;

             default:
                 System.out.println("❌ Invalid option! Please try again.");
         }

     } while (choice != 4);
 }
}

//------- Main Class -------
public class ATMInterface {
 public static void main(String[] args) {

     BankAccount userAccount = new BankAccount(5000); // starting balance ₹5000
     ATM atm = new ATM(userAccount);

     atm.showMenu();
 }
}

