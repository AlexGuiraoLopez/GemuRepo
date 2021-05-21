package videogame;
import date.Date;
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
        if (title.length()<=TITLE_MAX_LENGTH){
            this.title = title;
        }else{
            this.title=title.substring(0,TITLE_MAX_LENGTH);
        }
        
        if (company.length()<=COMPANY_MAX_LENGTH){
            this.company = company;
        }else{
            this.company=company.substring(0, COMPANY_MAX_LENGTH);
        }
        
        if (gameConsole.length()<=GAME_CONSOLE_MAX_LENGTH){
            this.gameConsole = gameConsole;
        }else{
            this.gameConsole=gameConsole.substring(0, GAME_CONSOLE_MAX_LENGTH);
        }
        
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return "Videogame{" + "title=" + title + ", company=" + company + ", gameConsole=" + gameConsole +", " 
                +"Release Date: "+releaseDate.toString();
    }
    
    
    
    /**
     * Tamaño de cada uno de los registros.
     * Incluye las longitudes de los atributos con valor String y 
     * la fecha formada por 3 atributos de tipo integer (año, mes y dia).
     * @return tamaño de un registro.
     */
    public static int getRecordSize(){
        return TITLE_MAX_LENGTH+COMPANY_MAX_LENGTH+GAME_CONSOLE_MAX_LENGTH+(Integer.BYTES*3);
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
