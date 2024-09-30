package race;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import race.inputView.CarRequirement;
import race.inputView.InputView;
import race.inputView.InputViewException;
import race.inputView.RoundRequirement;

import java.util.Scanner;

import static org.assertj.core.api.Assertions.*;

class RaceTest {

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"})
    void 자동차는_1대_이상_10대_이하로_제한한다(String input) {
        assertThatCode(() -> InputView.askCount(new Scanner(input), new CarRequirement())).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings = {"-100", "-1", "0", "11", "100"})
    void 자동차는_1대_미만_10대_초과하여_설정할_수_없다(String input) {
        assertThatThrownBy(() -> InputView.askCount(new Scanner(input), new CarRequirement()))
                .isInstanceOf(InputViewException.class)
                .hasMessage("자동차는 1대 이상 10대 이하로 설정해야 합니다.");

    }

    @ParameterizedTest
    @ValueSource(strings = {"한글", "english", "1.1"})
    @DisplayName("자동차 수는 1~10의 정수 이외의 값은 사용할 수 없다.")
    void 자동차_수_입력_시_숫자만_사용가능(String input) {
        assertThatThrownBy(() -> InputView.askCount(new Scanner(input), new CarRequirement()))
                .isInstanceOf(InputViewException.class)
                .hasMessage("1 ~ 10 사이의 정수만 사용할 수 있습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "4", "7", "11", "16", "22", "29", "30"})
    void 이동_횟수는_1회_이상_30회_이하로_제한한다(String input) {
        assertThatCode(() -> InputView.askCount(new Scanner(input), new RoundRequirement())).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings = {"-100", "-1", "0", "31", "100"})
    void 이동_횟수는__1회_미만_30회_초과로_설정할_수_없다(String input) {
        assertThatThrownBy(() -> InputView.askCount(new Scanner(input), new RoundRequirement()))
                .isInstanceOf(InputViewException.class)
                .hasMessage("이동 횟수는 1회 이상 30회 이하로 설정해야 합니다.");

    }

    @ParameterizedTest
    @ValueSource(strings = {"한글", "english", "1.1"})
    @DisplayName("이동 횟수는 정수 이외의 값은 사용할 수 없다.")
    void 이동_횟수_입력_시_숫자만_사용가능(String input) {
        assertThatThrownBy(() -> InputView.askCount(new Scanner(input), new RoundRequirement()))
                .isInstanceOf(InputViewException.class)
                .hasMessage("1 ~ 30 사이의 정수만 사용할 수 있습니다.");
    }
}