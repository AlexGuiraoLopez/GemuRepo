package datacontrol;

import filecontrol.UserFileControl;
import filecontrol.VideogameFileControl;
import java.util.ArrayList;
import user.User;
import videogame.Videogame;

/** 
 * @author Alex Guirao López <aguiraol2021@cepnet.net>
 */
public class DataControl 
{
    public static ArrayList<Videogame> gameList=VideogameFileControl.read();
    public static ArrayList<User> userList = UserFileControl.read();
    
    public static boolean saved=true; //Los datos más recientes están guardados en el archivo binario.
    public static boolean recordChanged=false; //Se ha producido algún cambio en un registro de la lista.
    
    public static boolean clear=false;  //Se han eliminado las filas de la tabla.
    public static boolean refresh=false; //La tabla se ha actualizado.
    
}
