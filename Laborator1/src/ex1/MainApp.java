package ex1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainApp {

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Lungime: ");
        int lungime = Integer.parseInt(br.readLine());
        System.out.println("Latime: ");
        int latime = Integer.parseInt(br.readLine());
        System.out.println("Perimetru: " + (2*(lungime+latime)));
        System.out.println("Arie: "+lungime*latime);

    }
}
