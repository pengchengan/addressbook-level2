package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

public class Unit {
	public static final String EXAMPLE = "123, some street";
    public static final String MESSAGE_UNIT_CONSTRAINTS = "Person Block can be in any format";
    public static final String UNIT_VALIDATION_REGEX = ".+";

    public final String value;
    private boolean isPrivate;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Unit(String unit, boolean isPrivate) throws IllegalValueException {
        String trimmedUnit = unit.trim();
        this.isPrivate = isPrivate;
        if (!isValidBlock(trimmedUnit)) {
            throw new IllegalValueException(MESSAGE_UNIT_CONSTRAINTS);
        }
        this.value = trimmedUnit;
    }

    /**
     * Returns true if a given string is a valid person email.
     */
    public static boolean isValidBlock(String test) {
        return test.matches(UNIT_VALIDATION_REGEX);
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
