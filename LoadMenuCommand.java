package budget;

import java.io.*;

class LoadMenuCommand {
    static void execute(BudgetProgram budgetProgram) {
        File file = new File("purchases.txt");
        try {
            FileInputStream fis = new FileInputStream(file);
            BufferedInputStream bis = new BufferedInputStream(fis);
            ObjectInputStream ois = new ObjectInputStream(bis);
            SaveLoadFile saveLoadFile = (SaveLoadFile) ois.readObject();
            budgetProgram.setPurchases(saveLoadFile.getPurchases());
            budgetProgram.setBalance(saveLoadFile.getBalance());
            ois.close();
        } catch (FileNotFoundException e) {
            System.out.println("Loading Failed! File Not Found!");
        } catch (ClassNotFoundException e) {
            System.out.println("Loading Failed! Class Not Found!");
        } catch (IOException e) {
            System.out.println("Loading Failed!");
        }
        System.out.println("Purchases were loaded!");
        System.out.print("\n");
        budgetProgram.getMenu().runMenu();
    }
}
