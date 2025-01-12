import java.util.Scanner;

class Account {
    protected String customerName;
    protected int accountNumber;
    protected double balance;
    protected String accountType;

    public Account(String customerName, int accountNumber, double balance, String accountType) {
        this.customerName = customerName;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.accountType = accountType;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
    }

    public void displayBalance() {
        System.out.println("Account Balance: " + balance);
    }

    public abstract void withdraw(double amount);

    public abstract void calculateInterest();
}

class SavAcct extends Account {
    private static final double INTEREST_RATE = 0.04;

    public SavAcct(String customerName, int accountNumber, double balance) {
        super(customerName, accountNumber, balance, "Savings");
    }

    @Override
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient funds in savings account.");
        }
    }

    @Override
    public void calculateInterest() {
        double interest = balance * INTEREST_RATE;
        balance += interest;
        System.out.println("Interest of " + interest + " added to the balance.");
    }
}

class CurAcct extends Account {
    private static final double MIN_BALANCE = 500;
    private static final double PENALTY = 50;

    public CurAcct(String customerName, int accountNumber, double balance) {
        super(customerName, accountNumber, balance, "Current");
    }

    @Override
    public void withdraw(double amount) {
        if (balance - amount >= MIN_BALANCE) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Cannot withdraw, minimum balance of " + MIN_BALANCE + " must be maintained.");
        }
    }

    public void checkBalanceAndApplyPenalty() {
        if (balance < MIN_BALANCE) {
            balance -= PENALTY;
            System.out.println("Penalty of " + PENALTY + " applied due to low balance.");
        }
    }

    @Override
    public void calculateInterest() {
        System.out.println("Current account does not earn interest.");
    }
}

public class Bank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Account savingsAccount = new SavAcct("John Doe", 101, 1000.00);
        Account currentAccount = new CurAcct("Jane Smith", 102, 600.00);

        System.out.println("Performing operations for Savings Account:");
        savingsAccount.deposit(500);
        savingsAccount.displayBalance();
        savingsAccount.calculateInterest();
        savingsAccount.displayBalance();
        savingsAccount.withdraw(300);
        savingsAccount.displayBalance();

        System.out.println("\nPerforming operations for Current Account:");
        currentAccount.deposit(200);
        currentAccount.displayBalance();
        currentAccount.withdraw(50);
        currentAccount.displayBalance();
        ((CurAcct) currentAccount).checkBalanceAndApplyPenalty();
        currentAccount.displayBalance();

        scanner.close();
    }
}
