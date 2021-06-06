/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visualfront;
import localdata.LocalData;
import filecontrol.VideogameFileControl;
import java.util.ArrayList;
import java.sql.Date;
import videogame.Videogame;
import datacontrol.DataControl;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
/**
 * Investigar sobre JDialog.
 * @author Alex Guirao Lopez <aguiraol2021@cepnet.net>
 */
public class AddVideogame extends javax.swing.JDialog {

    private static int counter=0;
    
    public AddVideogame(java.awt.Frame parent, boolean modal) 
    {
        super(parent, modal);
        initComponents();
        initComboBoxes();
        this.getRootPane().setDefaultButton(btnRegister); //Permite accionar el botón con la tecla intro.
        
        setTitle(LocalData.NAME + " - Add Videogame");
        setIconImage(WindowControl.appIcon.getImage());
        
        ImageIcon backgroundImage = new ImageIcon("assets/bckgImage/particleBackground.jpg");
        JLabel background = new JLabel("",backgroundImage,JLabel.CENTER);
        background.setBounds(0,0,1200,500);
        add(background);
        
        
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * Inicia los valores de las combo box para que el usuario pueda
     * seleccionar la compañía y la consola respecto a la compañía 
     * seleccionada.
     */
    private void initComboBoxes()
    {
        //Añade las compañías a la primera combo box.
        for (String s: LocalData.COMPANIES)
        {
            cbCompany.addItem(s);
        }
        
       //Añade las consolas a la segunda combo box (por defecto empiezas siendo las de Nintendo)
        for (String s: LocalData.NINTENDO_CONSOLES)
        {
            cbConsole.addItem(s);
        }
    }
    
    /**
     * Actualiza la combo box de consolas respecto a la que esté seleccionada en la de compañías.
     */
    private void updateConsoleBox()
    {
        cbConsole.removeAllItems(); //Elimina los elementos
        
        switch((String)cbCompany.getSelectedItem())
        {
            case "Nintendo": 
                for (String s: LocalData.NINTENDO_CONSOLES)
                {
                    cbConsole.addItem(s);
                }
                break;
                
            case "Sony":
                for (String s: LocalData.SONY_CONSOLES)
                {
                    cbConsole.addItem(s);
                }
                break;
        }
    }
    
    /**
     * DEBUG: Muestra la lista de videojuegos actual por consola.
     */
    public void showVideogameList()
    {
        for (Videogame v:DataControl.gameList)
        {
            System.out.println(v.toString());
        }
    }
    
    /**
     * Añade un videojuego a la lista local. (Datos no persistentes si no se guardan manualmente)
     */
    private void addVideogame() 
    {
        String title=txtTitle.getText();
        String company=(String)cbCompany.getSelectedItem();
        String gameConsole=(String)cbConsole.getSelectedItem();
        /*Crear tipo DATE*/
        int year=Integer.parseInt(txtYear.getText()); //Obtén año
        int month=Integer.parseInt(txtMonth.getText()); //Obtén mes
        int day=Integer.parseInt(txtDay.getText()); //Obten día
        String date = ""+year + "-" + month + "-" + day; //Concatena los valores en un String
        
        int completed=0;
        if (chkCompleted.isSelected())
        {
            completed=1; //Investigar para guardar valores boolean en un archivo binario (apaño con integer = 1).
        }
        
        DataControl.gameList.add(new Videogame(title, company, gameConsole,  Date.valueOf(date) /*new Date (year,month,day)*/,completed));
        DataControl.saved=false;
        DataControl.recordChanged=true;
        
        //Resetea los campos para añadir otro videojuego sin tener que cerrar la ventana.
        txtTitle.setText("");
        txtDay.setText("");
        txtYear.setText("");
        txtMonth.setText("");
        chkCompleted.setSelected(false);
        
        //DEBUG
        System.out.println(ConsoleColors.GREEN+"¡El videojuego se registró con éxito!");
        showVideogameList();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtTitle = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtYear = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnCancel = new javax.swing.JButton();
        txtMonth = new javax.swing.JTextField();
        txtDay = new javax.swing.JTextField();
        btnRegister = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        chkCompleted = new javax.swing.JCheckBox();
        cbCompany = new javax.swing.JComboBox<>();
        cbConsole = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Title");

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Company");

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Console");

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Release Date");

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("<HTML><U>INSERT VIDEOGAME INFO</U></HTML>");

        btnCancel.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnRegister.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnRegister.setText("Add");
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Completed");

        cbCompany.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCompanyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 107, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(214, 214, 214)
                        .addComponent(jLabel1))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtYear, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDay, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)
                                .addComponent(chkCompleted))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6))
                            .addComponent(txtTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(14, 14, 14)
                                        .addComponent(jLabel2))
                                    .addComponent(cbCompany, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(36, 36, 36)
                                        .addComponent(jLabel3))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(cbConsole, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addComponent(btnRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(112, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(txtTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbCompany, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbConsole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chkCompleted)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegister)
                    .addComponent(btnCancel))
                .addGap(29, 29, 29))
        );

        txtTitle.getAccessibleContext().setAccessibleName("txtTitle");
        txtYear.getAccessibleContext().setAccessibleName("txtYear");
        btnCancel.getAccessibleContext().setAccessibleName("btnRecord");
        txtMonth.getAccessibleContext().setAccessibleName("txtMonth");
        txtDay.getAccessibleContext().setAccessibleName("txtDay");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        setVisible(false);
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
        addVideogame();
    }//GEN-LAST:event_btnRegisterActionPerformed

    private void cbCompanyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCompanyActionPerformed
        updateConsoleBox();
    }//GEN-LAST:event_cbCompanyActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnRegister;
    private javax.swing.JComboBox<String> cbCompany;
    private javax.swing.JComboBox<String> cbConsole;
    private javax.swing.JCheckBox chkCompleted;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField txtDay;
    private javax.swing.JTextField txtMonth;
    private javax.swing.JTextField txtTitle;
    private javax.swing.JTextField txtYear;
    // End of variables declaration//GEN-END:variables
}
