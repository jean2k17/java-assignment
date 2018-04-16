package com.assignment.work;

import java.io.File;

public class FileRead 
{
	//attributes
	String filename;
	File fleExample;
	
	//constructor to take in file 
	public FileRead (String filename)
	{
		this.filename = filename;
	}
	
	//open file
	public void openFile()
	{
		fleExample = new File(filename);
	}

}
