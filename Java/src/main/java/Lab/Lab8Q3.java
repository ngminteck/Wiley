package Lab;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Lab8Q3 {

    public static void cat(File file)
    {
        RandomAccessFile input = null;
        String line;

        try {
            input = new RandomAccessFile(file,"r");

            while((line = input.readLine()) !=null)
            {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println(e);
        } finally {

                try {
                    if (input != null) {
                        input.close();
                    }
                } catch (IOException e) {
                    System.out.println(e);
                }



        }
    }

    public static void main(String[] args)
    {

        cat(new File("src/Lab/ListOfNumber.txt"));
    }
}
