package bankkata;

import java.time.LocalDate;

import bankkata.Acount;


import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Acount account = new Acount();

        account.deposit(1000, LocalDate.of(2012, 1, 10));
        account.deposit(2000, LocalDate.of(2012, 1, 13));
        account.withdraw(500, LocalDate.of(2012, 1, 14));

        account.printStatement();
    }
}
