package datacontrol;

import database.Database;
import elements.Company;
import elements.Console;
import filecontrol.UserFileControl;
import filecontrol.VideogameFileControl;
import java.util.ArrayList;
import elements.User;
import elements.Videogame;

/** 
 * Librería con las variables de control que se utilizan en distintas clases del programa.
 * @author Alex Guirao López <aguiraol2021@cepnet.net>
 */
public class DataControl 
{
    /*Listas locales para trabajar dentro del programa. 
    * Los datos no se guardan en el archivo binario sin que el usuario seleccione la opción de guardado.
    * Al iniciar el programa, los datos de los archivos binarios son transferidos a las listas locales para
    * trabajar con ellas durante la ejecución del programa.
    */
    //public static ArrayList<Videogame> gameList=VideogameFileControl.read();
    //public static ArrayList<User> userList = UserFileControl.read();
    public static ArrayList<User> userList;
    public static ArrayList<Videogame> gameList;
    public static ArrayList<Company> companyList;
    public static ArrayList<Console> consoleList;
    
    
    public static boolean saved=true; //Los datos más recientes están guardados en el archivo binario.
    public static boolean recordChanged=false; //Se ha producido algún cambio en un registro de la lista.
    
    public static boolean clear=false;  //Se han eliminado las filas de la tabla.
    public static boolean refresh=false; //La tabla se ha actualizado.
    
}
