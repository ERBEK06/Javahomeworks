/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package osman_bahadir_erbek_hw4;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

public class HW4_Hash implements HW4_Interface{
    
    	public Integer GetHash(String mystring) {
		 int sum=0;
	     String myword= mystring;
	     char[] dizi=myword.toCharArray();
	     
	     for(int i=0;i<myword.length();i++) {
	    	 
	    	char x =dizi[i];
	    	int ascii = x;
	    	sum += ascii;
	    	 
	     }
		return sum;
	}
	
            @Override
	public void ReadFileandGenerateHash(String filename, int size) throws IOException {
		
		      int tablesize=size;
		 
		      Map<Integer,String> map1=new TreeMap<>();
	    
	          File f1=new File(filename); 
		      String[] arr=null;  
		      FileReader fr = new FileReader(f1); 
		      BufferedReader br = new BufferedReader(fr); 
		      String mytext;     
		      String  mystring=null;
		      
		      while((mytext=br.readLine())!=null)   
		      {
		    	  mytext = mytext.toLowerCase();
	        	  mytext = mytext.replace("-", "");
	        	  mytext = mytext.replace(":", "");
	        	  mytext = mytext.replace(",", "");
	        	  mytext = mytext.replace("'", "");
	        	  mytext = mytext.replace("ı", "i");
	        	  mytext = mytext.replace("-", "");
	        	  mytext = mytext.replace(";", "");
	        	  mytext = mytext.replace("?", "");
	        	  mytext = mytext.replace("--", "");
	        	  mytext = mytext.replace(".", "");
		          arr=mytext.split(" "); 
		         
		       
		         for(int i=0;i<arr.length;i++){
                  mystring= arr[i];
                  int mode= GetHash(mystring)%tablesize;
                  map1.put(mode, arr[i]);
	             	         }   
		          }
		      //System.out.println(map1.entrySet());
	}
	

	public void DisplayResult(String Outputfile) throws IOException {
		
		  Map<String,Integer> map1=new TreeMap<>();
 
          File f1=new File("hw4text.txt"); 
	      String[] arr=null; 
	      FileReader fr = new FileReader(f1);  
	      BufferedReader br = new BufferedReader(fr); 
	      String mytext;     
	      FileWriter fw = new FileWriter(Outputfile);      
	      while((mytext=br.readLine())!=null)   
	      {
	    	  mytext = mytext.toLowerCase();
        	  mytext = mytext.replace("-", "");
        	  mytext = mytext.replace(":", "");
        	  mytext = mytext.replace(",", "");
        	  mytext = mytext.replace("'", "");
        	  mytext = mytext.replace("ı", "i");
        	  mytext = mytext.replace("-", "");
        	  mytext = mytext.replace(";", "");
        	  mytext = mytext.replace("?", "");
        	  mytext = mytext.replace("--", "");
        	  mytext = mytext.replace(".", "");
	          arr=mytext.split(" ");  
	         
	    
	          for(int i=0;i<arr.length;i++)
	          {
	        	  
	              if(map1.containsKey(arr[i]))
	              {
	                  map1.put(arr[i], map1.get(arr[i])+1);
	              }
	              else
	              {
	                  map1.put(arr[i],1);
	              }
	          }
	         
	          }
      
	          for(Map.Entry<String,Integer> map:map1.entrySet())
	          {
	              fw.write(map.getKey()+ " - "+map.getValue());
	              fw.write("\n");
	      }
          fw.close();

	}
	
	public void DisplayResultOrdered(String Outputfile) throws IOException {
		 
		      Map<String,Integer> map1=new TreeMap<>();
   
	          File f1=new File("hw4text.txt"); 
		      String[] arr=null;  
		      FileReader fr = new FileReader(f1); 
		      BufferedReader br = new BufferedReader(fr); 
		      String mytext;     
		      FileWriter fw = new FileWriter(Outputfile);
		      
		      while((mytext=br.readLine())!=null)   
		      {
		    	  mytext = mytext.toLowerCase();
	        	  mytext = mytext.replace("-", "");
	        	  mytext = mytext.replace(":", "");
	        	  mytext = mytext.replace(",", "");
	        	  mytext = mytext.replace("'", "");
	        	  mytext = mytext.replace("ı", "i");
	        	  mytext = mytext.replace("-", "");
	        	  mytext = mytext.replace(";", "");
	        	  mytext = mytext.replace("?", "");
	        	  mytext = mytext.replace("--", "");
	        	  mytext = mytext.replace(".", "");
		          arr=mytext.split(" ");  
		
		          for(int i=0;i<arr.length;i++)
		          {
		        	       
		              if(map1.containsKey(arr[i]))
		              {
		                  map1.put(arr[i], map1.get(arr[i])+1);
		              }
		              else
		              {
		                  map1.put(arr[i],1);
		              }
		          }
 
		          }
		      
		       List<Entry<String, Integer>> sorted = new ArrayList<>(map1.entrySet());
			    Collections.sort(sorted, new Comparator<Entry<String, Integer>>() {
			    	
			        public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
			        int comp = Integer.compare(o2.getValue(), o1.getValue());
			        if (comp != 0) {
			            return comp;
			        }
			        return o1.getKey().compareTo(o2.getKey());
			        }
			    }
			    );
		      
		      
		          for(Map.Entry<String,Integer> map:sorted)
		          {
		             // System.out.println(map.getKey()+ " - "+map.getValue());
		          
		              fw.write(map.getKey()+ " - "+map.getValue());
		              fw.write("\n");
		          
		      }
		          fw.close();
		
	}
	

	public void DisplayResult() throws IOException {
        Map<String,Integer> map1=new TreeMap<>();

   
          File f1=new File("hw4text.txt"); 
	      String[] arr=null;  
	      FileReader fr = new FileReader(f1);  
	      BufferedReader br = new BufferedReader(fr); 
	      String mytext;     

	      while((mytext=br.readLine())!=null)   
	      {
	    	  mytext = mytext.toLowerCase();
        	  mytext = mytext.replace("-", "");
        	  mytext = mytext.replace(":", "");
        	  mytext = mytext.replace(",", "");
        	  mytext = mytext.replace("'", "");
        	  mytext = mytext.replace("ı", "i");
        	  mytext = mytext.replace("-", "");
        	  mytext = mytext.replace(";", "");
        	  mytext = mytext.replace("?", "");
        	  mytext = mytext.replace("--", "");
        	  mytext = mytext.replace(".", "");
	          arr=mytext.split(" "); 

	          for(int i=0;i<arr.length;i++)
	          {

	              if(map1.containsKey(arr[i]))
	              {
	                  map1.put(arr[i], map1.get(arr[i])+1);
	              }
	              else
	            	  
	              {
	                  map1.put(arr[i],1);
	              }
	          }

	          }
	      
	          for(Map.Entry<String,Integer> map:map1.entrySet())
	          {
	              System.out.println(map.getKey()+ " - "+map.getValue());
          
	      }

	}

         
	public int showFrequency(String myword) throws IOException {
		  File f1=new File("hw4text.txt"); 
	      String[] words=null;  
	      FileReader fr = new FileReader(f1);  
	      BufferedReader br = new BufferedReader(fr); 
	      String mytext;     
	      String input=myword;   
	      int count=0;   
	      while((mytext=br.readLine())!=null)   
	      {
	         words=mytext.split(" ");  
      
	          for (String word : words) 
	          {
	  
	        	  word = word.toLowerCase();
	        	  word = word.replace("-", "");
	        	  word = word.replace(":", "");
	        	  word = word.replace(",", "");
	        	  word = word.replace("'", "");
	        	  word = word.replace("?", "");
	        	  word = word.replace("-", "");
	        	  word = word.replace("--", "");
	        	  word = word.replace(";", "");
	                 if (word.equals(input))  
	                 {
	                   count++;   
	                 }
	          }
	      }
	      if(count!=0)  
	      {
	         System.out.println("'" + input + "'"  + "number of occurrences is " + count);
	      }
	      else
	      {
	        // System.out.println(input + " is not found in the text");
	    	  return -1;
	      }
	      
	         return count;
		
	}
	
	public String showMaxRepeatedWord() throws IOException {
		
		    String mytext, word = "";  
	        int count = 0, maxCount = 0;  
	        ArrayList<String> words = new ArrayList<String>();  
 
	        FileReader fr = new FileReader("hw4text.txt");  
	        BufferedReader br = new BufferedReader(fr);  
	        String string[];
	         
	        while((mytext = br.readLine()) != null) {  
	               
	              mytext = mytext.toLowerCase();
	        	  mytext = mytext.replace("-", "");
	        	  mytext = mytext.replace(":", "");
	        	  mytext = mytext.replace(",", "");
	        	  mytext = mytext.replace("'", "");
	        	  mytext = mytext.replace("ı", "i");
	        	  mytext = mytext.replace("-", "");
	        	  mytext = mytext.replace(";", "");
	        	  mytext = mytext.replace("?", "");
	        	  mytext = mytext.replace("--", "");
	        	  mytext = mytext.replace(".", "");
	              string=mytext.split(" ");
	              
	            for(String s : string){  
	                words.add(s);  
	            }  
	        }  
	       
	          
	          
	            for(int i = 0; i < words.size(); i++){  
	            count = 1;  
	             
	            for(int j = i+1; j < words.size(); j++){  
	                if(words.get(i).equals(words.get(j))){  
	                    count++;  
	                }   
	            }  
	            
	            if(count > maxCount){  
	                maxCount = count;  
	                word = words.get(i);  
	            }  
	        }  
	          System.out.println(word);
	        return word;
	    }  
	
	public void checkWord(String myword) throws IOException {
		
		   Map<String,Integer> map1=new TreeMap<>();
	        
           String text = ""; 
	        
	        
	         File f1=new File("hw4text.txt"); 
		      String[] arr=null;  
		      FileReader fr = new FileReader(f1);  
		      BufferedReader br = new BufferedReader(fr); 
		      String mytext;     
		      
		      
		      while((mytext=br.readLine())!=null)   
		      {
		    	  mytext = mytext.toLowerCase();
	        	  mytext = mytext.replace("-", "");
	        	  mytext = mytext.replace(":", "");
	        	  mytext = mytext.replace(",", "");
	        	  mytext = mytext.replace("'", "");
	        	  mytext = mytext.replace("ı", "i");
	        	  mytext = mytext.replace("-", "");
	        	  mytext = mytext.replace(";", "");
	        	  mytext = mytext.replace("?", "");
	        	  mytext = mytext.replace("--", "");
	        	  mytext = mytext.replace(".", "");
		          arr=mytext.split(" ");  
		         
		         
		          int c=0;
		         for(int i=0;i<arr.length;i++)
		          {
	              map1.put(arr[i], c);
	              c++;
		          }
          
		          }
		      for(Map.Entry<String,Integer> map:map1.entrySet())
	          {
	    	    
		        if(map1.containsKey(myword) ) {
	             System.out.println(myword + " is  found "  );
	             break;
	             
		    		 //System.out.println(arr.length);
		    	  }
		        else {
		        	System.out.println(myword+" is not found in the text");
		        	break;
		        }
        
	      }
	}
}
