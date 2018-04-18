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
		
		Search= new JButton("Search");
		add(Search);
		Search.addActionListener(this);
		
		browse= new JButton("browse");
		add(browse);
		browse.addActionListener(this);
		
		browse2= new JButton("another file");
		add(browse2);
		browse2.addActionListener(this);
		
		compare= new JButton("compare files");
		add(compare);
		compare.addActionListener(this);
		
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
					if (event.getSource() == Search)
					{
						
					}
						br = new BufferedReader(new FileReader(file));
					
					
						String currentLine;
						while ((currentLine = br.readLine()) !=null)
						{
							view.add(currentLine);
							if(currentLine.contains(text1))
							{
								System.out.println("word found");
							}
	
						//System.out.println(currentLine);
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
			if(view.contains(text1)) 
			{
				JOptionPane.showMessageDialog(this, "word was found");
				//System.out.println("word was found");
				/*for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i));
				}*/
			}

		}//end if
		if(event.getSource() == browse2)
		{
			returnVal = fileC.showOpenDialog(null);
			if (returnVal == JFileChooser.APPROVE_OPTION)
			{
				file = fileC.getSelectedFile();
				try
				{
					if (event.getSource() == Search)
					{
						
					}
						br = new BufferedReader(new FileReader(file));
					
					
						String currentLine;
						while ((currentLine = br.readLine()) !=null)
						{
							view2.add(currentLine);
							if(currentLine.contains(text1))
							{
								System.out.println("word found");
							}
	
						//System.out.println(currentLine);
					}
				}
				catch(Exception error)
				{
					error.printStackTrace();
				}
			}
			
		}//end if
		if(event.getSource() == compare)
		{
			for (int i = 0; i < view.size(); i++)
			{
				for (int x = 0; x < view2.size(); x++)
				{
					if(view.contains(text1) && view2.contains(text1)) 
					{
						JOptionPane.showMessageDialog(this, "both files have the word");
					//System.out.println("word was found");
					/*for (int i = 0; i < list.size(); i++) {
					System.out.println(list.get(i));
					}*/
					}
					else
					{
						JOptionPane.showMessageDialog(this, "no match");
					}
				}
			}
		}//end if
	}

}
