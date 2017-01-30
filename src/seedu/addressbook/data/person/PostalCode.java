package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

public class PostalCode {
	public static final String EXAMPLE = "123, some street";
    public static final String MESSAGE_PSOTALCODE_CONSTRAINTS = "Person Block can be in any format";
    public static final String PSOTALCODE_VALIDATION_REGEX = ".+";

    public final String value;
    private boolean isPrivate;

    /**
     * Validates given postalcode.
     *
     * @throws IllegalValueException if given postalcode string is invalid.
     */
    public PostalCode(String postalCode, boolean isPrivate) throws IllegalValueException {
        String trimmedPostalCode = postalCode.trim();
        this.isPrivate = isPrivate;
        if (!isValidPostalcode(trimmedPostalCode)) {
            throw new IllegalValueException(MESSAGE_PSOTALCODE_CONSTRAINTS);
        }
        this.value = trimmedPostalCode;
    }

    /**
     * Returns true if a given string is a valid person postalcode.
     */
    public static boolean isValidPostalcode(String test) {
        return test.matches(PSOTALCODE_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Block // instanceof handles nulls
                && this.value.equals(((Block) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}
