import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.*;
//import java.awt.*;
@SuppressWarnings("serial")
public class LoginPage extends JFrame implements ActionListener{

    public LoginPage(String title) {

    	
    	setTitle(title);
    	//setLocationRelativeTo(this);
        jLabel1 = new javax.swing.JLabel(new ImageIcon("realestate2.jpg"));
        l1 = new javax.swing.JLabel();
        l2 = new javax.swing.JLabel();
        t1 = new javax.swing.JTextField();
        forgotl = new javax.swing.JButton();
        passl2 = new javax.swing.JPasswordField();
        loginbtn = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        labelregister = new javax.swing.JLabel();
        registerbtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setBounds(100, 100, 400, 300);

        l1.setText("Username");

        l2.setText("Password");
        
        loginbtn.setText("Login");
        loginbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent ae) {
            	int flag=0;
        		if(ae.getSource()==loginbtn){
        			String s1=t1.getText();
        			char ch[]=passl2.getPassword();
        			String s2=String.copyValueOf(ch);
        			String usertype="";
        			//System.out.println(s1+":::"+s2);
        			Connection conn=DBInfo.con;
        			String query="select * from login where username=? and password=?";
        			//int flag=0;
        			try{
        				PreparedStatement ps=conn.prepareStatement(query);
        				ps.setString(1, s1);
        				ps.setString(2, s2);
        				ResultSet res=ps.executeQuery();
        				while(res.next())
        				{
        					flag=1;
        					usertype=res.getString(3);
        					break;
        				}
        			}
        			catch(Exception e){
        				e.printStackTrace();
        			}
        			if (flag==1 && usertype.equalsIgnoreCase("admin"))
        			{
        				//write some code for AdminSection
        				AdminSection obj=new AdminSection("Admin Panel");
        				obj.setVisible(true);
        			}
        			if (flag==1 && usertype.equalsIgnoreCase("seller"))
        			{
        				//write some code for AdminSection
        				SellerSection obj=new SellerSection("Seller Panel");
        				obj.setVisible(true);
        			}
        			if (flag==1 && usertype.equalsIgnoreCase("Agent"))
        			{
        				//write some code for AdminSection
        				AgentSection obj=new AgentSection("Agent Panel");
        				obj.setVisible(true);
        			}
        			if (flag==1 && usertype.equalsIgnoreCase("Customers"))
        			{
        				//write some code for AdminSection
        				CustomerSection obj=new CustomerSection("Customer Panel");
        				obj.setVisible(true);
        			}
        			if(flag==0){
        				JOptionPane.showMessageDialog(getParent(), "ERROR", "wrong username or password", 0);
        			}
        			t1.setText("");
        			passl2.setText("");
        		}
            }
        });
        forgotl.setText("Forgot Password?");
        forgotl.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(arg0.getSource()==forgotl){
					forgotpass f=new forgotpass("forgot password");
					f.setVisible(true);
				
			}
			}});

        labelregister.setText("Not Register?");

        registerbtn.setText("Register!!!");
        registerbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent ae) {
            	if(ae.getSource()==registerbtn){
        			RegisterPageFinal rp=new RegisterPageFinal("register");
        			rp.setVisible(true);
        		}
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(forgotl)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(l1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(l2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(t1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(passl2, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(labelregister, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(registerbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addComponent(loginbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(110, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(l1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(t1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(l2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passl2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(forgotl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(loginbtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(registerbtn)
                    .addComponent(labelregister))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

   
   
    public static void main(String args[]) {
      
        
                new LoginPage("Login Page").setVisible(true);
            }
       
    

    // Variables declaration - do not modify                     
    private JButton forgotl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel l1;
    private javax.swing.JLabel l2;
    private javax.swing.JLabel labelregister;
    private javax.swing.JButton loginbtn;
    private javax.swing.JPasswordField passl2;
    private javax.swing.JButton registerbtn;
    private javax.swing.JTextField t1;
    // End of variables declaration                   
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
