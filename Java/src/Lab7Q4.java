import java.text.SimpleDateFormat;
import java.util.Date;

interface SomethingIsWrong {
    void aMethod(int aValue);
}

class NothingIsWrong implements SomethingIsWrong
{

    @Override
    // idk input int for what? no point too
    public void aMethod(int aValue) {
        System.out.println("Hi Mom");

    }
}

interface ExtraCharSequenceInterface
{
    String Backward();

    String CurrentDateTime();
}


class CustomCharSequence implements java.lang.CharSequence , ExtraCharSequenceInterface
{
    private CharSequence cs;

    public CustomCharSequence(CharSequence cs) {
        this.cs = cs;
    }

    public CharSequence getCs() {
        return cs;
    }

    public void setCs(CharSequence cs) {
        this.cs = cs;
    }

    @Override
    public int length() {
        return cs.length();
    }

    @Override
    public char charAt(int index) {
        return cs.charAt(index);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return cs.subSequence(start, end);
    }

    @Override
    public String toString() {
        return "CustomCharSequence{" +
                "cs=" + cs +
                '}';
    }


    @Override
    public String Backward() {
        StringBuilder sb = new StringBuilder(cs);
        sb.reverse();
        return sb.toString();

    }

    @Override
    public String CurrentDateTime() {
        Date date = new Date();

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        return formatter.format(date);

    }
}


public class Lab7Q4
{
    public static void main(String[] args)
    {
        CustomCharSequence ccs = new CustomCharSequence("CCS");
        System.out.println("Length:" + ccs.length());
        System.out.println("First Chars:" + ccs.charAt(0));
        System.out.println("Sub Seq:" + ccs.subSequence(0,2));
        System.out.println("Backward:" + ccs.Backward());
        System.out.println("Current date and time:" + ccs.CurrentDateTime());
    }
}
