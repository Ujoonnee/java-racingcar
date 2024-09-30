package race.inputView;

public final class RoundRequirement implements RaceRequirement {

    private static final int LOWER_LIMIT = 1;
    private static final int UPPER_LIMIT = 30;

    private static final String COUNT_QUESTION = "이동 횟수는 몇 번 인가요?";
    private static final String OUT_OF_RANGE_ERROR_MESSAGE = "이동 횟수는 "+ LOWER_LIMIT +"회 이상 "+ UPPER_LIMIT +"회 이하로 설정해야 합니다.";
    private static final String TYPE_MISMATCH_ERROR_MESSAGE = LOWER_LIMIT +" ~ "+ UPPER_LIMIT +" 사이의 정수만 사용할 수 있습니다.";

    @Override
    public void printCountQuestion() {
        System.out.println(COUNT_QUESTION);
    }

    @Override
    public void validateRange(int count) throws InputViewException {
        if (!isValidRange(count)) {
            throw new InputViewException(OUT_OF_RANGE_ERROR_MESSAGE);
        }
    }

    private static boolean isValidRange(int count) {
        return count >= LOWER_LIMIT && count <= UPPER_LIMIT;
    }

    @Override
    public void throwWithTypeErrorMessage() throws InputViewException {
        throw new InputViewException(TYPE_MISMATCH_ERROR_MESSAGE);
    }
}
