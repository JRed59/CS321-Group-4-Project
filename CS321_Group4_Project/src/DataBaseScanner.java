import java.io.*;  

public class DataBaseScanner {
    public DataBaseScanner() {
        try {
            File filename = newFile("UAHDining.txt");
            FileInputStream fis = new FileInputStream(filename);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

}
