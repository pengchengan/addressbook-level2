package seedu.addressbook.util;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.person.Name;

/**
 * @author user
 * This class is used to test isSimilar function in class Name
 */
public class PersonNameTest {
	@Test
	public void TestIdentical(){
		try {
			assertFalse(new Name("aaa").isSimilar(new Name("aaa")));
			assertFalse(new Name("a a").isSimilar(new Name("a a")));
			assertFalse(new Name("ab ab ab").isSimilar(new Name("ab ab ab")));
		} catch(IllegalValueException e) {
			System.out.println(e);
		}
	}
}
