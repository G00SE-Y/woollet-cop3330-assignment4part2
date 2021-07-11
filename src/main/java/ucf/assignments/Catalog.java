/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Ethan Woollet
 */
package ucf.assignments;

import javafx.collections.ObservableList;

import java.util.LinkedList;

public class Catalog {
	private ObservableList<ToDoList> observableCatalog;
	private LinkedList<ToDoList> catalog;
	private int numberOfLists;

	public LinkedList<ToDoList>getCatalog() {
		return this.catalog;
	}

	public ObservableList<ToDoList> getObservableCatalog() {
		return observableCatalog;
	}

	public Catalog() {
		this.catalog = new LinkedList<>();
		updateSize();
	}

	public void setActiveCatalog(LinkedList<ToDoList> catalog) {
		this.catalog = catalog;
		updateSize();
	}

	private void updateSize() {
		this.numberOfLists = this.catalog.size();
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
