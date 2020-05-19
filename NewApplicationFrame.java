import java.awt.Color;
import java.awt.Dimension;
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
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.basic.BasicScrollBarUI;

public class NewApplicationFrame extends JFrame {
	
	private JLabel titleLabel ;
	private JTextField availableTextField ;
	private JButton applyButton ;
	private JButton backToMenuButton;
	private JList<String> jobList ;
	private DefaultListModel<String> model ;
	private JPanel panel ;
	private JPanel headerPanel;
	private JPanel bottomPanel;
	private JPanel middlePanel;
	private ArrayList<JobOffer> offersList ;
	private Candidate cand ;
	private ImageIcon icon;
	
	public NewApplicationFrame(ArrayList<JobOffer> offerList, Candidate aCand) {
	
		titleLabel = new JLabel("->Apply for a new Job") ;
		titleLabel.setFont(new Font("->Apply for a new Job", Font.BOLD, 15));
		availableTextField =  new JTextField("Available Jobs:");
		availableTextField.setFont(new Font("Available Jobs:", Font.BOLD, 15));
		availableTextField.setBackground(Color.black);
		availableTextField.setForeground(Color.white);
		availableTextField.setEditable(false);
		applyButton = new JButton("Apply");
		applyButton.setBackground(Color.black);
		applyButton.setForeground(Color.white);
		backToMenuButton=new JButton("Back To Menu");
		backToMenuButton.setBackground(Color.black);
		backToMenuButton.setForeground(Color.white);
		jobList = new JList<String>();
		jobList.setBackground(Color.black);
		jobList.setForeground(Color.white);
		model = new DefaultListModel<String>();
		panel = new JPanel();
		panel.setBackground(Color.white);
		headerPanel = new JPanel();
		headerPanel.setBackground(Color.white);
		bottomPanel = new JPanel();
		bottomPanel.setBackground(Color.white);
		middlePanel = new JPanel();
		middlePanel.setBackground(Color.white);
		
		cand = aCand ;
		
		offersList = offerList;
		
		for(JobOffer offer : offerList) {
			model.addElement(offer.getOfferName());
		}
		
		jobList.setModel(model);
		
		jobList.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				String selected = "";
				JobOffer selectedOffer = null ;
				if(e.getClickCount() == 1) {
					selected = (String) jobList.getSelectedValue();
					for(JobOffer offer : offersList) {
						if(offer.getOfferName().equals(selected)) {
							selectedOffer = offer;
							break;
						}
					}
					JOptionPane.showMessageDialog(null, "Required Skills:\n ->Minimum Degree Grade " +selectedOffer.getDegreeGrade() +"\n ->Preferred Programming Languages: " +selectedOffer.getProgrammingLanguages() +"\n ->Preferred Foreign Languages: " +selectedOffer.getForeignLanguages()+"\n ->Preferred Educational Level: " +selectedOffer.getEducationLevel()+"\n ->Preferred Software Knowledge: " +selectedOffer.getSoftwareKnowledge()+"\n ->Preferred Working Experience: " +selectedOffer.getWorkExperience());
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
		jobList.setPreferredSize(new Dimension(150,300));
		JScrollPane listScroller = new JScrollPane(jobList);
	    UIManager.put("ScrollBar.thumb", new ColorUIResource(Color.white));             
		listScroller.getVerticalScrollBar().setUI(new BasicScrollBarUI() );
	   
		
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		
		
		
		middlePanel.add(availableTextField);
		middlePanel.add(listScroller);
		bottomPanel.add(applyButton);
		bottomPanel.add(backToMenuButton);
        headerPanel.add(titleLabel) ;
        panel.add(headerPanel);
        panel.add(middlePanel);
        panel.add(bottomPanel);
       
		this.setContentPane(panel);
	
		ButtonListener listener = new ButtonListener();
		applyButton.addActionListener(listener);
		backToMenuButton.addActionListener(listener);
	
		 icon = new ImageIcon ("icon.png") ;
		
		this.setIconImage(icon.getImage());
		this.setSize(400,300);
		this.setTitle("New Applications");
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource().equals(backToMenuButton)) {
				new MainMenuFrame(cand);
				dispose();
			}			
			else {
			String selectedOfferName = (String) jobList.getSelectedValue(); 
			JobOffer selectedOffer = null;
			for(JobOffer offer : offersList) {
				if(offer.getOfferName().equals(selectedOfferName)) {
					selectedOffer = offer ;
					break ;
				}
			}			
			
			if(selectedOffer!=null)
			{
				if(selectedOffer.getEnrolledCandidates().contains(cand))
					JOptionPane.showMessageDialog(null,"You have already applied to this offer!");
				else
				{
					cand.applyJobOffer(selectedOffer);				
				selectedOffer.addCandidateToJobOffer(cand);
				 //Εγγραφή δεδομένων
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
		        
				JOptionPane.showMessageDialog(null, "You have successfully applied to the Job Offer's List!");
				new MainMenuFrame(cand);
				dispose();
			}
		}
			else
				JOptionPane.showMessageDialog(null, "You have to select an Offer first!");
			}
		}	
	}
	
	public void dispose() {
		this.setVisible(false);
	}	
}