
package studentCoursesBackup.driver;

import java.util.ArrayList;
import java.util.Iterator;

import studentCoursesBackup.util.FileProcessor;
import studentCoursesBackup.util.Results;
import studentCoursesBackup.util.TreeBuilder;

/**
 * @author Haniel Sceva
 *
 */
    
    public class Driver {
	
	public static void main(String[] args) {
	    
	    /*
	     * As the build.xml specifies the arguments as argX, in case the
	     * argument value is not given java takes the default value specified in
	     * build.xml. To avoid that, below condition is used
	     */

	    if ( (args.length != 5) || args[0].equals("${arg0}") || args[1].equals("${arg1}") || args[2].equals("${arg2}|| args[3].equals(\"${arg3}|| args[4].equals(\"${arg4}")) {
		    
		    System.err.println("Error: Incorrect number of arguments. Program accepts 6 argumnets.");
		    System.exit(0);
	    } 
	    ArrayList<String> inputData= new ArrayList<String>();
	    ArrayList<String> deleteData= new ArrayList<String>();
	    FileProcessor Fp = new FileProcessor(args[0]);
	    TreeBuilder treeBuilder = new TreeBuilder();
		FileProcessor Fp2 = new FileProcessor(args[1]);
		inputData = Fp.readLine();
		Iterator i = inputData.iterator();
		while(i.hasNext()) {
			String temp1 = (String) i.next();
			String[] temp = temp1.split(":");
			if(temp[0].length() != 4) {
				System.err.println("Error: Incorrect length of Bnumber.");
				System.exit(0);
			} else if (temp[1].length() !=1 && (65>(int)temp[1].charAt(0)||75<(int)temp[1].charAt(0))) {
				System.err.println("Error: Incorrect course.");
				System.exit(0);
			} else {
			treeBuilder.insertData(Integer.parseInt(temp[0]),temp[1]);
			}
		}
		deleteData = Fp2.readLine();
		Iterator j = deleteData.iterator();
		while(j.hasNext()) {
			String temp1 = (String) j.next();
			String[] temp = temp1.split(":");
			if(temp[0].length() != 4) {
				System.err.println("Error: Incorrect length of Bnumber.");
				System.exit(0);
			} else if (temp[1].length() !=1 && (65>(int)temp[1].charAt(0)||75<(int)temp[1].charAt(0))) {
				System.err.println("Error: Incorrect course.");
				System.exit(0);
			} else {
			treeBuilder.deleteData(Integer.parseInt(temp[0]),temp[1]);
			}
		}
		System.out.println("output");
		Results Output1 = new Results();
		treeBuilder.printNodes("Output1",Output1);
		Output1.printOutputToFile(args[2]);
		Results Output2 = new Results();
		treeBuilder.printNodes("Output2",Output2);
		Output1.printOutputToFile(args[3]);
		Results Output3 = new Results();
		treeBuilder.printNodes("Output3",Output2);
		Output1.printOutputToFile(args[4]);
	}  
    }  
