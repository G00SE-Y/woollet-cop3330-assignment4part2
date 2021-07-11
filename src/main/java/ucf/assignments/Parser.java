package ucf.assignments;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.LinkedList;

public class Parser {
	private static final JSONParser parse = new JSONParser();

	public static LinkedList<ToDoItem> loadList(String listName) throws IOException, ParseException {
		return jsonReadList(FileHandler.getReader(listName+".json"));
	}

	public static LinkedList<ToDoList> loadCatalog() throws IOException {
		try{
			return jsonReadCatalog(FileHandler.getReader("catalog.json"));
		} catch (IOException | ParseException e) {
			new File(FileHandler.getDirectory()+"/List_Data/catalog.json").createNewFile();
		}
		return new LinkedList<>();
	}

	private static LinkedList<ToDoItem> jsonReadList(BufferedReader in) throws IOException, ParseException {

		JSONArray jsonArray = (JSONArray) parse.parse(in);

		LinkedList<ToDoItem> list = new LinkedList<>();

		for (Object item : jsonArray) {
			JSONObject jsonObj = (JSONObject) item;

			String name = (String) jsonObj.get("name");
			String description = (String) jsonObj.get("description");
			LocalDate date = parseDate((String) jsonObj.get("date"));

			list.add(new ToDoItem(name, description, date));

		}
		in.close();
		return list;
	}

	private static LinkedList<ToDoList> jsonReadCatalog(BufferedReader in) throws IOException, ParseException {

		JSONArray jsonArray = (JSONArray) parse.parse(in);

		LinkedList<ToDoList> catalog = new LinkedList<>();

		for (Object list : jsonArray) {
			JSONObject jsonObj = (JSONObject) list;

			String name = (String) jsonObj.get("name");

			catalog.add(new ToDoList(name));

		}
		in.close();
		return catalog;
	}

	public static LocalDate parseDate(String stringDate) {
		return LocalDate.parse(stringDate);
	}

	public static void parseToListFile(ToDoList list) throws IOException {

		JSONArray array = new JSONArray();

		for (ToDoItem item : list.getList()) {
			JSONObject object = new JSONObject();
			object.put("name", item.getName());
			object.put("description", item.getDescription());
			object.put("date", String.valueOf(item.getDate()));
			array.add(object);
		}
		FileHandler.writeToFile(array.toJSONString(), list.getName() + ".json");
	}

	public static void parseToCatalogFile(Catalog catalog ) throws IOException {
		JSONArray array = new JSONArray();

		for(ToDoList list : catalog.getCatalog()){
			JSONObject object = new JSONObject();
			object.put("name" , list.getName());
			object.put("description" , list.getSize());
			array.add(object);
		}

		FileHandler.writeToFile(array.toJSONString(),"catalog.json");
	}
}
