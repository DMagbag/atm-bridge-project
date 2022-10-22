import java.util.Scanner;

public class AtmClientApplication {

    public static void main(String[] args) {
        Scanner input = new Scanner((System.in));
        Atm myAtm = new Atm(500, "1234");

        System.out.println("Welcome to Bridge Bank.\n");
        System.out.println("Please enter your pin.");
        String userEnteredPin = input.nextLine();

        while (!myAtm.allowAccess(userEnteredPin)) {
            System.out.println("Incorrect pin. Please reenter your pin.");
            userEnteredPin = input.nextLine();
        }

        System.out.println("\nPlease select from the menu below:\n" +
                "1: Check balance\n" +
                "2: Make a deposit\n" +
                "3: Make a withdrawal\n" +
                "4: Exit\n");

        String userChoice = input.nextLine();

        while (!userChoice.equals("4")) {
            if (userChoice.equals("1")) {
                System.out.println("Your balance is $" + myAtm.getBalance() + "\n");
            } else if (userChoice.equals("2")) {
                System.out.println("Enter the amount to deposit.");
                int amountToDeposit = input.nextInt();
                input.nextLine();
                myAtm.deposit(amountToDeposit);
            } else if (userChoice.equals("3")) {
                System.out.println("Enter the amount to withdraw.");
                int amountToWithdraw = input.nextInt();
                input.nextLine();
                myAtm.withdrawal(amountToWithdraw);
            } else {
                System.out.println("Sorry. I do not understand your choice.");
            }
            System.out.println("\nPlease select from the menu below:\n" +
                    "1: Check balance\n" +
                    "2: Make a deposit\n" +
                    "3: Make a withdrawal\n" +
                    "4: Exit\n");

            userChoice = input.nextLine();
        }
        System.out.println("Thank you for banking with Bridge Bank.");
    }
}