package elements;

import java.util.Objects;

/** 
 * @author Alex Guirao Lopez <alexguiraolopez@gmail.com>
 */
public class Console 
{
    public static int MAX_NAME_LENGTH=20;
    
    private String id;
    private Company company;

    public Console(String id, Company company) 
    {
        this.id = id;
        this.company = company;
    }

    @Override
    public int hashCode() 
    {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.id);
        hash = 11 * hash + Objects.hashCode(this.company);
        return hash;
    }

    @Override
    public boolean equals(Object obj) 
    {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Console other = (Console) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.company, other.company)) {
            return false;
        }
        return true;
    }

    public static int getRecordSize(){
        return MAX_NAME_LENGTH+Company.MAX_NAME_LENGTH;
    }
    
    public String getFormattedName(){
        return String.format("%-"+MAX_NAME_LENGTH+"."+MAX_NAME_LENGTH+"s", this.id);
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
