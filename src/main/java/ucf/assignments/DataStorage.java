/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Ethan Woollet
 */
package ucf.assignments;

import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

public class DataStorage {
	private File storageFolder;

	DataStorage() {
		this.storageFolder = new File(FileHandler.getDirectory()+ "/List_Data");
	}



	public static Catalog loadLists(String listName) {
		// use list name array to read list files from folder
		// use json parsing to read the item data and add to list
		// continue until all lists in array is created-
		return null;
	}

	public static void saveToMemory(Catalog catalog) {
		// go through each list in the catalog and parse the item data into a single large string
		// create a filewriter for each list
		// create new file or overwrite old file with name of list '.txt'
		// read all file names in the folder that isnt the catalog file
		// create a new string with all of the filenames as list names
		// print list name string to catalog file


	}

	public static void saveToMemory(ToDoList list) {
		// parse the item data into a single large string
		// create a filewriter for list
		// create new file or overwrite old file with name of list '.txt'
		// read all file names in the folder that isnt the catalog file
		// create a new string with all of the filenames as list names
		// print list name string to catalog file


	}

	public static void deleteList(ToDoList list) {
		// delete list file
		// delete list from catalog file

		File listFile = new File(FileHandler.getDirectory() + "/List_Data/catalog.json");
		listFile.delete();




	}

	private static void delete () {


	}
}
