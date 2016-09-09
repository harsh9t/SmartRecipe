

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class CsvFileReader {

    public List<RcpStructure> allRcps = new ArrayList<RcpStructure>();
    public void createRecipeStructure()
    {
        
        
        try {

			BufferedReader br = new BufferedReader(new FileReader("/home/dharmen/bbcfoodCSV.csv"));
			
			String line = "";
			
			List<String> lines = new ArrayList<String>();
			int cnt = 0;
			while ((line = br.readLine()) != null) {
				lines.add(line);				
			}
			br.close();
			
			for(String rcp:lines)
			{
				int findx = rcp.indexOf(",");
				int sindx = rcp.indexOf(",",findx+1);
				int tindx = rcp.indexOf(",",sindx);
				String sub1 = rcp.substring(0, findx);
				String sub2 = rcp.substring(findx+1,sindx);
				String sub3 = rcp.substring(tindx+1);
				sub3 = sub3.replaceAll("\"\",\"\"", "");
				String[] values2 = sub3.split("\"\"]");
				RcpStructure rcpst = new RcpStructure();
				rcpst.URL = sub1;
				rcpst.Name = sub2;
				for(String element:values2)
				{
					if(element.contains("recipeInstructions"))
					{
						rcpst.recipeInstruction = element.substring(element.indexOf("[\"\"")+3);
					}
					else if(element.contains("ingredients"))
					{
						rcpst.ingredients = element.substring(element.indexOf("[\"\"")+3);
					}
					else if(element.contains("recipeYield"))
					{
						rcpst.recipeYield = element.substring(element.indexOf("[\"\"")+3);
					}
					else if(element.contains("cookTime"))
					{
						rcpst.cookTime = element.substring(element.indexOf("[\"\"")+3);
					}
					else if(element.contains("description"))
					{
						rcpst.description = element.substring(element.indexOf("[\"\"")+3);
					}
					else if(element.contains("image"))
					{
						rcpst.image = element.substring(element.indexOf("[\"\"")+3);
					}
					else if(element.contains("prepTime"))
					{
						rcpst.preptime = element.substring(element.indexOf("[\"\"")+3);
					}
					else if(element.contains("author"))
					{
						rcpst.author = element.substring(element.indexOf("/chefs/")+7);
						//rcpst.author = rcpst.author.substring(0,rcpst.author.indexOf("/") );
					}
					else if(element.contains("type"))
					{
						rcpst.type = element.substring(element.indexOf("[\"\"")+3);
					}
				}				
				allRcps.add(rcpst);
				//rcpst.printReceipe();
				//break;
			}    
                        
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   
	
    }
}

