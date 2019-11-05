import java.util.Calendar;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;

import net.sourceforge.tess4j.*;

public class extractText {
    public static void main(String[] args) throws IOException{
    	
        File imageFile = new File("C:\\Users\\mssp1\\OneDrive\\Pictures\\Screenshots\\Screenshot (61).png");//specify the path in which the image resides
        ITesseract instance = new Tesseract();  
        instance.setDatapath("D:\\Tess4J-3.4.8-src\\Tess4J");//path where Tess4J resides
        instance.setLanguage("eng");

        try {
            String result = instance.doOCR(imageFile);
            
            Calendar cal = Calendar.getInstance();
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
            File fp = new File("D:/out"+formatter.format(cal.getTime())+".txt");//specify the location for the output file
            
            if(fp.createNewFile())
            	System.out.println("File created!");
            else {
            	System.out.println("New file created!");
            }
            
            FileWriter writer = new FileWriter(fp);
            writer.write(result);
            writer.close();
        } catch (TesseractException e) {
            System.err.println(e.getMessage());
        }
    }
}
