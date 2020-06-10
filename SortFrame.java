import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.basic.BasicScrollBarUI;

//frame taxinomisis ton ipopsifion enos job offer kai dinatotita gia prosthiki tous stin shortlist kathe job offer 
public class SortFrame extends JFrame {

	private JPanel mainPanel;
	private JPanel headerPanel;
	private JPanel middlePanel;
	private JPanel panel3;
	private JPanel bottomPanel;
	private JLabel sortingCriteria;
	private DefaultListModel<String> skillsModel;
	private DefaultListModel<String> skillsSortedModel;
	private DefaultListModel<String> candModel;
	private JList<String> skillsList;
	private JList<String> skillsSortedList;
	private JList<String> candList;
	private JLabel rateListLabel;
	private ArrayList<Candidate> candidates;
	private JButton show = new JButton("Show List");
	private JButton menu = new JButton("Back to Menu");
	private JButton shortlistButton=new JButton("Add Candidate to Shortlist");
	private int sortNumber;
	private JobOffer aJobOffer;
	private ImageIcon icon;
	private Company company;
	
	public SortFrame (Company aComp, JobOffer offer)
	{
		company = aComp;
		aJobOffer=offer;
		candidates = offer.getEnrolledCandidates();
		mainPanel=new JPanel();
		mainPanel.setBackground(Color.white);
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
		headerPanel = new JPanel();
		headerPanel.setBackground(Color.white);
		
		
		
		middlePanel=new JPanel();
		middlePanel.setLayout(new FlowLayout());
		middlePanel.setBackground(Color.white);
		panel3= new JPanel();
		panel3.setLayout(new FlowLayout());
		panel3.setBackground(Color.white);
		bottomPanel=new JPanel();
		bottomPanel.setBackground(Color.white);
		rateListLabel = new JLabel(" ->Choose the sorting method"); 
		rateListLabel.setFont(new Font("Courier",Font.BOLD,20));
		skillsList = new JList<String>();
		skillsList.setBackground(Color.black);
		skillsList.setForeground(Color.white);		
		skillsModel = new DefaultListModel();
		candModel = new DefaultListModel();
		candList = new JList<String>();
		candList.setBackground(Color.black);
		candList.setForeground(Color.white);
		candList.setPreferredSize(new Dimension(150,300));
		skillsSortedModel = new DefaultListModel();
		shortlistButton.setBackground(Color.black);
		shortlistButton.setForeground(Color.white);
		show.setBackground(Color.black);
		show.setForeground(Color.white);
		menu.setBackground(Color.black);
		menu.setForeground(Color.white);		
		
		skillsModel.addElement("SortbyAge");
		skillsModel.addElement("SortbyDegreeGrade");
		skillsModel.addElement("SortbyEducationalLevel");
		skillsModel.addElement("SortbyWorkExperience");
		
		skillsList.setModel(skillsModel); 
		
		for(Candidate cand: candidates)
			candModel.addElement(cand.getFullName());
		
		candList.setModel(candModel); 
		
		candList.setVisible(true);		
		
		headerPanel.add(rateListLabel);

		JScrollPane scrollPane = new JScrollPane(candList);
		UIManager.put("ScrollBar.thumb", new ColorUIResource(Color.white));             
	    scrollPane.getVerticalScrollBar().setUI(new BasicScrollBarUI() );

	
		middlePanel.add(skillsList);
		middlePanel.add(scrollPane);
		
		panel3.add(show);	
		panel3.add(shortlistButton);
		
		bottomPanel.add(menu);
		mainPanel.add(headerPanel);
		mainPanel.add(middlePanel);
		mainPanel.add(panel3);
		mainPanel.add(bottomPanel);
		
		this.setContentPane(mainPanel);
		

		icon = new ImageIcon ("icon.png") ;
		this.setIconImage(icon.getImage());

		candList.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				String selected = "";
				Candidate selectedCandidate = null ;
				if(e.getClickCount() == 1) {
					selected = (String) candList.getSelectedValue();
					for(Candidate aCand: aJobOffer.getEnrolledCandidates()) {
						if(aCand.getFullName().equals(selected)) {
							selectedCandidate=aCand;
							break;
						}
					}
					JOptionPane.showMessageDialog(null, "->Selected Candidate's Skills: \n" +selectedCandidate.getDegreeGrade() +"\n ->Programming Languages: " +selectedCandidate.getProgrammingLanguages() +"\n ->Foreign Languages: " +selectedCandidate.getForeignLanguages()+"\n ->Educational Level: " +selectedCandidate.getEducationLevel()+"\n ->Software Knowledge: " +selectedCandidate.getSoftwareKnowledge()+"\n ->Working Experience: " +selectedCandidate.getWorkExperience()+ "  years"+"\n ->Grade of Degree: "+ selectedCandidate.getDegreeGrade());
				}
				
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		ButtonListener listener = new ButtonListener();
		show.addActionListener(listener);
		menu.addActionListener(listener);
		shortlistButton.addActionListener(listener);
		
		this.setTitle("Sort Candidates");
		this.setSize(400, 500);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
	}
	
	class ButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
				
		if(e.getSource().equals(show)) {		
			String selectedSkillsName = (String) skillsList.getSelectedValue();
			if(selectedSkillsName == null)
				JOptionPane.showMessageDialog(null,"You have to select a Criterion first!");
			else {
				candList.removeAll();
				candModel.removeAllElements();
			
				if(selectedSkillsName.equals("SortbyAge")) {
					sortNumber = 0;
					aJobOffer.sortCandidates(sortNumber);	
					for(Candidate cand: candidates)
						candModel.addElement(cand.getFullName());
				}
				if (selectedSkillsName.equals("SortbyDegreeGrade")) {		
					sortNumber = 1;
					aJobOffer.sortCandidates(sortNumber);	
					Collections.reverse(candidates);
					for(Candidate cand: candidates)
						candModel.addElement(cand.getFullName());
				}	
				if (selectedSkillsName.equals("SortbyEducationalLevel")) {					
					sortNumber = 2;
					aJobOffer.sortCandidates(sortNumber);	
					Collections.reverse(candidates);
					for(Candidate cand: candidates)
						candModel.addElement(cand.getFullName());
				}				
				if(selectedSkillsName.equals("SortbyWorkExperience")) {					
					sortNumber = 3;
					aJobOffer.sortCandidates(sortNumber);	
					Collections.reverse(candidates);
					for(Candidate cand: candidates)
						candModel.addElement(cand.getFullName());
				}
				candList.setModel(candModel);
				candList.setVisible(true);
			}
	    }
	    else if(e.getSource().equals(menu)) {
	        dispose();
	        new MainMenuFrame(company);		
	    }
	    else if(e.getSource().equals(shortlistButton)) {
	        String selected = "";
	        Candidate selectedCandidate = null ;
				 
		    selected = (String) candList.getSelectedValue();
		    for(Candidate aCand: aJobOffer.getEnrolledCandidates()) 
			{
		    	if(aCand.getFullName().equals(selected)) {
					selectedCandidate=aCand;
					break;
				}
			}
		    if(selectedCandidate!=null)
		    {
		    	if(aJobOffer.getShortList().contains(selectedCandidate)) 
		    		JOptionPane.showMessageDialog(null, selectedCandidate.getFullName()+" is already in your shortlist");
		    	else {
		    		aJobOffer.addToShortlist(selectedCandidate);
		    		JOptionPane.showMessageDialog(null,"Selected Candidate has been succesfully added to your shortlist!");
		    		
		    		//data entry
		    		try {
		    			FileOutputStream fouts = new FileOutputStream(Main.f);
		    			ObjectOutputStream douts = new ObjectOutputStream(fouts);
		    			douts.writeObject(Main.data);
		    			fouts.close();
		    			douts.close();
		    		} catch (FileNotFoundException e1) {
		    			e1.printStackTrace();
		    		}catch (IOException e1) {
		    			e1.printStackTrace();
		    		}
		    	}
		    }	
		    else
		    	JOptionPane.showMessageDialog(null,"You have to select a Candidate first!");
		    	
		}
				
		}
	}
	public void dispose() {
		this.setVisible(false);
	}
}




