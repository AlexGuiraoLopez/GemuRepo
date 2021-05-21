package datacontrol;

import filecontrol.VideogameFileControl;
import java.util.ArrayList;
import videogame.Videogame;

/** 
 * @author Alex Guirao López <aguiraol2021@cepnet.net>
 */
public class DataControl 
{
    public static ArrayList<Videogame> gameList=VideogameFileControl.read();
}
