/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Ethan Woollet
 */
package ucf.assignments;

import javafx.beans.property.*;

import java.time.LocalDate;


public class ToDoItem {
	private final SimpleStringProperty name;
	private final SimpleStringProperty description;
	private final SimpleObjectProperty<LocalDate> date;
	private final SimpleBooleanProperty complete;

	public String getName() {
		return name.get();
	}

	public void setName(String name) {
		this.name.set(name);
	}

	public SimpleStringProperty nameProperty() {
		return name;
	}

	public String getDescription() {
		return description.get();
	}

	public void setDescription(String description) {
		this.description.set(description);
	}

	public LocalDate getDate() {
		return date.get();
	}

	public void setDate(LocalDate date) {
		this.date.set(date);
	}

	public boolean isComplete() {
		return complete.get();
	}

	public void swapComplete() {
		this.complete.set(!this.complete.get());
	}

	public SimpleBooleanProperty completeProperty() {
		return complete;
	}

	public ToDoItem(String name, String description, LocalDate date) {
		this.name = new SimpleStringProperty();
		this.description = new SimpleStringProperty();
		this.date = new SimpleObjectProperty<>();
		this.complete = new SimpleBooleanProperty();

		this.name.set(name);
		this.description.set(description);
		this.date.set(date);
		this.complete.set(false);
	}

	public void setComplete(boolean complete) {
		this.complete.set(complete);
	}
}
