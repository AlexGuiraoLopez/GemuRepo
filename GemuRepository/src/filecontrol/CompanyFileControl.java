package filecontrol;

import elements.Company;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.util.ArrayList;
import visualfront.ConsoleColors;

/**
 * Libreria para controlar la comunicación con el archivo binario que da persistencia de datos
 * para las consolas que se registran en el programa.
 * @author Alex Guirao López <alexguiraolopez@gmail.com>
 */
public class CompanyFileControl 
{
    public final static String PATH="datafiles/companies.bin";
    
        /**
         * @return cantidad de registros de compañías que hay en el archivo binario. 
         */
        public static int getRecordAmount()
        {
            return (int)new File(PATH).length()/Company.getRecordSize();
        }
    
        /**
         * Escribe de una lista local hacia el archivo binario para que se mantenga al iniciar de nuevo el programa.
         * @param list lista de usuarios a escribir.
         */
       public static void write(ArrayList<Company> list)
       {
            File file = new File(PATH);
        
            try 
            {
                RandomAccessFile raf = new RandomAccessFile(file, "rw");

                for (Company c:list)
                {
                    raf.write(c.getFormattedName().getBytes(Charset.defaultCharset()));
                }

                raf.close();

            } catch (IOException ex) {
                System.out.println(ConsoleColors.RED+"No se pudo acceder al archivo");
                ex.printStackTrace();
            }
        }
      
       /**
        * Lee el archivo binario de compañías y retorna una lista local para trabajar dentro del programa
        * @return lista de compañías con los datos del archivo binario.
        */
       public static ArrayList<Company> read()
       {
        ArrayList<Company> list = new ArrayList();
        
        File file = new File(PATH);
        if (file.exists()&&getRecordAmount()>0)
        {
            int recordAmount=getRecordAmount();

            byte[] bName;
            String name;
            RandomAccessFile raf;
            try {
                raf = new RandomAccessFile(file,"r");
                for (int i = 0; i<recordAmount;i++)
                {
                    bName= new byte[Company.MAX_NAME_LENGTH];
                    raf.read(bName);
                    name=new String(bName).trim();
                    list.add(new Company(name));
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
     * Elimina los datos del archivo binario de usuarios.
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
