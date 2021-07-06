/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Ethan Woollet
 */
package ucf.assignments;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListOptionsControllerTest {

	@Test
	void completeBoxChecked() {
		// create new list
		// create new item in list
		// click 'complete' check box
		// assert that 'complete' value is now true
		// click complete checkbox
		// assert that 'complete' value is now false
	}

	@Test
	void deleteButtonClicked() {
		// create new list
		// create new item in list
		// click delete button
		// click confirm delete button
		// assert that list item no longer exists
	}

	@Test
	void editButtonClicked() {
		// create new list
		// create new item in list
		// click edit button
		// fill out submission fields
		// click submit button
		// assert that the list contains an item with that data
	}

	@Test
	void newButtonClicked() {
		// create a new list
		// click new button
		// fill out submission fields
		// click submit button
		// assert that the list contains an item with that data
	}

	@Test
	void allButtonClicked() {
		// create a new list
		// create 2 new items within the list: 1 complete == true, and 1 complete == false
		// click 'all' button
		// assert that both items are being displayed in the tableview
	}

	@Test
	void completedButtonClicked() {
		// create a new list
		// create 2 new items within the list: 1 complete == true, and 1 complete == false
		// click 'all' button
		// assert that only the true item is being displayed in the tableview
	}

	@Test
	void incompleteButtonClicked() {
		// create a new list
		// create 2 new items within the list: 1 complete == true, and 1 complete == false
		// click 'all' button
		// assert that only the false item is being displayed in the tableview
	}
}