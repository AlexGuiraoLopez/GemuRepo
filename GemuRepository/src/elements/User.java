package elements;

/** 
 * Información sobre los usuarios que se registran al programa.
 * @author Alex Guirao Lopez  <alexguiraolopez@gmail.com>
 */
public class User 
{
    public static int MAX_NAME_LENGTH=8;
    public static int MAX_PASSWORD_LENGTH=8;
    public static int MAX_EMAIL_LENGTH=25;
    
    private String username;
    private String password;
    private String email;
    
    public User(String username, String password,String email) 
    {
        this.username = username;
        this.password = password;
        this.email=email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
    
    public static int getRecordSize(){
        return MAX_NAME_LENGTH+MAX_PASSWORD_LENGTH+MAX_EMAIL_LENGTH;
    }
    
    public String getFormattedUsername(){
        return String.format("%-"+MAX_NAME_LENGTH+"."+MAX_NAME_LENGTH+"s", this.username);
    }
    
    public String getFormattedPassword(){
        return String.format("%-"+MAX_PASSWORD_LENGTH+"."+MAX_PASSWORD_LENGTH+"s", this.password);
    }
    
    public String getFormattedEmail(){
        return String.format("%-"+MAX_EMAIL_LENGTH+"."+MAX_EMAIL_LENGTH+"s",this.email);
    }
    
}
