import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;


@SuppressWarnings("serial")
public class UpdateProperty1 extends javax.swing.JFrame {

    public UpdateProperty1(String title) {
        super(title);

        jLabel1 = new javax.swing.JLabel();
        nametxt = new javax.swing.JTextField();
        locationtxt = new javax.swing.JTextField();
        phonetxt = new javax.swing.JTextField();
        amounttxt = new javax.swing.JTextField();
        addresstxt = new javax.swing.JTextField();
        extrainfotxt = new javax.swing.JTextField();
        areatxt = new javax.swing.JTextField();
        categorycb = new javax.swing.JComboBox<>();
        specifictypecb = new javax.swing.JComboBox<>();
        citycb = new javax.swing.JComboBox<>();
        unitcb = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Customer Details");

        nametxt.setToolTipText("NAME");

        locationtxt.setToolTipText("LOCATION");
        
        phonetxt.setToolTipText("PHONE NO");
       
        amounttxt.setToolTipText("Budget(approx)");

        addresstxt.setToolTipText("ADDRESS");

        extrainfotxt.setToolTipText("Extra Info");
       
        areatxt.setToolTipText("AREA");

        categorycb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"<Select>", "Commercial Property", "Residential Property" }));
        categorycb.setToolTipText("Select Property");

        specifictypecb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<Select Specific Type>", "Building", "Commercial Plot", "Godown", "Hotel/Resort", "Office", "Shop" }));
        specifictypecb.setToolTipText("Specific Type");

        citycb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Jaipur", "ALwar", "Udaipur", "Kota", "Jodhpur" }));
        citycb.setToolTipText("CITY");

        unitcb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Acres", "inches", "sq.ft", "sq.yd", "bigha" }));
        unitcb.setToolTipText("Unit");

        jButton1.setText("update");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if(evt.getSource()==jButton1){
                	Connection conn=DBInfo.con;
                	String name=nametxt.getText();
            		String phone=phonetxt.getText();
            		String address=addresstxt.getText();
            		String propertyname=(String) categorycb.getSelectedItem();
            		String type=(String) specifictypecb.getSelectedItem();
            		String location=locationtxt.getText();
            		String city=(String) citycb.getSelectedItem();
            		String budget=(String) amounttxt.getText();
            		String area=areatxt.getText();
            		String unit=(String) unitcb.getSelectedItem();
            		String extrainfo=extrainfotxt.getText();
            		
            		String query="insert into customerdetail values(?,?,?,?,?,?,?,?,?,?,?)";
            		
            		PreparedStatement ps;
					try {
						ps = conn.prepareStatement(query);
						
						ps.setString(1, name);
	        			ps.setString(2, phone);
	        			ps.setString(3, address);
	        			ps.setString(4, propertyname);
	        			ps.setString(5, type);
	        			ps.setString(6, city);
	        			ps.setString(7, location);
	        			ps.setString(8, budget);
	        			ps.setString(9, area);
	        			ps.setString(10, unit);
	        			ps.setString(11, extrainfo);
	        			
	        			ps.executeUpdate();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					JOptionPane.showMessageDialog(getParent(), "updated!!!", "information", 1);
					dispose();
        			
                }
            }
        });

       

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(amounttxt)
                    .addComponent(nametxt)
                    .addComponent(addresstxt, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(phonetxt)
                    .addComponent(locationtxt)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(areatxt, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(unitcb, 0, 83, Short.MAX_VALUE))
                    .addComponent(categorycb, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(extrainfotxt)
                    .addComponent(citycb, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(specifictypecb, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(nametxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(phonetxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addresstxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(categorycb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(specifictypecb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(citycb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(locationtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(amounttxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(areatxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(unitcb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(extrainfotxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1))
                    
                .addContainerGap(26, Short.MAX_VALUE))
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
            java.util.logging.Logger.getLogger(UpdateProperty1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateProperty1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateProperty1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateProperty1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
      
    }

    // Variables declaration - do not modify                     
    private javax.swing.JTextField addresstxt;
    private javax.swing.JTextField amounttxt;
    private javax.swing.JTextField areatxt;
    private javax.swing.JComboBox<String> categorycb;
    private javax.swing.JComboBox<String> citycb;
    private javax.swing.JTextField extrainfotxt;
    private javax.swing.JButton jButton1;
    
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField locationtxt;
    private javax.swing.JTextField nametxt;
    private javax.swing.JTextField phonetxt;
    private javax.swing.JComboBox<String> specifictypecb;
    private javax.swing.JComboBox<String> unitcb;
    // End of variables declaration                   
}
