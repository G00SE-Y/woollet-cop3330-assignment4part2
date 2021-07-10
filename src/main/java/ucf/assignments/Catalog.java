/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Ethan Woollet
 */
package ucf.assignments;

import java.util.LinkedList;

public class Catalog {
	LinkedList<String> allListNames;
	private LinkedList<ToDoList> catalog;
	private int numberOfLists;

	public LinkedList<ToDoList>getCatalog() {
		return this.catalog;
	}

	public Catalog() {
		this.catalog = new LinkedList<>();
		this.numberOfLists = 0;
	}

	private void updateSize() {
		this.numberOfLists = catalog.size();
	}

	public void addList(ToDoList newList) {
		catalog.add(newList);
		updateSize();
	}

	public void deleteList(ToDoList newList) {
		catalog.remove(newList);
		updateSize();
	}

	public void editList(String oldName, String newName) {
		for(ToDoList list : this.catalog) {
			if(list.getName().contentEquals(oldName))
				list.setName(newName);
		}
	}
}
