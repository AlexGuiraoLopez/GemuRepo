package visualfront;

import datacontrol.DataControl;
import java.util.ArrayList;
import elements.Videogame;
/**
 * Ventana con las estadísticas de la colección.
 * @author Alex Guirao López  <alexguiraolopez@gmail.com>
 */
public class Statistics extends javax.swing.JDialog 
{
    public Statistics(java.awt.Frame parent, boolean modal) 
    {
        super(parent, modal);
        initComponents();
         this.getRootPane().setDefaultButton(btnExit); //Permite accionar el botón con la tecla intro.
        lblTotal.setText(Integer.toString(DataControl.gameList.size()));
        lblPercentage.setText(String.format("%.2f", getCompletedPercentage())+"%");
        setIconImage(WindowControl.appIcon.getImage());
        setTitle("Statistics");
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * Calcula el porcentaje de juegos completados.
     * @return porcentaje de juegos completados.
     */
    public float getCompletedPercentage()
    {
        float percentage=0f;
        ArrayList<Videogame> gameList =DataControl.gameList;
        int total=gameList.size();
        int completed=0;
        
        if (total!=0)
        {
            for(Videogame v: gameList)
            {
                if (v.getCompleted()==1)
                {
                    completed++;
                }
            }

            percentage = ((float)completed/total)*100;
        }
        
        return percentage;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        lblPercentage = new javax.swing.JLabel();
        btnExit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel1.setText("<HTML><U>Total games</U><HTML>");

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel2.setText("<HTML><U>Completed percentage</U><HTML>");

        lblTotal.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblTotal.setText("jLabel3");

        lblPercentage.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblPercentage.setText("jLabel3");

        btnExit.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnExit.setText("Exit");
        btnExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnExitMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(117, 117, 117)
                            .addComponent(lblPercentage)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lblTotal)
                                .addGap(8, 8, 8)))))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTotal)
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPercentage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(btnExit)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseClicked
        setVisible(false);
    }//GEN-LAST:event_btnExitMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblPercentage;
    private javax.swing.JLabel lblTotal;
    // End of variables declaration//GEN-END:variables
}
