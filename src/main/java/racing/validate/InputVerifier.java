package racing.validate;

import racing.view.output.OutputView;

public class InputVerifier {
    public static void validateNameLength(String input) {
        for (String name : input.split(",")) {
            checkNameLength(name);
            checkSpace(name);
        }
    }

    public static void checkSpace(String name) {
        if (name.contains(" ")) {
            throw new IllegalArgumentException(OutputView.CANT_CONTAIN_SPACE);
        }
    }

    public static void checkNameLength(String name) {
        if (isValidLength(name)) {
            throw new IllegalArgumentException(OutputView.UNSUITABLE_LENGTH);
        }
    }

    private static boolean isValidLength(String name) {
        return name.length() < 1 || 5 < name.length();
    }

    public static String checkInputTypeIsNumber(String input) {
        if (!input.matches("[0-9]+")) {
            throw new IllegalArgumentException(OutputView.INPUT_ONLY_DIGIT);
        }
        return input;
    }
}
