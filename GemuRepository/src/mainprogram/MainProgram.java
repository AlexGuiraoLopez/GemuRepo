package mainprogram;

import database.Database;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import visualfront.ConsoleColors;
import visualfront.Login;
import visualfront.MainWindow;
import visualfront.ErrorWindow;
import datacontrol.DataControl;

/**
 * @author Alex Guirao Lopez <aguiraol2021@cepnet.net>
 */
public class MainProgram 
{
    public static void main(String[] args) 
    {
        //Comprueba el estado del driver para conectar a la base de datos. 
        try { 
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");     
            System.out.println("Driver funciona correctamente."); 
        }catch (ClassNotFoundException e) {
            System.out.println("Error: " + e.getMessage()); 
        }
        
        //Realiza la conexión a la base de datos y empieza el flujo principal del programa.
        try {
            System.out.println("Comprobando conexión...");
            Database db = new Database();
            DataControl.userList=db.getUserList();
            DataControl.gameList=db.getVideogameList();
            DataControl.companyList=db.getCompaniesList();
            DataControl.consoleList=db.getConsoleList();
            
            //new Login();
            new MainWindow();
         
            db.close();
        }
        catch (SQLException ex) 
        {
            ErrorWindow error = new ErrorWindow();
            System.out.println(ConsoleColors.RED+"Algo salió mal con la base de datos");
            ex.printStackTrace();
        }
    }
}
