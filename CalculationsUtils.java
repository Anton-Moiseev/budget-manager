package budget;

import java.util.List;

class CalculationsUtils {
    static double getTotal(List<Purchase> purchases) {
        return purchases.stream()
                .map(Purchase::getPrice)
                .reduce(0.00, Double::sum);
    }
}
