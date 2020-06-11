import java.awt.Color;
	import java.awt.FlowLayout;
	import java.awt.Font;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

	import javax.swing.BoxLayout;
	import javax.swing.ImageIcon;
	import javax.swing.JButton;
	import javax.swing.JFrame;
	import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
	import javax.swing.JRadioButton;
	import javax.swing.JTextField;
import javax.swing.border.LineBorder;
	
//frame dimiourgias enos neou JobOffer
public class CreateJobOfferFrame extends JFrame {

	private ImageIcon icon; 
	private JPanel mainpanel;
	private JPanel panel00;
	private JPanel panel0;
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	private JPanel panel4;
	private JPanel panel5;
	private JPanel panel6;
	private JLabel title;
	private JLabel nameTitle;
	private JLabel educationalLevel;
	private JLabel gradeOfDegree;
	private JLabel programmingLanguages;
	private JLabel otherLanguages;
	private JLabel softwares;
	private JLabel yearsOfWork;
	private JTextField name;
	private JTextField grade;
	private JTextField years;
	private JTextField neededSkillsTitle;
	private JButton update;
	private JRadioButton c;
	private JRadioButton java;
	private JRadioButton cPlusPlus;
	private JRadioButton python;
	private JRadioButton sql;
	private JRadioButton ruby;
	private JRadioButton highSchool;
	private JRadioButton college;
	private JRadioButton masterDegree;
	private JRadioButton phD;
	private JRadioButton french;
	private JRadioButton spanish;
	private JRadioButton greek;
	private JRadioButton italian;
	private JRadioButton hindi;
	private JRadioButton arabic;
	private JRadioButton chinese;
	private JRadioButton photoshop;
	private JRadioButton max;
	private JRadioButton tableau;
	private JRadioButton matlab;
	private JRadioButton sourceTree;
	private JRadioButton visualParadigm;
	private JPanel panelHeader;
	private JPanel endingPanel;
	private double gradeSkills;
	private int educationlevelSkills;
	private ArrayList<String> programmingLanguagesSkills ;
	private int workExperienceSkills ;
	private ArrayList<String> foreignLanguagesSkills ;
	private ArrayList<String> SoftwareKnowledgeSkills ;
	private String nameString;
	private Company comp;
	private Skills skill;
	private JobOffer offer;
		

	public CreateJobOfferFrame(Company aComp)
	{
			
			comp = aComp;
			
			mainpanel=new JPanel();
			mainpanel.setBackground(Color.white);
			mainpanel.setLayout(new BoxLayout(mainpanel, BoxLayout.PAGE_AXIS));
			
			title = new JLabel(" -> Create a new JobOffer");
			nameTitle = new JLabel("Job Name:");
			title.setFont(new Font("Courier",Font.BOLD,30));
						
	
			panelHeader=new JPanel();
			panelHeader.setBackground(Color.white);
			panelHeader.add(title);
			mainpanel.add(panelHeader);
			
			
			
			panel00 = new JPanel();
			panel00.setBackground(Color.white);
			panel00.add(nameTitle);
			name=new JTextField(12);
			
			 
			name.setBackground(Color.black);
			name.setForeground(Color.white);
			nameTitle.setFont(new Font("Courier",Font.BOLD,17));
			panel00.add(name);
			
			panel0 = new JPanel();
			panel0.setBackground(Color.white);
			neededSkillsTitle = new JTextField(" Needed Skills:");
			neededSkillsTitle.setBorder(new LineBorder(Color.BLACK,2));
			neededSkillsTitle.setEditable(false);
			neededSkillsTitle.setBackground(Color.black);
			neededSkillsTitle.setForeground(Color.white);
			panel0.add(neededSkillsTitle);
			neededSkillsTitle.setFont(new Font("Courier",Font.BOLD,15));
			
	
			panel1=new JPanel();
			educationalLevel= new JLabel("Educational Level:");
			educationalLevel.setFont(new Font("Courier",Font.BOLD,20));
			panel1.add(educationalLevel);
			panel1.setLayout(new FlowLayout());
			panel1.setBackground(Color.white);
			highSchool=new JRadioButton("High School Graduate");
			highSchool.setBackground(Color.white);
			college=new JRadioButton("College Graduate");
			college.setBackground(Color.white);
			masterDegree=new JRadioButton("MastersDegree owner");
			masterDegree.setBackground(Color.white);
			phD=new JRadioButton("PhD owner");
			phD.setBackground(Color.white);
			panel1.add(highSchool);
			panel1.add(college);
			panel1.add(masterDegree);
			panel1.add(phD);
			
		
			panel2=new JPanel();
			gradeOfDegree= new JLabel("Minimum Grade of Degree:");
			gradeOfDegree.setFont(new Font("Courier",Font.BOLD,20));
			grade=new JTextField(10);
			grade.setBackground(Color.black);
			grade.setForeground(Color.white);
			panel2.setBackground(Color.white);
			panel2.setLayout(new FlowLayout());
			panel2.add(gradeOfDegree);
			panel2.add(grade);
		
			
			panel3=new JPanel();
			programmingLanguages=new JLabel("Programming Languages:");
			programmingLanguages.setFont(new Font("Courier",Font.BOLD,20));
			panel3.setBackground(Color.white);
			panel3.setLayout(new FlowLayout());
			panel3.add(programmingLanguages);
			java=new JRadioButton("Java");
			c=new JRadioButton("C");
			cPlusPlus=new JRadioButton("C++");
			python=new JRadioButton("Python");
			sql=new JRadioButton("Sql");
			ruby= new JRadioButton("Ruby");
			java.setBackground(Color.white);
			c.setBackground(Color.white);
			cPlusPlus.setBackground(Color.white);
			python.setBackground(Color.white);
			sql.setBackground(Color.white);
			ruby.setBackground(Color.white);
			panel3.add(c);
			panel3.add(java);
			panel3.add(cPlusPlus);
			panel3.add(python);
			panel3.add(sql);
			panel3.add(ruby);
			

			panel4=new JPanel();
			otherLanguages= new JLabel("Other Languages:");
			otherLanguages.setFont(new Font("Courier",Font.BOLD,20));
			panel4.setBackground(Color.white);
			panel4.add(otherLanguages);
			french= new JRadioButton("French");
			spanish= new JRadioButton("Spanish");
			greek= new JRadioButton("Greek");
			italian= new JRadioButton("Italian");
			hindi= new JRadioButton("Hindi");
			arabic= new JRadioButton("Arabic");
			chinese= new JRadioButton("Chinese");
			french.setBackground(Color.white);
			spanish.setBackground(Color.white);
			greek.setBackground(Color.white);
			italian.setBackground(Color.white);
			hindi.setBackground(Color.white);
			arabic.setBackground(Color.white);
			chinese.setBackground(Color.white);
			panel4.setLayout(new FlowLayout());
			panel4.add(arabic);
			panel4.add(chinese);
			panel4.add(hindi);
			panel4.add(italian);
			panel4.add(spanish);
			panel4.add(greek);
			panel4.add(french);
			
			
			panel5=new JPanel();
			panel5.setBackground(Color.white);
			softwares= new JLabel("Software Knowledge:");
			softwares.setFont(new Font("Courier",Font.BOLD,20));
			panel5.setLayout(new FlowLayout());
			panel5.add(softwares);
			photoshop=new JRadioButton("Adobe Photoshop CC");
			max=new JRadioButton("3dsMax");
			tableau=new JRadioButton("Tableau");
			matlab= new JRadioButton("Matlab");
			sourceTree=new JRadioButton("SourceTree");
			visualParadigm=new JRadioButton("Visual Paradigm");
			photoshop.setBackground(Color.white);
	        max.setBackground(Color.white);
	        tableau.setBackground(Color.white);
	        matlab.setBackground(Color.white);
	        sourceTree.setBackground(Color.white);
	        visualParadigm.setBackground(Color.white);
	        panel5.add(photoshop);
	        panel5.add(max);
	        panel5.add(tableau);
	        panel5.add(matlab);
	        panel5.add(sourceTree);
	        panel5.add(visualParadigm);
	        
			
	        
			panel6=new JPanel();
			yearsOfWork=new JLabel("Minimum years of Work Experience:");
			yearsOfWork.setFont(new Font("Courier",Font.BOLD,20));
			years=new JTextField(10);
			
			years.setBackground(Color.black);
			years.setForeground(Color.white);
			panel6.setBackground(Color.white);
			panel6.setLayout(new FlowLayout());
			panel6.add(yearsOfWork);
			panel6.add(years);
			
			
			
			update= new JButton("Create a Job Offer");
			update.setBackground(Color.black);
			update.setForeground(Color.white);
			endingPanel=new JPanel();
			endingPanel.setBackground(Color.white);
			endingPanel.setLayout(new FlowLayout());
			endingPanel.add(update);	
			
			
		    icon= new ImageIcon("icon.png");
		    
		    //Action listener gia tin eisagogi dedomenon sto profil
		    update.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e) {
				
			    nameString = name.getText();
			    workExperienceSkills=Integer.parseInt(years.getText());
			    gradeSkills=Double.valueOf(grade.getText());
			    programmingLanguagesSkills=new ArrayList<String>();
			    foreignLanguagesSkills=new ArrayList<String>();
			    SoftwareKnowledgeSkills= new ArrayList<String>();
			    if(c.isSelected())
	    		  programmingLanguagesSkills.add("C");
		    	if(cPlusPlus.isSelected())
		    	  programmingLanguagesSkills.add("C++");
		    	if(java.isSelected())
		    		programmingLanguagesSkills.add("Java");
		    	if(python.isSelected())
		    	  programmingLanguagesSkills.add("Python");
		    	if(sql.isSelected())
		    	 programmingLanguagesSkills.add("SQL");
		    	if(ruby.isSelected())
		    		programmingLanguagesSkills.add("Ruby");
		    	if(highSchool.isSelected())	
		    		educationlevelSkills=1;
		    	if(college.isSelected())	
		    		educationlevelSkills=2;
		    	if(masterDegree.isSelected())
		    		educationlevelSkills=3;
		    	if(phD.isSelected())
		    		educationlevelSkills=4;
		    	if(french.isSelected())
		    		foreignLanguagesSkills.add("French");
		    	if(spanish.isSelected())	
		    		foreignLanguagesSkills.add("Spanish");
		    	if(greek.isSelected())	
		    		foreignLanguagesSkills.add("Greek");
		    	if(italian.isSelected())
		    		foreignLanguagesSkills.add("Italian");
		    	if(hindi.isSelected())
		    		foreignLanguagesSkills.add("Hindi");
		    	if(arabic.isSelected())
		    		foreignLanguagesSkills.add("Arabic");
		    	if(chinese.isSelected())
		    		foreignLanguagesSkills.add("Chinese");
		    	if(photoshop.isSelected())
		    		SoftwareKnowledgeSkills.add("Adobe Photoshop CC");
		    	if(max.isSelected())	
		    		SoftwareKnowledgeSkills.add("3dsMax");
		    	if(tableau.isSelected())
		    		SoftwareKnowledgeSkills.add("Tableau");
		        if(matlab.isSelected())
		        	SoftwareKnowledgeSkills.add("Matlab");
		        if(sourceTree.isSelected())
		        	SoftwareKnowledgeSkills.add("SourceTree");
		        if(visualParadigm.isSelected())
		        	SoftwareKnowledgeSkills.add("Visual Paradigm");
		        
		    
		        skill = new Skills(gradeSkills,educationlevelSkills,programmingLanguagesSkills,workExperienceSkills,foreignLanguagesSkills,SoftwareKnowledgeSkills);
		        offer = new JobOffer(nameString,skill);
		        comp.addJobOffer(offer);
		        Main.data.addJobOffer(offer);
		      //data entry
				try {
					FileOutputStream fouts = new FileOutputStream(Main.f);
					ObjectOutputStream douts = new ObjectOutputStream(fouts);
					douts.writeObject(Main.data);
					fouts.close();
					douts.close();
				} catch (FileNotFoundException e3) {
					e3.printStackTrace();
				}catch (IOException e3) {
					e3.printStackTrace();
				}
		        
		        JOptionPane.showMessageDialog(null, "Your offer has been successfully created!");
		  		new MainMenuFrame(comp);
		  		dispose();
		    	}
		    });
		    
		    
			this.setContentPane(mainpanel);
			this.add(panel00);
			this.add(panel0);
			this.add(panel1);
			this.add(panel2);
			this.add(panel3);
			this.add(panel4);
			this.add(panel5);
			this.add(panel6);
			this.add(endingPanel);

			this.setIconImage(icon.getImage());
			this.setVisible(true);
			this.pack();
			this.setTitle("My Profile");
			this.setSize(500,650);
			this.setLocationRelativeTo(null);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
			
		}
		public void dispose() {
			this.setVisible(false);
	}
		
	}

