package ex1;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import ex2.Chitara;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class MainApp
{
    record Carte(String titlul, String autorul, int anul){}

    public static void main(String[] args) throws IOException
    {
        ObjectMapper mapper=new ObjectMapper();
        Map<Integer,Carte> carti_map = mapper.readValue(
                new File("src/main/resources/Carti.json"),
                new TypeReference<>(){});
        //afisarea colectiei
        System.out.println("Colectia initiala de carti");
        carti_map.forEach((id,carte)->System.out.println("ID: "+id+ " "+carte));

        //stergerea unei carti
        carti_map.remove(2);
        System.out.println("\nDupă ștergerea cărții cu ID 2:");
        carti_map.forEach((id, carte) -> System.out.println("ID: " + id + " -> " + carte));

        //Adaugarea unei carti
        carti_map.putIfAbsent(7, new Carte("Educated", "Tara Westover", 2018));
        System.out.println("\nDupă adăugarea unei noi cărți:");
        carti_map.forEach((id, carte) -> System.out.println("ID: " + id + " -> " + carte));

        //salvarea in fisierul JSON
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        mapper.writeValue(new File("src/main/resources/Carti.json"), carti_map);

        //Extrage toate cărțile scrise de Yuval Noah Harari
        Set<Carte> carti_Harari=carti_map.values().stream().
                filter(carte -> "Yuval Noah Harari".equals(carte.autorul())).collect(Collectors.toSet());
        System.out.println("\nCărțile scrise de Yuval Noah Harari:");
        carti_Harari.forEach(System.out::println);

        //Afisare ordonata dupa titlu
        System.out.println("\nCărțile ordonate după titlu:");
        carti_Harari.stream().sorted(Comparator.comparing(Carte::titlul)).forEach(System.out::println);

        //afisarea celei mai vechi carti
        System.out.println("\n Anul celei mai vechi carti");
        Optional<Carte> veche=carti_Harari.stream().min(Comparator.comparingInt(Carte::anul));
        veche.ifPresent(carte -> System.out.println(carte.anul));

    }
}
