import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;


public class sortedinfo {

    public static boolean isValid(String dateStr, DateTimeFormatter formatter) {
        try {
            LocalDate.parse(dateStr, formatter);
        } catch (DateTimeParseException e) {
            return false;
        }
        return true;
    }
    
    public static int checkExists(ArrayList<provinceData> a, String p1, String c1)
    {
        for(int i = 0; i < a.size(); i++)
        {
            if(a.get(i).getProvince().equals(p1) && a.get(i).getCountry().equals(c1))
            {
                return i;
            }
        }
        return -1;
    }

	public static void main(String[] args) {
		BufferedReader reader;
        ArrayList<provinceData> processingData = new ArrayList<provinceData>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
		try {
			reader = new BufferedReader(new FileReader("../resources/COVID19_open_line_list.csv"));
            String line = reader.readLine();
            line = reader.readLine();
            int i = 0, j = 0, k = 0;
            provinceData p1;
            LocalDate localDate;
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
                //Indices: 2 - sex, 4 - province, 5 - country, 12 - date_confirmation
                if(parsing1.size() >= 6 && !(parsing1.get(4).equals("") || parsing1.get(5).equals("")))
                {
                    k = checkExists(processingData, parsing1.get(4), parsing1.get(5));
                    if(k < 0)
                    {
                        p1 = new provinceData(parsing1.get(4), parsing1.get(5));
                        if(parsing1.size() >= 13 && !(parsing1.get(12).equals("")) && isValid(parsing1.get(12),formatter))
                        {
                            localDate = LocalDate.parse(parsing1.get(12), formatter);
                            p1.changeDate(localDate);
                        }
                        if(!(parsing1.get(2).equals("")))
                        {
                            switch(parsing1.get(2))
                            {
                                case "male":
                                    p1.incMen();
                                    break;
                                case "female":
                                    p1.incWomen();
                                    break;
                                default:
                                    break;
                            }
                        }
                        processingData.add(p1);
                    }
                    else
                    {
                        if(parsing1.size() >= 13 && !(parsing1.get(12).equals("")) && isValid(parsing1.get(12),formatter))
                        {
                            localDate = LocalDate.parse(parsing1.get(12), formatter);
                            if(processingData.get(k).getConfDate() == null ||
                               processingData.get(k).getConfDate() != null && localDate.compareTo(processingData.get(k).getConfDate()) < 0)
                            {
                                processingData.get(k).changeDate(localDate);
                            }
                        }
                        if(!(parsing1.get(2).equals("")))
                        {
                            switch(parsing1.get(2))
                            {
                                case "male":
                                    processingData.get(k).incMen();
                                    break;
                                case "female":
                                    processingData.get(k).incWomen();
                                    break;
                                default:
                                    break;
                            }
                        }
                    }
                }
				line = reader.readLine();
            }
            reader.close();
            timeline t1 = new timeline();
            ratios r1 = new ratios();
            t1.fill(processingData);
            t1.show();
            r1.fill(processingData);
            r1.show();
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}