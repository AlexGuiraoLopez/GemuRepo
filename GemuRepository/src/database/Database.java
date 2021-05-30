package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import user.User;
import visualfront.ConsoleColors;

/** 
 * @author Alex Guirao López <aguiraol2021@cepnet.net>
 */
public class Database 
{
    private Connection conn;
    
    public Database() throws SQLException{
        String url="jdbc:mysql://localhost/videogameCollection";
        String user="root";
        String password="";
        conn = DriverManager.getConnection(url, user, password);
    }
    
    public void close() throws SQLException
    {
        conn.close();
    }
    
    //==========================USERS===================================
    /**
     * Obtiene la lista de usuarios registrados en el programa desde la base de datos.
     * @return lista de usuarios registrados.
     */
    public ArrayList<User> getUserList()
    {
        ArrayList<User> userList= new ArrayList();
        String query = "Select * from users";
        PreparedStatement ps;
        ResultSet rs;
        
        try {
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            boolean aux=false;
            while (rs.next())
            {
                aux=true;
                String username = rs.getString(1);
                String password = rs.getString(2);
                String email = rs.getString(3);
                userList.add(new User(username, password, email));
            }
            
            if (!aux)
            {
                System.out.println(ConsoleColors.RED+"La lista de usuarios está vacía");
            }
        } 
        catch (SQLException ex) 
        {
            System.out.println(ConsoleColors.RED+"No se ha podido acceder a la tabla de usuarios");
            ex.printStackTrace();
        }
      
        return userList;
    }
    
    /**
     * Añade un nuevo usuario a la base de datos.
     * @param user usuario a añadir.
     */
    public void insertNewUser(User user)
    {
        String query = "Insert into users values (?, ?, ?)";
        
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getEmail());
            
            int rowsChanged=ps.executeUpdate();
            if (rowsChanged!=0)
            {
                System.out.println(ConsoleColors.GREEN+"Se ha insertado " + rowsChanged + " usuario.");
            }else{
                System.out.println(ConsoleColors.RED+"No se insertó ningún usuario");
            }
        } 
        catch (SQLException ex) 
        {
            System.out.println(ConsoleColors.RED+"Hubo un error al insertar un nuevo usuario"+ex);
            ex.printStackTrace();
        }
    }
}
