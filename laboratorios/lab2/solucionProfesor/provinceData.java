import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class provinceData
{
    private String province;
    private String country;
    private LocalDate firstConfirmedDate;
    private int men;
    private int women;

    public provinceData(String province, String country)
    {
        this.province = province;
        this.country = country;
        this.firstConfirmedDate = null;
        this.men = 0;
        this.women = 0;
    }

    public String getProvince()
    {
        return province;
    } 

    public String getCountry()
    {
        return country;
    } 

    public LocalDate getConfDate()
    {
        return firstConfirmedDate;
    }

    public int getMen()
    {
        return men;
    }

    public int getWomen()
    {
        return women;
    }

    public double menToWomen()
    {
        if(women > 0)
        {
            return((double)men/(double)women);
        }
        else
        {
            return Double.NaN;
        }
    }

    public void changeDate(LocalDate newDate)
    {
        firstConfirmedDate = newDate;
    }

    public void incMen()
    {
        men++;
    }

    public void incWomen()
    {
        women++;
    }

}