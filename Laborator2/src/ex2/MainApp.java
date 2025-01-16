package ex2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainApp {
    public static void main(String[] args) throws IOException
    {
        //String x="hello world";
        //System.out.println(x.substring(x.length()-3));
        String filename="src/ex2/cantec_in.txt",exit_file="src/ex2/cantec_out.txt";
        List<Vers>list=readFile(filename);
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Gruparea de litere aleasa: ");

        String s=br.readLine();

        BufferedWriter bw=new BufferedWriter(new FileWriter(exit_file));
        for(Vers v:list)
        {
            String vers=v.getVers(),b;

            if(vers.substring(vers.length()-s.length()).equals(s))
                b="*";
            else b="";

            Random r=new Random();
            //System.out.println(r.nextBoolean());
            if(r.nextBoolean())
            bw.write(v.getVers()+" "+v.cuv()+" "+v.voc()+" "+b);
            else
                bw.write(v.getVers().toUpperCase()+" "+v.cuv()+" "+v.voc()+" "+b);
            bw.newLine();

        }
        br.close();
        bw.close();
    }
    public static List<Vers> readFile(String filename) throws IOException
    {
        List<Vers> list = new ArrayList<Vers>();
        String line;
        BufferedReader br = new BufferedReader(new FileReader(filename));
        while((line=br.readLine())!=null)
            list.add(new Vers(line));
        br.close();
        return list;
    }
}
