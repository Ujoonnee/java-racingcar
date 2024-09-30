package race;

import java.util.InputMismatchException;
import java.util.Scanner;

final class InputView {

    private static final int CAR_COUNT_LOWER_LIMIT = 1;
    private static final int CAR_COUNT_UPPER_LIMIT = 10;

    static int askCarCount(final Scanner scanner) {
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
}
