package videogame;
import time.Date;
/** 
 * @author Alex Guirao Lopez <aguiraol2021@cepnet.net>
 */
public class Videogame 
{
    public final static int TITLE_MAX_LENGTH=25;
    public final static int COMPANY_MAX_LENGTH=15;
    public final static int GAME_CONSOLE_MAX_LENGTH=10;
    
    private String title;
    private String company;
    private String gameConsole;
    private Date releaseDate;

    public Videogame(String title, String company, String gameConsole, Date releaseDate) {
        this.title = title;
        this.company = company;
        this.gameConsole = gameConsole;
        this.releaseDate = releaseDate;
    }
    
    /**
     * Tamaño de cada uno de los registros.
     * Incluye las longitudes de los atributos con valor String y 
     * la fecha formada por 3 atributos de tipo byte (año, mes y dia).
     * @return tamaño de un registro.
     */
    public static int getRecordSize(){
        return TITLE_MAX_LENGTH+COMPANY_MAX_LENGTH+GAME_CONSOLE_MAX_LENGTH+(Byte.BYTES*3);
    }
    
    public String getFormattedTitle(){
        return String.format("%-"+TITLE_MAX_LENGTH+"."+TITLE_MAX_LENGTH+"s", this.title);
    }
    public String getFormattedCompany(){
        return String.format("%-"+COMPANY_MAX_LENGTH+"."+COMPANY_MAX_LENGTH+"s", this.company);
    }
    public String getFormattedGameConsole(){
        return String.format("%-"+GAME_CONSOLE_MAX_LENGTH+"."+GAME_CONSOLE_MAX_LENGTH+"s", this.gameConsole);
    }

    //GET & SET
    public String getTitle() {
        return title;
    }

    public String getCompany() {
        return company;
    }

    public String getGameConsole() {
        return gameConsole;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }
    
    
    
    
}
