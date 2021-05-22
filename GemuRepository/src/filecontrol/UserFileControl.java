package filecontrol;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.util.ArrayList;
import user.User;
import visualfront.ConsoleColors;

/** 
 * @author Alex Guirao Lopez <aguiraol2021@cepnet.net>
 */
public class UserFileControl 
{
        public final static String PATH="datafiles/users.bin";

          public static int getRecordAmount(){
            return (int)new File(PATH).length()/User.getRecordSize();
        }
    
       public static void write(ArrayList<User> list)
       {
            File file = new File(PATH);
        
            try 
            {
                RandomAccessFile raf = new RandomAccessFile(file, "rw");

                for (User u:list)
                {
                    raf.write(u.getFormattedUsername().getBytes(Charset.defaultCharset()));
                    raf.write(u.getFormattedPassword().getBytes(Charset.defaultCharset()));
                    raf.write(u.getFormattedEmail().getBytes(Charset.defaultCharset()));
                }

                raf.close();

            } catch (IOException ex) {
                System.out.println(ConsoleColors.RED+"No se pudo acceder al archivo");
                ex.printStackTrace();
            }
        }
      
       public static ArrayList<User> read(){
        ArrayList<User> list = new ArrayList<User>();
        
        File file = new File(PATH);
        if (file.exists()&&getRecordAmount()>0){
            int recordAmount=getRecordAmount();

            byte[] bName;
            String username;
            String password;
            String email;
            RandomAccessFile raf;
            try {
                raf = new RandomAccessFile(file,"r");
                for (int i = 0; i<recordAmount;i++){
                    bName= new byte[User.MAX_NAME_LENGTH];
                    raf.read(bName);
                    username=new String(bName).trim();

                    bName= new byte[User.MAX_PASSWORD_LENGTH];
                    raf.read(bName);
                    password=new String(bName).trim();

                    bName= new byte[User.MAX_EMAIL_LENGTH];
                    raf.read(bName);
                    email=new String(bName).trim();
                    
                    list.add(new User(username,password,email));
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
       
       
       
       public static void delete()
       {
            File file = new File(PATH);
            if (file.exists())
            {
                file.delete();
            }
        }
      
      
      
}
