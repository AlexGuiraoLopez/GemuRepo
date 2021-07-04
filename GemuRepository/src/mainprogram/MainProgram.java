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
import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author Alex Guirao Lopez <aguiraol2021@cepnet.net>
 */
public class MainProgram 
{
    public static void main(String[] args) throws SQLException 
    {
        //Comprueba el estado del driver para conectar a la base de datos. 
       try {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                System.out.println("Driver funciona correctamente");
            } catch (ClassNotFoundException ex) {
                System.out.println("Error al registrar el driver de MySQL: " + ex);
            }
            Connection connection = null;
            // Database connect
            // Conectamos con la base de datos
            connection = DriverManager.getConnection(
                    "jdbc:mysql://85.208.22.148:3306/videogamesCollection",
                    "aresu", "Aresu2020");
            boolean valid = connection.isValid(50000);
            System.out.println(valid ? "TEST OK" : "TEST FAIL");
        } catch (java.sql.SQLException sqle) {
            System.out.println("Error: " + sqle);
            sqle.printStackTrace();
        }
    
  
        //Consulta los archivos binarios para obtener los datos de cada uno de los elementos del programa.
        DataControl.userList=UserFileControl.read();
        DataControl.gameList=VideogameFileControl.read();
        DataControl.companyList=CompanyFileControl.read();
        DataControl.consoleList=ConsoleFileControl.read();
            
        new Login();
         
    }
}
