package seedu.addressbook.data;

import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.tag.Tag;

/**
 * @author user
 * This class represent each tagging relation for every person and his tags.
 */
public class Tagging {
	
	private Person person;
	private Tag tag;
	private boolean isAdd; 
	public Tagging(){
		
	}
	/**
	 * construct a Tagging class when adding a tag to a person
	 * @param person
	 * @param tag
	 * @param isAdd
	 */
	public Tagging(Person person, Tag tag, boolean isAdd){
		this.person = person;
		this.tag = tag;
		this.isAdd = isAdd;
	}
	
	/**
	 * delete the tag of a person
	 * (call this function after the deletion of certain tag of person is done)
	 */
	public void deleteTag(){
		this.isAdd = false;
	}
	
	/* 
	 * format the tagging relation
	 */
	@Override 
	public String toString(){
		String returnStr="";
		returnStr += isAdd ? "+" : "-";
		returnStr += " [" + person.getName() + "]" + tag.tagName;
		return returnStr;
	}
}
