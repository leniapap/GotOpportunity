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
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.ComponentOrientation;
import java.awt.Cursor;
import java.awt.Label;
import java.awt.TextField;
import java.awt.Window;
import java.awt.Button;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JTextArea;
import javax.swing.DropMode;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class RegistryFrameCompany extends JFrame {

	private JPanel contentPane;
	private JTextField textemail;
	private JTextField textlocation;
	private JTextField textyears;
	private JTextField textnumber;
	private JTextField textname;
	private JTextField textusername;
	private JPasswordField textpassword;
	private ImageIcon icon;

	
	public RegistryFrameCompany() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 350, 350);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		JLabel lblPersonalInfo = new JLabel("Personal Info");
		lblPersonalInfo.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JLabel lblNewLabel = new JLabel("Name:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		
		JLabel lblNewLabel_1 = new JLabel("E-mail:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		
		JLabel lblNewLabel_2 = new JLabel("Location:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		
		textemail = new JTextField();
		textemail.setText("Type..");
		textemail.setForeground(Color.WHITE);
		textemail.setBackground(new Color(0, 0, 0));
		textemail.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		textemail.setColumns(10);
		
		textlocation = new JTextField();
		textlocation.setText("Type..");
		textlocation.setForeground(Color.WHITE);
		textlocation.setBackground(new Color(0, 0, 0));
		textlocation.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		textlocation.setColumns(10);
		
		textyears = new JTextField();
		textyears.setText("Type..");
		textyears.setForeground(Color.WHITE);
		textyears.setBackground(new Color(0, 0, 0));
		textyears.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		textyears.setColumns(10);
		
		textnumber = new JTextField();
		textnumber.setText("Type..");
		textnumber.setForeground(Color.WHITE);
		textnumber.setBackground(new Color(0, 0, 0));
		textnumber.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		textnumber.setColumns(10);
		
		textname = new JTextField();
		textname.setText("Type..");
		textname.setBackground(new Color(0, 0, 0));
		textname.setForeground(Color.WHITE);
		textname.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		textname.setColumns(10);
		
		JLabel lblNumber = new JLabel("Number:");
		lblNumber.setFont(new Font("Times New Roman", Font.BOLD, 15));
		
		JButton buttonComplete = new JButton("Complete");
		buttonComplete.setForeground(Color.WHITE);
		buttonComplete.setBackground(Color.BLACK);
		buttonComplete.setBorderPainted(false);
		buttonComplete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComponent comp = (JComponent) e.getSource();
				  Window win = SwingUtilities.getWindowAncestor(comp);
				  win.dispose();
				  String username,name,password,email,location,yearsOfEstablishment;
				  username = textusername.getText();
				  password = textpassword.getText();
				  name = textname.getText();
				  email = textemail.getText();
				  location = textlocation.getText();
				  yearsOfEstablishment = textyears.getText();
				  Main.data.addUser(new Company(username,name,password,email,location,"123",Integer.parseInt(yearsOfEstablishment)));
				//Εγγραφή δεδομένων
					try {
						FileOutputStream fouts = new FileOutputStream(Main.f);
						ObjectOutputStream douts = new ObjectOutputStream(fouts);
						douts.writeObject(Main.data);
						fouts.close();
						douts.close();
					} catch (FileNotFoundException e2) {
						e2.printStackTrace();
					}catch (IOException e2) {
						e2.printStackTrace();
					}
			}
		});
		buttonComplete.setFont(new Font("Times New Roman", Font.BOLD, 15));
		
		JTextArea txtrYearsOfEstablishment = new JTextArea();
		txtrYearsOfEstablishment.setLineWrap(true);
		txtrYearsOfEstablishment.setWrapStyleWord(true);
		txtrYearsOfEstablishment.setTabSize(10);
		txtrYearsOfEstablishment.setRows(2);
		txtrYearsOfEstablishment.setFont(new Font("Times New Roman", Font.BOLD, 15));
		txtrYearsOfEstablishment.setText("Years of  Establishment:");
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Times New Roman", Font.BOLD, 15));
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 15));
		
		textusername = new JTextField();
		textusername.setBackground(Color.BLACK);
		textusername.setForeground(Color.WHITE);
		textusername.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		textusername.setText("Type..");
		textusername.setColumns(10);
		
		textpassword = new JPasswordField();
		textpassword.setForeground(Color.WHITE);
		textpassword.setBackground(Color.BLACK);
		textpassword.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		textpassword.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(41)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel)
								.addComponent(lblNewLabel_1)
								.addComponent(lblNewLabel_2)
								.addComponent(lblNumber))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(textemail, 103, 103, 103)
								.addComponent(textname, 103, 103, 103)
								.addComponent(textlocation, 103, 103, 103)
								.addComponent(textnumber, 103, 103, 103)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(104)
							.addComponent(lblPersonalInfo))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(txtrYearsOfEstablishment, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblPassword)
										.addComponent(lblUsername))
									.addGap(5)))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(textpassword)
								.addComponent(textusername, GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
								.addComponent(textyears, 103, 103, 103)
								.addComponent(buttonComplete, GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE))))
					.addGap(90))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblPersonalInfo)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textemail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textlocation, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textnumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNumber))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(txtrYearsOfEstablishment, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textyears, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(8)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textusername, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblUsername))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPassword)
						.addComponent(textpassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
					.addComponent(buttonComplete, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
		);
		contentPane.setLayout(gl_contentPane);
		
		
		
		setContentPane(contentPane);
		icon = new ImageIcon("icon.png");
		this.setIconImage(icon.getImage());
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
}
