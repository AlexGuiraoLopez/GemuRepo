package visualfront;

import appinfo.AppInfo;
import datacontrol.DataControl;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Comparator;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.Timer;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import sun.swing.table.DefaultTableCellHeaderRenderer;
import videogame.Videogame;
import time.Time;

/**
 * @author Alex Guirao López <aguiraol2021@cepnet.net>
 */
public class MainWindow extends javax.swing.JFrame implements ActionListener
{
    Timer timer;
    private static final int DELAY=60;
 
    RowColor rc = new RowColor(); //Renderer personalizado para las propiedades de la tabla.
    
    /**
     * Creates new form MainWindow
     */
    public MainWindow() 
    {
        initComponents();
        //Cambia el renderer de la tabla para colorear las filas segun el estado del videojuego.
        tblList.setDefaultRenderer(tblList.getColumnClass(0), rc); 
        
        setTitle(AppInfo.name);
        setIconImage(WindowControl.appIcon.getImage());
        setLocationRelativeTo(null);
        setVisible(true);
        fillTable();
        listenTableRows();
        setResizable(false);
        startTimer();
        
    }
    
    /**
     * Rellena la tabla con los videojuegos de la lista.
     */
    public void fillTable()
    {
        DefaultTableModel model = (DefaultTableModel) tblList.getModel();
        Object rowData [] = new Object[4];
        for (int i = 0; i<DataControl.gameList.size();i++)
        {
            rowData[0]= DataControl.gameList.get(i).getTitle();
            rowData[1]= DataControl.gameList.get(i).getGameConsole();
            rowData[2]= DataControl.gameList.get(i).getCompany();
            rowData[3]= DataControl.gameList.get(i).getReleaseDate();
            model.addRow(rowData);
            
            DataControl.recordChanged=false;
        }
    }
    
    /**
     * Añade la fila insertada más reciente a la tabla.
     */
    public void addRow()
    {
        DefaultTableModel model = (DefaultTableModel) tblList.getModel();
        Object rowData [] = new Object[4];
        int lastPos = DataControl.gameList.size()-1;
        rowData[0]= DataControl.gameList.get(lastPos).getTitle();
        rowData[1]= DataControl.gameList.get(lastPos).getGameConsole();
        rowData[2]= DataControl.gameList.get(lastPos).getCompany();
        rowData[3]= DataControl.gameList.get(lastPos).getReleaseDate();
        model.addRow(rowData);
    }
    
    /**
     * Limpia la tabla.
     */
    public void clearTable()
    {
        DefaultTableModel model = (DefaultTableModel) tblList.getModel();
        model.setRowCount(0);
    }
    
    /**
     * Muestra la imagen correspondiente al videojuego seleccionado en la lista.
     */
    public void listenTableRows()
    {
        ListSelectionModel model = tblList.getSelectionModel();
        model.addListSelectionListener(new ListSelectionListener() 
        {
            @Override
            public void valueChanged(ListSelectionEvent lse) 
            {
                if (!model.isSelectionEmpty())
                {
                    int selectedRow = model.getMinSelectionIndex();
                    imgGameCase.setIcon(new ImageIcon("assets/caseImage/"+DataControl.gameList.get(selectedRow).getImage()));
                }
            }
        });
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblList = new javax.swing.JTable();
        imgGameCase = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnuAddVideogame = new javax.swing.JMenu();
        mnuErase = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        mnuStatistics = new javax.swing.JMenu();
        mnuSort = new javax.swing.JMenu();
        mnuOff = new javax.swing.JMenu();

        jMenuItem1.setText("jMenuItem1");

        jMenuItem2.setText("jMenuItem2");

        jMenu5.setText("jMenu5");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setForeground(new java.awt.Color(190, 50, 0));

        tblList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title", "Console", "Company", "Release Year"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblList.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblList.setRowHeight(25);
        jScrollPane2.setViewportView(tblList);
        if (tblList.getColumnModel().getColumnCount() > 0) {
            tblList.getColumnModel().getColumn(0).setResizable(false);
            tblList.getColumnModel().getColumn(0).setPreferredWidth(200);
            tblList.getColumnModel().getColumn(1).setResizable(false);
            tblList.getColumnModel().getColumn(2).setResizable(false);
            tblList.getColumnModel().getColumn(3).setResizable(false);
        }

        imgGameCase.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/splatoon2.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(imgGameCase)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1615, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(imgGameCase, javax.swing.GroupLayout.PREFERRED_SIZE, 660, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jMenuBar1.setBackground(new java.awt.Color(204, 204, 255));
        jMenuBar1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        mnuAddVideogame.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cross.png"))); // NOI18N
        mnuAddVideogame.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnuAddVideogameMouseClicked(evt);
            }
        });
        mnuAddVideogame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuAddVideogameActionPerformed(evt);
            }
        });
        jMenuBar1.add(mnuAddVideogame);

        mnuErase.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/minus.png"))); // NOI18N
        mnuErase.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                mnuEraseMousePressed(evt);
            }
        });
        jMenuBar1.add(mnuErase);

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/floppyPixel.png"))); // NOI18N
        jMenu3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenu3MousePressed(evt);
            }
        });
        jMenuBar1.add(jMenu3);

        mnuStatistics.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/data.png"))); // NOI18N
        mnuStatistics.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnuStatisticsMouseClicked(evt);
            }
        });
        jMenuBar1.add(mnuStatistics);

        mnuSort.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/sort.png"))); // NOI18N
        mnuSort.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnuSortMouseClicked(evt);
            }
        });
        jMenuBar1.add(mnuSort);

        mnuOff.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/off.png"))); // NOI18N
        mnuOff.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnuOffMouseClicked(evt);
            }
        });
        jMenuBar1.add(mnuOff);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1026, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 658, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenu3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu3MousePressed
        SaveData sd = new SaveData();
    }//GEN-LAST:event_jMenu3MousePressed

    private void mnuAddVideogameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuAddVideogameActionPerformed
        
    }//GEN-LAST:event_mnuAddVideogameActionPerformed

    private void mnuAddVideogameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuAddVideogameMouseClicked
       AddVideogame av = new AddVideogame(this, true);
    }//GEN-LAST:event_mnuAddVideogameMouseClicked

    private void mnuStatisticsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuStatisticsMouseClicked
       new Statistics(this, true);
    }//GEN-LAST:event_mnuStatisticsMouseClicked

    private void mnuEraseMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuEraseMousePressed
        //setVisible(false);
        EraseData ed = new EraseData(this,true);
        
    }//GEN-LAST:event_mnuEraseMousePressed

    private void mnuOffMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuOffMouseClicked
        if (DataControl.saved)
        {
            System.exit(100);
        }else{
            new ExitSave(this,true);
        }
    }//GEN-LAST:event_mnuOffMouseClicked

    private void mnuSortMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuSortMouseClicked
        /*DataControl.gameList.sort(new Comparator<Videogame>()
        {
            @Override
            public int compare(Videogame t, Videogame t1) 
            {
                int char1 = t.getTitle().charAt(0);
                int char2 = t1.getTitle().charAt(0);
                return char1-char2;
            }
        });
        DataControl.clear=true;
        new ExtraWindow(this,true);
        */
        new SortBy(this,true);
    }//GEN-LAST:event_mnuSortMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel imgGameCase;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenu mnuAddVideogame;
    private javax.swing.JMenu mnuErase;
    private javax.swing.JMenu mnuOff;
    private javax.swing.JMenu mnuSort;
    private javax.swing.JMenu mnuStatistics;
    private javax.swing.JTable tblList;
    // End of variables declaration//GEN-END:variables

    
    //==================TIMER=========================
    public void startTimer()
    {
        /*Inicialización del tiempo*/
        timer = new Timer (DELAY,this); //Investigar el timer.
        timer.start();
    }
            
    @Override
    public void actionPerformed(ActionEvent ae) 
    {
        if (DataControl.clear)
        {
            clearTable();
        }
        
        if (DataControl.recordChanged)
        {
            addRow();
            DataControl.recordChanged=false;
        }
        
        if (DataControl.refresh)
        {
            fillTable();
            DataControl.refresh=false;
        }
    }
}
