package ex4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainApp {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Numarul de persoane: ");
        int n=Integer.parseInt(br.readLine());
        Persoana[] persoanas = new Persoana[n];
        for(int i=0;i<n;i++)
        {
            System.out.println("Persoana "+(i+1)+": ");
            System.out.print("Introduceți numele: ");
            String numele = br.readLine();
            String cnp;

            while (true) {
                System.out.print("Introduceți CNP-ul: ");
                cnp = br.readLine();

                if (Persoana.validareCNP(cnp)) {
                    break;
                } else {
                    System.out.println("CNP invalid.");
                }
            }

            persoanas[i] = new Persoana(numele, cnp);
        }
        br.close();
        for(Persoana p : persoanas)
            System.out.println(p.info());
    }
}
