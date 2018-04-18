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
	private JButton search;
	private JButton browse;
	private JButton timesFound;
	private JButton browse2;
	private JButton compare;
	private JTextField word;
	private JTextField chosenF;
	private JFileChooser fileC;
	int returnVal;
	private File file;
	private BufferedReader br;
	ArrayList<String> view = new ArrayList<String>(); 
	ArrayList<String> view2 = new ArrayList<String>(); 

	
	//JFileChooser file = new JFileChooser();
	public GUI(String title)
	{
		super(title);
		setSize(500,500);
		setLayout(new FlowLayout());
		
		word=new JTextField("Enter something to search for here");
		add(word);
		word.addActionListener(this);
		
		chosenF=new JTextField("");
		add(chosenF);
		chosenF.addActionListener(this);
		
		search= new JButton("Search");
		add(search);
		search.addActionListener(this);
		
		browse= new JButton("browse");
		add(browse);
		browse.addActionListener(this);
		
		browse2= new JButton("another file");
		add(browse2);
		browse2.addActionListener(this);
		
		compare= new JButton("compare files");
		add(compare);
		compare.addActionListener(this);
		
		timesFound= new JButton("times found");
		add(timesFound);
		timesFound.addActionListener(this);
		
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
		fileC = new JFileChooser();
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
						String[] ar=currentLine.split(".");
						view.add(currentLine);
	
					}//end while loop
				}//end try
				catch(Exception error)
				{
					error.printStackTrace();
				}//end catch
			}//end if
		}//end if
		if (event.getSource() == search)
		{
			System.out.println(view);
			if(view.contains(text1)) 
			{
				//System.out.println("word found");
				JOptionPane.showMessageDialog(this, "word was found");
			}//end if 
			else
			{
				JOptionPane.showMessageDialog(this, "not found");
			}//end else

		}//end if
		
		if(event.getSource() == browse2)
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
						if(currentLine==".")
						{
							currentLine = currentLine.replace(".", "");
						//String[] ar=currentLine.split(",");
							view2.add(currentLine);
						}
					}//end  while
				}//end try
				catch(Exception error)
				{
					error.printStackTrace();
				}//end catch
			}//end if 
		}//end if
		if(event.getSource() == compare)
		{
			if(view.contains(text1) && view2.contains(text1)) 
			{
				JOptionPane.showMessageDialog(this, "both files have the word");
			}//end if
			else
			{
				JOptionPane.showMessageDialog(this, "no match");
			}//end else
		}//end if
		if(event.getSource()==timesFound)
		{
			int num = 0;
			
			for (int i = 0; i < view.size(); i++) 
			{
				if(word.getText()==view.get(i)) 
				{
					num++;
				}
			}
			JOptionPane.showMessageDialog(this, "times found: " + num);
		}
	}//end actionperformed
}//end gui
