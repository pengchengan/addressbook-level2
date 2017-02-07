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
			assertTrue(new Name("aaa").isSimilar(new Name("aaa")));
			assertTrue(new Name("a a").isSimilar(new Name("a a")));
			assertTrue(new Name("ab ab ab").isSimilar(new Name("ab ab ab")));
		} catch(IllegalValueException e) {
			System.out.println(e);
		}
	}
	
	@Test
	public void TestDifferentOrder(){
		try {
			assertTrue(new Name("a  ,a,  a").isSimilar(new Name("aa  a")));
			assertTrue(new Name("a a b").isSimilar(new Name(" b a a ")));
			assertTrue(new Name("a  b a  b a b c").isSimilar(new Name("ab ab ; ;ab")));
		} catch(IllegalValueException e) {
			System.out.println(e);
		}
	}
	
	@Test
	public void TestFewError(){
		try {
			assertTrue(new Name("aaabb").isSimilar(new Name("aaa")));
			assertTrue(new Name("a a b").isSimilar(new Name("a a ")));
			assertTrue(new Name("ab ab ab c").isSimilar(new Name("ab ab ab")));
		} catch(IllegalValueException e) {
			System.out.println(e);
		}
	}
	
}
