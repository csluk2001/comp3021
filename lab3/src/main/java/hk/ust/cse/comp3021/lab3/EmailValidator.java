package hk.ust.cse.comp3021.lab3;

/**
 * <p>Referenced from <a href="https://en.wikipedia.org/wiki/Email_address">here</a>.</p>
 */
public class EmailValidator extends Validator {
    private static final int MAX_LOCAL_PART_LENGTH = 64;
    private static final int MAX_DOMAIN_LENGTH = 255;
    private final String PRINTABLE_CHARACTERS = "!#$%&'*+-/=?^_`{|}~.";
    private final String SPACE_AND_SPECIAL_CHARACTERS = " \"(),:;<>@[\\]";
    /*
        A: ASCII code 65
        Z: ASCII code 90
        a: ASCII code 97
        z: ASCII code 122
        0: ASCII code 48
        9: ASCII code 57
     */
    private String localPart;
    private String domain;

    @Override
    public boolean validate(final String input) {
        int symbolCount = this.checkContainSymbol(input);
        // only 1 @
        if (symbolCount != 1) {
            return false;
        }

        if (!this.concatEmail(input)) {
            return false;
        }
        return checkLocalPart(this.localPart) && checkDomain(this.domain);
    }

    private int checkContainSymbol(String email) {
        int count = 0, emailLength = email.length();
        for (int i = 0; i < emailLength; i++) {
            if (email.charAt(i) == '@') {
                count++;
            }
        }
        return count;
    }

    private boolean concatEmail(String email) {
        String[] localPartAndDomain = email.split("@");
        if (localPartAndDomain.length != 2) {
            return false;
        }

        this.localPart = localPartAndDomain[0];
        if (this.localPart.length() > MAX_LOCAL_PART_LENGTH) {
            return false;
        }

        this.domain = localPartAndDomain[1];
        if (this.domain.length() > MAX_DOMAIN_LENGTH) {
            return false;
        }
        return true;
    }

    private boolean checkLocalPart(String localPart) {
        /*
            dot (.), provided that it is not the first or last character and provided also that it does not appear consecutively (e.g., John..Doe@example.com is not allowed).
         */
        if (localPart.startsWith(".") || localPart.endsWith(".") || localPart.contains("..")) {
            return false;
        }
        char tempChar;
        for (int i = 0; i < localPart.length(); i++) {
            tempChar = localPart.charAt(i);
            if (!Character.isLetterOrDigit(tempChar) && !this.PRINTABLE_CHARACTERS.contains(String.valueOf(tempChar))) {
                return false;
            }
        }

        return true;
    }

    private boolean checkDomain(String domain) {
        char c;
        for (int i = 0; i < domain.length(); i++) {
            c = domain.charAt(i);
            if (!Character.isLetterOrDigit(c)) {
                if (c == '-') {
                    if (i == 0 || i == domain.length() - 1) {
                        return false;
                    }
                } else if (c == '.') {
                    if (i != domain.length() - 1 && domain.charAt(i + 1) == '.') {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        return true;
    }

//    private boolean checkCommentAndOutsideCommentBracket(String localPart) {
//        char c;
//        boolean isComment = false;
//        for (int i = 0; i < localPart.length(); i++) {
//            c = localPart.charAt(i);
//            if (c == '\"') {
//                isComment = !isComment;
//            }
//            if (!isComment) {
//                if (SPACE_AND_SPECIAL_CHARACTERS.contains(String.valueOf(c))) {
//                    return false;
//                }
//            }
//        }
//        return true;
//    }
}
