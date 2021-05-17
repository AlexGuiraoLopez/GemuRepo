package mainprogram;

import filecontrol.FileControl;
import java.util.ArrayList;
import time.Date;
import videogame.Videogame;
import visualfront.Window;

/**
 * @author Alex Guirao Lopez <aguiraol2021@cepnet.net>
 */
public class MainProgram 
{
    public static ArrayList<Videogame> gameList = new ArrayList();
    public static void main(String[] args) 
    {
        gameList=FileControl.read();
        new Window().start();
    }
    
    
    public static void addGame (String title, String company, String console, int year, int month, int day)
    {
        gameList.add(new Videogame(title, company, console, new Date (year,month,day)));
        FileControl.write(gameList);
        
        for (Videogame v: gameList){
            System.out.println(v.toString());
        }
    }
    
}
