package ex2;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws IOException
    {
        FileWriter wr=new FileWriter("src/ex2/out.txt");
        Path path=Paths.get("src/ex2/in.txt");
        List<String> list= Files.readAllLines(path);
        String min=Collections.min(list),max=Collections.max(list);
        float sum=0;
        for(int i=0;i<list.size();i++)
        {
            System.out.println(list.get(i));
            sum+=Float.parseFloat(list.get(i));
        }
        float avg=sum/list.size();
        System.out.println("Minimul este: "+min);
        System.out.println("Maximul este: "+max);
        System.out.println("Avg: "+avg);
        System.out.println("Sum: "+sum);
        wr.write("Minimul este: "+min+"\n");
        wr.write("Maximul este: "+max+"\n");
        wr.write("Avg: "+avg+"\n");
        wr.write("Sum: "+sum+"\n");
        wr.close();

    }
}
