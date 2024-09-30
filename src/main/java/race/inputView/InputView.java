package race.inputView;

import java.util.InputMismatchException;
import java.util.Scanner;

public final class InputView {

    private static final int CAR_COUNT_LOWER_LIMIT = 1;
    private static final int CAR_COUNT_UPPER_LIMIT = 10;
    private static final String CAR_TYPE_MISMATCH_ERROR_MESSAGE = "1 ~ 10 사이의 정수만 사용할 수 있습니다.";
    private static final String CAR_OUT_OF_RANGE_ERROR_MESSAGE = "자동차는 1대 이상 10대 이하로 설정해야 합니다.";

    private static final int ROUND_COUNT_LOWER_LIMIT = 1;
    private static final int ROUND_COUNT_UPPER_LIMIT = 30;
    private static final String ROUND_TYPE_MISMATCH_ERROR_MESSAGE = "1 ~ 30 사이의 정수만 사용할 수 있습니다.";
    private static final String ROUND_OUT_OF_RANGE_ERROR_MESSAGE = "이동 횟수는 1회 이상 30회 이하로 설정해야 합니다.";

    public static int askCarCount(final Scanner scanner) {
        System.out.println("자동차는 몇 대 인가요?");

        int carCount = 0;
        try {
            carCount = scanner.nextInt();
            validateRange(carCount, CAR_COUNT_LOWER_LIMIT, CAR_COUNT_UPPER_LIMIT, CAR_OUT_OF_RANGE_ERROR_MESSAGE);

        } catch (InputMismatchException e) {
            throw new InputViewException(CAR_TYPE_MISMATCH_ERROR_MESSAGE);
        }

        return carCount;
    }

    public static int askRoundCount(final Scanner scanner) {
        System.out.println("이동 횟수는 몇 번 인가요?");

        int roundCount = 0;
        try {
            roundCount = scanner.nextInt();
            validateRange(roundCount, ROUND_COUNT_LOWER_LIMIT, ROUND_COUNT_UPPER_LIMIT, ROUND_OUT_OF_RANGE_ERROR_MESSAGE);

        } catch (InputMismatchException e) {
            throw new InputViewException(ROUND_TYPE_MISMATCH_ERROR_MESSAGE);
        }

        return roundCount;
    }

    private static void validateRange(final int count, final int lowerLimit, final int upperLimit, final String errorMessage) {
        if (count < lowerLimit || count > upperLimit) {
            throw new InputViewException(errorMessage);
        }
    }
}
