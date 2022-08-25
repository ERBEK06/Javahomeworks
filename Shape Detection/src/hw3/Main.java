
package hw3;

import java.io.IOException;

/**
 *
 * @author ERBEK
 */
public class Main {
    public static void main(String[] args) throws IOException{
    Shape hw3 = new Shape();
     String path = "C:\\Users\\REPEDRA\\Desktop\\HW3\\HW3Q2.TXT";// hw3 klasörü içerisindeki HW3Q2.txt dosyasına sağ tık özellikler diyerek konum kısmı buraya yazılmalı.	
     String path1 = "C:\\Users\\REPEDRA\\Desktop\\HW3";//hw3 klasörünün dosya yolu buraya yazılmalıdır.
     
		hw3.ReadShapeFile(path);
		hw3.OutputShapes();
		hw3.OutputShapestoFile(path1);
}
        }