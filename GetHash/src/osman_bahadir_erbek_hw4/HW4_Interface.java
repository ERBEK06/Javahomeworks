/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package osman_bahadir_erbek_hw4;

;
import java.io.IOException;
/**
 *
 * @author REPEDRA
 */
public interface HW4_Interface {
    
 public Integer GetHash(String mystring);
 public void ReadFileandGenerateHash(String filename, int size) throws IOException;
 public void DisplayResult(String Outputfile)throws IOException;
 public void DisplayResult()throws IOException;
 public void DisplayResultOrdered(String Outputfile)throws IOException;
 public int showFrequency(String myword)throws IOException;
 public String showMaxRepeatedWord()throws IOException;
 public void checkWord(String myword)throws IOException;
 

    
}
