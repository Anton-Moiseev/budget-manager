package budget;

enum PurchaseType {
    Food, Entertainment, Clothes, Other;

    static PurchaseType getPurchaseType(int pick) {
        switch (pick) {
            case 1:
                return PurchaseType.Food;
            case 2:
                return PurchaseType.Clothes;
            case 3:
                return PurchaseType.Entertainment;
            default:
                return PurchaseType.Other;
        }
    }
}
