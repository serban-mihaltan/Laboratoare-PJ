package ex3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainApp
{
    public static void main(String[] args) throws IOException
    {
        String a,b,filename;
        //StringBuilder rezultat;
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Primul sir: ");
        a=br.readLine();
        System.out.println("Al doilea sir: ");
        b=br.readLine();
        br.close();
        StringBuilder rezultat=new StringBuilder(a);
        rezultat.insert(3,b);
        System.out.println(rezultat.toString());
        rezultat.delete(3,8);
        System.out.println(rezultat.toString());

    }
}
