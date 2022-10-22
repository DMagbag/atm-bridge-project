public class Atm {

    private int balance;
    private String requiredPin;

    public int getBalance() {
        return balance;
    }

    public Atm(int balance, String requiredPin) {
        this.balance = balance;
        this.requiredPin = requiredPin;
    }

    public void deposit(int amountToDeposit) {
        balance += amountToDeposit;
    }

    public void withdrawal(int amountToWithdraw) {
        if (amountToWithdraw <= balance) {
            balance -= amountToWithdraw;
        } else {
            System.out.println("Insufficient funds. Please select another option.");
        }
    }

    public boolean allowAccess(String enteredPin) {
        if (enteredPin.equals(requiredPin)) {
            return true;
        } else {
            return false;
        }
    }
}