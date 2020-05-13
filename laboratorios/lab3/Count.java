import java.util.ArrayList;
import java.sql.Array;
import java.text.DecimalFormat;
import java.time.LocalDate;

public class Count {
    private ArrayList<provinceData> array;
    String[] array1 = array.toArray(new String[0]);


/** 
    public void fill(ArrayList<provinceData> allData) {
        for(provinceData p : allData) {
            if(!Double.isNaN(p.menToWomen())) {
                array.add(p);
            }
        }
    }*/

    public void show()
    {
        //InsertSort.Sort(array1);
        int i = 1;
        for(provinceData p : array)
        {
            System.out.println("Province: " + p.getProvince());
            System.out.println("Country: " + p.getCountry());
            System.out.println("Count: " + p.getCount());
            System.out.print("\n\n");
            i++;
        }
    }
}