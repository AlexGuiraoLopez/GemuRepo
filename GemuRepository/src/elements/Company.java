package elements;

import java.util.Objects;

/** 
 * @author Alex Guirao Lopez  <alexguiraolopez@gmail.com>
 */
public class Company 
{
    public static final int MAX_NAME_LENGTH = 20;
    
    private String name;

    public Company(String name) 
    {
        this.name = name;
    }

    @Override
    public int hashCode() 
    {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public boolean equals(Object obj) 
    {
        if (this == obj) 
        {
            return true;
        }
        if (obj == null) 
        {
            return false;
        }
        if (getClass() != obj.getClass()) 
        {
            return false;
        }
        final Company other = (Company) obj;
        if (!Objects.equals(this.name, other.name)) 
        {
            return false;
        }
        return true;
    }

     public static int getRecordSize()
    {
        return MAX_NAME_LENGTH;
    }
     
    public String getFormattedName()
    {
        return String.format("%-"+MAX_NAME_LENGTH+"."+MAX_NAME_LENGTH+"s", this.name);
    }
    
    public String getName() 
    {
        return name;
    }

    public void setName(String name) 
    {
        this.name = name;
    }
    
    
    
}
