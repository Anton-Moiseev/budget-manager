package budget;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class ShowListMenuCommand {
    private static final Scanner scanner = new Scanner(System.in);
    static void execute(BudgetProgram budgetProgram) {
        List<Purchase> purchases = budgetProgram.getPurchases();
        double totalPrice;
        if (purchases.size() == 0) {
            System.out.println("The purchase list is empty!\n");
            return;
        }
        PrintUtils.typeOfPurchaseToShowMenu();
        int pick = Integer.parseInt(scanner.nextLine().trim());
        if (pick == 6) {
            System.out.print("\n");
            budgetProgram.getMenu().runMenu();
            return;
        } else if (pick == 5) {
            System.out.println("\nAll:");
            for (Purchase purchase : purchases) {
                String name = purchase.getName();
                double price = purchase.getPrice();
                System.out.printf("%s $%.2f\n", name, price);
            }
            totalPrice = CalculationsUtils.getTotal(purchases);
        } else {
            PurchaseType purchaseType = PurchaseType.getPurchaseType(pick);
            List<Purchase> filteredPurchases = budgetProgram.getPurchases()
                    .stream()
                    .filter((purchase) -> purchase.getPurchaseType() == purchaseType)
                    .collect(Collectors.toList());
            if (filteredPurchases.size() == 0) {
                System.out.println("\n" + purchaseType.name() + ":");
                System.out.println("The purchase list is empty!\n");
                return;
            }
            System.out.println("\n" + purchaseType.name() + ":");
            for (Purchase purchase : filteredPurchases) {
                String name = purchase.getName();
                double price = purchase.getPrice();
                System.out.printf("%s $%.2f\n", name, price);
            }
            totalPrice = CalculationsUtils.getTotal(filteredPurchases);
        }
        PrintUtils.printTotal(totalPrice);
        System.out.print("\n");
        execute(budgetProgram);
    }
}
