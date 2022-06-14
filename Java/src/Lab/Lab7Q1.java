package Lab;

class TestObjectClass
{
    int number;

    public TestObjectClass(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return ""+ number;
    }


}


public class Lab7Q1 {

    public static void main (String[] args)
    {
        int intNo = 1;
        String stringNo = "1";

        // just use string + method the most simple
        String intNoString = ""+ intNo;


        int stringNoInt;


        try{
            stringNoInt = Integer.parseInt(stringNo);

        }catch(NumberFormatException ignored){
            // ask the user to try again
        }



    }
}
