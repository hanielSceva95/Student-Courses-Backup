package studentCoursesBackup.myTree;

public interface ObserverI {
	/**
	* update method used to update the respective index in the course list of observer nodes.
	* @param nameIndex
	*/
	public void update(int Bnumber,String course, Node backupNode);

}
