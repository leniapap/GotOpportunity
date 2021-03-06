import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

//frame me tous ipopsifious mias job offer pou exei ksexorisei kathe company kai dinatotita sigkrisis tous
public class ShortListFrame extends JFrame {

		private JPanel contentPane;
		private JTable table;
		private ImageIcon icon;

		public ShortListFrame(Company aComp,JobOffer aJobOffer) {
			setBounds(100, 100, 1200, 450);
			contentPane = new JPanel();
			contentPane.setBackground(Color.WHITE);
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			contentPane.setLayout(null);
			setContentPane(contentPane);
	
			
			setFont(new Font("Arial", Font.BOLD, 12));
			
			
			icon = new ImageIcon("icon.png");
			
			JLabel lblShortList = new JLabel("Short List of: "+aJobOffer.getOfferName());
			lblShortList.setFont(new Font("Courier", Font.BOLD | Font.ITALIC, 20));
			lblShortList.setBounds(10, 11, 497, 28);setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			contentPane.add(lblShortList);
			
	
			JScrollPane scrollPaneOfShortList = new JScrollPane();
			scrollPaneOfShortList.setForeground(Color.WHITE);
			scrollPaneOfShortList.setBackground(Color.WHITE);
			scrollPaneOfShortList.setBounds(10, 50, 1161, 164);
			contentPane.add(scrollPaneOfShortList);
			
	
			table = new JTable();
			table.setBackground(Color.WHITE);
			table.setFont(new Font("Courier", Font.BOLD, 12));
			scrollPaneOfShortList.setViewportView(table);
			Object[] columns={"Name", "Age", "Degree Grade", "Education Level", "Programming Languages", "Work Experience", "Software Knowledge", "Foreign Languages"};
			DefaultTableModel dtm = new DefaultTableModel();
			dtm.setColumnIdentifiers(columns);
			Object[] row= new Object[8];
			for(Candidate cand: aJobOffer.getShortList())
			{
				row[0]= cand.getFullName();
				row[1]= cand.getAge();
				row[2]= cand.getDegreeGrade();
				row[3]= cand.getEducationLevel();
				row[4]= cand.getProgrammingLanguages();
				row[5]= cand.getWorkExperience();
				row[6]= cand.getSoftwareKnowledge();
				row[7]= cand.getForeignLanguages();
				dtm.addRow(row);
			}
			table.setModel(dtm);
			table.getColumnModel().getColumn(0).setPreferredWidth(30);
			table.getColumnModel().getColumn(1).setPreferredWidth(15);
			table.getColumnModel().getColumn(2).setPreferredWidth(45);
			table.getColumnModel().getColumn(3).setPreferredWidth(45);
			table.getColumnModel().getColumn(5).setPreferredWidth(45);
			

			JLabel lblCompareCandidates = new JLabel("Compare 2 Candidates");
			lblCompareCandidates.setFont(new Font("Courier", Font.BOLD | Font.ITALIC, 20));
			lblCompareCandidates.setBounds(10, 225, 240, 35);
			contentPane.add(lblCompareCandidates);
			
		
			JLabel lblCandidate = new JLabel("Select first ");
			lblCandidate.setFont(new Font("Courier", Font.BOLD, 13));
			lblCandidate.setBounds(10, 271, 88, 28);
			contentPane.add(lblCandidate);
			
			JLabel lblCandidate_1 = new JLabel("Select Second ");
			lblCandidate_1.setFont(new Font("Courier", Font.BOLD, 13));
			lblCandidate_1.setBounds(108, 271, 101, 28);
			contentPane.add(lblCandidate_1);

			JScrollPane scrollPane_1 = new JScrollPane();
			scrollPane_1.setForeground(new Color(0, 0, 0));
			scrollPane_1.setBounds(10, 310, 88, 100);
			contentPane.add(scrollPane_1);
			

			JList listCand1 = new JList();
			scrollPane_1.setViewportView(listCand1);
			listCand1.setForeground(Color.WHITE);
			listCand1.setBackground(Color.BLACK);
			DefaultListModel<String> dlm1 = new DefaultListModel<String>();
			for(Candidate cand : aJobOffer.getShortList())
			{
				dlm1.addElement(cand.getFullName());
			}
			listCand1.setModel(dlm1);
			
		
			JScrollPane scrollPane_2 = new JScrollPane();
			scrollPane_2.setBackground(Color.WHITE);
			scrollPane_2.setForeground(new Color(255, 255, 255));
			scrollPane_2.setBounds(108, 310, 88, 100);
			contentPane.add(scrollPane_2);
			
		
			JList listCand2 = new JList();
			scrollPane_2.setViewportView(listCand2);
			listCand2.setForeground(Color.WHITE);
			listCand2.setBackground(Color.BLACK);
			DefaultListModel<String> dlm2 = new DefaultListModel<String>();
			dlm2=dlm1;
			listCand2.setModel(dlm2);
			
		
			JLabel lblBest = new JLabel("Best:");
			lblBest.setFont(new Font("Times New Roman", Font.BOLD, 15));
			lblBest.setBounds(206, 353, 93, 23);
			contentPane.add(lblBest);
			
			
			JTextPane textBest = new JTextPane();
			textBest.setFont(new Font("Courier", Font.BOLD, 13));
			textBest.setText("         ...");
			textBest.setForeground(new Color(255, 255, 255));
			textBest.setBackground(new Color(0, 0, 0));
			textBest.setBounds(206, 387, 101, 23);
			
	
			JLabel lblMakeAnAppointment = new JLabel("Make an Appointment here:");
			lblMakeAnAppointment.setFont(new Font("Courier", Font.BOLD, 13));
			lblMakeAnAppointment.setBounds(321, 310, 186, 23);
			contentPane.add(lblMakeAnAppointment);
			
			
			JTextPane textAppointment = new JTextPane();
			textAppointment.setFont(new Font("Courier", Font.BOLD, 13));
			textAppointment.setForeground(Color.WHITE);
			textAppointment.setBackground(Color.BLACK);
			textAppointment.setText("                      ...");
			textAppointment.setBounds(317, 387, 190, 23);
			
	
			JButton btnCompare = new JButton("Compare");
			btnCompare.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String name1 =(String) listCand1.getSelectedValue();
					String name2 =(String) listCand2.getSelectedValue();
					Candidate cand1 = null ;
					Candidate cand2 = null ;
					boolean flag1=false,flag2=false;
					for(Candidate cand : aJobOffer.getShortList())
					{
						if(cand.getFullName().equals(name1))
						{
							cand1=cand;
							flag1=true;
							
						}else if(cand.getFullName().equals(name2))
						{
							cand2=cand;
							flag2=true;
						}
						if(flag1&&flag2)
						{
							break;
						}
					}
					if(!(flag1&&flag2))
					{
						JOptionPane.showMessageDialog(null,"Select a different Candidate");
						
					}else
					{
						Candidate bestCand =aJobOffer.compare2Candidates(cand1, cand2);
						textBest.setText(bestCand.getFullName());
						
						
						
					}
				}
			});
			btnCompare.setBorderPainted(false);
			btnCompare.setForeground(new Color(255, 255, 255));
			btnCompare.setBackground(new Color(0, 0, 0));
			btnCompare.setFont(new Font("Courier", Font.BOLD, 13));
			btnCompare.setBounds(206, 307, 101, 23);
			
			contentPane.add(btnCompare);
			contentPane.add(textBest);
			contentPane.add(textAppointment);
			
		
			JButton btnEmail = new JButton("E-mail");
			btnEmail.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String candname = textBest.getText();
					boolean flag = false;
					for(Candidate cand: aJobOffer.getShortList())
					{
						if(cand.getFullName().equals(candname))
						{
							textAppointment.setText("Email: "+cand.getEmail());
							flag= true;
							break;
						}
					}
					if(!flag)
					{
						JOptionPane.showMessageDialog(null, "First Compare 2 Candidates");
					}
				}
			});
			btnEmail.setFont(new Font("Courier", Font.BOLD, 13));
			btnEmail.setForeground(Color.WHITE);
			btnEmail.setBorderPainted(false);
			btnEmail.setBackground(Color.BLACK);
			btnEmail.setBounds(321, 344, 89, 23);
			contentPane.add(btnEmail);
			
			
			JButton btnPhoneNumber = new JButton("Phone");
			btnPhoneNumber.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String candname = textBest.getText();
					boolean flag = false;
					for(Candidate cand: aJobOffer.getShortList())
					{
						if(cand.getFullName().equals(candname))
						{
							textAppointment.setText("Phone: "+cand.getPhoneNumber());
							flag= true;
							break;
						}
					}
					if(!flag)
					{
						JOptionPane.showMessageDialog(null, "First Compare 2 Candidates");
					}
				}
			});
			btnPhoneNumber.setBackground(Color.BLACK);
			btnPhoneNumber.setBorderPainted(false);
			btnPhoneNumber.setFont(new Font("Courier", Font.BOLD, 13));
			btnPhoneNumber.setForeground(Color.WHITE);
			btnPhoneNumber.setBounds(418, 344, 89, 23);
			contentPane.add(btnPhoneNumber);
			
			JButton btnBackToMain = new JButton("Back to Main Menu<-");
			btnBackToMain.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new MainMenuFrame(aComp);
					JComponent comp = (JComponent) e.getSource();
					  Window win = SwingUtilities.getWindowAncestor(comp);
					  win.dispose();
				}
			});
			btnBackToMain.setBorderPainted(false);
			btnBackToMain.setBackground(Color.BLACK);
			btnBackToMain.setForeground(Color.WHITE);
			btnBackToMain.setFont(new Font("Courier", Font.BOLD , 13));
			btnBackToMain.setBounds(771, 11, 177, 33);
			contentPane.add(btnBackToMain);
			
			JButton btnBackTomy = new JButton("Back to \"My JobOffers\"<-");
			btnBackTomy.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new JobOfferDetails(aComp);
					JComponent comp = (JComponent) e.getSource();
					  Window win = SwingUtilities.getWindowAncestor(comp);
					  win.dispose();
				}
			});
			btnBackTomy.setForeground(Color.WHITE);
			btnBackTomy.setBackground(Color.BLACK);
			btnBackTomy.setBorderPainted(false);
			btnBackTomy.setFont(new Font("Courier", Font.BOLD , 13));
			btnBackTomy.setBounds(958, 11, 213, 33);
			contentPane.add(btnBackTomy);
			
			
			
			this.setIconImage(icon.getImage());
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
			this.setVisible(true);
			this.setResizable(false);
			this.setLocationRelativeTo(null);
			this.setTitle("Got Opportunity - Short List of "+aJobOffer.getOfferName()+" Job Offer");
		}
}

