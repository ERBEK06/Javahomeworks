/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package osman_bahadır_erbek_hw1;

/**
 *
 * @author REPEDRA
 */
public class Osman_Bahadır_Erbek_HW1 {
    
    public static void main(String[] args) {
      cMatrix m1 = new cMatrix();
 m1.AssignRandom();
 m1.printMatrix();
 System.out.println("");
 m1.printMatrixWithPrime();
 cMatrix m2 = new cMatrix(10,20);
 m2.AssignRandom();
 cMatrix m3 = new cMatrix(20,10);
 m3.AssignRandom();
 cMatrix m4 = new cMatrix();
 m4 = m2.multiplyMatrices(m3);
 m4.printMatrixWithPrime(); 
    }
    
}
