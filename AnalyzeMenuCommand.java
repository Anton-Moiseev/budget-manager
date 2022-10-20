package budget;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class AnalyzeMenuCommand {
    private static final Scanner scanner = new Scanner(System.in);

    static void execute(BudgetProgram budgetProgram) {
        PrintUtils.analyzeMenu();
        int pick = Integer.parseInt(scanner.nextLine().trim());
        System.out.print("\n");
        List<Purchase> purchases = budgetProgram.getPurchases();
        switch (pick) {
            case 1:
                sortAllPurchases(purchases);
                execute(budgetProgram);
                break;
            case 2:
                sortByType(purchases);
                execute(budgetProgram);
                break;
            case 3:
                sortCertainType(purchases);
                execute(budgetProgram);
                break;
            default:
                System.out.print("\n");
                budgetProgram.getMenu().runMenu();
        }
    }

    private static void sortAllPurchases(List<Purchase> purchases) {
        if (purchases.size() == 0) {
            System.out.println("The purchase list is empty!\n");
            return;
        }
        System.out.println("All:");
        purchases = purchases.stream()
                .sorted((p1, p2) -> {
                    if (p1.getPrice() < p2.getPrice()) {
                        return 1;
                    } else if (p1.getPrice() > p2.getPrice()) {
                        return -1;
                    } else {
                        return 0;
                    }
                })
                .collect(Collectors.toList());
        for (Purchase purchase : purchases) {
            String name = purchase.getName();
            double price = purchase.getPrice();
            System.out.printf("%s $%.2f\n", name, price);
        }
        double total = CalculationsUtils.getTotal(purchases);
        System.out.printf("Total: $%.2f\n", total);
        System.out.print("\n");
    }

    private static void sortByType(List<Purchase> purchases) {
        System.out.println("Types:");
        for (PurchaseType type : PurchaseType.values()) {
            String typeName = type.name();
            List<Purchase> purchasesSublist = purchases.stream()
                    .filter(purchase -> purchase.getPurchaseType() == type)
                    .collect(Collectors.toList());
            double subTotal = CalculationsUtils.getTotal(purchasesSublist);
            System.out.printf("%s - $%.2f\n", typeName, subTotal);
        }
        double total = CalculationsUtils.getTotal(purchases);
        System.out.printf("Total sum: $%.2f\n", total);
        System.out.print("\n");
    }

    private static void sortCertainType(List<Purchase> purchases) {
        PrintUtils.typeOfPurchaseAnalyzeMenu();
        int pick = Integer.parseInt(scanner.nextLine().trim());
        System.out.print("\n");
        PurchaseType purchaseType;
        switch (pick) {
            case 1:
                purchaseType = PurchaseType.Food;
                break;
            case 2:
                purchaseType = PurchaseType.Clothes;
                break;
            case 3:
                purchaseType = PurchaseType.Entertainment;
                break;
            default:
                purchaseType = PurchaseType.Other;
        }
        System.out.println(purchaseType.name() + ":");
        List<Purchase> purchasesSublist = purchases.stream()
                .filter(purchase -> purchase.getPurchaseType() == purchaseType)
                .sorted((p1, p2) -> {
                    if (p1.getPrice() < p2.getPrice()) {
                        return 1;
                    } else if (p1.getPrice() > p2.getPrice()) {
                        return -1;
                    } else {
                        return 0;
                    }
                })
                .collect(Collectors.toList());
        if (purchasesSublist.size() == 0) {
            System.out.println("The purchase list is empty!\n");
            return;
        }
        for (Purchase purchase : purchasesSublist) {
            String name = purchase.getName();
            double price = purchase.getPrice();
            System.out.printf("%s $%.2f\n", name, price);
        }
        double subTotal = CalculationsUtils.getTotal(purchasesSublist);
        System.out.printf("Total sum: $%.2f\n", subTotal);
        System.out.print("\n");
    }
}
