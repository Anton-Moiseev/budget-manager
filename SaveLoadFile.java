package budget;

import java.io.Serializable;
import java.util.List;

class SaveLoadFile implements Serializable {
    private static final long serialVersionUID = 2L;
    private final List<Purchase> purchases;
    private final double balance;

    SaveLoadFile(List<Purchase> purchases, double balance) {
        this.purchases = purchases;
        this.balance = balance;
    }

    List<Purchase> getPurchases() {
        return purchases;
    }

    double getBalance() {
        return balance;
    }
}
