package mainprogram;

import database.Database;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import visualfront.ConsoleColors;
import visualfront.Login;
import visualfront.MainWindow;
import visualfront.TrialFrame;
import datacontrol.DataControl;

/**
 * @author Alex Guirao Lopez <aguiraol2021@cepnet.net>
 */
public class MainProgram 
{
    public static void main(String[] args) 
    {
        /*
        try { 
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");     
            System.out.println("Driver funciona correctamente."); 
        }catch (ClassNotFoundException e) {
            System.out.println("Error: " + e.getMessage()); 
        }
        */
        try {
            Database db = new Database();
            DataControl.userList=db.getUserList();
            DataControl.gameList=db.getVideogameList();
            
            //MainWindow mw = new MainWindow();
            new Login();
            db.close();
        }
        catch (SQLException ex) 
        {
            System.out.println(ConsoleColors.RED+"Algo salió mal con la base de datos");
            ex.printStackTrace();
        }
    }
}
