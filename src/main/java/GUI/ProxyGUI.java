/*
 * Copyright (C) 2017
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package GUI;

import java.awt.Frame;
import DataAccess.GlobalValueSetter;
import java.awt.Color;
import java.util.Arrays;
import javax.swing.BorderFactory;
import javax.swing.JTextField;


public class ProxyGUI extends javax.swing.JDialog {
       
       String delim = ":";
    /**
     * Creates new form ProxyGUI
     * @param owner
     */
    public ProxyGUI(Frame owner) {
        super(owner, true);
        initComponents();
        usernameField.setText(GlobalValueSetter.getProx());
        
    }
       
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        proxyPanel = new javax.swing.JPanel();
        usernameField = new javax.swing.JTextField();
        proxyField = new javax.swing.JTextField();
        portField = new javax.swing.JTextField();
        userLBL = new javax.swing.JLabel();
        passLBL = new javax.swing.JLabel();
        proxLBL = new javax.swing.JLabel();
        portLBL = new javax.swing.JLabel();
        proxyButton = new javax.swing.JButton();
        passwordField = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        setSize(new java.awt.Dimension(0, 0));

        userLBL.setText("Username");

        passLBL.setText("Password");

        proxLBL.setText("Proxy");

        portLBL.setText("Port");

        proxyButton.setText("OK");
        proxyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proxyButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout proxyPanelLayout = new javax.swing.GroupLayout(proxyPanel);
        proxyPanel.setLayout(proxyPanelLayout);
        proxyPanelLayout.setHorizontalGroup(
            proxyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, proxyPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(proxyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(proxLBL, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passLBL)
                    .addComponent(portLBL)
                    .addComponent(userLBL))
                .addGap(18, 18, 18)
                .addGroup(proxyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(usernameField, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                    .addComponent(portField)
                    .addComponent(proxyField)
                    .addComponent(passwordField))
                .addGap(50, 50, 50))
            .addGroup(proxyPanelLayout.createSequentialGroup()
                .addGap(117, 117, 117)
                .addComponent(proxyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        proxyPanelLayout.setVerticalGroup(
            proxyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(proxyPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(proxyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userLBL))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(proxyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passLBL)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(proxyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(proxyField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(proxLBL))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(proxyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(portField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(portLBL))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(proxyButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(proxyPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(proxyPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void proxyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proxyButtonActionPerformed
   GlobalValueSetter arg = new GlobalValueSetter();
    int counter = 0;
    JTextField [] FieldsArr = {usernameField,proxyField,portField};
    
        for (JTextField FieldsArr1 : FieldsArr) {
            counter = counter + mMark_Fields(FieldsArr1, "Please enter required data");
            
        }
        
    if (passwordField.getPassword().length==0) {
        passwordField.setBorder(BorderFactory.createLineBorder(Color.RED));
       
        } else {
        counter++;
        passwordField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        }
    
    if (counter == 4) {
    arg.setProx(usernameField.getText() + delim + Arrays.toString(passwordField.getPassword()) + delim + proxyField.getText()+ delim + portField.getText());
    this.setVisible(false);
    }
    
     
    }//GEN-LAST:event_proxyButtonActionPerformed
    
    private int mMark_Fields(javax.swing.JTextField field, String text){
               if (field.getText().equals("") || field.getText().equals(text)){
               field.setBorder(BorderFactory.createLineBorder(Color.RED));
               field.setText(text);
               return 0;
             } 
                field.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                return 1;
               
    }
    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel passLBL;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JTextField portField;
    private javax.swing.JLabel portLBL;
    private javax.swing.JLabel proxLBL;
    private javax.swing.JButton proxyButton;
    private javax.swing.JTextField proxyField;
    private javax.swing.JPanel proxyPanel;
    private javax.swing.JLabel userLBL;
    private javax.swing.JTextField usernameField;
    // End of variables declaration//GEN-END:variables
}
