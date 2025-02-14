import java.util.Scanner;

class ATM {
    private static final int PIN = 1234;
    private double balance;

    public ATM(double initialBalance) {
        this.balance = initialBalance;
    }

    public void withdraw(double amount, int enteredPin) throws Exception {
        if (enteredPin != PIN) {
            throw new Exception("Invalid PIN. Access Denied.");
        }
        if (amount > balance) {
            throw new Exception("Insufficient balance.");
        }
        balance -= amount;
        System.out.println("Withdrawal successful. Amount withdrawn: " + amount);
    }

    public void displayBalance() {
        System.out.println("Remaining balance: " + balance);
    }
}

public class ATMSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ATM atm = new ATM(5000.00); 

        try {
            System.out.print("Enter PIN: ");
            int enteredPin = scanner.nextInt();

            System.out.print("Enter amount to withdraw: ");
            double amount = scanner.nextDouble();
            
            atm.withdraw(amount, enteredPin);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            atm.displayBalance();
            scanner.close();
        }
    }
}
