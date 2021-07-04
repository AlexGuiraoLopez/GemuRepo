package visualfront;

import database.Database;
import datacontrol.DataControl;
import java.sql.SQLException;

/**
 * Ventana con las funciones de conexión con la base de datos.
 * @author Alex Guirao López <alexguiraolopez@gmail.com>
 */
public class DatabaseWindow extends javax.swing.JDialog 
{
    public DatabaseWindow(java.awt.Frame parent, boolean modal) 
    {
        super(parent, modal);
        initComponents();
        setTitle("Database options");
        setIconImage(WindowControl.appIcon.getImage());
        setLocationRelativeTo(null);
        lblError.setVisible(false);
        btnExit.setVisible(false);
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnImport = new javax.swing.JButton();
        btnExport = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnExit = new javax.swing.JButton();
        lblError = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        lblUser = new javax.swing.JLabel();
        txtPassword = new javax.swing.JTextField();
        lblPassword = new javax.swing.JLabel();
        lblLoading = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnImport.setText("Import");
        btnImport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnImportMouseClicked(evt);
            }
        });

        btnExport.setText("Export");
        btnExport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnExportMousePressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel1.setText("Connect to database");

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel2.setText("Choose if you want to import or export data to the database.");

        btnExit.setText("Exit");
        btnExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnExitMouseClicked(evt);
            }
        });

        lblError.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblError.setForeground(new java.awt.Color(255, 0, 0));
        lblError.setText("Cannot connect to database");

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel3.setText("If you import it could override existing data in current database.");

        lblUser.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblUser.setText("Database User");

        lblPassword.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblPassword.setText("Database Password");

        lblLoading.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/loading.gif"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(183, 183, 183)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblLoading, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnExport, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(70, 70, 70)
                                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnImport, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(lblPassword)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtUser, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                                            .addComponent(txtPassword)))
                                    .addGap(170, 170, 170))
                                .addComponent(jLabel3)))
                        .addGap(0, 32, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(173, 173, 173)
                .addComponent(lblError)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblUser)
                .addGap(222, 222, 222))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblLoading, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(28, 28, 28)
                .addComponent(lblUser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblPassword)
                .addGap(3, 3, 3)
                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExport, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnImport, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(lblError)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExportMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExportMousePressed
        try {
            Database db = new Database(txtUser.getText(),txtPassword.getText());
            
            db.deleteAll();
            
            db.insertNewCompanies(DataControl.companyList);
            db.insertNewConsoles(DataControl.consoleList);
            db.InsertNewVideogames(DataControl.gameList);
           
            
            db.close();
            setVisible(false);
        } catch (SQLException ex) {
            System.out.println(ConsoleColors.RED+"No se pudo conectar con la base de datos.");
            ex.printStackTrace();
            lblError.setVisible(true);
            btnExit.setVisible(true);
            btnImport.setVisible(false);
            btnExport.setVisible(false);
        }
    }//GEN-LAST:event_btnExportMousePressed

    private void btnImportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnImportMouseClicked
        try {
            Database db = new Database(txtUser.getText(),txtPassword.getText());
            
            DataControl.companyList=db.getCompaniesList();
            DataControl.consoleList=db.getConsoleList();
            DataControl.gameList=db.getVideogameList();
            
            DataControl.clear=true;
            DataControl.refresh=true;
            DataControl.saved=false;
            
            db.close();
            setVisible(false);
        } catch (SQLException ex) {
            System.out.println(ConsoleColors.RED+"No se pudo conectar con la base de datos.");
            ex.printStackTrace();
            lblError.setVisible(true);
            btnExit.setVisible(true);
            btnImport.setVisible(false);
            btnExport.setVisible(false);
        }
    }//GEN-LAST:event_btnImportMouseClicked

    private void btnExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseClicked
        setVisible(false);
    }//GEN-LAST:event_btnExitMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnExport;
    private javax.swing.JButton btnImport;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblError;
    private javax.swing.JLabel lblLoading;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblUser;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
