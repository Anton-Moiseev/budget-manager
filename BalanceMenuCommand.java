package budget;

class BalanceMenuCommand {
    static void execute(BudgetProgram budgetProgram) {
        double balance = budgetProgram.getBalance();
        System.out.printf("Balance: $%.2f\n\n", balance);
        budgetProgram.getMenu().runMenu();
    }
}
