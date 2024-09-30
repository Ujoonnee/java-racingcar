package race.inputView;

import java.util.InputMismatchException;
import java.util.Scanner;

public final class InputView {

    public static <T extends RaceRequirement> int askCount(final Scanner scanner, final T requirement) {
        requirement.printCountQuestion();

        int count = 0;
        try {
            count = scanner.nextInt();

        } catch (InputMismatchException e) {
            requirement.throwWithTypeErrorMessage();
        }

        requirement.validateRange(count);

        return count;
    }
}
