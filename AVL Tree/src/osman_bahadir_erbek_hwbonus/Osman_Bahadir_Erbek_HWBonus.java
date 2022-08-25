
package osman_bahadir_erbek_hwbonus;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author REPEDRA
 */
public class Osman_Bahadir_Erbek_HWBonus {

  
    public static void main(String[] args) throws NumberFormatException, IOException {
        
              ConstructAVLTree hwbonus = new ConstructAVLTree();   

        hwbonus.processFile("C:\\Users\\REPEDRA\\Documents\\NetBeansProjects\\Osman_Bahadir_Erbek_HWBonus\\file.txt");
        // hwbonus.insertStudent(146, "bahadir", "erbek", 1); 
        // hwbonus.printSearchPath(11);
        
       
       
       String name;
       String surname;
       int idnumber;
       int choice;    
       Scanner sc = new Scanner(System.in);   
        do      
        {  
            System.out.println("\nSelect an operation:\n");  
            System.out.println("1. Insert a student");  
            System.out.println("2. Search a student");  
            System.out.println("3. Remove all Students from AVL Tree");  
             
  
           
            int ch = sc.nextInt();              
            switch (ch)  
            {  
                case 1 :   
                    System.out.println("Enter an id number");  
                    idnumber = sc.nextInt();
                    System.out.println("Enter an Name"); 
                    name = sc.next();
                    System.out.println("Enter an Surname"); 
                    surname = sc.next();
                    hwbonus.insertStudent( idnumber, name, surname, 1 );                       
                    break;                            
                case 2 :   
                    System.out.println("Enter idnumber to search");  
                    hwbonus.printSearchPath( sc.nextInt() );  
                    break;                                            
                       
                case 3 :   
                    hwbonus.removeAll();  
                    System.out.println("\nTree Cleared successfully");  
                    break;  
   
            }  
            System.out.println("\nPress '1' to continue \n");  
            System.out.println("Press '0' to exit");
            choice = sc.nextInt();
            if(choice==0) {
            	System.out.println("Logged out");
            	break;
            }
        } while (choice == 1); 
    }
    
}
