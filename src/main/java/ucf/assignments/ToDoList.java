/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Ethan Woollet
 */
package ucf.assignments;

import java.util.LinkedList;

public class ToDoList {
	private String name;
	private String size;
	private LinkedList<ToDoItem> list;

	public ToDoList(String name) {
		this.name = name;
		this.list = new LinkedList<>();
		this.size = "0";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSize() {
		return size;
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
		this.size = String.valueOf(this.list.size());
	}
}
