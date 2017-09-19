import java.awt.BorderLayout;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


@SuppressWarnings("serial")
public class WelcomePage extends JFrame
{
	JLabel l;
	JButton b;
	public WelcomePage(String title){
		setTitle(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		setLocationRelativeTo(this);
		setVisible(true);
		
		
		setLayout(new BorderLayout());
		JLabel background=new JLabel(new ImageIcon("realestate.jpg"));
		add(background);
		background.setLayout(new FlowLayout());
		JLabel l1=new JLabel("REAL ESTATE MANAGEMENT SYSTEM");
		final JButton b2=new JButton("Welcome To World of Real Estate");
		background.add(l1);
		background.add(b2);
		b2.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				if(arg0.getSource()==b2)
				{
					LoginPage lp=new LoginPage("Login Page");
					lp.setVisible(true);
					
				}
				
			}
		});
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WelcomePage img=new WelcomePage("Welcome");
		img.setVisible(true);

	}

}
