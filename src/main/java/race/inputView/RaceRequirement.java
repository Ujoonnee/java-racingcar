package race.inputView;

interface RaceRequirement {

    void printCountQuestion();
    void validateRange(final int count);
    void throwWithTypeErrorMessage();
}
