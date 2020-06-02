import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.basic.BasicScrollBarUI;

//parathiro emfanisis ton job offer sta opoia exei kanei apply o kathe xristis
public class ApplicationFrame extends JFrame{

	   private JLabel header;
	   private JList<String> offersList;
	   private DefaultListModel<String> model;
	   private JButton backToMenu;
	   private JPanel mainPanel;
	   private JPanel headerPanel;
	   private JPanel middlePanel;
	   private JPanel bottomPanel;
	   private ImageIcon icon; 
	   private ImageIcon image ;
	   private JLabel imageLabel;
	   private ArrayList<JobOffer> anOfferList;
	   
	   public ApplicationFrame(Candidate acand)
	   {
		   mainPanel= new JPanel();
		   mainPanel.setBackground(Color.white);
		   mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
		   model=new DefaultListModel<String>();
		   header=new JLabel("-> My Applications");
		   header.setFont(new Font("Courier",Font.BOLD,20));
		   headerPanel=new JPanel();
		   headerPanel.setBackground(Color.white);
		   headerPanel.add(header);
		   
		   anOfferList=acand.getAppliedJobOffers();
		  
		   offersList = new JList<String>();	
		   JScrollPane scrollPane = new JScrollPane(offersList);
		   UIManager.put("ScrollBar.thumb", new ColorUIResource(Color.white));             
		   scrollPane.getVerticalScrollBar().setUI(new BasicScrollBarUI() );
	
		   offersList.setPreferredSize(new Dimension(150,300));
		   for(JobOffer job: acand.getAppliedJobOffers())
		   {
			  model.addElement(job.getOfferName());
		   }
	
		   offersList.setModel(model);
           //Mouse listener o opoios emfanizei ta stoixeia kathe aggelias me to klik tou xristi
		   offersList.addMouseListener(new MouseListener() {

				@Override
				public void mouseClicked(MouseEvent e) {
					String selected = "";
					JobOffer selectedOffer = null ;
					if(e.getClickCount() == 1) {
						selected = (String) offersList.getSelectedValue();
						for(JobOffer offer : anOfferList) {
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
		   scrollPane.setViewportView(offersList);
		   offersList.setBackground(Color.black);
		   offersList.setForeground(Color.white);
		   middlePanel=new JPanel();
		   middlePanel.setBackground(Color.white);
		   image = new ImageIcon("image.png");
		   imageLabel= new JLabel(image);
		   bottomPanel=new JPanel();
		   bottomPanel.setBackground(Color.white);
		   bottomPanel.add(imageLabel);
		  
		   middlePanel.add(scrollPane);
		   mainPanel.add(headerPanel);
		   mainPanel.add(middlePanel);
		   mainPanel.add(bottomPanel);
		   
		   //koumpi exodou
		   backToMenu=new JButton("Back To Menu");
		   backToMenu.addActionListener(new ActionListener(){
			    public void actionPerformed(ActionEvent e) {
					new MainMenuFrame(acand);
			    	dispose(); 	
			    }
		    });
		   
		   
		   
		   
		  
		   backToMenu.setBackground(Color.black);
		   backToMenu.setForeground(Color.white);
		   middlePanel.add(backToMenu);
		   icon= new ImageIcon("icon.png");
		   
		   
		   this.setContentPane(mainPanel);
		

			this.setIconImage(icon.getImage());
			this.setVisible(true);
			this.setTitle("My Applications");
			this.setSize(300,450);
			this.setLocationRelativeTo(null);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		   
		   
		   
	   }
	   
	   public void dispose() {
			this.setVisible(false);
	}	
	
}
