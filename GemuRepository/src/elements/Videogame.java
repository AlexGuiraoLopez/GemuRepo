package elements;


/** 
 * Información sobre los videojuegos que se registran en el programa.
 * @author Alex Guirao Lopez <alexguiraolopez@gmail.com>
 */
public class Videogame 
{
    public final static int TITLE_MAX_LENGTH=40;
    public final static int COMPANY_MAX_LENGTH=15;
    public final static int GAME_CONSOLE_MAX_LENGTH=15;
    
    private String title;
    private String company;
    private String gameConsole;
    private int releaseYear;
    private int completed;
    private String image;
    
    public Videogame(String title, String company, String gameConsole, int releaseYear, int completed) 
    {
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
        
        this.completed=completed;
        
        this.image=title.toLowerCase()+".jpg";
        this.releaseYear = releaseYear;
    }

    @Override
    public String toString() 
    {
        return "Videogame{" + "title=" + title + ", company=" + company + ", gameConsole=" + gameConsole +", " 
                +"Release Date: "+releaseYear;
    }
    
    
    //GET & SET
    
    /**
     * Tamaño de cada uno de los registros.
     * Incluye las longitudes de los atributos con valor String,
     * el año de lanzamiento y un entero 0/1 para saber si se ha completado el juego.
     * @return tamaño de un registro.
     */
    public static int getRecordSize(){
        return TITLE_MAX_LENGTH+COMPANY_MAX_LENGTH+GAME_CONSOLE_MAX_LENGTH+(Integer.BYTES*2);
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

    public String getTitle() {
        return title;
    }

    public String getCompany() {
        return company;
    }

    public String getGameConsole() {
        return gameConsole;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public String getImage() {
        return image;
    }
    
    /*
    public int getYear(){
        return this.releaseYear.getYear();
    }
    */
    
    public int getCompleted(){
        return this.completed;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setGameConsole(String gameConsole) {
        this.gameConsole = gameConsole;
    }
    
    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }
    
    public void setCompleted(int completed) {
        this.completed = completed;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
