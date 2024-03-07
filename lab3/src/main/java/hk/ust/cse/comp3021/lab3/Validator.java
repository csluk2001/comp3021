package hk.ust.cse.comp3021.lab3;

/**
 * A generic validator for any kind of string input.
 */
public abstract class Validator {

    /**
     * Validates whether the given input is valid.
     *
     * @param input The input string to validate.
     * @return {@code true} if the string matches the requirements of the input type.
     */
    public abstract boolean validate(final String input);
}
