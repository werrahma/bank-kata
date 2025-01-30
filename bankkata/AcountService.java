package bankkata;


public interface AcountService {
    void deposit(int amount);
    void withdraw(int amount);
    void printStatement();
};