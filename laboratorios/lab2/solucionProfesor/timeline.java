import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Comparator; 
import java.util.PriorityQueue; 

class dateComparator implements Comparator<provinceData> 
{ 
    public int compare(provinceData p1, provinceData p2) 
    { 
        return p1.getConfDate().compareTo(p2.getConfDate()); 
    } 
} 

public class timeline 
{
    private PriorityQueue<provinceData> sorted;

    public timeline()
    {
        sorted = new PriorityQueue<provinceData>(new dateComparator());
    }

    public void fill(ArrayList<provinceData> allData)
    {
        for(provinceData p : allData)
        {
            if(p.getConfDate() != null)
            {
                sorted.add(p);
            }
        }
    }

    public void show()
    {
        int i = 1;
        for(provinceData p : sorted)
        {   
            System.out.println("Site " + i + ":");
            System.out.println("Province: " + p.getProvince());
            System.out.println("Country: " + p.getCountry());
            System.out.println("Date of confirmation: " + p.getConfDate());
            System.out.print("\n\n");
            i++;
        }
    }

}