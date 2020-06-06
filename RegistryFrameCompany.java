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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.text.JTextComponent;

//frame eggrafis company
public class RegistryFrameCompany extends JFrame {

	private JPanel contentPane;
	private JTextField textemail;
	private JTextField textlocation;
	private JTextField textyears;
	private JTextField textname;
	private JTextField textusername;
	private JPasswordField textpassword;
	private ImageIcon icon;
	private JTextArea textphone;

	
	public RegistryFrameCompany() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 350, 379);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		JLabel lblPersonalInfo = new JLabel("Personal Info");
		lblPersonalInfo.setBounds(119, 5, 112, 24);
		lblPersonalInfo.setFont(new Font("Courier", Font.BOLD, 15));
		
		JLabel lblNewLabel = new JLabel("Name:");
		lblNewLabel.setBounds(75, 38, 43, 18);
		lblNewLabel.setFont(new Font("Courier", Font.BOLD, 13));
		
		JLabel lblNewLabel_1 = new JLabel("E-mail:");
		lblNewLabel_1.setBounds(71, 68, 47, 18);
		lblNewLabel_1.setFont(new Font("Courier", Font.BOLD, 13));
		
		JLabel lblNewLabel_2 = new JLabel("Location:");
		lblNewLabel_2.setBounds(56, 98, 62, 18);
		lblNewLabel_2.setFont(new Font("Courier", Font.BOLD, 13));
		
		textemail = new JTextField();
		textemail.setBounds(136, 65, 103, 24);
		textemail.setText("Type..");
		textemail.setForeground(Color.WHITE);
		textemail.setBackground(new Color(0, 0, 0));
		textemail.setFont(new Font("Courier", Font.ITALIC, 13));
		textemail.setColumns(10);
		textemail.addFocusListener(new MyFocusListener2());
		
		textlocation = new JTextField();
		textlocation.setBounds(136, 95, 103, 24);
		textlocation.setText("Type..");
		textlocation.setForeground(Color.WHITE);
		textlocation.setBackground(new Color(0, 0, 0));
		textlocation.setFont(new Font("Courier", Font.ITALIC, 13));
		textlocation.setColumns(10);
		textlocation.addFocusListener(new MyFocusListener2());
		
		textyears = new JTextField();
		textyears.setBounds(136, 130, 103, 24);
		textyears.setText("Type..");
		textyears.setForeground(Color.WHITE);
		textyears.setBackground(new Color(0, 0, 0));
		textyears.setFont(new Font("Courier", Font.ITALIC, 13));
		textyears.setColumns(10);
		textyears.addFocusListener(new MyFocusListener2());
		
		textname = new JTextField();
		textname.setBounds(136, 35, 103, 24);
		textname.setText("Type..");
		textname.setBackground(new Color(0, 0, 0));
		textname.setForeground(Color.WHITE);
		textname.setFont(new Font("Courier", Font.BOLD, 13));
		textname.setColumns(10);
		textname.addFocusListener(new MyFocusListener2());
		
		JButton buttonComplete = new JButton("Complete");
		buttonComplete.setBounds(136, 293, 103, 36);
		buttonComplete.setForeground(Color.WHITE);
		buttonComplete.setBackground(Color.BLACK);
		buttonComplete.setBorderPainted(false);
		buttonComplete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				  String username,name,password,email,location,yearsOfEstablishment,phone;
				  username = textusername.getText();
				  password = textpassword.getText();
				  name = textname.getText();
				  email = textemail.getText();
				  location = textlocation.getText();
				  yearsOfEstablishment = textyears.getText();
				  phone = textphone.getText();
				  
				  if(username.equals("")||password.equals("")||name.equals("")||email.equals("")||location.equals("")||yearsOfEstablishment.equals("")||phone.equals(""))
				  {
					  JOptionPane.showMessageDialog(null,"Fill all the fields" );
				  }else {
					  boolean flag = false;
					  for(User aUser: Main.data.getuList())
					  {
						  if(aUser.getUserName().equals(username))
						  {
							  flag = true;
							  break;
						  }
					  }
					  if(flag)
					  {
						  JOptionPane.showMessageDialog(null,"Username already exists, type another one" );
					  }else
					  {
						  JComponent comp = (JComponent) e.getSource();
						  Window win = SwingUtilities.getWindowAncestor(comp);
						  win.dispose();
						  
						  Main.data.addUser(new Company(username,name,password,email,
								  phone,location,Integer.parseInt(yearsOfEstablishment)));
						  //data entry
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
		buttonComplete.setFont(new Font("Courier", Font.BOLD, 13));
		
		JTextArea txtrYearsOfEstablishment = new JTextArea();
		txtrYearsOfEstablishment.setBounds(15, 127, 103, 38);
		txtrYearsOfEstablishment.setLineWrap(true);
		txtrYearsOfEstablishment.setWrapStyleWord(true);
		txtrYearsOfEstablishment.setTabSize(10);
		txtrYearsOfEstablishment.setRows(2);
		txtrYearsOfEstablishment.setFont(new Font("Courier", Font.BOLD, 13));
		txtrYearsOfEstablishment.setText("Year of Establishment:");
		txtrYearsOfEstablishment.setEditable(false);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(46, 209, 72, 18);
		lblUsername.setFont(new Font("Courier", Font.BOLD, 13));
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(51, 244, 67, 18);
		lblPassword.setFont(new Font("Courier", Font.BOLD, 13));
		
		textusername = new JTextField();
		textusername.setBounds(136, 206, 103, 24);
		textusername.setBackground(Color.BLACK);
		textusername.setForeground(Color.WHITE);
		textusername.setFont(new Font("Courier", Font.ITALIC, 13));
		textusername.setText("Type..");
		textusername.setColumns(10);
		textusername.addFocusListener(new MyFocusListener2());
		
		textpassword = new JPasswordField();
		textpassword.setBounds(136, 241, 103, 24);
		textpassword.setForeground(Color.WHITE);
		textpassword.setBackground(Color.BLACK);
		textpassword.setFont(new Font("Courier", Font.ITALIC,13));
		textpassword.addFocusListener(new MyFocusListener2());
		
		textphone = new JTextArea();
		textphone.setForeground(Color.WHITE);
		textphone.setBackground(Color.BLACK);
		textphone.setFont(new Font("Courier", Font.ITALIC, 13));
		textphone.setText("Type..");
		textphone.setBounds(136, 171, 103, 24);
		textphone.setColumns(10);
		textphone.addFocusListener(new MyFocusListener2());
		
		JLabel lblPhone = new JLabel("Phone:");
		lblPhone.setFont(new Font("Courier", Font.BOLD, 13));
		lblPhone.setBounds(72, 176, 46, 14);
		
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(lblNewLabel);
		contentPane.add(lblNewLabel_1);
		contentPane.add(lblNewLabel_2);
		contentPane.add(textemail);
		contentPane.add(textname);
		contentPane.add(textlocation);
		contentPane.add(lblPersonalInfo);
		contentPane.add(txtrYearsOfEstablishment);
		contentPane.add(lblPassword);
		contentPane.add(lblUsername);
		contentPane.add(textpassword);
		contentPane.add(textusername);
		contentPane.add(textyears);
		contentPane.add(buttonComplete);
		contentPane.add(textphone);
		contentPane.add(lblPhone);
		
		
		
		icon = new ImageIcon("icon.png");
		this.setIconImage(icon.getImage());
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}

}
class MyFocusListener2 extends FocusAdapter {
	   @Override
	   public void focusGained(FocusEvent fEvt) {
	      JTextComponent component = (JTextComponent) fEvt.getSource();
	      component.selectAll();
	   }
	}
