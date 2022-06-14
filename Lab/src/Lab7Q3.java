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

    /*
    @Override
    public int hashCode() {
        int result = 0;
        StringBuilder stringNo = new StringBuilder();
        for(int i = 0; i < name.length() ; ++i)
        {
            if( i == 3)
                break;

            int no = name.charAt(i);
            int digit = String.valueOf(no).length();

            if(digit == 1)
                stringNo.append("00").append(no);
            else if (digit == 2)
                stringNo.append("0").append(no);
            else
                stringNo.append(no);
        }

        try{
            result = Integer.parseInt(stringNo.toString());

        }catch(NumberFormatException ignored){

        }

        return result;
    }
    */

}


public class Lab7Q3 {


    public static void main(String[] args)
    {
        ArrayList<SearchHashCode>  arr1 = new ArrayList<>();

        for(int i = 0 ; i < 100 ; ++i)
        {
            StringBuilder name = new StringBuilder();
            for(int j = 0 ; j < 3 ; ++ j)
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
