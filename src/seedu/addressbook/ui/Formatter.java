package seedu.addressbook.ui;

import static seedu.addressbook.common.Messages.MESSAGE_GOODBYE;
import static seedu.addressbook.common.Messages.MESSAGE_INIT_FAILED;
import static seedu.addressbook.common.Messages.MESSAGE_PROGRAM_LAUNCH_ARGS_USAGE;
import static seedu.addressbook.common.Messages.MESSAGE_USING_STORAGE_FILE;
import static seedu.addressbook.common.Messages.MESSAGE_WELCOME;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import seedu.addressbook.commands.CommandResult;
import seedu.addressbook.data.person.ReadOnlyPerson;

/**
 * Formatter for the application
 *
 */
public class Formatter {

    /** A decorative prefix added to the beginning of lines printed by AddressBook */
    private static final String LINE_PREFIX = "|| ";

    /** A platform independent line separator. */
    private static final String LS = System.lineSeparator();

    private static final String DIVIDER = "===================================================";

    /** Format of indexed list item */
    private static final String MESSAGE_INDEXED_LIST_ITEM = "\t%1$d. %2$s";


    /** Offset required to convert between 1-indexing and 0-indexing.  */
    public static final int DISPLAYED_INDEX_OFFSET = 1;

    /** Format of a comment input line. Comment lines are silently consumed when reading user input. */
    private static final String COMMENT_LINE_FORMAT_REGEX = "#.*";
    
    public Formatter() {
        
    }
    /**
     * Returns true if the user input line should be ignored.
     * Input should be ignored if it is parsed as a comment, is only whitespace, or is empty.
     *
     * @param rawInputLine full raw user input line.
     * @return true if the entire user input line should be ignored.
     */
    private boolean shouldIgnore(String rawInputLine) {
        return rawInputLine.trim().isEmpty() || isCommentLine(rawInputLine);
    }

    /**
     * Returns true if the user input line is a comment line.
     *
     * @param rawInputLine full raw user input line.
     * @return true if input line is a comment.
     */
    private boolean isCommentLine(String rawInputLine) {
        return rawInputLine.trim().matches(COMMENT_LINE_FORMAT_REGEX);
    }

    /**
     * Prompts for the command and reads the text entered by the user.
     * Ignores empty, pure whitespace, and comment lines.
     * Return the command back to TextUi.
     * 
     * @param in
     * @return command (full line) entered by the user
     */
    public String formatUserCommand(Scanner in) {    	
        String fullInputLine = in.nextLine();
        while (shouldIgnore(fullInputLine)) {
            fullInputLine = in.nextLine();
        }
        return fullInputLine;
    }

    /**
     * Format the storageFileInfo in WelcomeMessage
     * 
     * @param storageFilePath
     * @return formatted storageFileInfo
     */
    public String formatWelcomeMessage(String storageFilePath) {
        String storageFileInfo = String.format(MESSAGE_USING_STORAGE_FILE, storageFilePath);
        return storageFileInfo;
        
    }
    

    /**
     * Formats one message
     * 
     * @param message
     * @return formated message
     */
    public String formatShowToUser(String message) {
            String formatedMessage = LINE_PREFIX + message.replace("\n", LS + LINE_PREFIX);
            return formatedMessage;
    }
    
    /**
     * Formats the result of a command execution to the user. Includes additional formatting to demarcate different
     * command execution segments.
	 *	
     * @param result raw command results 
     * @return formatShowPersonListView
     */
    public String formatShowResultToUser(CommandResult result) {
        final Optional<List<? extends ReadOnlyPerson>> resultPersons = result.getRelevantPersons();
        if (resultPersons.isPresent()) {
        	return formatShowPersonListView(resultPersons.get());
        }else{
        	return null;
        }
        
    }
    
    /**
     * Formats a list of persons to the user, formatted as an indexed list.
     * Private contact details are hidden.
	 *
     * @param persons
     * @return showToUserAsIndexedList
     */
    private String formatShowPersonListView(List<? extends ReadOnlyPerson> persons) {
        final List<String> formattedPersons = new ArrayList<>();
        for (ReadOnlyPerson person : persons) {
            formattedPersons.add(person.getAsTextHidePrivate());
        }
        return showToUserAsIndexedList(formattedPersons);
    }

    /** formats a list of strings to the user, formatted as an indexed list. 
     * 
     * @param list
     * @return getIndexedListForViewing
     */
    private String showToUserAsIndexedList(List<String> list) {
        return getIndexedListForViewing(list);
    }

    /** Formats a list of strings as a viewable indexed list.
     *
     * @param listItems
     * @return IndexedListForViewing
     */
    private static String getIndexedListForViewing(List<String> listItems) {
        final StringBuilder formatted = new StringBuilder();
        int displayIndex = 0 + DISPLAYED_INDEX_OFFSET;
        for (String listItem : listItems) {
            formatted.append(getIndexedListItem(displayIndex, listItem)).append("\n");
            displayIndex++;
        }
        return formatted.toString();
    }

    /**
     * Formats a string as a viewable indexed list item.
     *
     * @param visibleIndex visible index for this listing
     * @return IndexedListItem
     */
    private static String getIndexedListItem(int visibleIndex, String listItem) {
        return String.format(MESSAGE_INDEXED_LIST_ITEM, visibleIndex, listItem);
    }
}
