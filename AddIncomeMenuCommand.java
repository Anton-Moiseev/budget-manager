package budget;

import java.util.Scanner;

class AddIncomeMenuCommand {
    private static final Scanner scanner = new Scanner(System.in);
    static void execute(BudgetProgram budgetProgram) {
        System.out.println("Enter income:");
        double input = Double.parseDouble(scanner.nextLine().trim());
        if (input < -budgetProgram.getBalance()) {
            budgetProgram.setBalance(0);
        } else {
            budgetProgram.addBalance(input);
        }
        System.out.println("Income was added!\n");
        budgetProgram.getMenu().runMenu();
    }
}
