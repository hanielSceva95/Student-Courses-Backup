# Student-Courses-Backup
-----------------------------------------------------------------------
-----------------------------------------------------------------------
Following are the commands and the instructions to run ANT on your project.
#### Note: build.xml is present in studentCoursesBackup/src folder.

-----------------------------------------------------------------------
## Instruction to clean:

####Command: 
ant -buildfile studentCoursesBackup/src/build.xml clean

Description: It cleans up all the .class files that were generated when you
compiled your code.

-----------------------------------------------------------------------
## Instruction to compile:

####Command: ant -buildfile studentCoursesBackup/src/build.xml all

Description: Compiles your code and generates .class files inside the BUILD folder.

-----------------------------------------------------------------------
## Instruction to run:

####Command: 
ant -buildfile studentCoursesBackup/src/build.xml run -Darg0=<inputFile.txt> -Darg1=<deleteFile.txt> -Darg2=<output1.txt> -Darg3=<output2.txt> -Darg4=<output3.txt> 


-----------------------------------------------------------------------
## Description:
This project takes in the data related to students and their courses from an input and deletes the respective 
courses mentioned in delete file for that particualr student using the nodes concept and gives out 3 outputs
one, which is calculated and other 2 as a backup.
