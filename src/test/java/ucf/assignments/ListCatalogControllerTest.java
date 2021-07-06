/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Ethan Woollet
 */
package ucf.assignments;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListCatalogControllerTest {

	@Test
	void testRenameButtonClicked() {
		// create a new list
		// select list
		// click edit list button
		// fill prompt field with new list name
		// click submit button
		// assert that the list's name is the new name
	}

	@Test
	void testNewButtonClicked() {
		// click button
		// fill out text field for name
		// click submit button
		// assert that a new list exists with that name and 0 items
	}

	@Test
	void testDeleteButtonClicked() {
		// create new list
		// select list
		// click delete button
		// click confirm delete button
		// assert that no list with the original name exists
	}

	@Test
	void testSaveListButtonClicked() {
		// create list
		// add example items to list
		// select list
		// click save list
		// assert that 'listname.txt' file exists
		// assert that the contents of the text file are a csv string of the list data
		// assert that the catalog.txt has the list name in it
	}

	@Test
	void testSaveAllListsButtonClicked() {
		// create 2 lists
		// add example items to lists
		// click save all lists
		// assert that 'listname.txt' file exists for both lists
		// assert that the contents of the text files are a csv string of the list data
		// assert that the catalog.txt has the list names in it
	}
}