package eswcss;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class ReadCSV {
 // private static data d;

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new FileReader("/Users/mohnish/bbcfoodCSV.csv"));
    String line = null;
    
    BufferedWriter bw = new BufferedWriter(new FileWriter("/Users/mohnish/BBCfood.csv"));
	
    int counter=1;
    while ((line = br.readLine()) != null) {
      String[] values = line.split(",");
      //for (String str : values) {
       // System.out.println(str);
      //}
      //System.out.println(" -------------------");
     // System.out.println("URL : "+values[0]+" Name : "+values[1]);
      //--------------------------for array merge
      for(int i=3;i<values.length;i++)
      {values[2]=values[2]+values[i];
      }
      try{
      data.URL = values[0];
      data.Name = values[1];
      
     }
      catch(Exception e){
    	  //This catch block catches all the exceptions
    	}
     
      
      
      String[] values2 = values[2].split("\"\"]");
      for (String str : values2) {
    	 // System.out.println(str);
        if(str.contains("recipeInstructions"))
        	data.recipeInstruction = str.substring(44).replace("\"", "").trim();
        else if(str.contains("\"ingredients\""))
        	data.ingredients = str.substring(str.indexOf("[")+1).replace("\"", "").trim();
        else if(str.contains("\"recipeYield\""))
        	data.recipeYield = str.substring(str.indexOf("[")+1).replace("\"", "").trim();
        else if(str.contains("\"cookTime\""))
        	data.cookTime = str.substring(str.indexOf("[")+1).replace("\"", "").trim();
        else if(str.contains("\"name\""))
        	data.names = str.substring(str.indexOf("[")+1).replace("\"", "").trim();
        else if(str.contains("\"description\""))
        	data.discription = str.substring(str.indexOf("[")+1).replace("\"", "").trim();
        else if(str.contains("\"image\""))
        	data.image = str.substring(str.indexOf("[")+1).replace("\"", "").trim();
        else if(str.contains("\"prepTime\""))
        	data.preptime = str.substring(str.indexOf("[")+1).replace("\"", "").trim();
        else if(str.contains("\"author\""))
        	data.author = str.substring(str.indexOf("[")+1).replace("\"", "").trim();
        else if(str.contains("\"type\""))
        	data.type = str.substring(str.indexOf("[")+1).replace("\"", "").trim();
        
      }
      System.out.println(data.recipeInstruction);
      System.out.println(data.ingredients);
      System.out.println(data.recipeYield );
      System.out.println(data.cookTime);
      System.out.println(data.names);
      System.out.println(data.discription );
      System.out.println(data.image);
      System.out.println(data.preptime);
      System.out.println(data.author );
      
      bw.write(counter +", "+ data.Name +", "+ data.URL +", "+data.recipeInstruction +", "+ data.ingredients +", "+  data.recipeYield +", "+  data.cookTime  +", "+ data.names
    		  +", "+ data.discription +", "+  data.image  +", "+ data.preptime  +", "+ data.author  +", "+ data.type +"\n ");
      counter++;
      data.clear();
    }
    bw.close();
    br.close();
  }
}

class data{
	public static String URL;
	public static String Name;
	public static String recipeInstruction;
	public static String ingredients;
	public static String recipeYield;
	public static String cookTime;
	public static String names;
	public static String discription;
	public static String image;
	public static String preptime;
	public static String author;
	public static String type;
	 
	 public static void clear(){
		 URL=null;Name=null; cookTime=null;
		 recipeInstruction=null; ingredients=null; recipeYield=null;
		 names=null; discription=null; image=null;
		 preptime=null; author=null; type=null;
	 }
 }