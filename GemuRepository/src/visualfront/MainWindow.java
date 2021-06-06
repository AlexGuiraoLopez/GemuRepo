package visualfront;

import localdata.LocalData;
import database.Database;
import datacontrol.DataControl;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.Comparator;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.Timer;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import videogame.Videogame;
import time.Time;
import visualfront.UpdateVideogame;

/**
 * @author Alex Guirao López <aguiraol2021@cepnet.net>
 */
public class MainWindow extends javax.swing.JFrame implements ActionListener
{
    Timer timer;
    private static final int DELAY=60;
    int selectedRow=-1; //Número de fila seleccionada.
    
    RowColor rc = new RowColor(); //Renderer personalizado para las propiedades de la tabla.
    
    /**
     * Creates new form MainWindow
     */
    public MainWindow() 
    {
        initComponents();
        createWindowListener();
        //Cambia el renderer de la tabla para colorear las filas segun el estado del videojuego.
        tblList.setDefaultRenderer(tblList.getColumnClass(0), rc); 
        setTitle(LocalData.NAME);
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
        Object rowData [] = new Object[5];
        for (int i = 0; i<DataControl.gameList.size();i++)
        {
            ImageIcon icon = new ImageIcon("assets\\icon\\edit.png");
            
            rowData[0]= new JButton(icon);
            rowData[1]= DataControl.gameList.get(i).getTitle();
            rowData[2]= DataControl.gameList.get(i).getGameConsole();
            rowData[3]= DataControl.gameList.get(i).getCompany();
            rowData[4]= DataControl.gameList.get(i).getReleaseDate();
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
        Object rowData [] = new Object[5];
        int lastPos = DataControl.gameList.size()-1;
        
        ImageIcon icon = new ImageIcon("assets\\icon\\edit.png");
            
        rowData[0]= new JButton(icon);
        rowData[1]= DataControl.gameList.get(lastPos).getTitle();
        rowData[2]= DataControl.gameList.get(lastPos).getGameConsole();
        rowData[3]= DataControl.gameList.get(lastPos).getCompany();
        rowData[4]= DataControl.gameList.get(lastPos).getReleaseDate();
        model.addRow(rowData);
    }
    
    public void deleteRow()
    {
        if (selectedRow!=-1)
        {
            DataControl.gameList.remove(selectedRow);
            DataControl.clear=true;
            DataControl.refresh=true;
            DataControl.saved=false;
        }
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
     * Actualiza la tabla para que coincida con los datos de la lista actuales.
     */
    public void refreshTable()
    {
        DataControl.refresh=true;
        tblList.repaint();
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
                    selectedRow = model.getMinSelectionIndex();
                    imgGameCase.setIcon(new ImageIcon("assets/caseImage/"+DataControl.gameList.get(selectedRow).getImage()));
                }
            }
        });
    }
    
        
    //========================WINDOW FUNCTIONS=========================
    public void createWindowListener()
    {
        JFrame mainWindow = this;
        
        this.addWindowListener( new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)
            {
                if (!DataControl.saved)
                {
                    System.out.println("yes");
                    new ExitSave(mainWindow, true);
                }
            }
        });
    }
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
        mnuDelete = new javax.swing.JMenu();
        mnuSave = new javax.swing.JMenu();
        mnuStatistics = new javax.swing.JMenu();
        mnuSort = new javax.swing.JMenu();
        mnuErase = new javax.swing.JMenu();
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
                "Edit", "Title", "Console", "Company", "Release Year"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
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
        tblList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblListMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblList);
        if (tblList.getColumnModel().getColumnCount() > 0) {
            tblList.getColumnModel().getColumn(0).setResizable(false);
            tblList.getColumnModel().getColumn(0).setPreferredWidth(10);
            tblList.getColumnModel().getColumn(1).setResizable(false);
            tblList.getColumnModel().getColumn(1).setPreferredWidth(200);
            tblList.getColumnModel().getColumn(2).setResizable(false);
            tblList.getColumnModel().getColumn(3).setResizable(false);
            tblList.getColumnModel().getColumn(4).setResizable(false);
        }

        imgGameCase.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mainImage.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 562, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(imgGameCase))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imgGameCase, javax.swing.GroupLayout.PREFERRED_SIZE, 660, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1615, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        mnuDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/minus.png"))); // NOI18N
        mnuDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnuDeleteMouseClicked(evt);
            }
        });
        jMenuBar1.add(mnuDelete);

        mnuSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/floppyPixel.png"))); // NOI18N
        mnuSave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                mnuSaveMousePressed(evt);
            }
        });
        jMenuBar1.add(mnuSave);

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

        mnuErase.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/warning.png"))); // NOI18N
        mnuErase.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                mnuEraseMousePressed(evt);
            }
        });
        jMenuBar1.add(mnuErase);

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
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 658, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnuSaveMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuSaveMousePressed
        new SaveData(this,true);
    }//GEN-LAST:event_mnuSaveMousePressed

    private void mnuAddVideogameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuAddVideogameActionPerformed
        
    }//GEN-LAST:event_mnuAddVideogameActionPerformed

    private void mnuAddVideogameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuAddVideogameMouseClicked
       AddVideogame av = new AddVideogame(this, true);
    }//GEN-LAST:event_mnuAddVideogameMouseClicked

    private void mnuStatisticsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuStatisticsMouseClicked
       new Statistics(this, true);
    }//GEN-LAST:event_mnuStatisticsMouseClicked

    private void mnuEraseMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuEraseMousePressed
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
      
        new SortBy(this,true);
    }//GEN-LAST:event_mnuSortMouseClicked

    private void mnuDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuDeleteMouseClicked
        deleteRow();
    }//GEN-LAST:event_mnuDeleteMouseClicked

    private void tblListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListMouseClicked
        
        /*Al clicar en la tabla quiero detectar el punto exacto donde se ha realizado el click.
        Para eso voy a obtener 2 ejes*/
        int column = tblList.getColumnModel().getColumnIndexAtX(evt.getX()); //Obtén el índice de la columna donde el click
        int row = evt.getY()/tblList.getRowHeight(); //Obtén la fila donde el click
        
        //Comprueba límites de ltabla.
        if (row < tblList.getRowCount() && row >=0 && column < tblList.getColumnCount() && column >= 0)
        {
            Object value = tblList.getValueAt(row, column); //Obtén el objeto del click
            if (value instanceof JButton)   //Si es un botón...
            {
                ((JButton)value).doClick(); //Haz un click "virtual" en el botón
                JButton btn = (JButton) value;
                new UpdateVideogame(this,true,row);
            }
        }
        
    }//GEN-LAST:event_tblListMouseClicked
    /*
    public JTable getTableList()
    {
        return tblList;
    }
    */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel imgGameCase;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenu mnuAddVideogame;
    private javax.swing.JMenu mnuDelete;
    private javax.swing.JMenu mnuErase;
    private javax.swing.JMenu mnuOff;
    private javax.swing.JMenu mnuSave;
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
            DataControl.clear=false;
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
