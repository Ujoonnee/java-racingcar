package race.inputView;

import java.util.InputMismatchException;
import java.util.Scanner;

public final class InputView {

    private static final int CAR_COUNT_LOWER_LIMIT = 1;
    private static final int CAR_COUNT_UPPER_LIMIT = 10;
    private static final int ROUND_COUNT_LOWER_LIMIT = 1;
    private static final int ROUND_COUNT_UPPER_LIMIT = 30;

    public static int askCarCount(final Scanner scanner) {
        System.out.println("자동차는 몇 대 인가요?");

        int carCount = 0;
        try {
            carCount = scanner.nextInt();
            validateCarCountRange(carCount);

        } catch (InputMismatchException e) {
            throw new InputViewException("1 ~ 10 사이의 정수만 사용할 수 있습니다.");
        }

        return carCount;
    }


    private static void validateCarCountRange(int count) {
        if (count < CAR_COUNT_LOWER_LIMIT || count > CAR_COUNT_UPPER_LIMIT) {
            throw new InputViewException("자동차는 1대 이상 10대 이하로 설정해야 합니다.");
        }
    }

    public static int askRoundCount(final Scanner scanner) {
        System.out.println("이동 횟수는 몇 번 인가요?");

        int roundCount = 0;
        try {
            roundCount = scanner.nextInt();
            validateRoundCountRange(roundCount);

        } catch (InputMismatchException e) {
            throw new InputViewException("1 ~ 30 사이의 정수만 사용할 수 있습니다.");
        }

        return roundCount;
    }

    private static void validateRoundCountRange(int count) {
        if (count < ROUND_COUNT_LOWER_LIMIT || count > ROUND_COUNT_UPPER_LIMIT) {
            throw new InputViewException("이동 횟수는 1회 이상 30회 이하로 설정해야 합니다.");
        }
    }
}
