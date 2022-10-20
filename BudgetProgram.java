package budget;

import java.util.ArrayList;
import java.util.List;

class BudgetProgram {
    private double balance = 0;
    private List<Purchase> purchases = new ArrayList<>();
    private final Menu menu = new Menu(this);

    void run() {
        menu.runMenu();
    }

    double getBalance() {
        return balance;
    }

    void setBalance(double balance) {
        this.balance = balance;
    }

    List<Purchase> getPurchases() {
        return purchases;
    }

    void setPurchases(List<Purchase> purchases) {
        this.purchases = purchases;
    }

    Menu getMenu() {
        return menu;
    }

    void addBalance(double sum) {
        balance += sum;
    }

    void addPurchase(Purchase purchase) {
        purchases.add(purchase);
    }
}
