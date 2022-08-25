

package osman_bahadır_erbek_hw1;


import java.util.Random;

public class cMatrix {
	 private long [][] elements; // Keeps the elements of matrix in two dimensional array
	 private int row; // row size
	 private int col; // column size
	 
	  public cMatrix(){ 
		row=10;
		col=10;
		long[][] elements = new long[row][col];
		this.elements=elements;
		
			}
	  
	  public cMatrix(int row, int col){ //Constructor
		  long[][] elements = new long[row][col];
			 this.elements=elements;
			 this.row = row;
			 this.col = col;
		    
		    
	  }
	  
	  public void AssignRandom(){ //Assigning random variables in range 1 - 10000
		  int sayi;
		  Random rnd = new Random();
			sayi = rnd.nextInt(10000);
	  
		  for(int i=0; i<row; i++) {
				for(int j=0; j<col; j++) {
					elements[i][j]=rnd.nextInt(10000);
			}
                  }
		  }
	  
	  
	  public void printMatrix(){ 
		  
		  elements=this.elements;
		  
		  
				for(int i=0; i<row; i++) {
					for(int j=0; j<col; j++) {
					System.out.print(elements[i][j] + " ");}
					
					System.out.print("\n");
	  }
		  }
	  
	  public void printMatrixWithPrime(){ //Prints the matrix with “*” signnear the prime elements
		  long beginTime = 0, endTime = 0;
		  beginTime = System.currentTimeMillis();
		        int sayac = 0;
		         for(int i=0; i<row; i++) {
					for(int j=0; j<col; j++) {
		                for(int a = 2; a < elements[i][j]; a++)
		        {
		            if(elements[i][j] % a == 0) {
		                sayac++;
		            }
		        }	 
				     if(sayac == 0) {
		            System.out.print(elements[i][j] + "* ");
		        }
		        else {
		            System.out.print(elements[i][j] + " ");
		            sayac=0;
		        }
		        }
					System.out.print("\n");
		        }
		        
		        endTime = System.currentTimeMillis();
				  System.out.println("The duration of multiplication of matrices : " + this.row +"x" +this.col + "  " +((double) (endTime - beginTime)) + " milisecond"); 
				  System.out.println("\n");
		   }
          
	   public cMatrix(long [][] newmx) {
               
		 this.elements=newmx;  
                 
	       this.row=newmx.length; 
	       this.col=newmx.length; 
	 }
           
	  public cMatrix multiplyMatrices(cMatrix Multiplicand){ // Multiply two matrices and informs the user about time lapse
		  
		  long[][] carpan = Multiplicand.elements;
		  long[][] newmx = new long [elements.length][carpan.length];
		  int row1=Multiplicand.row;
		  int col1=Multiplicand.col;
		  
		  for(int i=0; i< this.row; i++) {
			  for(int j=0; j<col1; j++) {
				  for(int k=0; k<row1;k++) {
					  newmx[i][j] += cMatrix.this.elements[i][k] * Multiplicand.elements[k][j];	  
				  }
			  }
		  }
		  
		  return new cMatrix(newmx);
		  
		   }
	  }

		  
