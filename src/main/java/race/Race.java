package race;

import java.util.Scanner;

public final class Race {

    public static void run() {
        try(Scanner scanner = new Scanner(System.in)) {
            int carCount = InputView.askCarCount(scanner);
        }
    }


}
