package hk.ust.cse.comp3021.lab3;

import java.util.ArrayList;
import java.util.List;

public class StringUtils {
    /**
     * Obtains the character in a string at the given position.
     *
     * @param input The input string.
     * @param idx The index of the string.
     * @return The character at the given position of the string.
     */
    static char getCharAt(final String input, final int idx) {
        if (idx < 0 || idx >= input.length()) {
            throw new StringIndexOutOfBoundsException(idx);
        }
        return input.toCharArray()[idx];
    }

    /**
     * Checks whether the length of a string is less than the given maximum length.
     *
     * @param input The input string.
     * @param len The maximum length of the string (inclusive).
     * @return {@code true} if the string has fewer or equal number of characters than {@code len}.
     */
    static boolean lengthLessThanEqual(final String input, final int len) {
    	return input.length() <= len;
    }

    /**
     * Splits the input string by the given delimiter character.
     *
     * <p>
     * For example, given a string {@code "a,b,ca,dd,12345"} and delimiter {@code ','}, the returned list should contain
     * the following elements:
     * </p>
     * <ul>
     *     <li>{@code a}</li>
     *     <li>{@code b}</li>
     *     <li>{@code ca}</li>
     *     <li>{@code dd}</li>
     *     <li>{@code 12345}</li>
     * </ul>
     * <p>
     * You should keep empty string in the list. For example, splitting {@code "a,,b"} by {@code ','} should contain
     * three elements, {@code "a"}, {@code ""}, and {@code "b}.
     * </p>
     *
     * @param input The input string to split.
     * @param delimiter The delimiter to split by.
     * @return A {@link List} of {@link String} containing the split elements.
     */
    static List<String> splitByCharacter(final String input, final char delimiter) {
        if (input == null || input.isEmpty()) {
            return null;
        }

        List<String> result = new ArrayList<>();
        StringBuilder currentElement = new StringBuilder();

        char c;
        for (int i = 0; i < input.length(); i++) {
            c = input.charAt(i);

            if (c == delimiter) {
                result.add(currentElement.toString());
                currentElement.setLength(0); // Reset the StringBuilder
            } else {
                currentElement.append(c);
            }
        }

        // Add the remaining element if it is not empty
        if (!currentElement.isEmpty()) {
            result.add(currentElement.toString());
        }

        return result;
    }

    /**
     * Checks whether the given input string contains any whitespace character.
     *
     * <p>
     * Hint: {@link Character#isWhitespace(char)}.
     * </p>
     *
     * @param input The input string to check.
     * @return {@code true} if any character in the string is a whitespace.
     */
    static boolean containsWhitespace(final String input) {
        if (input == null || input.isEmpty()) {
            return false;
        }
        char c;
        for (int i = 0; i < input.length(); i++) {
            c = input.charAt(i);
            if (c == ' ') {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks whether the given input string starts with an alphabet character.
     *
     * <p>
     * Hint: {@link Character#isAlphabetic(int)}.
     * </p>
     *
     * @param input The input string to check.
     * @return {@code true} if the input string starts with an alphabet character.
     */
    static boolean startWithAlphabet(final String input) {
        if (input == null || input.isEmpty()) {
            return false;
        }

        char firstChar = input.charAt(0);
        return Character.isAlphabetic(firstChar);
    }

    /**
     * Checks whether all characters in the given string are "valid characters".
     *
     * <p>
     * Valid characters are any of the following characters:
     * </p>
     * <ul>
     *     <li>Alphabetic characters, if {@code alphabetsValid} is {@code true}</li>
     *     <li>Digit characters, if {@code digitsValid} is {@code true}</li>
     *     <li>Any character within the {@code validChars} string</li>
     * </ul>
     * <p>
     * For example, to check whether a string only contains question marks ({@code ?}) and exclamation points
     * ({@code !}), this method should be invoked as such:
     * {@code StringUtils.allCharactersValid(input, false, false, "?!")}.
     * </p>
     *
     * @param input The input string to check.
     * @param alphabetsValid Whether all alphabet characters are considered to be valid characters.
     * @param digitsValid Whether all digit characters are considered to be valid characters.
     * @param validChars A string of characters which can also be considered to be valid characters.
     * @return Whether all characters in the input string are valid.
     */
    static boolean allCharactersValid(final String input, final boolean alphabetsValid, final boolean digitsValid, final String validChars) {
        if (input == null || input.isEmpty()) {
            return false;
        }

        for (char c : input.toCharArray()) {
            if (alphabetsValid && Character.isAlphabetic(c)) {
                continue;
            }
            if (digitsValid && Character.isDigit(c)) {
                continue;
            }
            if (validChars.contains(String.valueOf(c))) {
                continue;
            }
            return false;
        }

        return true;
    }
}
