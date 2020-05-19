import java.awt.Color;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class MainFrame extends JFrame{
	 //Τα πάνελ
	 private JPanel mainpanel,logSignPanel,usernamepanel,passwordpanel,imagepanel;
	 //Τα κουμπιά
	 private JButton signInButton,logInButton;
	 //Τα πεδία κειμένου
	 private JTextField usernametext;
	 //
	 private JPasswordField passwordtext;
	 //Η εικόνα
	 private ImageIcon image,icon;
	 //Τα λάμπελ
	 private JLabel orText,description,usernamelabel,passwordlabel,
	 contactInfo1,contactInfo2,contactInfo3,imagelabel;
	 
	 
	 
	public MainFrame()
			 {
		
		//Δημιουργία πάνελ
		mainpanel = new JPanel();
		logSignPanel =  new JPanel();
		usernamepanel = new JPanel();
		passwordpanel = new JPanel();
		imagepanel = new JPanel();
		
		//Ανάθεση χρωμάτων στα πάνελ
		imagepanel.setBackground(Color.white);
		usernamepanel.setBackground(Color.white);
		passwordpanel.setBackground(Color.white);
		logSignPanel.setBackground(Color.white);
		mainpanel.setBackground(Color.white);
		
		//Δημιουργία εικόνας
		image = new ImageIcon("image.png");
		imagelabel = new JLabel(image);
		imagepanel.add(imagelabel);
		
		//Δημιουρία εικονιδίου
		icon = new ImageIcon("icon.png");
		
		//Δημιουργία πάνελ username
		usernamelabel = new JLabel("Username");
		usernametext = new JTextField(10);
		usernamepanel.add(usernamelabel);
		usernamepanel.add(usernametext);
		
		
		//Δημιουργία πάνελ password
		passwordlabel = new JLabel("Password");
		passwordtext = new JPasswordField(10);
		passwordpanel.add(passwordlabel);
		passwordpanel.add(passwordtext);
		
		
		//Δημιουργία πάνελ κουμπιών
		signInButton = new JButton("Sign in");
		signInButton.setBackground(Color.black);
		signInButton.setForeground(Color.white);
		logInButton = new JButton("Log in");
		logInButton.setBackground(Color.black);
		logInButton.setForeground(Color.white);
		orText = new JLabel("or");
		logSignPanel.add(signInButton);
		logSignPanel.add(orText);
		logSignPanel.add(logInButton);
		
		
		//Δημιουργία πάνελ πληροφιριών
		contactInfo1 = new JLabel("Contact us here:");
		contactInfo2 = new JLabel("->2310-123456");
		contactInfo3 = new JLabel("->gotOpportunity@gmail.com");
		description  = new JLabel("Business Software");
		
		
		
		//Προσθήκη αντικειμένων στο κεντρικό πάνελ
		mainpanel.setLayout(new BoxLayout(mainpanel,BoxLayout.Y_AXIS));
		//mainpanel.add(description);
		mainpanel.add(imagepanel);
		mainpanel.add(usernamepanel);
		mainpanel.add(passwordpanel);
		mainpanel.add(logSignPanel);
		mainpanel.add(contactInfo1);
		mainpanel.add(contactInfo2);
		mainpanel.add(contactInfo3);
		
		//Ακροατής για το κουμπί log in
		logInButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				ArrayList<Integer>  verification=new ArrayList<Integer>();
				String username = usernametext.getText();
				String password = passwordtext.getText();
				
				verification = Main.data.logAttempt(username, password);
				int userIndex= verification.get(2); //Η τρίτη θέση του πίνακα δείχνει τη θέση που έχει ο χρήστης στη συνολική λίστα των χρηστών
				if(!verification.isEmpty()) { //Έλεγχος ύπαρξης χρηστών
					if(verification.get(0)==1)//Έλεγχος ορθότητας Username
					{
						if(verification.get(1)==1) //Έλεγχος ορθότητας Password
						{	
							
							JOptionPane.showMessageDialog(null,"Welcome "+username +"!");
							dispose();
							new MainMenuFrame(Main.data.getuList().get(userIndex)); 
													
						}
						else
						{
							JOptionPane.showMessageDialog(null,"Wrong Password, try again." );
						}
					}else
					{
						JOptionPane.showMessageDialog(null,"Username doesn't exist, try again." );
					}
				}else
				{
					JOptionPane.showMessageDialog(null,"No Users. Please register." );
				}
				
				
			}
		});
		
		//Ακροατής για το κουμπί sign in
		signInButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				new RegistryFrame();			
			}
		});
		
		this.setContentPane(mainpanel);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setIconImage(icon.getImage());
		this.setVisible(true);
		this.setSize(350, 350);
		this.setTitle("Got Opportunity");
		this.setResizable(false);
		this.setLocationRelativeTo(null);
				
	}
	public void dispose() {
		this.setVisible(false);
}	


}