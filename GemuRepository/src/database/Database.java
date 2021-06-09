package database;

import elements.Company;
import elements.Console;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import elements.User;
import elements.Videogame;
import visualfront.ConsoleColors;

/** 
 * @author Alex Guirao López <aguiraol2021@cepnet.net>
 */
public class Database 
{
    private Connection conn;
    
    public Database() throws SQLException{
        
        String url="jdbc:mysql://localhost/videogamesCollection";
        String user="root";
        String password="";
        /*
        String url="jdbc:sqlserver://85.208.20.43:1433;databaseName=videogamesCollection";
        String user="sa";
        String password="Aresu2020";
        */
        conn = DriverManager.getConnection(url, user, password);
    }
    
    public void close() throws SQLException
    {
        conn.close();
    }
    
    //==========================USERS===================================
    /**
     * Comprueba si un usuario existe en la base de datos por su nombre.
     * @param username nombre del usuario a comprobar.
     * @return TRUE si existe.
     */
    public boolean checkUserExists(String username)
    {
        boolean exists=false;
        String query = "Select * from users where username = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next())
            {
                exists=true;
            }
            
            if (!exists)
            {
                System.out.println(ConsoleColors.RED+"El usuario no existe en la base de datos");
            }
        } 
        catch (SQLException ex) 
        {
            System.out.println(ConsoleColors.RED+"No se pudo acceder a la tabla de usuarios.");
        }
        return exists;
    }
    
    public boolean checkUserPassword(String username, String userPassword)
    {
        boolean match = false;
        String query = "Select password from users where username = ?";
        
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
           
            rs.next();
            String password = rs.getString(1);
            
            if (password.equals(userPassword))
            {
                match=true;
            }
        }
        catch (SQLException ex) 
        {
            System.out.println(ConsoleColors.RED+"No se pudo acceder a la tabla de usuarios.");
            ex.printStackTrace();
        }
        
        return match;
    }
    
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
                System.out.println(ConsoleColors.PURPLE+"La lista de usuarios está vacía");
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
    
    //===========================VIDEOGAMES================================
    /**
     * Obtiene la lista de videojuegos registrados en el programa desde la base de datos.
     * @return lista de videojuegos registrados.
     */
    public ArrayList<Videogame> getVideogameList()
    {
        ArrayList<Videogame> videogameList= new ArrayList();
        String query = "Select * from videogames";
        PreparedStatement ps;
        ResultSet rs;
        
        try {
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            boolean aux=false;
            while (rs.next())
            {
                aux=true;
                String title = rs.getString(1);
                String company = rs.getString(2);
                String gameConsole = rs.getString(3);
                String date = rs.getString(4);
                
                int completed = rs.getInt(5);
                videogameList.add(new Videogame(title, company, gameConsole,Date.valueOf(date),completed));
            }
            
            if (!aux)
            {
                System.out.println(ConsoleColors.PURPLE+"La lista de videojuegos está vacía");
            }
        } 
        catch (SQLException ex) 
        {
            System.out.println(ConsoleColors.RED+"No se ha podido acceder a la tabla de videojuegos");
            ex.printStackTrace();
        }
      
        return videogameList;
    }
    
    /**
     * Añade una lista de videojuegos a la base de datos.
     * @param videogameList lista de videojuegos a añadir.
     */
    public void InsertNewVideogames(ArrayList<Videogame> videogameList)
    {
        String query = "Insert into videogames values (?, ?, ?, ?, ?)";
        
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            int rowsChanged=0;
            for (Videogame v:videogameList)
            {
                ps.setString(1, v.getTitle());
                ps.setString(2, v.getCompany());
                ps.setString(3, v.getGameConsole());
                ps.setDate(4, v.getReleaseDate());
                ps.setInt(5, v.getCompleted());
            
                ps.executeUpdate();
                rowsChanged++;
            }
            
            if (rowsChanged!=0)
            {
                System.out.println(ConsoleColors.GREEN+"Se ha insertado " + rowsChanged + " videojuego.");
            }else{
                System.out.println(ConsoleColors.RED+"No se insertó ningún usuario");
            }
        } 
        catch (SQLException ex) 
        {
            System.out.println(ConsoleColors.RED+"Hubo un error al insertar un nuevo videojuego"+ex);
            ex.printStackTrace();
        }
    }
    
    /**
     * Elimina los videojuegos de la base de datos.
     */
    public void deleteVideogames()
    {
        String query = "delete from videogames";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.executeUpdate();
        }
        catch (SQLException ex) 
        {
            System.out.println(ConsoleColors.RED+"Problemas con la base de datos");
            ex.printStackTrace();
        }
    }
        
    //==============================COMPANIES===============================
    /**
     * Comprueba si existe una compañía en concreto dentro de la base de datos. 
     * @param name nombre de la compañía a revisar.
     * @return TRUE si ya existe.
     */
    public boolean checkCompanyExists(String name)
    {
        boolean exists=false;
        String query = "Select * from companies where id = ?";
        
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, name.toUpperCase());
            ResultSet rs = ps.executeQuery();
            
            while(rs.next())
            {
                exists=true;
            }
            
        } catch (SQLException ex) {
            System.out.println(ConsoleColors.RED+"No se pudo comprobar si la compañía existe");
            ex.printStackTrace();
        }
        return exists;
    }
    
    /**
     * Añade una compañía a la base de datos.
     * @param name nombre de la compañía a añadir.
     * @return TRUE si la operación se ha realizado correctamente.
     */
    public boolean  insertCompany(String name)
    {
        boolean done=false;
        String query="Insert into companies values (?)";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, name.toUpperCase());
            int rowsChanged = ps.executeUpdate();
            
            if (rowsChanged!=0)
            {
                System.out.println(ConsoleColors.RED+"Se han insertado "+ rowsChanged + " compañías.");
                done = true;
            }
            
        } catch (SQLException ex) {
            System.out.println("No se pudo insertar la compañía"+ex);
            ex.printStackTrace();
        }
        
        return done;
    }
    
    /**
     * Obtén la lista de compañías existentes en la base de datos.
     * @return lista de las compañías.
     */
    public ArrayList<Company> getCompaniesList()
    {
        ArrayList<Company> companiesList=new ArrayList();
        String query = "select * from companies";
        PreparedStatement ps;
        boolean aux=false;
        
        try {
            ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
          
            while(rs.next())
            {
                aux = true;
                String name = rs.getString(1);
                companiesList.add(new Company(name));
            }
             
        } catch (SQLException ex) {
            System.out.println(ConsoleColors.RED+"No se pudo obtener la lista de compañias de la base de datos.");
            ex.printStackTrace();
        }
       
        if (!aux)
        {
            System.out.println(ConsoleColors.PURPLE+"La lista de compañías está vacía");
        }
        
        return companiesList;
    }
     
    /**
     * Añade una lista de compañías a la base de datos.
     * @param companyList lista de compañías a añadir.
     */
    public void InsertNewCompanies(ArrayList<Company> companyList)
    {
        String query = "Insert into companies values (?)";
        
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            int rowsChanged=0;
            
            for (Company c:companyList)
            {
                ps.setString(1, c.getName());
                ps.executeUpdate();
                rowsChanged++;
            }
            
            if (rowsChanged!=0)
            {
                System.out.println(ConsoleColors.GREEN+"Se ha insertado " + rowsChanged + " compañías.");
            }else{
                System.out.println(ConsoleColors.RED+"No se insertó ninguna compañía");
            }
        } 
        catch (SQLException ex) 
        {
            System.out.println(ConsoleColors.RED+"Hubo un error al insertar una nueva compañía"+ex);
            ex.printStackTrace();
        }
    }
    
    //==============================CONSOLES===============================
    /**
     * Comprueba si existe una consola en concreto dentro de la base de datos. 
     * @param name nombre de la consola a revisar.
     * @return TRUE si ya existe.
     */
    public boolean checkConsoleExists(String name)
    {
        boolean exists=false;
        String query = "Select * from videogameConsoles where id = ?";
        
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, name.toUpperCase());
            ResultSet rs = ps.executeQuery();
            
            while(rs.next())
            {
                exists=true;
            }
            
        } catch (SQLException ex) {
            System.out.println(ConsoleColors.RED+"No se pudo comprobar si la consola existe");
            ex.printStackTrace();
        }
        return exists;
    }
    
    /**
     * Añade una consola a la base de datos.
     * @param name nombre de la consola a añadir.
     * @param companyName nombre de la compañía a la que pertenece la consola.
     * @return TRUE si la operación se ha realizado con éxito.
     */
    public boolean insertConsole(String name, String companyName)
    {
        boolean done=false;
        
        if (checkCompanyExists(companyName))
        {
            String query="Insert into companies values (?, ?)";
            try {
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setString(1, name.toUpperCase());
                ps.setString(2, companyName);
                int rowsChanged = ps.executeUpdate();

                if (rowsChanged!=0)
                {
                    System.out.println(ConsoleColors.RED+"Se han insertado "+ rowsChanged + " consolas.");
                    done=true;
                }

            } catch (SQLException ex) {
                System.out.println("No se pudo insertar la consola"+ex);
                ex.printStackTrace();
            }
        }
        
        return done;
    }
    
    /**
     * Obtén la lista de las consolas existentes en la base de datos.
     * @return lista de las consolas.
     */
    public ArrayList<Console> getConsoleList()
    {
        ArrayList<Console> consoleList=new ArrayList();
        String query = "select * from videogameConsoles";
        PreparedStatement ps;
        boolean aux=false;
        
        try {
            ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
          
            while(rs.next())
            {
                aux = true;
                String name = rs.getString(1);
                String companyName = rs.getString(2);
                consoleList.add(new Console(name,new Company(companyName)));
            }
             
        } catch (SQLException ex) {
            System.out.println(ConsoleColors.RED+"No se pudo obtener la lista de consolas de la base de datos.");
            ex.printStackTrace();
        }
       
        if (!aux)
        {
            System.out.println(ConsoleColors.PURPLE+"La lista de consolas está vacía");
        }
        
        return consoleList;
    }
    
     /**
     * Añade una lista de consolas a la base de datos.
     * @param consoleList lista de consolas a añadir.
     */
    public void InsertNewConsoles(ArrayList<Console> consoleList)
    {
        String query = "Insert into videogameConsoles values (?,?)";
        
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            int rowsChanged=0;
            
            for (Console c: consoleList)
            {
                ps.setString(1, c.getId());
                ps.setString(2,c.getCompany().getName());
                ps.executeUpdate();
                rowsChanged++;
            }
            
            if (rowsChanged!=0)
            {
                System.out.println(ConsoleColors.GREEN+"Se ha insertado " + rowsChanged + " consolas.");
            }else{
                System.out.println(ConsoleColors.RED+"No se insertó ninguna consola");
            }
        } 
        catch (SQLException ex) 
        {
            System.out.println(ConsoleColors.RED+"Hubo un error al insertar una nueva consola"+ex);
            ex.printStackTrace();
        }
    }
}
