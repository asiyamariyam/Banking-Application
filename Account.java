import java.util.Scanner;

/**
 * Account
 */
public class Account {
    //class variables
    int balance;
    int previousTransaction;
    String customerName;
    String customerID;

    //class constructor
    Account(String cname, String cid){
        customerName=cname;
        customerID=cid;
    }

    //Function for depositing money
    void deposit(int amount){
        if (amount != 0){
            balance = balance+amount;
            previousTransaction = amount;
        }
    }

    //Function for withdrawing money
    void withdraw(int amount){
        if (amount!=0){
            balance=balance-amount;
            previousTransaction=-amount;
        }
    }

    //Function showing the previous transaction
    void getPreviousTransaction(){
        if (previousTransaction>0){
            System.out.println("Deposited:" + previousTransaction);
        }else if (previousTransaction < 0){
            System.out.println("Withdrawn:" + Math.abs(previousTransaction));
        }else{
            System.out.println("No transaction occured");
        }
    }

    //Function calculating interest of current funds after a number of years
    void calculateInterest(int years){
        double interestRate = -.0185;
        double newBalance = (balance * interestRate * years) + balance;
        System.out.println("The current interest rate is:" + (100 * interestRate));
        System.out.println("After " + years + " years, your baalnce will be: " + newBalance );
    }

    //Function showing the main menu
    void showMenu(){
        char option = '\0';
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome, " + customerName + "!");
        System.out.println("Your ID is: " + customerID);
        System.out.println();
        System.out.println("What would you like to do?");
        System.err.println();
        System.out.println("A: Check your balance");
        System.out.println("B. Make a deposit");
        System.out.println("C. Make a withdrawal");
        System.out.println("D. View previous transaction");
        System.out.println("E. Calculate Interest");
        System.out.println("F. Exit"); 

        do{
            System.out.println();
            System.out.println("Enter the option: ");
            char option1 = sc.next().charAt(0);
            option = Character.toUpperCase(option1);
            System.out.println();

            switch ((option1)) {
            //Case 'A' allows the user t check their account balance
            case 'A':
            System.out.println("=============================");
            System.out.println("Balance = $" + balance);
            System.out.println("=============================");
            System.out.println();
            break;

            //Case 'B' allows the user to deposit money into their account
            case 'B':
            System.out.println("Enter an amount to deposit: ");
            int amount = sc.nextInt();
            deposit(amount);
            System.out.println();
            break;

            //Case 'C' allows the user to withdraw money from their account
            case 'C':
            System.out.println("Enter an amount to withdraw: ");
            int amount2 =  sc.nextInt();
            withdraw(amount2);
            System.out.println();
            break;
            
            //Case 'D' allows the user to view their most recent transaction
            case 'D':
            System.out.println("=============================");
            getPreviousTransaction();
            System.out.println("=============================");
            System.out.println();
            break;

            //Case 'E' calculates the accrued interest on the account
            case 'E':
            System.out.println("Enter how many years of accrued interest: ");
            int years = sc.nextInt();
            calculateInterest(years);
            break;

            //Case 'F' exits the user from their account
            case 'F':
            System.out.println("=============================");
            break;
            
            //The default case let's the user know that they entered an invalid character
            default:
            System.out.println("Error: invalid option. Please enter A, B, C, D, E or F");
            break;
            }
        } while(option != 'F');
        System.out.println("Thank you for banking with us!");
    }
}