package Lab;

import java.util.ArrayList;
import java.util.Objects;

class SearchHashCode
{
    private final String name;

    public SearchHashCode(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SearchHashCode that = (SearchHashCode) o;

        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }


}


public class Lab7Q3 {


    public static void main(String[] args)
    {
        ArrayList<SearchHashCode>  arr1 = new ArrayList<>();

        for(int i = 0 ; i < 1000 ; ++i)
        {
            StringBuilder name = new StringBuilder();
            for(int j = 0 ; j < 10 ; ++ j)
            {
                int asciiNo = 1 + (int) (Math.random() * ((127 + 1)));
                char c = (char) asciiNo;
                name.append(c);

            }
            arr1.add(new SearchHashCode(name.toString()));


        }



        long time = System.nanoTime();



        for (int i = 0; i < arr1.size(); ++i)
        {
            if(arr1.get(i).getName().equals(arr1.get(0).getName()))
            {
                System.out.println("No hash time taken:" + (System.nanoTime() -  time));
                break;
            }
        }
        time = System.nanoTime();
        for (int i = 0; i < arr1.size(); ++i)
        {
            if(arr1.get(i).hashCode() == arr1.get(0).hashCode())
            {
                System.out.println("Hash time taken:" + (System.nanoTime() -  time));
                break;
            }
        }
    }
}
