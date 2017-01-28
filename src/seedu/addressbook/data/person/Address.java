package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "123, some street, some unit, some postal_code";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses can be in any format";
    public static final String ADDRESS_VALIDATION_REGEX = ".+";
    public static final String ADDRESS_CONCATENATION_SYMBLE = ", ";

    //public final String value;

    private final Block valueBlock;
    private final Street valueStreet;
    private final Unit valueUnit;
    private final PostalCode valuePostalCode;
    
    private boolean isPrivate;
    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        String trimmedAddress = address.trim();
        this.isPrivate = isPrivate;
        if (!isValidAddress(trimmedAddress)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        //this.value = trimmedAddress;
        String[]SplitAddress=trimmedAddress.split(", ");
        this.valueBlock = new Block(SplitAddress[0], isPrivate);
        this.valueStreet = new Street(SplitAddress[1], isPrivate);
        this.valueUnit = new Unit(SplitAddress[2], isPrivate);
        this.valuePostalCode = new PostalCode(SplitAddress[3], isPrivate);
    }

    /**
     * Returns true if a given string is a valid person email.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
    	String Address = valueBlock.toString() + ADDRESS_CONCATENATION_SYMBLE + 
    			valueStreet.toString() + ADDRESS_CONCATENATION_SYMBLE +    			
    			valueUnit.toString() + ADDRESS_CONCATENATION_SYMBLE + 
    			valuePostalCode.toString();
        return Address;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.toString().equals(((Address) other).toString())); // state check
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}
