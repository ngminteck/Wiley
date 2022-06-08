import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


public class Lab3
{
    public static int WordExtract(String para, String match)
    {
        return (para.split(match,-1).length) -1;
    }

    public static int CountVowels(String str)
    {
        int count = 0;
       for(int i = 0 ;i <str.length(); ++i)
       {
           if(str.charAt(i) == 'A' || str.charAt(i) == 'a'
           || str.charAt(i) == 'E' || str.charAt(i) == 'e'
           || str.charAt(i) == 'I' || str.charAt(i) == 'i'
           || str.charAt(i) == 'O' || str.charAt(i) == 'o'
           || str.charAt(i) == 'U' || str.charAt(i) == 'u')
               ++ count;
       }
       return count;
    }

    public static void Question1()
    {
        System.out.println("Count:" + WordExtract("abaabaaabaa", "aab"));
    }

    public static void Question2()
    {
        System.out.println("Vowels count:" + CountVowels("CLARENCE ng min teck"));
    }

    public static void Question3()
    {
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());
        while(testCases>0){
            String line = in.nextLine();

            //Write your code here

            boolean recordOpenTag = false;
            boolean recordCloseTag = false;
            boolean recordMsg = true;
            boolean printAnything = false;
            String newString ="";
            String openTag="";
            String closeTag="";
            for(int i = 0; i < line.length(); ++ i)
            {
                if(line.charAt(i) == '<')
                {
                    // check out of bound
                    if(i + 1 >= line.length())
                    {
                        recordOpenTag = false;
                        recordCloseTag = false;
                        recordMsg = true;
                        newString ="";
                        openTag="";
                        closeTag="";
                        break;
                    }
                    // process record closing tag signature
                    if(line.charAt(i + 1) == '/')
                    {
                        closeTag="";
                        recordCloseTag = true;
                    }
                    // process record opening tag signature
                    else
                    {
                        openTag ="";
                        recordOpenTag = true;
                    }
                    recordMsg = false;
                    continue;
                }

                if(line.charAt(i) == '>')
                {
                    // processing the message output if done record closing tag
                    if(recordCloseTag)
                    {
                        if(openTag.length() > 0 && closeTag.length() > 0)
                        {
                            closeTag = closeTag.substring(1, closeTag.length());

                            if(openTag.equals(closeTag)&& newString.length() > 0)
                            {
                                System.out.println(newString);
                                printAnything = true;
                            }
                        }
                        // reset variable
                        recordOpenTag = false;
                        recordCloseTag = false;
                        recordMsg = true;
                        newString ="";
                        openTag="";
                        closeTag="";

                    }
                    // processing record main message and stop record open tag
                    else
                    {
                        recordOpenTag = false;
                        recordMsg = true;
                        newString ="";
                    }
                    continue;
                }

                // just copy string
                if(recordOpenTag)
                    openTag += line.charAt(i);

                if(recordCloseTag)
                    closeTag += line.charAt(i);

                if(recordMsg)
                    newString += line.charAt(i);
            }

            if(!printAnything)
                System.out.println("None");

            testCases--;
        }
    }


    public static void main(String[] args)
    {
        //Question1();
        //Question2();
        //Question3();
    }
}
