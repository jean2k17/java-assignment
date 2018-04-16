package com.assignment.work;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileRead 
{
	//attributes
	String filename;
	File file;
	
	//constructor to take in file 
	public FileRead (String filename)
	{
		this.filename = filename;
	}
	
	//open file
	public void openFile()
	{
		file = new File(filename);
	}
	
	public String readLine()
	{		
			String line = "no line in file";
		    try
			{
			 Scanner myScanner = new Scanner(file);
			 
			  
			 if (myScanner.hasNextLine())
			    {
			      line = myScanner.nextLine();
			      System.out.println ("I read this line " + line);
			    }

			myScanner.close();
			}
			catch (FileNotFoundException e)
			{
				System.out.println(e.getMessage());
			}

		    return line;
			  
			  
	} 
}
