/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Ethan Woollet
 */
package ucf.assignments;

import java.util.LinkedList;

public class Catalog {
	private LinkedList<ToDoList> catalog;

	public LinkedList<ToDoList>getCatalog() {
		return this.catalog;
	}

	public Catalog() {
		this.catalog = new LinkedList<>();
	}

	public void addList(ToDoList newList) {
		catalog.add(newList);
	}

	public void deleteList(ToDoList newList) {
		catalog.remove(newList);
	}

	public void addAllLists(LinkedList<ToDoList> catalog) {
		this.catalog.addAll(catalog);
	}
}
