import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.text.JTextComponent;

public class RegistryFrameCandidate extends JFrame {

	private JPanel contentPane;
	private JTextField textname;
	private JTextField textemail;
	private JTextField textage;
	private JTextField textusername;
	private JPasswordField textpassword;
	private ImageIcon icon;
	private JTextField textphone;
	
	public RegistryFrameCandidate() {
		setTitle("Candidate Regisrty");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 350, 350);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		
		JLabel lblPersonalInfo = new JLabel("Personal Info");
		lblPersonalInfo.setBounds(116, 5, 112, 24);
		lblPersonalInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblPersonalInfo.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(91, 51, 43, 18);
		lblName.setFont(new Font("Times New Roman", Font.BOLD, 15));
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(87, 83, 47, 18);
		lblEmail.setFont(new Font("Times New Roman", Font.BOLD, 15));
		
		JLabel lblAge = new JLabel("Age:");
		lblAge.setBounds(97, 150, 32, 18);
		lblAge.setFont(new Font("Times New Roman", Font.BOLD, 15));
		
		textname = new JTextField();
		textname.setBounds(143, 48, 106, 24);
		textname.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		textname.setText("Type..");
		textname.setBackground(new Color(0, 0, 0));
		textname.setForeground(Color.WHITE);
		textname.setColumns(10);
		textname.addFocusListener(new MyFocusListener());
		
		textemail = new JTextField();
		textemail.setBounds(143, 83, 106, 24);
		textemail.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		textemail.setText("Type..");
		textemail.setForeground(Color.WHITE);
		textemail.setBackground(new Color(0, 0, 0));
		textemail.setColumns(10);
		textemail.addFocusListener(new MyFocusListener());
		
		textage = new JTextField();
		textage.setBounds(143, 147, 106, 24);
		textage.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		textage.setText("Type..");
		textage.setForeground(Color.WHITE);
		textage.setBackground(new Color(0, 0, 0));
		textage.setColumns(10);
		textage.addFocusListener(new MyFocusListener());
		
		
		
		textusername = new JTextField();
		textusername.setBounds(143, 182, 106, 24);
		textusername.setBackground(Color.BLACK);
		textusername.setForeground(Color.WHITE);
		textusername.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		textusername.setText("Type..");
		textusername.setColumns(10);
		textusername.addFocusListener(new MyFocusListener());
		
		textpassword = new JPasswordField();
		textpassword.setBounds(143, 216, 106, 24);
		textpassword.setBackground(Color.BLACK);
		textpassword.setForeground(Color.WHITE);
		textpassword.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		textpassword.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(57, 185, 72, 18);
		lblUsername.setFont(new Font("Times New Roman", Font.BOLD, 15));
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(62, 219, 67, 18);
		lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 15));
		
		
		
		JLabel lblPhone = new JLabel("Phone:");
		lblPhone.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblPhone.setBounds(83, 125, 46, 14);
		
		
		textphone = new JTextField();
		textphone.setForeground(Color.WHITE);
		textphone.setBackground(Color.BLACK);
		textphone.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		textphone.setText("Type..");
		textphone.setBounds(143, 116, 106, 23);
		textphone.setColumns(10);
		textphone.addFocusListener(new MyFocusListener());
		
		JButton btnComplete = new JButton("Complete");
		btnComplete.setBounds(143, 258, 106, 37);
		btnComplete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  
				  String name,email,phone,age,username,password;
				  name = textname.getText();
				  email = textemail.getText();
				  age = textage.getText();
				  username = textusername.getText();
				  password = textpassword.getText();
				  phone = textphone.getText();
				  boolean flag = false;
				  for(User aUser: Main.data.getuList())
				  {
					  if(aUser.getUserName().equals(username))
					  {
						  flag = true;
						  break;
					  }
				  }
				  if(username.equals("")||password.equals("")||name.equals("")||email.equals("")||age.equals("")||phone.equals(""))
				  {
					  JOptionPane.showMessageDialog(null,"Complete all the fields" );
				  }else
				  {
				  
					  if(flag)
					  {
						  JOptionPane.showMessageDialog(null,"Username Exist's, type an other one" );
					  }else
					  {
						  JComponent comp = (JComponent) e.getSource();
						  Window win = SwingUtilities.getWindowAncestor(comp);
						  win.dispose();
						  
						  Main.data.addUser(new Candidate(username, name, password,email,
								  Integer.parseInt(age), null, phone));
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
				  }
			}
		});
		btnComplete.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnComplete.setForeground(Color.WHITE);
		btnComplete.setBackground(Color.BLACK);
		btnComplete.setBorderPainted(false);
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(lblPersonalInfo);
		contentPane.add(lblPassword);
		contentPane.add(lblUsername);
		contentPane.add(lblName);
		contentPane.add(lblEmail);
		contentPane.add(lblAge);
		contentPane.add(textemail);
		contentPane.add(textname);
		contentPane.add(textage);
		contentPane.add(textusername);
		contentPane.add(textpassword);
		contentPane.add(btnComplete);
		contentPane.add(lblPhone);
		contentPane.add(textphone);
		
		icon = new ImageIcon("icon.png");
		this.setIconImage(icon.getImage());
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
}
class MyFocusListener extends FocusAdapter {
	   public void focusGained(FocusEvent fEvt) {
	      JTextComponent component = (JTextComponent) fEvt.getSource();
	      component.selectAll();
	   }
	}
