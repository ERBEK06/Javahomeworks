/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package osman_bahadir_erbek_hwbonus;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class AVLNode {
	
	int idnumber;
	String name;
	String surname;
	
	int element;  
    int h;  
    AVLNode left;  
    AVLNode right;  
      
   
    public AVLNode()  
    {  
        left = null;  
        right = null;  
        element = 0;  
        h = 0;  
    }  
   
    public AVLNode(int element)  
    {  
        left = null;  
        right = null;  
        this.element = element;  
        h = 0;  
    }       
}  
  


class ConstructAVLTree  
{  
    private AVLNode rootNode;       
  
 
    public void removeAll()  
    {  
        rootNode = null;  
    }  
      

      
    public void insertStudent(int element, String name, String surname,int i)  
    {  
    	 if(i<=0) {
         	return;
         }
        rootNode = insertStudent(element, rootNode, name, surname);  
      
    }  
  
    private int getHeight(AVLNode node )  
    {  
        return node == null ? -1 : node.h;  
    }  
      
    
    private int getMaxHeight(int leftNodeHeight, int rightNodeHeight)  
    {  
    return leftNodeHeight > rightNodeHeight ? leftNodeHeight : rightNodeHeight;  
    }  
    
    
    int numberofadd;
    int numberofdelete;

    public void processFile(String path) throws NumberFormatException, IOException {
    	
    	FileReader fileReader = new FileReader(path);
		String line;

		BufferedReader br = new BufferedReader(fileReader);
        int a =1;
        int digits1[] = new int[2];
		while ((line = br.readLine()) != null) {
			String theDigits[] = line.split(" ");
		    
		    for(int i = 0; i < theDigits.length; i++){
		        digits1[i] = Integer.parseInt(theDigits[i]);	        
		    }
		   
		    numberofadd = digits1[0];
		    numberofdelete = digits1[1];
		    
         a--;
         if(a==0) {
        	 break;
         }
		}

		br.close();
		
		FileReader fr = new FileReader(path);
		BufferedReader buffer = new BufferedReader(fr);
       
		String digits[][] = new String[100][100];
		int actualLine = 0;
        int aa=0;
        int bb=0;
	
		String line1 = buffer.readLine();

		while(line != null && !line1.equals("")){

		    String theDigits[] = line.split(" ");
		    for(int i = 0; i < theDigits.length; i++){
		        digits[actualLine][i] = theDigits[i];
		        aa=theDigits.length;
		       
		    }
		    
		    actualLine++;
		    bb=actualLine;
		    line = buffer.readLine();
		}
		String name="";
		String surname="";
		int idnumber=0;
		int c=1;
		for(int a1=0;a1<bb;a1++) {
			for(int b=0;b<aa;b++) {
				if(digits[a1][b]!= null) {
					if(c==bb) {
						break;
					}
					        idnumber = Integer.parseInt(digits[c][0]);							
						name = digits[c][1];
						surname = digits[c][2];
					
						insertStudent( idnumber,  name,  surname,numberofadd);
						numberofadd--;
						c++;	
				}
			}
		}}
    
    
   
    private AVLNode insertStudent(int idnumber, AVLNode node, String name, String surname)  
    {  
         
        if (node == null)  
            node = new AVLNode(idnumber);  
         
        else if (idnumber < node.element)  
        {  
            node.left = insertStudent( idnumber, node.left, name,  surname );  
            if( getHeight( node.left ) - getHeight( node.right ) == 2 )  
                if( idnumber < node.left.element )  
                    node = rotateWithLeftChild( node );  
                else  
                    node = doubleWithLeftChild( node );  
        }  
        else if( idnumber > node.element )  
        {  
            node.right = insertStudent( idnumber, node.right,name, surname );  
            if( getHeight( node.right ) - getHeight( node.left ) == 2 )  
                if( idnumber > node.right.element)  
                    node = rotateWithRightChild( node );  
                else  
                    node = doubleWithRightChild( node );  
        }  
        else  
             
        node.h = getMaxHeight( getHeight( node.left ), getHeight( node.right ) ) + 1;  
          
        return node;  
          
    }  
      
    // creating rotateWithLeftChild() method to perform rotation of binary tree node with left child        
    private AVLNode rotateWithLeftChild(AVLNode node2)  
    {  
        AVLNode node1 = node2.left;  
        node2.left = node1.right;  
        node1.right = node2;  
        node2.h = getMaxHeight( getHeight( node2.left ), getHeight( node2.right ) ) + 1;  
        node1.h = getMaxHeight( getHeight( node1.left ), node2.h ) + 1;  
        return node1;  
    }  
  
    // creating rotateWithRightChild() method to perform rotation of binary tree node with right child        
    private AVLNode rotateWithRightChild(AVLNode node1)  
    {  
        AVLNode node2 = node1.right;  
        node1.right = node2.left;  
        node2.left = node1;  
        node1.h = getMaxHeight( getHeight( node1.left ), getHeight( node1.right ) ) + 1;  
        node2.h = getMaxHeight( getHeight( node2.right ), node1.h ) + 1;  
        return node2;  
    }  
  
    //create doubleWithLeftChild() method to perform double rotation of binary tree node. This method first rotate the left child with its right child, and after that, node3 with the new left child  
    private AVLNode doubleWithLeftChild(AVLNode node3)  
    {  
        node3.left = rotateWithRightChild( node3.left );  
        return rotateWithLeftChild( node3 );  
    }  
  
    //create doubleWithRightChild() method to perform double rotation of binary tree node. This method first rotate the right child with its left child and after that node1 with the new right child  
    private AVLNode doubleWithRightChild(AVLNode node1)  
    {  
        node1.right = rotateWithLeftChild( node1.right );  
        return rotateWithRightChild( node1 );  
    }      
  
  public void searchStudent(int idnumber) {
	  printSearchPath(idnumber);
	  
  }
  
     
    public void printSearchPath(int element)  
    {  
        printSearchPath(rootNode, element); 
        if(ctrl==false) {
        System.out.println("Student is not in tree");
        }
    }  
    boolean ctrl=false;
    private boolean printSearchPath(AVLNode head, int element)  
    {  
    while ((head != null) )  
        {  
        	
            int headElement = head.element;  
            if (element < headElement)  {
            	
                head = head.left; 
              
            System.out.print(headElement +"-(left)->" ); }
            else if (element > headElement)  {
            	
            	
                head = head.right;
               
            System.out.print(headElement + "-(right)->"); }
            else if( element == headElement)  
            {  
                 ctrl=true;
                System.out.print(headElement + "(Found)");
                break;  
            }  
            else {
            	System.out.println("Student is not in tree");
            }
              
        }  
         return ctrl;
    }
}
  

