package hk.ust.cse.comp3021.lab3;

/**
 * Validates variable names for Java.
 */
public class VariableNameValidator extends Validator {
    private final String[] reservedKeywords = {
            "abstract", "assert", "boolean", "break", "byte", "case", "catch", "char", "class", "const", "continue",
            "default", "do", "double", "else", "enum", "extends", "final", "finally", "float", "for", "goto", "if",
            "implements", "import", "instanceof", "int", "interface", "long", "native", "new", "package", "private",
            "protected", "public", "return", "short", "static", "strictfp", "super", "switch", "synchronized", "this",
            "throw", "throws", "transient", "try", "void", "volatile", "while"
    };
    @Override
    public boolean validate(final String input) {
        // check null and empty variable name
        if (input == null || input.isEmpty()) {
            return false;
        }

        // check java reserved keyword
        for (String keyword : reservedKeywords) {
            if (input.equals(keyword)) {
                return false;
            }
        }

        // check if the variable name does not start with a letter, underscore, or dollar sign
        char firstChar = input.charAt(0);
        if (!Character.isLetter(firstChar) && firstChar != '_' && firstChar != '$') {
            return false;
        }

        char ch;
        // check if the variable name contains only valid characters
        for (int i = 1; i < input.length(); i++) {
            ch = input.charAt(i);
            if (!Character.isLetterOrDigit(ch) && ch != '_' && ch != '$') {
                return false;
            }
        }

        // variable name is valid
        return true;
    }
}