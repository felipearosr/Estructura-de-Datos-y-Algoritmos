import java.util.ArrayList;
import java.text.DecimalFormat;
import java.time.LocalDate;

public class ratios 
{
    private ArrayList<provinceData> array;
    DecimalFormat df; 

    public ratios()
    {
        array = new ArrayList<provinceData>();
        df = new DecimalFormat("###.###");
    }

    private void merge(int l, int m, int r) 
    { 
        int n1 = m - l + 1; 
        int n2 = r - m; 
  
        ArrayList<provinceData> L = new ArrayList<provinceData>();
        ArrayList<provinceData> R = new ArrayList<provinceData>();

        for(int i=0; i<n1; i++)
        {
            L.add(array.get(l+i));
        }
        for(int j=0; j<n2; j++) 
        {
            R.add(array.get(m+1+j));
        }  
        int i = 0, j = 0; 
        int k = l; 
        while (i < n1 && j < n2) 
        { 
            if(L.get(i).menToWomen() <= R.get(j).menToWomen())
            { 
                array.set(k, L.get(i)); 
                i++; 
            } 
            else
            { 
                array.set(k, R.get(j));
                j++; 
            } 
            k++; 
        } 
        while (i < n1) 
        { 
            array.set(k, L.get(i)); 
            i++; 
            k++; 
        } 
        while (j < n2) 
        { 
            array.set(k, R.get(j));
            j++; 
            k++; 
        } 
    } 
  
    private void Msort(int l, int r) 
    { 
        if (l < r) 
        { 
            int m = (l+r)/2; 
            Msort(l, m); 
            Msort(m+1, r); 
            merge(l, m, r); 
        } 
    }

    public void fill(ArrayList<provinceData> allData)
    {
        for(provinceData p : allData)
        {
            if(!Double.isNaN(p.menToWomen()))
            {
                array.add(p);
            }
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
            System.out.println("Men to women ratio: " + df.format(p.menToWomen()));
            System.out.print("\n\n");
            i++;
        }
    }
}