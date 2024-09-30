package race;

import race.inputView.CarRequirement;
import race.inputView.InputView;
import race.inputView.RoundRequirement;

import java.util.Scanner;

public final class Race {

    public static void run() {
        try(Scanner scanner = new Scanner(System.in)) {
            int carCount = InputView.askCount(scanner, new CarRequirement());
            int roundCount = InputView.askCount(scanner, new RoundRequirement());
        }
    }
}
