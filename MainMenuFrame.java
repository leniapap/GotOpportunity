import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainMenuFrame extends JFrame {
	
	private JLabel welcomeLabel;
	private JLabel optionLabel ;
	private JButton createOfferButton ;
    private JButton viewOffersButton ;
    private JButton ratingButton ;
    private JButton updateButton ;
    private JButton applyButton ;
    private JButton deleteButton ;
    private JButton logOutButton ;
	private JPanel panel ;
	private JPanel labelPanel ;
    private JPanel buttonPanel ;
	private JPanel logoPanel ;
    private ImageIcon image ;
    private ImageIcon icon ;
	private JLabel imageLabel ;
	private JLabel ratingLabel ;
	
	public MainMenuFrame(User Auser) {		
		if(Auser.getType().equals("Company")) {
		
			welcomeLabel = new JLabel("Welcome Company12,");
			welcomeLabel.setFont(new Font("->Apply for a new Job", Font.BOLD, 20));
			optionLabel = new JLabel("-> What would you like to do?");
			createOfferButton = new JButton("Create a Job Offer");
			createOfferButton.setBackground(Color.black);
			createOfferButton.setForeground(Color.white);
			viewOffersButton = new JButton("View My Offers");
			viewOffersButton.setBackground(Color.black);
			viewOffersButton.setForeground(Color.white);
			logOutButton = new JButton("Log out");
			logOutButton.setBackground(Color.black);
			logOutButton.setForeground(Color.white);
			panel = new JPanel();
			panel.setBackground(Color.white);
			labelPanel = new JPanel();
			labelPanel.setBackground(Color.white);
			buttonPanel = new JPanel();
			buttonPanel.setBackground(Color.white);
			logoPanel = new JPanel();
			logoPanel.setBackground(Color.white);
			
			
			image = new ImageIcon("image.png");
			imageLabel = new JLabel(image);
			logoPanel.add(imageLabel);
			
			labelPanel.setLayout(new BoxLayout(labelPanel, BoxLayout.PAGE_AXIS));
			labelPanel.add(welcomeLabel);
			labelPanel.add(Box.createRigidArea(new Dimension(0,20)));
			labelPanel.add(optionLabel) ;
			labelPanel.add(Box.createRigidArea(new Dimension(0,20)));
			
			panel.add(labelPanel);
			
			buttonPanel.setLayout(new GridLayout(3,1, 10, 10));
			buttonPanel.add(createOfferButton);
			buttonPanel.add(viewOffersButton);
			buttonPanel.add(Box.createRigidArea(new Dimension(0,20)));
			buttonPanel.add(logOutButton);
			
			panel.add(buttonPanel);
			panel.add(logoPanel);
			
			ButtonListener listener = new ButtonListener();
			createOfferButton.addActionListener(listener);
			viewOffersButton.addActionListener(listener);
			logOutButton.addActionListener(listener);
			
			this.setContentPane(panel);
			
			icon = new ImageIcon ("icon.png") ;
			
			this.setIconImage(icon.getImage());
			this.setVisible(true);
			this.setTitle("Got Opportunity");
			this.setSize(400,350);
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		}
		else {
			welcomeLabel = new JLabel("Welcome Candidate12,");
			optionLabel = new JLabel("-> What would you like to do?");
			ratingButton = new JButton("See my Rating");
			ratingButton.setBackground(Color.black);
			ratingButton.setForeground(Color.white);
			ratingLabel = new JLabel("-> Your Rating is: " + ((Candidate)Auser).getRating()) ;
			ratingLabel.setVisible(false);
			updateButton = new JButton("Update my Profile");
			updateButton.setBackground(Color.black);
			updateButton.setForeground(Color.white);
			viewOffersButton = new JButton("View My JobOffers");
			viewOffersButton.setBackground(Color.black);
			viewOffersButton.setForeground(Color.white);
			deleteButton = new JButton("Delete my Account");
			deleteButton.setBackground(Color.black);
			deleteButton.setForeground(Color.white);
			applyButton = new JButton("Apply for a Job");
			applyButton.setBackground(Color.black);
			applyButton.setForeground(Color.white);
			logOutButton = new JButton("Log out");
			logOutButton.setBackground(Color.black);
			logOutButton.setForeground(Color.white);
			panel = new JPanel();
			panel.setBackground(Color.white);
			labelPanel = new JPanel();
			labelPanel.setBackground(Color.white);
			buttonPanel = new JPanel();
			buttonPanel.setBackground(Color.white);
			logoPanel = new JPanel();
			logoPanel.setBackground(Color.white);
			
			
			image = new ImageIcon("image.png");
			imageLabel = new JLabel(image);
			logoPanel.add(imageLabel);
			
			
			labelPanel.setLayout(new BoxLayout(labelPanel, BoxLayout.PAGE_AXIS));
			labelPanel.add(welcomeLabel);
			labelPanel.add(Box.createRigidArea(new Dimension(0,20)));
			labelPanel.add(optionLabel) ;
			labelPanel.add(Box.createRigidArea(new Dimension(0,20)));
			
			panel.add(labelPanel);
			
			buttonPanel.setLayout(new GridLayout(4, 4, 10, 10));
			buttonPanel.add(ratingButton);
			buttonPanel.add(ratingLabel);
			buttonPanel.add(updateButton);
			buttonPanel.add(applyButton);
			buttonPanel.add(deleteButton);
			buttonPanel.add(viewOffersButton);
			buttonPanel.add(logOutButton);
			
			panel.add(buttonPanel);
			panel.add(logoPanel);
			
			ButtonListener listener = new ButtonListener();
			ratingButton.addActionListener(listener);
			updateButton.addActionListener(listener);
			applyButton.addActionListener(listener);
			deleteButton.addActionListener(listener);
			viewOffersButton.addActionListener(listener);
			logOutButton.addActionListener(listener);
			
			this.setContentPane(panel);
			
			
			icon = new ImageIcon ("icon.png") ;
			
			this.setIconImage(icon.getImage());
			this.setVisible(true);
			this.setTitle("Got Opportunity");
			this.setSize(350,350);
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		}
	}

class ButtonListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(createOfferButton)) {
	//		new CreateJobOfferFrame();
			dispose();
		}
		else if(e.getSource().equals(viewOffersButton)) {
	//		new OffersFrame();
			dispose();
		}
		else if(e.getSource().equals(logOutButton)) {
			dispose();
		}
		else if(e.getSource().equals(ratingButton)) {
			ratingLabel.setVisible(true);
		}
		else if(e.getSource().equals(updateButton)) {
	//		new UpdateProfileFrame();
			dispose();
		}
		else if(e.getSource().equals(applyButton)) {
	//		new NewApplicationFrame();
			dispose();
		}
		else if(e.getSource().equals(deleteButton)) {
	//		user.deleteAccount();
			dispose();
		}
		else {
	//		new ApplicationFrame();
			dispose();
		}
	}
	
	
}
	public void dispose() {
		this.setVisible(false);
}	


}