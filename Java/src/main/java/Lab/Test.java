package Lab;

abstract class Abstract
{
    abstract void Test1 ();

    void Test2()
    {
        System.out.println("Lab.Abstract Test2");
    }
}

interface Interface1
{
    void Test1();
}

interface Interface2
{
    void Test2();
}

interface Interface3 extends Interface1 , Interface2
{
    // no point overriding abstract class
    void Test1();
    // no point overriding abstract class
    void Test2();

    void Test3();
}

class TestClassA
{
    public static void method4()
    {
        System.out.println("A");
    }

    public  void method2()
    {

    }


}

class TestClassB extends TestClassA
{
    public static void method4()
    {
        System.out.println("B");
    }

    public void method2()
    {

    }
}

// no point implement interface 1 cos interface 3 already included
public class Test extends Abstract implements Interface3, Interface1 {


    @Override
    public void Test1() {
        System.out.println("Class Test1");
    }

    @Override
    public void Test2() {
        System.out.println("Class Test2");
    }

    @Override
    public void Test3() {
        System.out.println("Class Test3");
    }



    public static void main(String[] args)
    {
        Test test = new Test();
        test.Test1();
        test.Test2();
        test.Test3();

        TestClassB tcb = new TestClassB();
        tcb.method2();
        tcb.method4();

        TestClassA tca = new TestClassB();
        tca.method4();
    }
}
