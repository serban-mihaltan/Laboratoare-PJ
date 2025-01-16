package ex2;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ex1.PerecheNumere;

import java.io.*;
import java.util.List;




/**
 * The MainApp class provides functionalities to read and write a list of Mobilier objects
 * from and to a JSON file. It also includes a main method that allows users to interact
 * with the list of Mobilier objects via the console.
 */
public class MainApp {

    /**
     * Writes a given list of Mobilier objects to a JSON file.
     *
     * @param list the list of Mobilier objects to be written to the JSON file
     */
    public static void scriere(List<Mobilier> list)
    {
        try{
            ObjectMapper mapper = new ObjectMapper();
            File file =new File("src/main/resources/mobilier.json");
            mapper.writeValue(file,list);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    /**
     * Reads a list of Mobilier objects from a JSON file located in the resources directory.
     *
     * @return a List of Mobilier objects read from the JSON file. If an error occurs during the reading
     *         operation, null is returned.
     */
    public static List<Mobilier>citeste()
    {
        try
        {
            ObjectMapper mapper = new ObjectMapper();
            File file =new File("src/main/resources/mobilier.json");
            List<Mobilier> list=mapper.readValue(file, new TypeReference<List<Mobilier>>(){});
            return list;
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return null;
        }
    }
    /**
     * The main entry point of the application. This method provides a command line interface
     * for interacting with a list of Mobilier objects. The user can display the complete list
     * of objects, selectively display objects based on a given name, and calculate the number
     * of sheets required for a given Mobilier object.
     *
     * @param args command-line arguments passed to the program.
     * @throws IOException if an I/O error occurs while reading from the input.
     */
    public static void main(String[] args) throws IOException
    {
        List<Mobilier> list=citeste();
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int opt;
        String s;
        do{
            System.out.println("1. Afisare lista completa\n 2. Afisare Selectiva\n 3. Afisare nr coli \n 0. Iesire\n Opt: ");
            opt=Integer.parseInt(br.readLine());
            switch(opt)
            {
                case 1:
                for (Mobilier mobilier : list)
                {
                    System.out.println(mobilier);
                }
                break;
                case 2:
                    System.out.println("Nume: ");
                    s=br.readLine();
                    for(Mobilier mobilier : list)
                    {
                        if(mobilier.getNume().equals(s))
                            System.out.println(mobilier);
                    }
                break;
                case 3:
                    System.out.println("Nume: ");
                    s=br.readLine();
                    for(Mobilier mobilier : list)
                    {
                        if(mobilier.getNume().equals(s))
                        {
                            System.out.println(mobilier.supPlaci()/(2800*2070)+1);
                        }
                    }
                    break;
                    case 0:
                        break;
                        default:
                            System.out.println("opt gresita");
                            break;


            }
        }while(opt!=0);


    }
}
