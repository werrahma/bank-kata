package bankkata;

import java.time.LocalDate;

public class Transaction {
   private LocalDate date;
   private int amount;
   private int balance;

   public Transaction(LocalDate var1, int var2, int var3) {
      this.date = var1;
      this.amount = var2;
      this.balance = var3;
   }

   public LocalDate getDate() {
      return this.date;
   }

   public int getAmount() {
      return this.amount;
   }

   public int getBalance() {
      return this.balance;
   }
}
