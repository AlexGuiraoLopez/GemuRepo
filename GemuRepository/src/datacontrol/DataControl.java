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
    
    /*Se ha actualizado toda la lista de datos. */
    public static boolean refresh=false; 
    
}
