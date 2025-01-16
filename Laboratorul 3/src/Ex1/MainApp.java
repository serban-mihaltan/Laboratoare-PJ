package Ex1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MainApp
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new FileReader("src/Ex1/in.txt"));
        List<Parabola> parabolas = new ArrayList<Parabola>();
        String line;
        while((line=br.readLine())!=null)
        {
            String[] tokens = line.split(" ");
            parabolas.add(new Parabola(Integer.parseInt(tokens[0]),Integer.parseInt(tokens[1]),Integer.parseInt(tokens[2])));
        }
        br.close();
        for(Parabola parabola:parabolas)
        {
            System.out.println(parabola);
            float []ar=parabola.varf();
            System.out.println("X: "+ar[0]+" Y: "+ar[1]);
        }

        float []ar;
        float cv;
        ar=parabolas.get(0).varfSegment(parabolas.get(2));
        cv=Parabola.lungimeSegmentParabole(parabolas.get(0),parabolas.get(2));
        System.out.println("Coord varf intersectie X: "+ar[0]+" Y: "+ar[1]);
        System.out.println("Lungime: "+cv);
    }
}
