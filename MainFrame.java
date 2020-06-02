import java.awt.Color;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

//frame eisodou tou xristi stin efarmogi
public class MainFrame extends JFrame{
	
	 private JPanel mainpanel,logSignPanel,usernamepanel,passwordpanel,imagepanel;
	 private JButton signInButton,logInButton;
	 private JTextField usernametext;
	 private JPasswordField passwordtext;
	 private ImageIcon image,icon;
	 private JLabel orText,description,usernamelabel,passwordlabel,
	 contactInfo1,contactInfo2,contactInfo3,imagelabel;
	 
	 
	 
	public MainFrame()
			 {
		
	
		mainpanel = new JPanel();
		logSignPanel =  new JPanel();
		usernamepanel = new JPanel();
		passwordpanel = new JPanel();
		imagepanel = new JPanel();
		
		
		imagepanel.setBackground(Color.white);
		usernamepanel.setBackground(Color.white);
		passwordpanel.setBackground(Color.white);
		logSignPanel.setBackground(Color.white);
		mainpanel.setBackground(Color.white);
		

		image = new ImageIcon("image.png");
		imagelabel = new JLabel(image);
		imagepanel.add(imagelabel);
		
	
		icon = new ImageIcon("icon.png");
	
		usernamelabel = new JLabel("Username");
		usernametext = new JTextField(10);
		usernamepanel.add(usernamelabel);
		usernamepanel.add(usernametext);
		
		
	
		passwordlabel = new JLabel("Password");
		passwordtext = new JPasswordField(10);
		passwordpanel.add(passwordlabel);
		passwordpanel.add(passwordtext);
		
		
		
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
		
		

		contactInfo1 = new JLabel("Contact us here:");
		contactInfo2 = new JLabel("->2310-123456");
		contactInfo3 = new JLabel("->gotOpportunity@gmail.com");
		description  = new JLabel("Business Software");
		
		

		mainpanel.setLayout(new BoxLayout(mainpanel,BoxLayout.Y_AXIS));
	
		mainpanel.add(imagepanel);
		mainpanel.add(usernamepanel);
		mainpanel.add(passwordpanel);
		mainpanel.add(logSignPanel);
		mainpanel.add(contactInfo1);
		mainpanel.add(contactInfo2);
		mainpanel.add(contactInfo3);
		
			logInButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				ArrayList<Integer>  verification=new ArrayList<Integer>();
				String username = usernametext.getText();
				String password = passwordtext.getText();
				
				verification = Main.data.logAttempt(username, password);
				int userIndex= verification.get(2); //The third entry of the array shows the position of the user in the list of users
                 if(!verification.isEmpty()) { //check of user existence
					if(verification.get(0)==1)//verification of username
					{
						if(verification.get(1)==1) //verification of password
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