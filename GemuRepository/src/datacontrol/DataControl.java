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
    public static boolean saved=true;
}
