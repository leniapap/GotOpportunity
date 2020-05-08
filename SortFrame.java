import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

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

public class SortFrame extends JFrame {

	private JPanel mainPanel;
	private JPanel headerPanel;
	private JPanel middlePanel;
	private JPanel panel3;
	private JPanel bottomPanel;
	private DefaultListModel<String> ratingModel;
	private DefaultListModel<String> skillsModel;
	private DefaultListModel<String> skillsSortedModel;
	private JList<String> skillsList;
	private JList<String> skillsSortedList;
	private JLabel rateListLabel;
	private ArrayList<Candidate> candidates;
	private ArrayList<Candidate> candidatesShortedBySkill;
	private JButton show = new JButton("Show List");
	private JButton menu = new JButton("Back to Menu");
	private JButton shortlistButton=new JButton("Add Candidate to Shortlist");
	private int sortNumber;
	private JobOffer aJobOffer;
	private ImageIcon icon;
	
	public SortFrame (JobOffer offer)
	{
		mainPanel=new JPanel();
		mainPanel.setBackground(Color.white);
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
		
		
		
		aJobOffer=offer;
		headerPanel = new JPanel();
		headerPanel.setBackground(Color.white);
		rateListLabel = new JLabel(" -> Best Candidates Sorted by Rating"); 
		rateListLabel.setFont(new Font("Courier",Font.BOLD,20));
		headerPanel.add(rateListLabel);
		
		middlePanel=new JPanel();
		middlePanel.setLayout(new FlowLayout());
		middlePanel.setBackground(Color.white);
		JScrollPane scrollPane = new JScrollPane();
		ratingModel = new DefaultListModel();
		candidates = offer.getEnrolledCandidates();
		skillsList = new JList<String>();
		scrollPane.setViewportView(skillsList);
		skillsModel = new DefaultListModel();
		skillsSortedList = new JList<String>();
		scrollPane.setViewportView(skillsSortedList);
		skillsSortedModel = new DefaultListModel();
		
		 for(Candidate cand: candidates)
		
		{
			ratingModel.addElement(cand.getFullName());
		}
		
		skillsModel.addElement("SortbyAge");
		skillsModel.addElement("SortbyDegreeGrade");
		skillsModel.addElement("SortbyEducationalLevel");
		skillsModel.addElement("SortbyWorkExperience");
		
		skillsList.setModel(skillsModel); 
		
		skillsSortedList = new JList<String>();
		skillsSortedModel = new DefaultListModel();
		
			
			
		candidatesShortedBySkill = offer.getEnrolledCandidates();
		
		for(Candidate skillsName : candidatesShortedBySkill)
			skillsSortedModel.addElement(skillsName.getFullName());
		  	
		skillsSortedList.setModel(skillsSortedModel); 
		skillsSortedList.setVisible(false);
		
		

		middlePanel.add(skillsList);
		middlePanel.add(skillsSortedList);
		
		panel3= new JPanel();
		panel3.setLayout(new FlowLayout());
		panel3.setBackground(Color.white);
		panel3.add(show);	
		shortlistButton.setBackground(Color.black);
		shortlistButton.setForeground(Color.white);
		panel3.add(shortlistButton);
		
		bottomPanel=new JPanel();
		bottomPanel.setBackground(Color.white);
		bottomPanel.add(menu);
		mainPanel.add(headerPanel);
		mainPanel.add(middlePanel);
		mainPanel.add(panel3);
		mainPanel.add(bottomPanel);
		this.setContentPane(mainPanel);
		

		icon = new ImageIcon ("icon.png") ;
		this.setIconImage(icon.getImage());
		skillsList.setBackground(Color.black);
		skillsSortedList.setBackground(Color.black);
		skillsList.setForeground(Color.white);
		skillsSortedList.setForeground(Color.white);
		show.setBackground(Color.black);
		show.setForeground(Color.white);
		menu.setBackground(Color.black);
		menu.setForeground(Color.white);
		shortlistButton.setBackground(Color.black);
		shortlistButton.setForeground(Color.white);
		
		
		skillsSortedList.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				String selected = "";
				Candidate selectedCandidate = null ;
				if(e.getClickCount() == 1) {
					selected = (String) skillsSortedList.getSelectedValue();
					for(Candidate aCand: aJobOffer.getEnrolledCandidates()) {
						if(aCand.getFullName().equals(selected)) {
							selectedCandidate=aCand;
							break;
						}
					}
					JOptionPane.showMessageDialog(null, "->Selected Candidate's Skills: \n" +selectedCandidate.getDegreeGrade() +"\n ->Preferred Programming Languages: " +selectedCandidate.getProgrammingLanguages() +"\n ->Preferred Foreign Languages: " +selectedCandidate.getForeignLanguages()+"\n ->Preferred Educational Level: " +selectedCandidate.getEducationLevel()+"\n ->Preferred Software Knowledge: " +selectedCandidate.getSoftwareKnowledge()+"\n ->Preferred Working Experience: " +selectedCandidate.getWorkExperience());
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
		
		this.setTitle("Candidates Applications");
		this.setSize(400, 500);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
		class ButtonListener implements ActionListener {

			public void actionPerformed(ActionEvent e) {
				
	      if(e.getSource() == show) {
					
				
				
				String selectedSkillsName = (String) skillsList.getSelectedValue();
				
				String age = new String("SortbyAge");
				
				if ( age.equals(selectedSkillsName) ) {
					
					sortNumber = 0;
					aJobOffer.sortCandidates(sortNumber);					
				}
				
				String degree = new String("SortbyDegreeGrade");
				
				if ( degree.equals(selectedSkillsName) ) {
					
					sortNumber = 1;
					aJobOffer.sortCandidates(sortNumber);		
				}

				String education = new String("SortbyEducationalLevel");
				
				if ( education.equals(selectedSkillsName) ) {
					
					sortNumber = 2;
					aJobOffer.sortCandidates(sortNumber);	
				}
				
				String experience = new String("SortbyWorkExperience");
				
				if ( experience.equals(selectedSkillsName) ) {
					
					sortNumber = 3;
					aJobOffer.sortCandidates(sortNumber);	

				}
				skillsSortedList.setVisible(true);
	          }
	          else if(e.getSource().equals(menu))
	        	   dispose();
	               //new MainMenuFrame(aCand);
			  
	          else if(e.getSource().equals(shortlistButton)) {
	        	  String selected = "";
				  Candidate selectedCandidate = null ;
				 
				  selected = (String) skillsSortedList.getSelectedValue();
				  for(Candidate aCand: aJobOffer.getEnrolledCandidates()) 
					{
				    	if(aCand.getFullName().equals(selected)) {
								selectedCandidate=aCand;
								break;
							}
					}
				  aJobOffer.addToShortlist(selectedCandidate);
				  JOptionPane.showMessageDialog(null,"Selected Candidate has been succesfully added to your shortlist!");	
			}
				
	}
		}
		public void dispose() {
			this.setVisible(false);
		}
}



