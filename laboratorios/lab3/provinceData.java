public class provinceData
{
    private String province;
    private String country;
    private int count;

    public provinceData(String province, String country)
    {
        this.province = province;
        this.country = country;
        this.count = 0;
    }

    public String getProvince()
    {
        return province;
    } 

    public String getCountry()
    {
        return country;
    }

    public int getCount()
    {
        return count;
    }
    

    public void incCount()
    {
        count++;
    }

}