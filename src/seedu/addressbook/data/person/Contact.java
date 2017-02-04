package seedu.addressbook.data.person;

/**
 * @author user
 * This class is an abstract class for Email, Phone, Address
 */
public abstract class Contact {

    public final String value;
    private boolean isPrivate;
    
    /** Initialize the value and isPrivate 
     * @param input 
     * @param isPrivate
     */
    public Contact(String input, boolean isPrivate){
    	String trimmedInput = input.trim();
    	this.value = trimmedInput;
    	this.isPrivate= isPrivate;
    }
    
    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                ||  this.getClass().isInstance(other) && this.value.equals((getClass().cast(other).value)); // value check
    }
    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}
