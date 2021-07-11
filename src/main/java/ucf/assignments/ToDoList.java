/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Ethan Woollet
 */
package ucf.assignments;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.LinkedList;

public class ToDoList {
	private final SimpleStringProperty name;
	private final SimpleStringProperty size;
	private final LinkedList<ToDoItem> list;

	public ToDoList(String name) {
		this.name = new SimpleStringProperty();
		this.size = new SimpleStringProperty();

		this.name.set(name);
		this.list = new LinkedList<>();
		this.size.set("0");
	}

	public SimpleStringProperty nameProperty() {
		return name;
	}

	public SimpleStringProperty sizeProperty() {
		return size;
	}

	public String getName() {
		return name.get();
	}

	public void setName(String name) {
		this.name.set(name);
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
		this.size.set(String.valueOf(this.list.size()));
	}

	public void addAllItems(LinkedList<ToDoItem> list) {
		this.list.addAll(list);
	}
}
