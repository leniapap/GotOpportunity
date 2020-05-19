import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
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
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.basic.BasicScrollBarUI;

public class JobOfferDetails extends JFrame {

	
	private JPanel mainPanel;
	private JPanel headerPanel;
	private JPanel middlePanel;
	private JPanel endingPanel;
	private JLabel headerTitle;
	private ImageIcon icon;
    private ImageIcon image;
	private JLabel imageLabel;
	private JButton chosenShortlist;
	private JButton sortOfferCandidates;
	private JButton backToMenu;
    private JList<String> offersList;
	private DefaultListModel<String> model;
	private ArrayList<JobOffer> offers;
	private Company company ;
	
	
	public JobOfferDetails(Company aComp)
	{
		company = aComp;
		offers=aComp.getCompanyOffers();		
		
		
		headerPanel=new JPanel();
		headerPanel.setBackground(Color.white);
		headerPanel.setLayout(new BoxLayout(headerPanel, BoxLayout.PAGE_AXIS));
		headerTitle=new  JLabel("->My Job Offers");
		headerTitle.setFont(new Font("Courier",Font.BOLD,20));
		headerPanel.add(headerTitle);
		image = new ImageIcon("icon.png");
		imageLabel = new JLabel(image);
		headerTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
		imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		headerPanel.add(imageLabel);
	
		mainPanel=new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		mainPanel.add(headerPanel);
	 
		mainPanel.setBackground(Color.white);
		
		middlePanel=new JPanel();
		middlePanel.setBackground(Color.white);
		
		offersList = new JList<String>();
		offersList.setPreferredSize(new Dimension(150,300));
		model = new DefaultListModel<String>();
		
		for(JobOffer offer:offers)
			model.addElement(offer.getOfferName());
		
		offersList.setModel(model);
		offersList.setBackground(Color.black);
		offersList.setForeground(Color.white);
		offersList.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				String selected = "";
				JobOffer selectedOffer = null ;
				if(e.getClickCount() == 1) {
					selected = (String) offersList.getSelectedValue();
					for(JobOffer offer: offers) {
						if(offer.getOfferName().equals(selected)) {
							selectedOffer=offer;
							break;
						}
					}
					JOptionPane.showMessageDialog(null, "->Selected Offer's Skills: \n ->Preferred Degree Grade: " +selectedOffer.getDegreeGrade() +"\n ->Preferred Programming Languages: " +selectedOffer.getProgrammingLanguages() +"\n ->Preferred Foreign Languages: " +selectedOffer.getForeignLanguages()+"\n ->Preferred Educational Level: " +selectedOffer.getEducationLevel()+"\n ->Preferred Software Knowledge: " +selectedOffer.getSoftwareKnowledge()+"\n ->Preferred Working Experience: " +selectedOffer.getWorkExperience());
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
		JScrollPane scrollPane = new JScrollPane(offersList);
		UIManager.put("ScrollBar.thumb", new ColorUIResource(Color.white));             
	    scrollPane.getVerticalScrollBar().setUI(new BasicScrollBarUI() );
		middlePanel.add(scrollPane);
        mainPanel.add(middlePanel);
		
		
		endingPanel=new JPanel();
		endingPanel.setBackground(Color.white);
		chosenShortlist=new JButton("View Chosen Offer's ShortList");
		sortOfferCandidates=new JButton("Sort Offer's Candidate");
		backToMenu=new JButton("Back to Menu");
		chosenShortlist.setBackground(Color.black);
		chosenShortlist.setForeground(Color.white);
		sortOfferCandidates.setBackground(Color.black);
		sortOfferCandidates.setForeground(Color.white);
		backToMenu.setBackground(Color.black);
		backToMenu.setForeground(Color.white);
		endingPanel.setLayout(new FlowLayout());
		endingPanel.add(chosenShortlist);
		endingPanel.add(sortOfferCandidates);
		endingPanel.add(backToMenu);
		
		mainPanel.add(endingPanel);
		chosenShortlist.addActionListener(new ActionListener(){
			    public void actionPerformed(ActionEvent e)
			    {
                    String selectedJobOffer=(String) offersList.getSelectedValue();
                    JobOffer selected=null;
                    for(JobOffer offer:offers)
                    {
                    	if(offer.getOfferName().equals(selectedJobOffer))
                    	{
                    		selected=offer;
                    		break;
                    	}
                    }
                    if(selected==null)
                    	JOptionPane.showMessageDialog(null,"You need to select a Job Offer first!");
                    else {
                      new ShortListFrame(selected);
  			    	  dispose();
                    }			    
			    }
		  });
		
		sortOfferCandidates.addActionListener(new ActionListener() {
			  public void actionPerformed(ActionEvent e)
			  {
				  String selectedJobOffer=(String) offersList.getSelectedValue();
                  JobOffer selected=null;
                  for(JobOffer offer:offers)
                  {
                  	if(offer.getOfferName().equals(selectedJobOffer)) 
                  	{
                  		selected=offer;
                  		break;
                  	}
                  }
                  if(selected==null)
                	  JOptionPane.showMessageDialog(null, "You need to select a Job Offer first!");
                  else
                  {
                	  new SortFrame(company, selected);
                	  dispose();
                  }
                	  
                 
			     
			  }
		});
		
		backToMenu.addActionListener(new ActionListener() {
			  public void actionPerformed(ActionEvent e)
			  {
				dispose();
			  new MainMenuFrame(aComp);
			  }
		});		
		this.setContentPane(mainPanel);
		
		icon = new ImageIcon ("icon.png") ;
		
		this.setIconImage(icon.getImage());
		this.setVisible(true);
		this.setTitle("MyJobOffers");
		this.setSize(400,500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		
		
		
		
		
	}
	public void dispose() {
		this.setVisible(false);
	}
}
