import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Window;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import java.awt.Color;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;

public class RegistryFrameCandidate extends JFrame {

	private JPanel contentPane;
	private JTextField textname;
	private JTextField textemail;
	private JTextField textage;
	private JTextField textusername;
	private JTextField textPhoneNumber;
	private JPasswordField textpassword;
	private ImageIcon icon;
	
	public RegistryFrameCandidate() {
		setTitle("Candidate Regisrty");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 350, 350);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		
		JLabel lblPersonalInfo = new JLabel("Personal Info");
		lblPersonalInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblPersonalInfo.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Times New Roman", Font.BOLD, 15));
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setFont(new Font("Times New Roman", Font.BOLD, 15));
		
		JLabel lblAge = new JLabel("Age:");
		lblAge.setFont(new Font("Times New Roman", Font.BOLD, 15));
		
		textname = new JTextField();
		textname.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		textname.setText("Type..");
		textname.setBackground(new Color(0, 0, 0));
		textname.setForeground(Color.WHITE);
		textname.setColumns(10);
		
		textemail = new JTextField();
		textemail.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		textemail.setText("Type..");
		textemail.setForeground(Color.WHITE);
		textemail.setBackground(new Color(0, 0, 0));
		textemail.setColumns(10);
		
		textage = new JTextField();
		textage.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		textage.setText("Type..");
		textage.setForeground(Color.WHITE);
		textage.setBackground(new Color(0, 0, 0));
		textage.setColumns(10);
		
		JButton btnComplete = new JButton("Complete");
		btnComplete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComponent comp = (JComponent) e.getSource();
				  Window win = SwingUtilities.getWindowAncestor(comp);
				  win.dispose();
				  String name,email,age,username,password;
				  name = textname.getText();
				  email = textemail.getText();
				  age = textage.getText();
				  username = textusername.getText();
				  password = textpassword.getText();
				  Main.data.addUser(new Candidate(username,name,password,email,Integer.parseInt(age),null,"1234"));
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
						  
			}
		});
		
		btnComplete.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnComplete.setForeground(Color.WHITE);
		btnComplete.setBackground(Color.BLACK);
		btnComplete.setBorderPainted(false);
		
		textusername = new JTextField();
		textusername.setBackground(Color.BLACK);
		textusername.setForeground(Color.WHITE);
		textusername.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		textusername.setText("Type..");
		textusername.setColumns(10);
		
		textpassword = new JPasswordField();
		textpassword.setBackground(Color.BLACK);
		textpassword.setForeground(Color.WHITE);
		textpassword.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		textpassword.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Times New Roman", Font.BOLD, 15));
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 15));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(57, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(lblPersonalInfo)
							.addGap(101))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblPassword)
								.addComponent(lblUsername)
								.addComponent(lblName)
								.addComponent(lblEmail)
								.addComponent(lblAge))
							.addPreferredGap(ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(textemail)
								.addComponent(textname, Alignment.LEADING)
								.addComponent(textage, Alignment.LEADING)
								.addComponent(textusername, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textpassword, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnComplete, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGap(80))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblPersonalInfo)
					.addGap(19)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblName)
						.addComponent(textname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblEmail)
						.addComponent(textemail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textage, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblAge))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textusername, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblUsername))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textpassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPassword))
					.addGap(26)
					.addComponent(btnComplete, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(31, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		
		setContentPane(contentPane);
		icon = new ImageIcon("icon.png");
		this.setIconImage(icon.getImage());
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
}