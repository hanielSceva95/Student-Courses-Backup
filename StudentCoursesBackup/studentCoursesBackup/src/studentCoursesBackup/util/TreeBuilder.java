package studentCoursesBackup.util;

import java.util.Iterator;

import studentCoursesBackup.myTree.Node;
import studentCoursesBackup.util.MyLogger.DebugLevel;

public class TreeBuilder {
	private DebugLevel debugLevel;
	Node Node_orig;
	public Node left;
	public Node right;
	private Node root_orig,backup_Root_1,backup_Root_2;
	public TreeBuilder(){
		 MyLogger.setDebugValue(2);
		MyLogger.setDebugValue(debugLevel.TREEBUILDER);
		MyLogger.writeMessage("Debug level is in TREEBUILDER", debugLevel);
		Node_orig = null;
	}
	String output1 = "Output1";
	String output2 = "Output2";
	String output3 = "Output3";
	
	/**
	 * search_node is used to search for a particular node using the Bnumber by iterating left and right 
	 * @param Bnumber which is int and is used to compare as we iterate.
	 * @return Node or Null depending upon the results
	 */
	public Node search_Node(int Bnumber)
	{
		Node Temp_node = this.root_orig;
		while(Temp_node != null && Temp_node.BNumber != Bnumber)
		{
			if(Bnumber > Temp_node.BNumber)
			{
				Temp_node = Temp_node.right;
			}
		        else
			{
		        Temp_node = Temp_node.left;
			}
			
			if(Temp_node == null){
				return null;
			}
		
		}
      		return Temp_node;
	}
	
	/**
	 * insertData is a function which is called to insert nodes or create a new one if its the first time and parallely clone the backup nodes 
	 * @param Bnumber uses to search, if the node already exits if not create a new one using this
	 * @param course makes an arrayList and puts in the respective courses into it.
	 */
	public void insertData(int Bnumber, String course) {
		Node_orig = search_Node(Bnumber);
			if (Node_orig != null) {
				if(!Node_orig.courses.contains(course))
				{
					Node_orig.courses.add(course);
					Node_orig.backup_Node_1.courses.add(course);
					Node_orig.backup_Node_2.courses.add(course);
				}
		}	else {
			Node_orig = new Node();
			Node_orig.BNumber = Bnumber;
			Node_orig.courses.add(course);
			try {
				Node_orig.backup_Node_1 = (Node)Node_orig.clone();
				Node_orig.backup_Node_2 = (Node)Node_orig.clone();
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}	
			if(root_orig != null) {
				insertNode(root_orig, Node_orig);
				insertNode(backup_Root_1, Node_orig.backup_Node_1);
				insertNode(backup_Root_2, Node_orig.backup_Node_2);
			} else if (root_orig == null) {
				root_orig = Node_orig;
				backup_Root_1= Node_orig.backup_Node_1;
				backup_Root_2= Node_orig.backup_Node_2;
			}
		}	
		}
		
	/**
	 * insertNode is called when we need to insert a new node for the already existing nodes 
	 * @param root the previous root node for reference
	 * @param newNode is the new node which is to be added
	 * @return Node the new root node
	 */
	private Node insertNode(Node root, Node newNode){
		Node tempNode1;
		while(true) {
			tempNode1=root;
      	if (newNode.BNumber < root.BNumber){
      		root = root.left;
      		if(this.checkNull(root)) {
      			tempNode1.left = newNode;
      			return tempNode1;
      		}
        }
    	else {
    		root = root.right;
    		if(this.checkNull(root)) {
      			tempNode1.right = newNode;
      			return tempNode1;
      		}
        }
	}
	}
	
	/**
	 * to check if the node is empty or not
	 * @param node
	 * @return boolean value
	 */
	public boolean checkNull(Node node) {
		if(node == null)
		{
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * this function is used to delete the respective courses for a given Bnumber
	 * @param Bnumber is used for search reference
	 * @param course - which are to be deleted
	 */
	public void deleteData(int Bnumber, String course) {
		Node temp = search_Node(Bnumber);
		if(temp !=null && temp.BNumber == Bnumber) {
			int i = 0;
			if(temp.courses.contains(course)) {
				temp.courses.remove(i);
				i++;
			}
			i=0;
		temp.notifyAll(Bnumber,course);
		}
		root_orig = temp;
	}
	
	/**
	 * this function is used to print out the output data into the particular file 
	 * @param outputType
	 * @param result - instance to print out the results
	 */
	public void printNodes(String outputType , Results result)
	{
		if(outputType.equals(output1)) {
			this.printOutputFile(backup_Root_1,result);
		} else if(outputType.equalsIgnoreCase(output2)) {
			this.printOutputFile(backup_Root_1,result);
		}else if (outputType.equals(output3)) {
			this.printOutputFile(backup_Root_2,result);
		} 
	}
	
	public void printOutputFile(Node outputData,Results result ) {
		{
			if(outputData != null) {
				result.addNewData(outputData.BNumber+":"+outputData.courses);
				if(outputData.left != null)
				{
					printOutputFile(outputData.left,result);
					}
				if(outputData.right != null)
				{
					printOutputFile(outputData.right,result);
				}
			}
		}
	}
}
