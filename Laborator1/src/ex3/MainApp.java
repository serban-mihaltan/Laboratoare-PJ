package ex3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainApp {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Nr: ");
        int nr=Integer.parseInt(br.readLine()),cnt=0;
        System.out.println(1);
        for(int i=2;i<=nr/2;i++)
            if(nr%i==0)
            {
                System.out.println(i);
                cnt++;
            }
        System.out.println(nr);
        if(cnt==0)
            System.out.println("Numarul este prim");

    }
}
