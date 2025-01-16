package ex1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
public class MainApp{

    /**
     * Writes the given list of PerecheNumere objects to a JSON file.
     *
     * @param list the list of PerecheNumere objects to be written to the file
     */
    public static void scriere(List<PerecheNumere> list)
    {
        try{
            ObjectMapper mapper = new ObjectMapper();
            File file =new File("src/main/resources/perechenumere.json");
            mapper.writeValue(file,list);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }
    /**
     * Reads a JSON file containing a list of PerecheNumere objects and converts
     * it into a List of PerecheNumere.
     *
     * @return a list of PerecheNumere objects if the file is successfully read,
     * or null if an IOException occurs.
     */
    public static List<PerecheNumere> citire()
    {
       try
       {
           ObjectMapper mapper = new ObjectMapper();
            File file =new File("src/main/resources/perechenumere.json");
            List<PerecheNumere> list=mapper.readValue(file, new TypeReference<List<PerecheNumere>>(){});
            return list;
        }
       catch (IOException e)
       {
           e.printStackTrace();
           return null;
       }
    }

    /**
     * The main method that serves as the entry point to the application. It creates
     * a list of PerecheNumere objects, writes them to a JSON file, reads the list
     * back from the JSON file, and then prints the list.
     *
     * @param args command line arguments
     */
    public static void main(String[] args)
    {
        List<PerecheNumere> perecheNumere=new ArrayList<PerecheNumere>();
        perecheNumere.add(new PerecheNumere(3,4));
        perecheNumere.add(new PerecheNumere(5,6));
        perecheNumere.add(new PerecheNumere(40,10));
        scriere(perecheNumere);
        List<PerecheNumere> p=citire();
        System.out.println(p);
    }
}
