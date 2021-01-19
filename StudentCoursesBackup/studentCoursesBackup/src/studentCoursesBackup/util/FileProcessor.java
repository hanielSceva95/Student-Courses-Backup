package studentCoursesBackup.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import studentCoursesBackup.util.MyLogger.DebugLevel;

public class FileProcessor {
	String inputFile;
	private DebugLevel debugLevel;
	public ArrayList<String> inputData= new ArrayList<String>();
	/**
	 * FileProcessor takes in the file name and stores it in local variable as soon as an instance is created.
	 * @param input is the name of the file, which is a string
	 */
	 public FileProcessor(String input) {
		 MyLogger.setDebugValue(1);
		 MyLogger.setDebugValue(debugLevel.FILE_PROCESSOR);
		MyLogger.writeMessage("Debug level is in fileprocessor", debugLevel);
		 this.inputFile = input;
	 }
	 /**
	  * readLine is a method which gets the input or delete file name and iterates through those files and returns and arrayList containing the data
	  * @return inputData which is ArrayList<String>
	  */
	 public ArrayList<String> readLine() {
		 String line = null;
		 try {
				File file = new File(this.inputFile) ;
				FileReader fileRead = new FileReader(file);
				BufferedReader inputfile = new BufferedReader(fileRead);
				while ((line = inputfile.readLine()) != null) {	
					inputData.add(line);
				}
				inputfile.close();
		 } catch(IOException e){
			 e.printStackTrace();
		 } 
			return inputData;
	 }
}
