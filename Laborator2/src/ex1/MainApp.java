package ex1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class MainApp
{
    public static void main(String[] args)
    {
        try{
            Scanner sc = new Scanner(System.in);
            String fisier_in="judete_in.txt";
            BufferedReader read=new BufferedReader(new FileReader(fisier_in));
            String[] judete=new String[42];
            int i=0;
            String a;
            while((a=read.readLine()) != null)
            {

                judete[i]=a;
                i++;
            }
            //for(i=0;i<judete.length;i++)
            //  System.out.println(judete[i]+" ");


            Arrays.sort(judete);
            for(i=0;i<judete.length;i++)
                System.out.println(judete[i]+" ");
            String jud;
            jud=sc.next();

            System.out.println(Arrays.binarySearch(judete,jud));

        }

        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

}
