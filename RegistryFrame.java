import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Window;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

//frame eggrafis user
public class RegistryFrame extends JFrame {

	private JPanel contentPane;
	private ImageIcon icon;
	public RegistryFrame() {
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 175, 200);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblSelectType = new JLabel("->Select Type");
		lblSelectType.setFont(new Font("Courier", Font.BOLD, 15));
		
		JButton btnCandidate = new JButton("Candidate");
		btnCandidate.setBorderPainted(false);
		btnCandidate.setForeground(Color.WHITE);
		btnCandidate.setBackground(Color.BLACK);
		btnCandidate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComponent comp = (JComponent) e.getSource();
				  Window win = SwingUtilities.getWindowAncestor(comp);
				  win.dispose();
				new RegistryFrameCandidate();
			}
		});
		btnCandidate.setFont(new Font("Courier", Font.PLAIN, 15));
		
		JButton btnCompany = new JButton("Company");
		btnCompany.setForeground(Color.WHITE);
		btnCompany.setBackground(Color.BLACK);
		btnCompany.setBorderPainted(false);
		btnCompany.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComponent comp = (JComponent) e.getSource();
				  Window win = SwingUtilities.getWindowAncestor(comp);
				  win.dispose();
				new RegistryFrameCompany();
				
			}
		});
		btnCompany.setFont(new Font("Courier", Font.PLAIN, 15));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnCandidate, GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnCompany, GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)))
					.addContainerGap())
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(34, Short.MAX_VALUE)
					.addComponent(lblSelectType)
					.addGap(25))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblSelectType)
					.addGap(18)
					.addComponent(btnCandidate)
					.addGap(11)
					.addComponent(btnCompany)
					.addGap(71))
		);
		contentPane.setLayout(gl_contentPane);
		icon = new ImageIcon("icon.png");
		this.setIconImage(icon.getImage());
		this.setVisible(true);
		this.setTitle("Registry");
		this.setResizable(false);
		this.setLocationRelativeTo(null);
	}

}