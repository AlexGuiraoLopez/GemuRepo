package filecontrol;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import time.Date;
import videogame.Videogame;
import visualfront.ConsoleColors;

/** 
 * @author Alex Guirao Lopez <aguiraol2021@cepnet.net>
 */
public class FileControl 
{
    public final static String PATH="datafiles/videogame.bin";

    public static int getRecordAmount(){
        return (int)new File(PATH).length()/Videogame.getRecordSize();
    }
    
    public static void write(ArrayList<Videogame> list){
        File file = new File(PATH);
        
        try {
            RandomAccessFile raf = new RandomAccessFile(file, "rw");
            
            for (Videogame v:list){
                raf.write(v.getFormattedTitle().getBytes(Charset.defaultCharset()));
                raf.write(v.getFormattedCompany().getBytes(Charset.defaultCharset()));
                raf.write(v.getFormattedGameConsole().getBytes(Charset.defaultCharset()));
                raf.write(v.getFormattedGameConsole().getBytes(Charset.defaultCharset()));
                raf.writeByte(v.getReleaseDate().getYear());
                raf.writeByte(v.getReleaseDate().getMonth());
                raf.writeByte(v.getReleaseDate().getDay());
            }
            
            raf.close();
            
        } catch (IOException ex) {
            System.out.println(ConsoleColors.RED+"No se pudo acceder al archivo");
            ex.printStackTrace();
        }
        
    }

    public static ArrayList<Videogame> read(){
        ArrayList list = new ArrayList();
        File file = new File(PATH);
        int recordAmount=getRecordAmount();
        
        byte[] bName;
        String title;
        String company;
        String gameConsole;
        byte year;
        byte month;
        byte day;
        
        RandomAccessFile raf;
        try {
            raf = new RandomAccessFile(file,"r");
            for (int i = 0; i<recordAmount;i++){
                bName= new byte[Videogame.TITLE_MAX_LENGTH];
                raf.read(bName);
                title=new String(bName);
                
                bName= new byte[Videogame.COMPANY_MAX_LENGTH];
                raf.read(bName);
                company=new String(bName);
                
                bName= new byte[Videogame.GAME_CONSOLE_MAX_LENGTH];
                raf.read(bName);
                gameConsole=new String(bName);
                
                year=raf.readByte();
                month=raf.readByte();
                day=raf.readByte();
               
                list.add(new Videogame(title,company,gameConsole,new Date(year,month,day)));
            }
            
            raf.close();
        } catch (FileNotFoundException ex) {
            System.out.println(ConsoleColors.RED+"No se pudo encontrar el archivo.");
            ex.printStackTrace();
        }catch (IOException ex){
            System.out.println(ConsoleColors.RED+"No se pudo acceder al archivo.");
            ex.printStackTrace();
        }
        
        

        
        
        return list;
    }



}
