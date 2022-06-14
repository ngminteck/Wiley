class JavaClassObj
{
    private final int id;
    private final String name;

    public JavaClassObj(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JavaClassObj that = (JavaClassObj) o;

        if (id != that.id) return false;
        return name != null ? name.equals(that.name) : that.name == null;
    }

    @Override
    // base on first 3 letter of the name and generate ascii number
    // no a good way to respresent just for this lab purpose
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

}

public class Lab7Q2 {
    public static void main(String[] args)
    {
        JavaClassObj obj1 = new JavaClassObj(1,"a");
        JavaClassObj obj2 = new JavaClassObj(1,"a");
        JavaClassObj obj3 = new JavaClassObj(2,"a");
        JavaClassObj obj4 = new JavaClassObj(2,"aa");

        System.out.println(obj1.equals(obj2));
        System.out.println(obj1.equals(obj3));

        System.out.println(obj1.hashCode());
        System.out.println(obj2.hashCode());
        System.out.println(obj3.hashCode());
        System.out.println(obj4.hashCode());
    }
}
