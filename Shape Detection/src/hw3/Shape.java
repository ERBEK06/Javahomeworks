/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hw3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
/**
 *
 * @author REPEDRA
 */
public class Shape implements IHW3_Interface{
                static int rows = 11;
	        static int columns = 14;
                static int count;
                static int row;
                static int col;
		
		static String [][] AB1 = new String[rows][columns];
		static String [][] AB2 = new String[rows][columns];
		static String [][] AB3 = new String[rows][columns];
		static String [][] AB4 = new String[rows][columns];
		static String [][] AB5 = new String[rows][columns];
		static String [][] AB6 = new String[rows][columns];
		static String [][] AB7 = new String[rows][columns];
		static String [][] AB8 = new String[rows][columns];
		static String [][] AB9 = new String[rows][columns];
		static String M[][]  = new String[rows][columns];
                static int c;
    
    public void ReadShapeFile(String path) throws IOException {
                FileReader fr = new FileReader(path);
		BufferedReader buffer = new BufferedReader(fr);
                int ab=11, abc=14;
		int digits[][] = new int[ab][abc];
		int actualLine = 0;

		// Dosyanın içindeki arrayi satır satır okur
		String line = buffer.readLine();

		while(line != null && !line.equals("")){

		    String theDigits[] = line.split(" ");
		    for(int i = 0; i < theDigits.length; i++){
		        digits[actualLine][i] = Integer.parseInt(theDigits[i]);
		    }
		    actualLine++;
		    line = buffer.readLine();
		}
		// Okunan int arrayi String arraye çevirmek için
                //M arrayi txt dosyasını içinde tutar
		for(int a=0;a<digits.length;a++) {
			for(int b=0;b<digits[0].length;b++) {
				if(digits[a][b]==0) {
					M[a][b]="0";
				}
				if(digits[a][b]==1)
				{
					M[a][b]="1";
				}
			}
		}
    }


        
    static int Numberofshapes(String [][] M)
	 {
             //count değişkeni içerisinde shape sayısını tutar.
             //text dosyasının içerisindeki matrixi baştan sona tarar.
             //İlk 1'i bulduğu an count sayısını bir artırır ve burdan search fonksiyonuna gider.
             //1'in tüm çevre komşularını Search içine gönderir ve orda tekrar komşu noktaları gezer.
             //fonksiyon count sayısı kadar çalışır ve her bir count yani shape için özel bir matrix vardır.
	     int ROW = M.length;
	     int COL = M[0].length;
	     int count = 0;

	      for (int i = 0; i < ROW; i++){
	         for (int j = 0; j < COL; j++){
	             if (M[i][j] == "1")
	             {	            	   
	                count++;	            	
	                        if(count==1) {
	                     AB1[i][j] = M[i][j]; //ilk 1'i matris içine saklar. Bunun kullanımına aslında gerek yok fakat tek noktalı şekiller için gerekli.
                                                  //Bu eşitleme sağlanmadığında tek noktalı şekiller tespit edilir fakat yazdırılmaz.
	                 Search1(M, i + 1, j, ROW, COL);     //sağ
	                 Search1(M, i - 1, j, ROW, COL);     //sol
	                 Search1(M, i, j + 1, ROW, COL);     //yukarı
	                 Search1(M, i, j - 1, ROW, COL);     //aşağı
	                 Search1(M, i + 1, j + 1, ROW, COL); //sağ üst çarpraz
	                 Search1(M, i - 1, j - 1, ROW, COL); //sol alt çarpraz
	                 Search1(M, i + 1, j - 1, ROW, COL); //sağ alt çarpraz
	                 Search1(M, i - 1, j + 1, ROW, COL); //sol üst çarpraz
	                 }
	                 if(count==2) {
	                	 AB2[i][j] = M[i][j]; // bu fonksiyon bulunan her bir şekil için kendine özel olarak çalışır.
                                                      //Her bir shape için sadece ismi farklı olan ama aynı metodu çalıştıran search fonksiyonu vardır.
	                 Search2(M, i + 1, j, ROW, COL);     //sağ
	                 Search2(M, i - 1, j, ROW, COL);     //sol
	                 Search2(M, i, j + 1, ROW, COL);     //yukarı
	                 Search2(M, i, j - 1, ROW, COL);     //aşağı
	                 Search2(M, i + 1, j + 1, ROW, COL); //sağ üst çarpraz
	                 Search2(M, i - 1, j - 1, ROW, COL); //sol alt çarpraz
	                 Search2(M, i + 1, j - 1, ROW, COL); //sağ alt çarpraz
	                 Search2(M, i - 1, j + 1, ROW, COL); //sol üst çarpraz
	                 }
	                 if(count==3) {
	                	 AB3[i][j] = M[i][j];
	                 Search3(M, i + 1, j, ROW, COL);     //sağ
	                 Search3(M, i - 1, j, ROW, COL);     //sol
	                 Search3(M, i, j + 1, ROW, COL);     //yukarı
	                 Search3(M, i, j - 1, ROW, COL);     //aşağı
	                 Search3(M, i + 1, j + 1, ROW, COL); //sağ üst çarpraz
	                 Search3(M, i - 1, j - 1, ROW, COL); //sol alt çarpraz
	                 Search3(M, i + 1, j - 1, ROW, COL); //sağ alt çarpraz
	                 Search3(M, i - 1, j + 1, ROW, COL); //sol üst çarpraz
	                 }
	                 if(count==4) {
	                	 AB4[i][j] = M[i][j];
	                 Search4(M, i + 1, j, ROW, COL);     //sağ
		             Search4(M, i - 1, j, ROW, COL);     //sol
		             Search4(M, i, j + 1, ROW, COL);     //yukarı
		             Search4(M, i, j - 1, ROW, COL);     //aşağı
		             Search4(M, i + 1, j + 1, ROW, COL); //sağ üst çarpraz
		             Search4(M, i - 1, j - 1, ROW, COL); //sol alt çarpraz
		             Search4(M, i + 1, j - 1, ROW, COL); //sağ alt çarpraz
		             Search4(M, i - 1, j + 1, ROW, COL); //sol üst çarpraz
	                 }
	                 if(count==5) {
	                	 AB5[i][j] = M[i][j];
	                 Search5(M, i + 1, j, ROW, COL);     //sağ
	                 Search5(M, i - 1, j, ROW, COL);     //sol
	                 Search5(M, i, j + 1, ROW, COL);     //yukarı
	                 Search5(M, i, j - 1, ROW, COL);     //aşağı
	                 Search5(M, i + 1, j + 1, ROW, COL); //sağ üst çarpraz
	                 Search5(M, i - 1, j - 1, ROW, COL); //sol alt çarpraz
	                 Search5(M, i + 1, j - 1, ROW, COL); //sağ alt çarpraz
	                 Search5(M, i - 1, j + 1, ROW, COL); //sol üst çarpraz
	             }
                         if(count==6) {
	                	 AB6[i][j] = M[i][j];
	                 Search6(M, i + 1, j, ROW, COL);     //sağ
	                 Search6(M, i - 1, j, ROW, COL);     //sol
	                 Search6(M, i, j + 1, ROW, COL);     //yukarı
	                 Search6(M, i, j - 1, ROW, COL);     //aşağı
	                 Search6(M, i + 1, j + 1, ROW, COL); //sağ üst çarpraz
	                 Search6(M, i - 1, j - 1, ROW, COL); //sol alt çarpraz
	                 Search6(M, i + 1, j - 1, ROW, COL); //sağ alt çarpraz
	                 Search6(M, i - 1, j + 1, ROW, COL); //sol üst çarpraz
	             }
                         if(count==7) {
	                	 AB7[i][j] = M[i][j];
	                 Search7(M, i + 1, j, ROW, COL);     //sağ
	                 Search7(M, i - 1, j, ROW, COL);     //sol
	                 Search7(M, i, j + 1, ROW, COL);     //yukarı
	                 Search7(M, i, j - 1, ROW, COL);     //aşağı
	                 Search7(M, i + 1, j + 1, ROW, COL); //sağ üst çarpraz
	                 Search7(M, i - 1, j - 1, ROW, COL); //sol alt çarpraz
	                 Search7(M, i + 1, j - 1, ROW, COL); //sağ alt çarpraz
	                 Search7(M, i - 1, j + 1, ROW, COL); //sol üst çarpraz
	             }
                         Search(M, i + 1, j, ROW, COL);     //sağ
	                 Search(M, i - 1, j, ROW, COL);     //sol
	                 Search(M, i, j + 1, ROW, COL);     //yukarı
	                 Search(M, i, j - 1, ROW, COL);     //aşağı
	                 Search(M, i + 1, j + 1, ROW, COL); //sağ üst çarpraz
	                 Search(M, i - 1, j - 1, ROW, COL); //sol alt çarpraz
	                 Search(M, i + 1, j - 1, ROW, COL); //sağ alt çarpraz
	                 Search(M, i - 1, j + 1, ROW, COL); //sol üst çarpraz
	         }
	     }
	      }
	     return count; //fonksiyon count olarak dönüyor ve shape sayısını çıktı olarak verirken bu counttan yararlanıyorum.
	     
	     
	    
	 }
	static void Search(String[][] M, int i, int j, int ROW, int COL)
	 {
		
	     
	     // matrix içinde gezinirken dışarı taşma durumu olursa 0 dönsün.
             // örneğin M[-1][0] olduğunda program hata verecektir.
	     if (i < 0 || j < 0 || i > (ROW - 1) || j > (COL - 1) || M[i][j] != "1")
	     {
	         return;
	     }
	 //Numberofshape fonksiyonundan buraya gelindiğinde şeklin başlangıç noktasından tüm komşu çevrelerini gezer. 
         //Recursive fonksiyon olduğu için birden fazla kez kendini çağırır ve şeklin uzayabileceği her yeri tarar.
         //Yani sadece basit bir kare etrafında dolaşmaz, son 1'i tespit edene kadar döner.
	     if (M[i][j] == "1")
	     {
	    	 
	         M[i][j] = "0";
	         Search(M, i + 1, j, ROW, COL);     //sağ
	         Search(M, i - 1, j, ROW, COL);     //sol
	         Search(M, i, j + 1, ROW, COL);     //yukarı
	         Search(M, i, j - 1, ROW, COL);     //aşağı
	         Search(M, i + 1, j + 1, ROW, COL); //sağ üst çarpraz
	         Search(M, i - 1, j - 1, ROW, COL); //sol alt çarpraz
	         Search(M, i + 1, j - 1, ROW, COL); //sağ alt çarpraz
	         Search(M, i - 1, j + 1, ROW, COL); //sol üst çarpraz
	     }
	 }
	 static void Search1(String[][] M, int i, int j, int ROW, int COL)
	 {
	      
	    
	     // matrix içinde gezinirken dışarı taşma durumu olursa 0 dönsün.
		   if (i < 0 || j < 0 || i > (ROW - 1) || j > (COL - 1) || M[i][j] != "1")
		     {
		         return;
		     }
	 //Bu ve bundan sonraki her search araması şekil tespit edildiğinde çağrılır.
         //Şekillerin içine atılacağı 2d arrayler manuel olarak olarak oluşturulmuştur dilenirse sayısı artırabilir.
         //bulunan 1 değeri önce array içinde saklanır sonra sıfırlanır. Bulunan değer 0'lanmazsa sonsuz bir döngü içine girer.
         //
	     if (M[i][j] == "1")
	     {
	    	 AB1[i][j] = M[i][j];
	         M[i][j] = "0";
	         Search1(M, i + 1, j, ROW, COL);     //sağ
	         Search1(M, i - 1, j, ROW, COL);     //sol
	         Search1(M, i, j + 1, ROW, COL);     //yukarı
	         Search1(M, i, j - 1, ROW, COL);     //aşağı
	         Search1(M, i + 1, j + 1, ROW, COL); //sağ üst çarpraz
	         Search1(M, i - 1, j - 1, ROW, COL); //sol alt çarpraz
	         Search1(M, i + 1, j - 1, ROW, COL); //sağ alt çarpraz
	         Search1(M, i - 1, j + 1, ROW, COL); //sol üst çarpraz
	     }
	 }
	 static void Search2(String[][] M, int i, int j, int ROW, int COL)
	 {
	    //ikinci bir shape tespit edilirse buraya gelinir ve yukarıdakilerin aynısı çalışır.  
	   
             
	     // matrix içinde gezinirken dışarı taşma durumu olursa 0 dönsün.
	     if (i < 0 || j < 0 || i > (ROW - 1) || j > (COL - 1) || M[i][j] != "1")
	     {
	         return;
	     }
	 
	     if (M[i][j] == "1")
	     {
	    	 AB2[i][j] = M[i][j];
	         M[i][j] = "0";
	         Search2(M, i + 1, j, ROW, COL);     //sağ
	         Search2(M, i - 1, j, ROW, COL);     //sol
	         Search2(M, i, j + 1, ROW, COL);     //yukarı
	         Search2(M, i, j - 1, ROW, COL);     //aşağı
	         Search2(M, i + 1, j + 1, ROW, COL); //sağ üst çarpraz
	         Search2(M, i - 1, j - 1, ROW, COL); //sol alt çarpraz
	         Search2(M, i + 1, j - 1, ROW, COL); //sağ alt çarpraz
	         Search2(M, i - 1, j + 1, ROW, COL); //sol üst çarpraz
	     }
	 }
	 static void Search3(String[][] M, int i, int j, int ROW, int COL)
	 {
	      
	     
	     // matrix içinde gezinirken dışarı taşma durumu olursa 0 dönsün.
	     if (i < 0 || j < 0 || i > (ROW - 1) || j > (COL - 1) || M[i][j] != "1")
	     {
	         return;
	     }
	 
	     if (M[i][j] == "1")
	     {
	    	 AB3[i][j] = M[i][j];
	         M[i][j] = "0";
	         Search3(M, i + 1, j, ROW, COL);     //sağ
	         Search3(M, i - 1, j, ROW, COL);     //sol
	         Search3(M, i, j + 1, ROW, COL);     //yukarı
	         Search3(M, i, j - 1, ROW, COL);     //aşağı
	         Search3(M, i + 1, j + 1, ROW, COL); //sağ üst çarpraz
	         Search3(M, i - 1, j - 1, ROW, COL); //sol alt çarpraz
	         Search3(M, i + 1, j - 1, ROW, COL); //sağ alt çarpraz
	         Search3(M, i - 1, j + 1, ROW, COL); //sol üst çarpraz
	     }
	 }
	 static void Search4(String[][] M, int i, int j, int ROW, int COL)
	 {
	      
	    
	     // matrix içinde gezinirken dışarı taşma durumu olursa 0 dönsün.
		   if (i < 0 || j < 0 || i > (ROW - 1) || j > (COL - 1) || M[i][j] != "1")
		     {
		         return;
		     }
	 
	     if (M[i][j] == "1")
	     {
	    	 AB4[i][j] = M[i][j];
	         M[i][j] = "0";
	         Search4(M, i + 1, j, ROW, COL);     //sağ
	         Search4(M, i - 1, j, ROW, COL);     //sol
	         Search4(M, i, j + 1, ROW, COL);     //yukarı
	         Search4(M, i, j - 1, ROW, COL);     //aşağı
	         Search4(M, i + 1, j + 1, ROW, COL); //sağ üst çarpraz
	         Search4(M, i - 1, j - 1, ROW, COL); //sol alt çarpraz
	         Search4(M, i + 1, j - 1, ROW, COL); //sağ alt çarpraz
	         Search4(M, i - 1, j + 1, ROW, COL); //sol üst çarpraz
	     }
	 }
	 static void Search5(String[][] M, int i, int j, int ROW, int COL)
	 {
	      
	    
	     // matrix içinde gezinirken dışarı taşma durumu olursa 0 dönsün.
		   if (i < 0 || j < 0 || i > (ROW - 1) || j > (COL - 1) || M[i][j] != "1")
		     {
		         return;
		     }
	 
	     if (M[i][j] == "1")
	     {
	    	 AB5[i][j] = M[i][j];
	         M[i][j] = "0";
	         Search5(M, i + 1, j, ROW, COL);     //sağ
	         Search5(M, i - 1, j, ROW, COL);     //sol
	         Search5(M, i, j + 1, ROW, COL);     //yukarı
	         Search5(M, i, j - 1, ROW, COL);     //aşağı
	         Search5(M, i + 1, j + 1, ROW, COL); //sağ üst çarpraz
	         Search5(M, i - 1, j - 1, ROW, COL); //sol alt çarpraz
	         Search5(M, i + 1, j - 1, ROW, COL); //sağ alt çarpraz
	         Search5(M, i - 1, j + 1, ROW, COL); //sol üst çarpraz
	     }
	 }
         static void Search6(String[][] M, int i, int j, int ROW, int COL)
	 {
	      
	    
	     // matrix içinde gezinirken dışarı taşma durumu olursa 0 dönsün.
		   if (i < 0 || j < 0 || i > (ROW - 1) || j > (COL - 1) || M[i][j] != "1")
		     {
		         return;
		     }
	 
	     if (M[i][j] == "1")
	     {
	    	 AB6[i][j] = M[i][j];
	         M[i][j] = "0";
	         Search6(M, i + 1, j, ROW, COL);     //sağ
	         Search6(M, i - 1, j, ROW, COL);     //sol
	         Search6(M, i, j + 1, ROW, COL);     //yukarı
	         Search6(M, i, j - 1, ROW, COL);     //aşağı
	         Search6(M, i + 1, j + 1, ROW, COL); //sağ üst çarpraz
	         Search6(M, i - 1, j - 1, ROW, COL); //sol alt çarpraz
	         Search6(M, i + 1, j - 1, ROW, COL); //sağ alt çarpraz
	         Search6(M, i - 1, j + 1, ROW, COL); //sol üst çarpraz
	     }
	 }
         static void Search7(String[][] M, int i, int j, int ROW, int COL)
	 {
	      //Son search algoritması. Eğerki dosya 7 den fazla şekil içeririyorsa program şekil sayısının doğru tespit eder
             //fakat sadece ilk 7 şekli yazdırır. Dilenirse bunun sayısı artırılabilir.
	    
	     // matrix içinde gezinirken dışarı taşma durumu olursa 0 dönsün.
		   if (i < 0 || j < 0 || i > (ROW - 1) || j > (COL - 1) || M[i][j] != "1")
		     {
		         return;
		     }
	 
	     if (M[i][j] == "1")
	     {
	    	 AB7[i][j] = M[i][j];
	         M[i][j] = "0";
	         Search7(M, i + 1, j, ROW, COL);     //sağ
	         Search7(M, i - 1, j, ROW, COL);     //sol
	         Search7(M, i, j + 1, ROW, COL);     //yukarı
	         Search7(M, i, j - 1, ROW, COL);     //aşağı
	         Search7(M, i + 1, j + 1, ROW, COL); //sağ üst çarpraz
	         Search7(M, i - 1, j - 1, ROW, COL); //sol alt çarpraz
	         Search7(M, i + 1, j - 1, ROW, COL); //sağ alt çarpraz
	         Search7(M, i - 1, j + 1, ROW, COL); //sol üst çarpraz
	     }
	 }
             @Override
    public void OutputShapes() throws IOException {
     // Şekil sayısı bulan numberofshape metodunun çıktısını değişken içine atıyorum.
     //Outputshapefile içerisinde tekrar kullanılması gerektiği için.
     //değişken içine atmayıp tekrar kendi halini çalıştırırsam recursive fonksiyon oldugu için fazladan dönmüş oluyor ve doğru sonuç vermiyor.
            int b = Numberofshapes(M); 
     
	        c=b;
   		System.out.print("There are " + b +" shapes" ); //Shape sayısını yazdırır
   		System.out.println("\n");
   		 
                //Tespit edilen shape arraylerinin içindeki 1 leri yıldıza, 0ları boşluğa çeviriyorum.
   			for(int h=0; h<=b;h++) {
   		            for(int x=0;x<11;x++) {	
   			      for(int y=0; y < 14;y++) {
   				if(h==1) {
   				  if(AB1[x][y]=="1") {
   				  AB1[x][y] = "*";
   				}
   				  else {
   			          AB1[x][y] = " ";
   				}
   				}
   				if(h==2) {
   					if(AB2[x][y]=="1") {
   						AB2[x][y] = "*";
   					}else {
   						AB2[x][y] = " ";
   					}
   					}
   				
   				if(h==3) {
   					if(AB3[x][y]=="1") {
   						AB3[x][y] = "*";
   					}
   					else {
   						AB3[x][y] = " ";
   					}
   					}
   				
   				if(h==4) {
   					if(AB4[x][y]=="1") {
   						AB4[x][y] = "*";
   					}
   					else {
   						AB4[x][y] = " ";
   					}
   					}	
   				if(h==5) {
   					if(AB5[x][y]=="1") {
   						AB5[x][y] = "*";
   					}
   					else {
   						AB5[x][y] = " ";
   					}
   					}
                                if(h==6) {
   					if(AB6[x][y]=="1") {
   						AB6[x][y] = "*";
   					}
   					else {
   						AB6[x][y] = " ";
   					}
   					}
                                if(h==7) {
   					if(AB7[x][y]=="1") {
   						AB7[x][y] = "*";
   					}
   					else {
   						AB7[x][y] = " ";
   					}
   					}
                               
   				}
   		
   		        }
   		  	}
   		//Tespit edilen şekilleri yazdırır. Count sayısı yani tespit edilen şekil sayısına kadar olan matrixleri yazdırır.
                //b değişkeni shape sayısını içinde tutar ve ana döngü shape sayısı kadar döner.
   		 for(int aa=1;aa<= b ;aa++) {
   			 System.out.println("Shape "+ aa);
   		    for(int i=0;i<11;i++) {
   		    	for(int j=0;j<14;j++) {
   		    		if(aa == 1) {
   		    		System.out.print(AB1[i][j]+ " ");
   		    		}
   		    		if(aa == 2) {
   			    		System.out.print(AB2[i][j]+ " ");
   			    		}
   		    		if(aa == 3) {
   			    		System.out.print(AB3[i][j]+ " ");
   			    		}
   		    		if(aa == 4) {
   			    		System.out.print(AB4[i][j]+ " ");
   			    		}
   		    		if(aa == 5) {
   			    		System.out.print(AB5[i][j]+ " ");
   			    		}
                                if(aa == 6) {
   			    		System.out.print(AB6[i][j]+ " ");
   			    		}
                                if(aa == 7) {
   			    		System.out.print(AB7[i][j]+ " ");
   			    		}
   		    	}
   		    	System.out.println(" ");
   		    }
   		 }
   		    

    }
        
        

    
    public void OutputShapestoFile(String path1) throws IOException {
        //Filewriter kullanarak aynı çıktımı txt dosyama aktarıyorum.
        FileWriter fw = new FileWriter("outputshapes.txt");
        fw.write("There are " + c +" shapes" );
           fw.write("\n");
           for(int aa=1;aa<= c ;aa++) {
     			 fw.write("Shape "+ aa);
     			 fw.write("\n");
     		    for(int i=0;i<11;i++) {
     		    	for(int j=0;j<14;j++) {
     		    		if(aa == 1) {
     		    			fw.write(AB1[i][j]+ " ");
     		    		}
     		    		if(aa == 2) {
     		    			fw.write(AB2[i][j]+ " ");
     			    		}
     		    		if(aa == 3) {
     		    			fw.write(AB3[i][j]+ " ");
     			    		}
     		    		if(aa == 4) {
     		    			fw.write(AB4[i][j]+ " ");
     			    		}
     		    		if(aa == 5) {
     		    			fw.write(AB5[i][j]+ " ");
     			    		}
                                if(aa == 6) {
     		    			fw.write(AB6[i][j]+ " ");
     			    		}
                                if(aa == 7) {
     		    			fw.write(AB7[i][j]+ " ");
     			    		}
     		    	}
     		    	fw.write("\n ");
     		    }
     		 }
           fw.close();  
    }
}
        
    

        
