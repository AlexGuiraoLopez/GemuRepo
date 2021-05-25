package visualfront;

import datacontrol.DataControl;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/** 
 * Clase para gestionar el color de las filas de la tabla de videojuegos que se muestra en la ventana principal.
 * @author Alex Guirao López <aguiraol2021@cepnet.net>
 */
public class RowColor extends DefaultTableCellRenderer
{  
    private final Color ROW_COLOR= new Color(49,247,188);
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean hasFocus, int row, int col)
    {
        super.getTableCellRendererComponent(table, value, selected, hasFocus, row, col);
    
        if (DataControl.gameList.get(row).getCompleted()==1)
            {
                setBackground(ROW_COLOR);
            }else{
                setBackground(null);
            }
        
        return this;
    }
    
}
