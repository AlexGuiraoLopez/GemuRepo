package visualfront;

import datacontrol.DataControl;
import java.awt.Color;
import java.util.Comparator;
import videogame.Videogame;
import localdata.LocalData;

/**
 *
 * @author Alex Guirao López <aguiraol2021@cepnet.net>
 */
public class SortBy extends javax.swing.JDialog {

    private boolean sorted=false;
    MainWindow mw;
    /**
     * Creates new form OrderBy
     */
    public SortBy(MainWindow parent, boolean modal) 
    {
        super(parent, modal);
        initComponents();
        this.mw=parent;
        setTitle("Sort By");
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCompany = new javax.swing.JButton();
        btnConsole = new javax.swing.JButton();
        btnTitle = new javax.swing.JButton();
        btnYear = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnApply = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnCompany.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnCompany.setText("Company");
        btnCompany.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompanyActionPerformed(evt);
            }
        });

        btnConsole.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnConsole.setText("Console");
        btnConsole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsoleActionPerformed(evt);
            }
        });

        btnTitle.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnTitle.setText("Title");
        btnTitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTitleActionPerformed(evt);
            }
        });

        btnYear.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnYear.setText("Year");
        btnYear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnYearActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel1.setText("Sort By");

        btnApply.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnApply.setText("OK");
        btnApply.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApplyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCompany, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnYear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnConsole, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE))
                .addContainerGap(26, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(btnApply, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCompany)
                            .addComponent(btnYear)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnTitle)
                            .addComponent(btnConsole))))
                .addGap(18, 18, 18)
                .addComponent(btnApply)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTitleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTitleActionPerformed
        DataControl.gameList.sort(new Comparator<Videogame>()
        {
            @Override
            public int compare(Videogame t, Videogame t1) 
            {
                int char1 = t.getTitle().toLowerCase().charAt(0);
                int char2 = t1.getTitle().toLowerCase().charAt(0);
                return char1-char2;
            }
        });
        
        sorted=true;
        DataControl.clear=true;
        
        btnTitle.setBackground(Color.green);
        btnConsole.setBackground(null);
        btnCompany.setBackground(null);
        btnYear.setBackground(null);
        
        mw.refreshTable();
    }//GEN-LAST:event_btnTitleActionPerformed

    private void btnConsoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsoleActionPerformed
        DataControl.gameList.sort(new Comparator<Videogame>()
        {
            @Override
            public int compare(Videogame t, Videogame t1) 
            {
                int char1 = t.getGameConsole().toLowerCase().charAt(0);
                int char2 = t1.getGameConsole().toLowerCase().charAt(0);
                return char1-char2;
            }
        });
        
        sorted=true;
        DataControl.clear=true;
        
        btnTitle.setBackground(null);
        btnConsole.setBackground(Color.green);
        btnCompany.setBackground(null);
        btnYear.setBackground(null);
        
        mw.refreshTable();
    }//GEN-LAST:event_btnConsoleActionPerformed

    private void btnCompanyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompanyActionPerformed
        DataControl.gameList.sort(new Comparator<Videogame>()
        {
            @Override
            public int compare(Videogame t, Videogame t1) 
            {
                int char1 = t.getCompany().toLowerCase().charAt(0);
                int char2 = t1.getCompany().toLowerCase().charAt(0);
                return char1-char2;
            }
        });
        
        sorted=true;
        DataControl.clear=true;
        
        btnTitle.setBackground(null);
        btnConsole.setBackground(null);
        btnCompany.setBackground(Color.green);
        btnYear.setBackground(null);
        
        mw.refreshTable();
    }//GEN-LAST:event_btnCompanyActionPerformed

    private void btnYearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnYearActionPerformed
        DataControl.gameList.sort(new Comparator<Videogame>()
        {
            @Override
            public int compare(Videogame t, Videogame t1) 
            {
                int year = t.getYear();
                int year1 = t1.getYear();
                return year-year1;
            }
        });
        
        sorted=true;
        DataControl.clear=true;
        
        btnTitle.setBackground(null);
        btnConsole.setBackground(null);
        btnCompany.setBackground(null);
        btnYear.setBackground(Color.green);
        
        mw.refreshTable();
    }//GEN-LAST:event_btnYearActionPerformed

    private void btnApplyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApplyActionPerformed
       if (sorted)
       {
            DataControl.clear=false;
            DataControl.refresh=true;
       }
        
        setVisible(false);
    }//GEN-LAST:event_btnApplyActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnApply;
    private javax.swing.JButton btnCompany;
    private javax.swing.JButton btnConsole;
    private javax.swing.JButton btnTitle;
    private javax.swing.JButton btnYear;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
