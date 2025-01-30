package bankkata;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import skypay.AcountService;
import skypay.Transaction;


public class Acount implements AcountService {
    private List<Transaction> transactions;
    private int balance;

    public Acount() {
        this.transactions = new ArrayList<>();
        this.balance = 0;
    }

    @Override
    public void deposit(int amount) {
        deposit(amount, LocalDate.now());
    }

    public void deposit(int amount, LocalDate date) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive.");
        }
        balance += amount;
        transactions.add(new Transaction(date, amount, balance));
    }

    @Override
    public void withdraw(int amount) {
        withdraw(amount, LocalDate.now());
    }

    public void withdraw(int amount, LocalDate date) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive.");
        }
        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient balance for withdrawal.");
        }
        balance -= amount;
        transactions.add(new Transaction(date, -amount, balance));
    }

    @Override
    public void printStatement() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        System.out.println("Date       | Amount  | Balance");
        System.out.println("-----------------------------");

        transactions.stream()
            .sorted((t1, t2) -> t2.getDate().compareTo(t1.getDate()))
            .forEach(transaction -> 
                System.out.printf("%-10s | %6d | %6d%n",
                    transaction.getDate().format(formatter),
                    transaction.getAmount(),
                    transaction.getBalance()
                )
            );
    }
    
}
