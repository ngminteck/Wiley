package Lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lab11Q1 {
    public static void main (String[] args)
    {
        List<Integer> mynum = Arrays.asList(2,3,45,56,23,67,88);

        mynum.forEach(i ->  { System.out.println(i + "x" + i + "=" + i*i); });
        System.out.println("Even");
        mynum.stream().filter((i) -> {return i % 2 ==0;}).forEach(i -> System.out.println(i));
        System.out.println("Odd");
        mynum.stream().filter((i) -> {return i % 2 !=0;}).forEach(i -> System.out.println(i));
    }

}
