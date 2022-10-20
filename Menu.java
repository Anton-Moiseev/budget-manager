package budget;

import java.util.Scanner;

class Menu {
    private final BudgetProgram budgetProgram;
    private final Scanner scanner = new Scanner(System.in);

    Menu(BudgetProgram budgetProgram) {
        this.budgetProgram = budgetProgram;
    }

    void runMenu() {
        PrintUtils.mainMenu();
        int pick = Integer.parseInt(scanner.nextLine().trim());
        System.out.print("\n");
        executeMenuPick(pick);
    }

    private void executeMenuPick(int pick) {
        switch (pick) {
            case 1:
                AddIncomeMenuCommand.execute(budgetProgram);
                break;
            case 2:
                AddPurchaseMenuCommand.execute(budgetProgram);
                break;
            case 3:
                ShowListMenuCommand.execute(budgetProgram);
                break;
            case 4:
                BalanceMenuCommand.execute(budgetProgram);
                break;
            case 5:
                SaveMenuCommand.execute(budgetProgram);
                break;
            case 6:
                LoadMenuCommand.execute(budgetProgram);
                break;
            case 7:
                AnalyzeMenuCommand.execute(budgetProgram);
                break;
            default:
                System.out.println("Bye!");
        }
    }
}
