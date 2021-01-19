package studentCoursesBackup.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import studentCoursesBackup.util.MyLogger.DebugLevel;

public class Results implements FileDisplayInterface, StdoutDisplayInterface {
	ArrayList<String>result;
	private DebugLevel debugLevel;
	/**
	 * initiates the ArrayList to collect the Strings which are to be printed
	 */
	public Results() {
		 MyLogger.setDebugValue(4);
		MyLogger.setDebugValue(debugLevel.IN_RESULTS);
		MyLogger.writeMessage("Debug level is in RESULTS", debugLevel);
		 result = new ArrayList<String>();
	}
	
	/**
	 * adds the output to the arrayList
	 * @param s
	 */
	public void addNewData(String s)
	{
		System.out.println(s);
		result.add(s);
	}
	
	/**
	 * this function is used to print the arrayList to the file using File and butterWriter
	 * @param outoutFileName 
	 */
	public void printOutputToFile(String outoutFileName) {
		 MyLogger.setDebugValue(5);
		MyLogger.setDebugValue(debugLevel.FROM_RESULTS);
		MyLogger.writeMessage("Debug level is in FROM_RESULTS", debugLevel);		
		try {
    		File file = new File(outoutFileName);
    		file.delete();
    		if (!file.exists()) {
    		     file.createNewFile();
    		  }
    		FileWriter writer = new FileWriter(file,true);
    		BufferedWriter bufferedWriter = new BufferedWriter(writer);
    		Iterator outputData = result.iterator();
    		while(outputData.hasNext()) {
    			bufferedWriter.write((String) outputData.next());
				bufferedWriter.newLine();
    		}		
    		bufferedWriter.close();
 		   }
    	catch (IOException e) {
    		System.out.println(e);
    	}
	}

}
