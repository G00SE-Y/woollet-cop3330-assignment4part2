/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Ethan Woollet
 */
package ucf.assignments;

import javafx.beans.property.SimpleStringProperty;

import java.util.LinkedList;

public class ToDoList {
	private SimpleStringProperty name;
	private SimpleStringProperty size;
	private LinkedList<ToDoItem> list = new LinkedList<>();

	public ToDoList(String name) {
		this.name = new SimpleStringProperty(name);
		this.size = new SimpleStringProperty("0");
	}

	public String getName() {
		return name.get();
	}

	public void setName(String name) {
		this.name = new SimpleStringProperty(name);
	}

	public String getSize() {
		return size.get();
	}

	public LinkedList<ToDoItem> getList() {
		return list;
	}

	public void addItem(ToDoItem item) {
		this.list.add(item);
		updateSize();
	}

	public void removeItem(ToDoItem item) {
		this.list.remove(item);
		updateSize();
	}

	public void editItem(ToDoItem oldItem, ToDoItem newItem) {
		this.list.remove(oldItem);
		this.list.add(newItem);
	}

	private void updateSize() {
		this.size = new SimpleStringProperty(""+this.list.size());
	}
}
