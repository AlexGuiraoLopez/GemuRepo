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
import filecontrol.CompanyFileControl;
import filecontrol.ConsoleFileControl;
import filecontrol.UserFileControl;
import filecontrol.VideogameFileControl;

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
        
        //Consulta los archivos binarios para obtener los datos de cada uno de los elementos del programa.
        DataControl.userList=UserFileControl.read();
        DataControl.gameList=VideogameFileControl.read();
        DataControl.companyList=CompanyFileControl.read();
        DataControl.consoleList=ConsoleFileControl.read();
            
        new Login();
         
    }
}
