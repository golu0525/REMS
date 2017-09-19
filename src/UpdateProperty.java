import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;



@SuppressWarnings("serial")
public class UpdateProperty extends javax.swing.JFrame {

    public UpdateProperty(String title) {
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
        b = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Add Property");

        nametxt.setToolTipText("NAME");

        locationtxt.setToolTipText("LOCATION");

        phonetxt.setToolTipText("PHONE NO");

        amounttxt.setToolTipText("AMOUNT(approx)");

        addresstxt.setToolTipText("ADDRESS");

        extrainfotxt.setToolTipText("Extra Info");
        
        areatxt.setToolTipText("AREA");

        categorycb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<Select>", "Commercial Property", "Residential Property"}));
        categorycb.setToolTipText("Select Property");

        specifictypecb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Building", "Commercial Plot", "Godown", "Hotel/Resort", "Office", "Shop", "<Select Specific Type>"}));
        specifictypecb.setToolTipText("Specific Type");

        citycb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Jaipur", "ALwar", "Udaipur", "Kota", "Jodhpur"}));
        citycb.setToolTipText("CITY");

        unitcb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Acres", "inches", "sq.ft", "sq.yd", "bigha" }));
        unitcb.setToolTipText("Unit");

        b.setText("Add");
        b.addActionListener(new java.awt.event.ActionListener() {
            @SuppressWarnings("unused")
			public void actionPerformed(java.awt.event.ActionEvent evt) {
            	String name=nametxt.getText();
        		String phone=phonetxt.getText();
        		String address=addresstxt.getText();
        		String propertyname=(String) categorycb.getSelectedItem();
        		String specifictype=(String) specifictypecb.getSelectedItem();
        		String city=(String) citycb.getSelectedItem();
        		String location=locationtxt.getText();
        		String amounttosell=amounttxt.getText();
        		String area=areatxt.getText();
        		String unit=(String) unitcb.getSelectedItem();
        		String extrainfo=extrainfotxt.getText();

        		String query="insert into sellerproperty values(?,?,?,?,?,?,?,?,?,?,?)";
        		Connection conn=DBInfo.con;
            	int flag=0;
        		try {
        			PreparedStatement ps=conn.prepareStatement(query);
        			ps.setString(1, name);
        			ps.setString(2, phone);
        			ps.setString(3, address);
        			ps.setString(4, propertyname);
        			ps.setString(5, specifictype);
        			ps.setString(6, city);
        			ps.setString(7, location);
        			ps.setString(8, amounttosell);
        			ps.setString(9, area);
        			ps.setString(10, unit);
        			ps.setString(11, extrainfo);
        			flag=ps.executeUpdate();
        			
        			if(name.length()==0 || phone.length()==0 || address.length()==0 || propertyname.length()==0 || city.length()==0 || specifictype.length()==0 || location.length()==0 || amounttosell.length()==0 || area.length()==0 || unit.length()==0 || extrainfo.length()==0)
        			{
        				JOptionPane.showMessageDialog(getParent(), "Please fill all fields", "ERROR", 0);
        			}
        			else{
        				JOptionPane.showMessageDialog(getParent(), "Property Posted", "INFO", JOptionPane.INFORMATION_MESSAGE);
        			}
            }
        		catch(Exception e){
        			e.printStackTrace();
        			}
        		dispose();
        		}
            
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                        .addComponent(unitcb, 0, 94, Short.MAX_VALUE))
                    .addComponent(categorycb, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(extrainfotxt)
                    .addComponent(citycb, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(specifictypecb, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(b, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            java.util.logging.Logger.getLogger(UpdateProperty.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateProperty.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateProperty.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateProperty.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        UpdateProperty up=new UpdateProperty("update");
        up.setVisible(true);
       
    }

                      
    private javax.swing.JTextField addresstxt;
    private javax.swing.JTextField amounttxt;
    private javax.swing.JTextField areatxt;
    private javax.swing.JComboBox<String> categorycb;
    private javax.swing.JComboBox<String> citycb;
    private javax.swing.JTextField extrainfotxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton b;
    private javax.swing.JTextField locationtxt;
    private javax.swing.JTextField nametxt;
    private javax.swing.JTextField phonetxt;
    private javax.swing.JComboBox<String> specifictypecb;
    private javax.swing.JComboBox<String> unitcb;
    // End of variables declaration                   
}

