package hk.ust.cse.comp3021.lab3;

/**
 * Validates a phone number with E.164 format.
 */
public class PhoneNumberValidator extends Validator {
    private final int MAX_LENGTH_WITHOUT_PREFIX = 12;
    private final int MAX_LENGTH_WITH_PREFIX = 15;
    private final String NUMBER_CHARACTERS = "0123456789";

    @Override
    public boolean validate(final String input) {
        // check length
        int startIdx = 0;
        if (input.startsWith("+")) {
            startIdx = 1;
            if (input.length() > this.MAX_LENGTH_WITH_PREFIX + 1) {
                return false;
            }
        } else {
            if (input.length() > this.MAX_LENGTH_WITHOUT_PREFIX) {
                return false;
            }
        }

        for (int i = startIdx; i < input.length(); i++) {
            if (!NUMBER_CHARACTERS.contains(String.valueOf(input.charAt(i)))) {
                return false;
            }
        }
        return true;
    }
}
