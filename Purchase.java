package budget;

import java.io.Serializable;

class Purchase implements Serializable {
    private static final long serialVersionUID = 1L;
    private final String name;
    private final double price;
    private final PurchaseType purchaseType;

    Purchase(String name, double price, PurchaseType purchaseType) {
        this.name = name;
        this.price = price;
        this.purchaseType = purchaseType;
    }

    String getName() {
        return name;
    }

    double getPrice() {
        return price;
    }

    PurchaseType getPurchaseType() {
        return purchaseType;
    }
}
