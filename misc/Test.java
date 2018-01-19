import java.io.*;
import java.util.*;

public class Test {
    public static void main(String[] args) {
        ArrayList<String> codes = new ArrayList<String>();
        ArrayList<String> letters = new ArrayList<String>();

        try {
            FileReader f = new FileReader("input.txt");
            BufferedReader br = new BufferedReader(f);

            String line;
            String[] splitted;


            while ((line = br.readLine()) != null) {
                System.out.println(line);
                splitted = line.split("\\s+");
                codes.add(splitted[0]);
                letters.add(splitted[1]);
            }


            f.close();
            br.close();

            System.out.println(codes.toString());
            System.out.println("---");
            System.out.println(letters.toString());

        } catch (Exception e) {
            System.out.println("File not found");
            return;
        } 
        
    }
}
