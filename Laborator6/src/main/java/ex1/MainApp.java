package ex1;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MainApp {

    public static List<Angajati> citire()
    {

        try
        {
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            File file =new File("src/main/resources/Angajati.json");
            List<Angajati>l= mapper.readValue(file, new TypeReference<List<Angajati>>(){});
            return l;
        }
        catch(IOException e)
        {
            return null;
        }

    }
    public void scriere(List<Angajati> list)
    {
        try{
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            File file =new File("src/main/resources/Angajati.json");
            mapper.writeValue(file,list);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    public static void main(String[] args)throws IOException
    {
        List<Angajati> list=citire();
        BufferedReader br=new BufferedReader(new java.io.InputStreamReader(System.in));
        int opt;
        if(list==null)
        {
            System.out.println("Lista vida");
        }
        else do
        {
            System.out.println("1 Afisarea listei de angajati");
            System.out.println("2 Afisarea angajatilor care au salariul peste 2500 RON");
            System.out.println("3 Crearea unei liste cu angajații din luna aprilie, a anului trecut, care au functie de " +
                    "conducere ");
            System.out.println("4 Afișarea angajaților care nu au funcție de conducere");
            System.out.println("5 Extragerea din lista de angajati a unei liste de String-uri care contine numele angajatilor " +
                    "scrise cu majuscule.");
            System.out.println("6 Afisarea salariilor mai mici de 3000 de RON");
            System.out.println("7 Afisarea datelor primului angajat al firmei.");
            System.out.println("8 Afisarea de statistici referitoare la salariul angajatilor.");
            System.out.println("9 Afisarea unor mesaje care indica dacă printre angajati exista cel putin un “Ion”.");
            System.out.println("10 Afisarea numarului de persoane care s-au angajat în vara anului precedent.");
            System.out.println("0 Iesire");
            opt=Integer.parseInt(br.readLine());
            switch (opt)
            {
                case 1:
                    list.forEach(System.out::println);
                    break;
                case 2:
                    list.stream().filter(a->a.getSalariu()>2500).forEach(System.out::println);
                    break;
                case 3:
                    int anul_curent = LocalDate.now().getYear();
                    List<Angajati> angajati_conducere = list.stream()
                            .filter(a -> a.getData_angajarii().getYear() == anul_curent - 1 &&
                                    a.getData_angajarii().getMonth() == Month.APRIL &&
                                    (a.getPostul().contains("sef") || a.getPostul().contains("director")))
                            .collect(Collectors.toList());
                    angajati_conducere.forEach(System.out::println);
                    break;
                case 4:
                    list.stream()
                            .filter(a -> !(a.getPostul().contains("sef") || a.getPostul().contains("director")))
                            .sorted(Comparator.comparing(Angajati::getSalariu).reversed())
                            .forEach(System.out::println);
                    break;
                case 5:
                    List<String> numeAngajati = list.stream()
                            .map(a -> a.getNume().toUpperCase())
                            .collect(Collectors.toList());
                    numeAngajati.forEach(System.out::println);
                    break;
                case 6:
                    list.stream()
                            .map(Angajati::getSalariu)
                            .filter(salariu -> salariu < 3000)
                            .forEach(System.out::println);
                    break;
                case 7:
                    Optional<Angajati> primulAngajat = list.stream()
                            .min(Comparator.comparing(Angajati::getData_angajarii));
                    primulAngajat.ifPresentOrElse(
                            System.out::println,
                            () -> System.out.println("Nu există angajați în firmă.")
                    );
                    break;
                case 8:
                    DoubleSummaryStatistics statisticiSalarii = list.stream()
                            .collect(Collectors.summarizingDouble(Angajati::getSalariu));
                    System.out.println("Salariul mediu: " + statisticiSalarii.getAverage());
                    System.out.println("Salariul minim: " + statisticiSalarii.getMin());
                    System.out.println("Salariul maxim: " + statisticiSalarii.getMax());
                    break;
                case 9:
                    list.stream()
                            .map(Angajati::getNume)
                            .filter(nume -> nume.equals("Ion"))
                            .findAny()
                            .ifPresentOrElse(
                                    ion -> System.out.println("Firma are cel puțin un Ion angajat"),
                                    () -> System.out.println("Firma nu are nici un Ion angajat")
                            );
                    break;
                case 10:
                    anul_curent = LocalDate.now().getYear();
                    long numarAngajatiVara = list.stream()
                            .filter(a -> a.getData_angajarii().getYear() == anul_curent - 1 &&
                                    (a.getData_angajarii().getMonth() == Month.JUNE ||
                                            a.getData_angajarii().getMonth() == Month.JULY ||
                                            a.getData_angajarii().getMonth() == Month.AUGUST))
                            .count();
                    System.out.println("Număr angajați vara anului precedent: " + numarAngajatiVara);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opt invalida");
                    break;
            }
        }while(opt!=0);
    }
}
