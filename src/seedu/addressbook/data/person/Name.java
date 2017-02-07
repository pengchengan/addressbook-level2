package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

import java.util.Arrays;
import java.util.List;

/**
 * Represents a Person's name in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidName(String)}
 */
public class Name {

    public static final String EXAMPLE = "John Doe";
    public static final String MESSAGE_NAME_CONSTRAINTS = "Person names should be spaces or alphabetic characters";
    public static final String NAME_VALIDATION_REGEX = "[\\p{Alpha} ]+";
    public final String fullName;
    
    public static final int ASCII_START_NUM = 65;
    public static final int ASCII_LOW_NUM = 0;
    public static final int ALPHABET_COUNT = 26;
    public static final int ERROR_TOLERANCE_NUM = 2;
    /**
     * Validates given name.
     *
     * @throws IllegalValueException if given name string is invalid.
     */
    public Name(String name) throws IllegalValueException {
        String trimmedName = name.trim();
        if (!isValidName(trimmedName)) {
            throw new IllegalValueException(MESSAGE_NAME_CONSTRAINTS);
        }
        this.fullName = trimmedName;
    }

    /**
     * Returns true if a given string is a valid person name.
     */
    public static boolean isValidName(String test) {
        return test.matches(NAME_VALIDATION_REGEX);
    }

    /**
     * Retrieves a listing of every word in the name, in order.
     */
    public List<String> getWordsInName() {
        return Arrays.asList(fullName.split("\\s+"));
    }

    @Override
    public String toString() {
        return fullName;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Name // instanceof handles nulls
                && this.fullName.equals(((Name) other).fullName)); // state check
    }

    @Override
    public int hashCode() {
        return fullName.hashCode();
    }
    
    /**
     * Returns true of the other name is very similar to this name.
     * Two names are considered similar if ...
     */
     public boolean isSimilar(Name other) {
    	 int[] alphabetCount = new int [26];
    	 int[] otherAlphabetCount = new int [26];
    	 
    	 String upperCaseName = this.fullName.toUpperCase();
    	 for(int i = 0; i < this.fullName.length(); i++) {
    		 if(upperCaseName.charAt(i) - 0 >= Name.ASCII_START_NUM && upperCaseName.charAt(i) - 0 <= Name.ASCII_START_NUM + ALPHABET_COUNT) {
    			 alphabetCount[upperCaseName.charAt(i) - Name.ASCII_START_NUM]++;
    		 }    		 
    	 }
    	 
    	 String otherUpperCaseName = other.fullName.toUpperCase();
    	 for(int i = 0; i < other.fullName.length(); i++) {
    		 if(otherUpperCaseName.charAt(i) - 0 >= Name.ASCII_START_NUM && otherUpperCaseName.charAt(i) - 0 <= Name.ASCII_START_NUM + ALPHABET_COUNT) {
    			 otherAlphabetCount[upperCaseName.charAt(i) - Name.ASCII_START_NUM]++; 
    		 }
    	 }
    	 
    	 int errorFlag = 0;
    	 for(int i = 0; i < Name.ALPHABET_COUNT ; i++) {
    		 if(Math.abs(alphabetCount[i] - otherAlphabetCount[i]) > 1) {
    			 errorFlag += alphabetCount[i] - otherAlphabetCount[i];
    		 }
    	 }
    	 
    	 if(errorFlag <= Name.ERROR_TOLERANCE_NUM) {
    		 return true;
    	 } else {
    		 return false;
    	 }
     }
}
