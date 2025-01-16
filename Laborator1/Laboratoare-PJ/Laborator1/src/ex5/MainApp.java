package ex5;

import java.io.IOException;
import java.util.Random;

public class MainApp
{
    public static void main(String[] args)throws IOException
    {
        Random rand = new Random();
        int n=rand.nextInt(21),a=0,b=1;

        while(a<=20)
        {
            if(a==n)
            {
                System.out.println("n: "+n+" apartine sirului lui Fibonacci");
                return;
            }
            b=b+a;
            a=b-a;
        }
        System.out.println("n: "+n+" nu apartine sirului lui Fibonacci");
    }
}
