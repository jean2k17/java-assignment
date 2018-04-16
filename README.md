# java-assignment

package com.assignment.work;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.plaf.FileChooserUI;
import javax.swing.JPanel;
import javax.swing.text.JTextComponent;
import javax.swing.JFileChooser;

public class GUI extends JFrame implements ActionListener, MouseListener
{
	private JButton Search;
	private JButton browse;
	private JTextField word;
	private JFileChooser fileC;
	int returnVal;
	private File file;
	private BufferedReader br;
	
	//JFileChooser file = new JFileChooser();
	public GUI(String title)
	{
		super(title);
		setSize(500,500);
		setLayout(new FlowLayout());
		
		word=new JTextField("Enter something to search for here");
		add(word);
		word.addActionListener(this);
		
		Search= new JButton("Search");
		add(Search);
		Search.addActionListener(this);
		
		browse= new JButton("browse");
		add(browse);
		browse.addActionListener(this);
		
		fileC = new JFileChooser();
		
		setVisible(true);
	
	}
	public void mouseClicked(MouseEvent arg0) 
	{

	}
	public void mouseEntered(MouseEvent arg0) 
	{
	}
	public void mouseExited(MouseEvent arg0)
	{
	}
	public void mousePressed(MouseEvent arg0) 
	{
	}
	public void mouseReleased(MouseEvent arg0) 
	{		
	}

	public void actionPerformed(ActionEvent event) 
	{
		String text1 = word.getText();

		if (event.getSource()==browse)
		{
			returnVal = fileC.showOpenDialog(null);
			if (returnVal == JFileChooser.APPROVE_OPTION)
			{
				file = fileC.getSelectedFile();
				try
				{
					br = new BufferedReader(new FileReader(file));
					
					
					String currentLine;
					while ((currentLine = br.readLine()) !=null)
					{
						if(currentLine == text1)
						{
							System.out.println("word found");
						}
						System.out.println(currentLine);
					}
				}
				catch(Exception error)
				{
					error.printStackTrace();
				}
			}
		}
		if (event.getSource() == Search)
		{
			if(text1.isEmpty() || !text1.contains(" "))
			{
			JOptionPane.showMessageDialog(this, "Error - you need to Enter a word to search for.");
			}
			/*
			else if (fileC.currentLine==word.)
			{
			
			}*/
		}
	}

}

package com.assignment.work;
import java.util.ArrayList;
public class Control {

	public static void main(String[] args) 
	{
		GUI myScreen = new GUI ("Screen");

	}

}
