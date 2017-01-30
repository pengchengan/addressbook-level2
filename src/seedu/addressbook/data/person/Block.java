package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

public class Block {
	public static final String EXAMPLE = "123, some street";
    public static final String MESSAGE_BLOCK_CONSTRAINTS = "Person Block can be in any format";
    public static final String BLOCK_VALIDATION_REGEX = ".+";

    public final String value;
    private boolean isPrivate;

    /**
     * Validates given block.
     *
     * @throws IllegalValueException if given block string is invalid.
     */
    public Block(String block, boolean isPrivate) throws IllegalValueException {
        String trimmedBlock = block.trim();
        this.isPrivate = isPrivate;
        if (!isValidBlock(trimmedBlock)) {
            throw new IllegalValueException(MESSAGE_BLOCK_CONSTRAINTS);
        }
        this.value = trimmedBlock;
    }

    /**
     * Returns true if a given string is a valid person block.
     */
    public static boolean isValidBlock(String test) {
        return test.matches(BLOCK_VALIDATION_REGEX);
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
