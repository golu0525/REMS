import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;


@SuppressWarnings("serial")
public class RegisterPageFinal extends javax.swing.JFrame {
    public RegisterPageFinal(String title) {
        setTitle(title);
        jLabel1 = new javax.swing.JLabel();
        rl1 = new javax.swing.JLabel();
        regl1 = new javax.swing.JTextField();
        rl2 = new javax.swing.JLabel();
        regl2 = new javax.swing.JTextField();
        rl3 = new javax.swing.JLabel();
        regl3 = new javax.swing.JTextField();
        rl4 = new javax.swing.JLabel();
        rl5 = new javax.swing.JLabel();
        regl4 = new javax.swing.JTextField();
        rl6 = new javax.swing.JLabel();
        regl5 = new javax.swing.JPasswordField();
        rl7 = new javax.swing.JLabel();
        regl6 = new javax.swing.JPasswordField();
        rl8 = new javax.swing.JLabel();
        rl9 = new javax.swing.JLabel();
        regl7 = new javax.swing.JTextField();
        rl10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        regta = new javax.swing.JTextArea();
        rl11 = new javax.swing.JLabel();
        ComboBox3 = new javax.swing.JComboBox<>();
        rl12 = new javax.swing.JLabel();
        ComboBox4 = new javax.swing.JComboBox<>();
        rl13 = new javax.swing.JLabel();
        regl8 = new javax.swing.JTextField();
        rl14 = new javax.swing.JLabel();
        regl9 = new javax.swing.JTextField();
        bregister = new javax.swing.JButton();
        breset = new javax.swing.JButton();
        ComboBox2 = new javax.swing.JComboBox<>();
        ComboBox1 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("                                             REGISTRATION");

        rl1.setText("Full Name");

       
        rl2.setText("Username");

        

        rl3.setText("DOB");

       

        rl4.setText("Gender");

        rl5.setText("Email Id");

       

        rl6.setText("Password");

        rl7.setText("Re-Password");

        rl8.setText("Usertype");

        rl9.setText("Mobile No");

       

        rl10.setText("Address");

        regta.setColumns(20);
        regta.setRows(20);
        jScrollPane1.setViewportView(regta);

        rl11.setText("Country");

        ComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<Select>", "India", "USA", "France", "England" }));
       

        rl12.setText("City");

        ComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<Select>", "Jaipur", "New Delhi", "Mumbai", "Chennai", "New York", "California" }));

        rl13.setText("State");

       

        rl14.setText("PinCode");

      

        bregister.setText("Register");
        bregister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	String fullname=regl1.getText();
        		String uname=regl2.getText();
        		String dob=regl3.getText();
        		String gender=(String) ComboBox1.getSelectedItem();
        		String email=regl4.getText();
        		String pass=String.copyValueOf(regl5.getPassword());
        		String repass=String.copyValueOf(regl6.getPassword());
        		String utype=(String) ComboBox2.getSelectedItem();
        		String phone=regl7.getText();
        		String address=regta.getText();
        		String country=(String) ComboBox3.getSelectedItem();
        		String city=(String) ComboBox4.getSelectedItem();
        		String state=regl8.getText();
        		String pin=regl9.getText();
        		
        		
        		
        		String query="insert into registration values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        		Connection conn=DBInfo.con;
            	int flag=0;
        		try {
        			PreparedStatement ps=conn.prepareStatement(query);
        			ps.setString(1, fullname);
        			ps.setString(2, uname);
        			ps.setString(3, dob);
        			ps.setString(4, gender);
        			ps.setString(5, email);
        			ps.setString(6, pass);
        			ps.setString(7, repass);
        			ps.setString(8, phone);
        			ps.setString(9, address);
        			ps.setString(10, country);
        			ps.setString(11, city);
        			ps.setString(12, state);
        			ps.setString(13, pin);
        			ps.setString(14, utype);
        			
        			flag=ps.executeUpdate();
        			
        			
        			//else if(!(pass==equals(repass))){
        				
        			//}
        			if(fullname.length()==0 || uname.length()==0 || dob.length()==0 || gender.length()==0 || email.length()==0 || pass.length()==0 || repass.length()==0 || utype.length()==0 || phone.length()==0 || address.length()==0 || country.length()==0 || city.length()==0 || state.length()==0 || pin.length()==0)
        			{
        				JOptionPane.showMessageDialog(getParent(), "Please fill all fields", "ERROR", 0);
        			}
        			else{
        				JOptionPane.showMessageDialog(getParent(), "record inserted", "INFO", JOptionPane.INFORMATION_MESSAGE);
        			}
        			
        			//dispose();
        		}	catch (SQLException e) {
        			// TODO Auto-generated catch block
        			e.printStackTrace();
        		}
        		
        		
        		String query1="insert into login values(?,?,?)";
        		Connection conn1=DBInfo.con;
        		int flags=0;
        		try {
        			PreparedStatement prs=conn1.prepareStatement(query1);
        			prs.setString(1, uname);
        			prs.setString(2, pass);
        			prs.setString(3, utype);
        			flags=prs.executeUpdate();
        			System.out.println(flags+"row inserted");
        			
        			
        			
        			
        			//dispose();
        		} catch (SQLException e) {
        			// TODO Auto-generated catch block
        			e.printStackTrace();
        		}
        		if(flag!=0 && flags!=0)
        		{
        			JOptionPane.showMessageDialog(getParent(), "Record Inserted", "Information", JOptionPane.INFORMATION_MESSAGE);
        		}
        		else{
        			JOptionPane.showConfirmDialog(getParent(), "Fill all fields", "ERROR", 0);
        		}  
        		dispose();
            }
        });

        breset.setText("Reset");
        breset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	regl1.setText("");
            	regl2.setText("");
            	regl3.setText("");
            	regl4.setText("");
            	regl5.setText("");
            	regl6.setText("");
            	regl7.setText("");
            	regl8.setText("");
            	regl9.setText("");
            	regta.setText("");
            	ComboBox1.setSelectedItem("<Select>");
            	ComboBox2.setSelectedItem("<Select>");
            	ComboBox3.setSelectedItem("<Select>");
            	ComboBox4.setSelectedItem("<Select>");
            	
            }
        });
        ComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<Select>", "Customers", "Seller", "Agent" }));

        ComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<Select>", "Male", "Female" }));
      

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rl13, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(regl8, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rl10, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rl7, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(regl6))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rl6, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(regl5))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rl5, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(regl4, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rl2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(regl2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rl1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(regl1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(bregister, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(breset, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rl14, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(regl9, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(rl12, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(ComboBox4, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(rl11, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(ComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(rl8, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(ComboBox2, 0, 160, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(rl9, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(regl7)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(rl4, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(ComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(rl3, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(regl3, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rl1)
                    .addComponent(regl1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rl2)
                    .addComponent(regl2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(regl3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rl3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rl4)
                    .addComponent(ComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rl5)
                    .addComponent(regl4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(regl5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rl6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(regl6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rl7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rl8)
                    .addComponent(ComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rl9)
                    .addComponent(regl7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(rl10)))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rl11)
                    .addComponent(ComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rl12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(regl8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rl13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(regl9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rl14))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bregister, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(breset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>                        

    public static void main(String args[]) {
       
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RegisterPageFinal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegisterPageFinal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegisterPageFinal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegisterPageFinal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
    }

    // Variables declaration - do not modify                     
    private javax.swing.JComboBox<String> ComboBox1;
    private javax.swing.JComboBox<String> ComboBox2;
    private javax.swing.JComboBox<String> ComboBox3;
    private javax.swing.JComboBox<String> ComboBox4;
    private javax.swing.JButton bregister;
    private javax.swing.JButton breset;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField regl1;
    private javax.swing.JTextField regl2;
    private javax.swing.JTextField regl3;
    private javax.swing.JTextField regl4;
    private javax.swing.JPasswordField regl5;
    private javax.swing.JPasswordField regl6;
    private javax.swing.JTextField regl7;
    private javax.swing.JTextField regl8;
    private javax.swing.JTextField regl9;
    private javax.swing.JTextArea regta;
    private javax.swing.JLabel rl1;
    private javax.swing.JLabel rl10;
    private javax.swing.JLabel rl11;
    private javax.swing.JLabel rl12;
    private javax.swing.JLabel rl13;
    private javax.swing.JLabel rl14;
    private javax.swing.JLabel rl2;
    private javax.swing.JLabel rl3;
    private javax.swing.JLabel rl4;
    private javax.swing.JLabel rl5;
    private javax.swing.JLabel rl6;
    private javax.swing.JLabel rl7;
    private javax.swing.JLabel rl8;
    private javax.swing.JLabel rl9;
    // End of variables declaration                   
}
