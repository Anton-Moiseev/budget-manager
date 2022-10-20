package budget;

import java.util.Scanner;

class AddPurchaseMenuCommand {
    private static final Scanner scanner = new Scanner(System.in);

    static void execute(BudgetProgram budgetProgram) {
        PrintUtils.typeOfPurchaseToAddMenu();
        int pick = Integer.parseInt(scanner.nextLine().trim());
        if (pick == 5) {
            System.out.print("\n");
            budgetProgram.getMenu().runMenu();
            return;
        }
        PurchaseType purchaseType = PurchaseType.getPurchaseType(pick);
        System.out.println("\nEnter purchase name:");
        String name = scanner.nextLine().trim();
        System.out.println("Enter its price:");
        double price = Double.parseDouble(scanner.nextLine().trim());
        budgetProgram.addPurchase(new Purchase(name, price, purchaseType));
        double balance = budgetProgram.getBalance();
        budgetProgram.setBalance(balance - price);
        System.out.println("Purchase was added!\n");
        execute(budgetProgram);
    }
}
