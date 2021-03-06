package visualfront;
import datacontrol.DataControl;
import java.sql.Date;
import java.text.SimpleDateFormat;
import elements.Videogame;
/**
 * Ventana para actualizar la información de un videojuego ya introducido.
 * @author Alex Guirao López  <alexguiraolopez@gmail.com>
 */
public class UpdateVideogame extends javax.swing.JDialog 
{
    
    private int row;
    private Videogame videogame;
    
    public UpdateVideogame(java.awt.Frame parent, boolean modal,int row) 
    {
        super(parent, modal);
        initComponents();
         this.getRootPane().setDefaultButton(btnUpdate); //Permite accionar el botón con la tecla intro.
        this.row=row;
        this.videogame=DataControl.gameList.get(row);
        fillVideogameInfo();
        setTitle("Update videogame data");
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * Rellena la información actual del videojuego en sus correspondientes campos de texto.
     */
    public void fillVideogameInfo()
    {
        txtTitle.setText(videogame.getTitle());
        txtCompany.setText(videogame.getCompany());
        txtGameConsole.setText(videogame.getGameConsole());
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        String dateText = sdf.format(videogame.getReleaseYear());
        String year = dateText.substring(0,4);
        String month = dateText.substring(5,7);
        String day = dateText.substring(8,10);
        
        txtYear.setText(year);
        
        if (videogame.getCompleted()==1)
        {
            chkCompleted.setSelected(true);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtTitle = new javax.swing.JTextField();
        txtCompany = new javax.swing.JTextField();
        txtGameConsole = new javax.swing.JTextField();
        txtYear = new javax.swing.JTextField();
        btnUpdate = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        chkCompleted = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        txtTitle.setText("jTextField1");

        txtCompany.setText("jTextField1");

        txtGameConsole.setText("jTextField1");

        txtYear.setText("jTextField1");

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancel");
        btnCancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelMouseClicked(evt);
            }
        });

        chkCompleted.setText("Completed");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnUpdate)
                        .addGap(66, 66, 66)
                        .addComponent(btnCancel))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtYear, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(chkCompleted))
                            .addComponent(txtGameConsole)
                            .addComponent(txtCompany)
                            .addComponent(txtTitle))))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(txtTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtCompany, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtGameConsole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chkCompleted))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdate)
                    .addComponent(btnCancel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        videogame.setTitle(txtTitle.getText());
        videogame.setCompany(txtCompany.getText());
        videogame.setGameConsole(txtGameConsole.getText());
        
        videogame.setReleaseYear(Integer.parseInt(txtYear.getText().toString()));
        
        if (chkCompleted.isSelected())
        {
            videogame.setCompleted(1);
        }else{
            videogame.setCompleted(0);
        }
        
        DataControl.clear=true;
        DataControl.refresh=true;
        DataControl.saved=false;
        setVisible(false);
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnCancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelMouseClicked
        setVisible(false);
    }//GEN-LAST:event_btnCancelMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JCheckBox chkCompleted;
    private javax.swing.JTextField txtCompany;
    private javax.swing.JTextField txtGameConsole;
    private javax.swing.JTextField txtTitle;
    private javax.swing.JTextField txtYear;
    // End of variables declaration//GEN-END:variables
}
