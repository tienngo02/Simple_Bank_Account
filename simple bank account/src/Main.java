import java.util.Scanner;

class bankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;

     public bankAccount(String accountNum, String accountName, double Balance) {
        this.accountNumber = accountNum;
        this.holderName = accountName;
        this.balance = Balance;
    }

    public void deposit(double amount) {
        if(amount > 0) {
            balance += amount;
            System.out.println("Deposited successfully: " + amount);
        } 
        else{
            System.out.println("Invalid amount for deposit.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn successfully: " + amount);
        } else {
            System.out.println("Invalid amount for withdrawal.");
        }
    }

    public double checkBalance() {
        return balance;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter account number: ");
        String accountNum = scanner.nextLine();
        System.out.print("Enter account holder name: ");
        String accountName = scanner.nextLine();
        System.out.print("Enter balance: ");
        double Balance = scanner.nextDouble();

        bankAccount bankAccount = new bankAccount(accountNum, accountName, Balance);

        while(true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch(choice) {
                case 1:
                    System.out.print("Enter the deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    bankAccount.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter the withdrawal amount: ");
                    double withdrawalAmount = scanner.nextDouble();
                    bankAccount.withdraw(withdrawalAmount);
                    break;
                case 3:
                    System.out.println("Current Balance: " + bankAccount.checkBalance());
                    break;
                case 4:
                    System.out.println("EXIT");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}