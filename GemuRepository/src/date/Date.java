package date;

import visualfront.ConsoleColors;

/** 
 * Define fechas.
 * Las muestra en formato (año/mes/día)
 * @author Alex Guirao López <aguiraol2021@cepnet.net>
 */
public class Date 
{
    private int year;
    private int month;
    private int day;

    public Date(int year, int month, int day) 
    {
        if (checkDateFormat(month, day))
        {
            this.year=year;
            this.month=month;
            this.day=day;
        }else{
            System.out.println(ConsoleColors.RED+"Los valores de la fecha no son correctos.");
        }
    }

    /**
     * Comprueba el formato de la fecha.
     * De momento no se tiene en cuenta los meses con menos de 31 días.
     * @param month mes a comprobar.
     * @param day día a comprobar.
     * @return TRUE si el formato es correcto.
     */
    private boolean checkDateFormat(int month, int day)
    {
        boolean isCorrect=false;
        
        if (month>=1&&month<=12&&day>=1&&day<=31)
        {
            isCorrect=true;
        }
        
        return isCorrect;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }
    
    @Override
    public String toString() 
    {
        return year + " - " + month + " - " + day ;
    }
}
