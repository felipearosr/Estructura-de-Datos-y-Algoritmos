import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class sortedinfo {

    public static int checkExists(ArrayList<provinceData> arr, String p1, String c1)
    {
        for(int i = 0; i < arr.size(); i++)
        {
            if(arr.get(i).getProvince().equals(p1) && arr.get(i).getCountry().equals(c1))
            {
                return i;
            }
        }
        return -1;
    }

	public static void main(String[] args) {
		BufferedReader reader;
        ArrayList<provinceData> processingData = new ArrayList<provinceData>();
		try {
			reader = new BufferedReader(new FileReader("resources/COVID19_open_line_list.csv"));
            String line = reader.readLine();
            line = reader.readLine();
            int i = 0, j = 0, k = 0;
            provinceData p1;
			while (line != null)
			{
				ArrayList<String> parsing1 = new ArrayList<String>();
				String[] row1, row2;
				row1 = line.split("\"",-1);
				for(String x : row1)
				{
					if(x.length() > 0 && x.charAt(0) == ',')
					{
						if(x.length() > 1)
						{
							x = x.substring(1, x.length());
						}
					}
					if(i%2 == 0)
					{
						if(x.length() > 0 && x.charAt(x.length()-1) == ',')
						{
							x = x.substring(0, x.length()-1);
						}
						row2 = x.split(",",-1);
						for(String y : row2)
						{
							parsing1.add(y);
						}
					}
					else
					{
						String z = new String("\"");
						z = z.concat(x);
						z = z.concat("\"");
						parsing1.add(z);
					}
					i++;
				}
                i = 0;
                if(parsing1.size() >= 6 && !(parsing1.get(4).equals("") || parsing1.get(5).equals("")))
                {
                    k = checkExists(processingData, parsing1.get(4), parsing1.get(5));
                    if(k < 0)
                    {
                        p1 = new provinceData(parsing1.get(4), parsing1.get(5));
                        processingData.add(p1);
                    }
                    else
                    {
                        if(!(parsing1.get(2).equals(""))) {
                            processingData.get(k).incCount();
                        }
                    }
                }
				line = reader.readLine();
            }
            reader.close();
            ratios r1 = new ratios();
            r1.fill(processingData);
            r1.show();
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}