package budget;

import java.io.*;
import java.util.List;

class SaveMenuCommand {
    static void execute(BudgetProgram budgetProgram) {
        File file = new File("purchases.txt");
        List<Purchase> purchases = budgetProgram.getPurchases();
        double balance = budgetProgram.getBalance();
        SaveLoadFile saveLoadFile = new SaveLoadFile(purchases, balance);
        try {
            FileOutputStream fos = new FileOutputStream(file);
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(saveLoadFile);
            oos.close();
        } catch (FileNotFoundException e) {
            System.out.println("Saving failed! File Not Found!");
        } catch (IOException e) {
            System.out.println("Saving failed!");
        }
        System.out.println("Purchases were saved!");
        System.out.print("\n");
        budgetProgram.getMenu().runMenu();
    }
}
