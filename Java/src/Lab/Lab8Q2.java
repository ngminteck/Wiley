package Lab;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

class ListOfNumber
{
    private final Vector<Integer> vec = new Vector<>();

    public void ReadFileAndAddNumber()
    {
        try {
            FileReader fileReader = new FileReader("src/Lab/ListOfNumber.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            Scanner sc =  new Scanner(bufferedReader);

            while (sc.hasNextLine())
            {
                String fileData = sc.nextLine();

                try {
                    vec.add(Integer.parseInt(fileData));
                }
                catch (NumberFormatException e)
                {
                    System.out.println(e);
                }

            }

            sc.close();
            bufferedReader.close();
            fileReader.close();

        } catch (IOException e) {
            System.out.println(e);
        }

    }
    public void PrintVector()
    {
        for (Integer integer : vec) {
            System.out.println(integer);
        }
    }
}

public class Lab8Q2 {

    public static void main(String[] args)
    {
        ListOfNumber lon = new ListOfNumber();

        lon.ReadFileAndAddNumber();
        lon.PrintVector();
    }




}
