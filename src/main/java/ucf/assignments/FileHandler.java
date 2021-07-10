/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Ethan Woollet
 */
package ucf.assignments;

import java.io.*;

public class FileHandler {
	private static File getDirectory() {
		//get storage file directory
		return new File(System.getProperty ("user.dir"));
	}

	private static void createListDirectory() {
		new File(getDirectory() + "\\List_Data").mkdir();
	}

	public static BufferedReader getReader(String fileName) throws FileNotFoundException {
		//create new buffered reader from string file path

		new BufferedReader(new FileReader(getDirectory() + "\\List_Data\\" + fileName + ".txt"));
		return null;
	}

	public static FileWriter getFileWriter(String fileName) throws IOException {
		// create a new buffered writer from string file path
		return new FileWriter(getOutputFile(fileName));
	}

	public static File getOutputFile(String outputFileName) throws IOException {

		if(!new File(getDirectory() + "\\List_Data").exists()) {
			createListDirectory();
		}
		File outputFile = new File(getDirectory() + "\\List_Data\\" + outputFileName);
		if (!outputFile.exists()) {
			outputFile.createNewFile();
		}
		return outputFile;
	}
}
