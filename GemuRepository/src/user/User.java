package user;
/** 
 * @author Alex Guirao Lopez <aguiraol2021@cepnet.net>
 */
public class User 
{
    public static int MAX_NAME_LENGTH=8;
    public static int MAX_PASSWORD_LENGTH=8;
    
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    
    public static int getRecordSize(){
        return MAX_NAME_LENGTH+MAX_PASSWORD_LENGTH;
    }
    
    public String getFormattedUsername(){
        return String.format("%-"+MAX_NAME_LENGTH+"."+MAX_NAME_LENGTH+"s", this.username);
    }
    
    public String getFormattedPassword(){
        return String.format("%-"+MAX_PASSWORD_LENGTH+"."+MAX_PASSWORD_LENGTH+"s", this.password);
    }
    
    
}
