import java.util.ArrayList;

public class ratios 
{
    private ArrayList<provinceData> array;

    public ratios()
    {
        array = new ArrayList<provinceData>();
    }
  
    private void Msort(int l, int r) 
    { 
        if (l < r) 
        { 
            int m = (l+r)/2; 
            Msort(l, m); 
            Msort(m+1, r);
        } 
    }

    public void fill(ArrayList<provinceData> allData)
    {
        for(provinceData p : allData)
        {
            array.add(p);
        }
    }

    public void show()
    {
        Msort(0, array.size()-1);
        int i = 1;
        for(provinceData p : array)
        {
            System.out.println("Ratio " + i + ":");
            System.out.println("Province: " + p.getProvince());
            System.out.println("Country: " + p.getCountry());
            System.out.println("Men to women ratio: " + p.getCount());
            System.out.print("\n\n");
            i++;
        }
    }
}