package filecontrol;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.sql.Date;
import elements.Videogame;
import visualfront.ConsoleColors;

/** 
 * Libreria para controlar la comunicación con el archivo binario que da persistencia de datos
 * para los videojuegos que el usuario introduce.
 * @author Alex Guirao Lopez  <alexguiraolopez@gmail.com>
 */
public class VideogameFileControl 
{
    public final static String PATH="datafiles/videogames.bin";

    /**
    * @return cantidad de registros de videojuegos que hay en el archivo binario. 
    */
    public static int getRecordAmount()
    {
        return (int)new File(PATH).length()/Videogame.getRecordSize();
    }
    
    /**
    * Escribe una lista local hacia el archivo binario para que se mantenga al iniciar de nuevo el programa.
    * @param list lista de videojuegos a escribir.
    */
    public static void write(ArrayList<Videogame> list){
        File file = new File(PATH);
        
        try {
            RandomAccessFile raf = new RandomAccessFile(file, "rw");
            
            for (Videogame v:list)
            {
                raf.write(v.getFormattedTitle().getBytes(Charset.defaultCharset()));
                raf.write(v.getFormattedCompany().getBytes(Charset.defaultCharset()));
                raf.write(v.getFormattedGameConsole().getBytes(Charset.defaultCharset()));
                raf.writeInt(v.getReleaseYear());
                raf.writeInt(v.getCompleted());
            }
            
            raf.close();
            
        } catch (IOException ex) {
            System.out.println(ConsoleColors.RED+"No se pudo acceder al archivo");
            ex.printStackTrace();
        }
    }

    /**
    * Lee el archivo binario de videojuegos y retorna una lista local para trabajar dentro del programa
    * @return lista de videojuegos con los datos del archivo binario.
    */
    public static ArrayList<Videogame> read()
    {
        ArrayList <Videogame> list = new ArrayList<Videogame>();
        
        File file = new File(PATH);
        if (file.exists()&&getRecordAmount()>0){
            int recordAmount=getRecordAmount();

            byte[] bName;
            String title;
            String company;
            String gameConsole;
            int year;
            int month;
            int day;
            int completed;

            RandomAccessFile raf;
            try {
                raf = new RandomAccessFile(file,"r");
                for (int i = 0; i<recordAmount;i++){
                    bName= new byte[Videogame.TITLE_MAX_LENGTH];
                    raf.read(bName);
                    title=new String(bName).trim();

                    bName= new byte[Videogame.COMPANY_MAX_LENGTH];
                    raf.read(bName);
                    company=new String(bName).trim();

                    bName= new byte[Videogame.GAME_CONSOLE_MAX_LENGTH];
                    raf.read(bName);
                    gameConsole=new String(bName).trim();

                    year=raf.readInt();

                    completed = raf.readInt();
                    
                    list.add(new Videogame(title,company,gameConsole,year,completed));
                }

                raf.close();
            } catch (FileNotFoundException ex) {
                System.out.println(ConsoleColors.RED+"No se pudo encontrar el archivo.");
                ex.printStackTrace();
            }catch (IOException ex){
                System.out.println(ConsoleColors.RED+"No se pudo acceder al archivo.");
                ex.printStackTrace();
            }
        }
        return list;
    }

    /**
     * Elimina los datos del archivo binario de videojuegos.
     */
    public static void delete()
    {
        File file = new File(PATH);
        if (file.exists())
        {
            file.delete();
        }
    }
}
