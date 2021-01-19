package studentCoursesBackup.myTree;

import java.util.ArrayList;

import studentCoursesBackup.util.MyLogger;
import studentCoursesBackup.util.TreeBuilder;
import studentCoursesBackup.util.MyLogger.DebugLevel;

public class Node implements SubjectI, ObserverI, Cloneable {
	public int BNumber;
	private DebugLevel debugLevel;
	public ArrayList<String> courses= new ArrayList<String>();

	public Node left;
	public Node right;
	public Node backup_Node_1;
	public Node backup_Node_2;
	private ArrayList<Node> nodes;
	public Node() {
		
	}
	
	public Node(int keyIn, String course){
		 MyLogger.setDebugValue(3);
		MyLogger.setDebugValue(debugLevel.NODE);
		MyLogger.writeMessage("Debug level is in NODE", debugLevel);
		this.BNumber = keyIn;
		this.courses.add(course);
		this.left = new Node();
		this.right = new Node();
		nodes = new ArrayList<Node>();
	}

	@SuppressWarnings("unchecked")
	public Node clone() throws CloneNotSupportedException{
//		MyLogger.writeMessage("in Node class clone method", debugLevel);
		Node cloneTemp =  new Node();
		try {
			cloneTemp = (Node)super.clone();
			cloneTemp.courses = (ArrayList<String>)courses.clone();
		}
		catch(CloneNotSupportedException e) {
			System.err.println("Exception: Not able to clone super class");
			System.err.println(e);
			System.exit(0);
		}
		return cloneTemp;
	}
	
	@Override
	public void update(int Bnumber, String course,Node backupNode)
	{	TreeBuilder tb = new TreeBuilder();
		Node temp = tb.search_Node(Bnumber);
		if(temp==null) {
		temp = backupNode;
		}
		if(temp.BNumber == Bnumber) {
			int i = 0;
			if(temp.courses.contains(course)) {
				temp.courses.remove(i);
				i++;
			}
			i=0;
//			if(temp.courses.size()==0) {
//				temp = temp.getRightChild();
//			}
		}
		
	}
	@Override
	public void notifyAll(int Bnumber, String course) {
		backup_Node_1.update(Bnumber,course,backup_Node_1);
		backup_Node_2.update(Bnumber,course,backup_Node_2);
		
	}
}
