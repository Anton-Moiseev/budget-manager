package budget;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class UserInputUtils {
    private static final Scanner scanner = new Scanner(System.in);

    static List<String> getAllUserInput() {
        List<String> list = new ArrayList<>();
        while (scanner.hasNext()) {
            list.add(scanner.nextLine().trim());
        }
        return list;
    }
}
