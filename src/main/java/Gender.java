
/**
 * represents sex of a person
 */
public enum Gender {
    Male,
    Female,
    Diverse;

    /**
     * Simple parsing of sex from a string. Onyly the intitial letter is evaluated
     * Everything that is not recognized is miscellaneous.
     *
     * @param gender as string.
     * @return Assignable gender constant.
     */
    public static Gender fromSingleCharacterString(String gender) {
        return switch (gender.charAt(0)) {
            case 'F' -> Female;
            case 'M' -> Male;
            default -> Diverse;
        };
    }
}
