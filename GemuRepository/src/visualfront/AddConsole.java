package visualfront;

import database.Database;
import datacontrol.DataControl;
import elements.Company;
import elements.Console;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Ventana para añadir una videoconsola.
 * @author Alex Guirao Lopez  <alexguiraolopez@gmail.com>
 */
public class AddConsole extends javax.swing.JDialog 
{
    public AddConsole(java.awt.Frame parent, boolean modal) 
    {
        super(parent, modal);
        initComponents();
        this.getRootPane().setDefaultButton(btnInsert); //Permite accionar el botón con la tecla intro.
        setTitle("Gemu Repo - Add Console");
        setLocationRelativeTo(null);
        lblError.setVisible(false);
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtConsole = new javax.swing.JTextField();
        btnInsert = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        lblCompany = new javax.swing.JLabel();
        lblConsole = new javax.swing.JLabel();
        txtCompany = new javax.swing.JTextField();
        lblError = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel1.setText("<HTML><U>Insert Console</U></HTML>");

        btnInsert.setText("Insert");
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancel");
        btnCancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelMouseClicked(evt);
            }
        });

        lblCompany.setText("Company");

        lblConsole.setText("Console");

        lblError.setForeground(new java.awt.Color(255, 0, 0));
        lblError.setText("jLabel2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addComponent(lblError))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(lblConsole))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel1)
                            .addComponent(txtCompany)
                            .addComponent(txtConsole))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblCompany)
                .addGap(119, 119, 119))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(62, Short.MAX_VALUE)
                .addComponent(btnInsert, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(lblCompany)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCompany, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblConsole)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtConsole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblError)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInsert)
                    .addComponent(btnCancel))
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
        ArrayList<Company> companyList = DataControl.companyList;
        ArrayList<Console> consoleList = DataControl.consoleList;

        String company = txtCompany.getText();
        String console = txtConsole.getText();

        /*Comprueba si la compañía ya existe en la lista de compañías.
        * En caso de que no exista la añade.
        * Comprueba si la consola existe en la lista de consolas.
        * En caso de que no exista la añade.
        */
        if (!companyList.isEmpty()&&companyList.contains(new Company(company.toUpperCase())))
        {
            if (!consoleList.contains(new Console(console.toUpperCase(),new Company(company.toUpperCase()))))
            {
                DataControl.consoleList.add(new Console (console.toUpperCase(), new Company(company.toUpperCase())));
                DataControl.saved=false;
                setVisible(false);
            }else{
                lblError.setText("Console already exists");
                lblError.setVisible(true);
            }
        }else{
            DataControl.companyList.add(new Company(company.toUpperCase()));
            DataControl.consoleList.add(new Console (console.toUpperCase(), new Company(company.toUpperCase())));
            DataControl.saved=false;
            setVisible(false);
        }
    }//GEN-LAST:event_btnInsertActionPerformed

    private void btnCancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelMouseClicked
        setVisible(false);
    }//GEN-LAST:event_btnCancelMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnInsert;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblCompany;
    private javax.swing.JLabel lblConsole;
    private javax.swing.JLabel lblError;
    private javax.swing.JTextField txtCompany;
    private javax.swing.JTextField txtConsole;
    // End of variables declaration//GEN-END:variables
}
