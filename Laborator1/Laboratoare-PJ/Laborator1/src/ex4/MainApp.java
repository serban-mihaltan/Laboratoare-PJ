package ex4;

import java.io.IOException;
import java.util.Random;

public class MainApp
{
    public static void main(String[] args) throws IOException
    {
        Random rand = new Random();
        int a=rand.nextInt(31),b=rand.nextInt(31);
        System.out.println("a: "+a+" ,b: "+b);
        if(a==0 )
            System.out.println("cmmdc: "+b);
        else if(b==0)
            System.out.println("cmmdc: "+a);



        else
        {
            while(a!=b)
            {
                if(a>b)a=a-b;
                else b=b-a;
            }
            System.out.println("cmmdc: "+a);
        }
    }
}
