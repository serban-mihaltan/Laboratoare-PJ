package ex2;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.io.File;
import java.io.IOException;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class MainApp {
    public static void main(String[] args) throws IOException
    {

        ObjectMapper mapper = new ObjectMapper();
        mapper.activateDefaultTyping(mapper.getPolymorphicTypeValidator(),
                ObjectMapper.DefaultTyping.NON_FINAL);
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        // Crearea colecției Set<InstrumentMuzical> cu 3 chitări și 3 seturi de tobe
        Set<InstrumentMuzical> instrumente = new HashSet<>();
        instrumente.add(new Chitara("Fender", 2500, TipChitara.ELECTRICA, 6));
        instrumente.add(new Chitara("Yamaha", 2000, TipChitara.ACUSTICA, 12));
        instrumente.add(new Chitara("Ibanez", 1500, TipChitara.CLASICA, 8));
        instrumente.add(new SetTobe("Roland", 3200, TipTobe.ELECTRONICE, 5, 3));
        instrumente.add(new SetTobe("Yamaha", 2800, TipTobe.ACUSTICE, 4, 2));
        instrumente.add(new SetTobe("Pearl", 3500, TipTobe.ACUSTICE, 6, 4));

        instrumente.stream().forEach(System.out::println);

        // Salvarea colecției în fișier JSON
        mapper.writeValue(new File("src/main/resources/instrumente.json"), instrumente);

        // Citirea colecției din JSON
        Set<InstrumentMuzical> instrumenteCitite = mapper.readValue(
                new File("src/main/resources/instrumente.json"), new TypeReference<Set<InstrumentMuzical>>() {}
        );
        System.out.println("Instrumentele citite din JSON:");
        instrumenteCitite.forEach(System.out::println);

        // Afișarea implementării utilizate de Set
        System.out.println("\nTipul colecției Set: " + instrumente.getClass().getName());

        // Verificarea duplicatelor
        Chitara chitaraDuplicat = new Chitara("Ibanez", 1500, TipChitara.CLASICA, 8);
        if (!instrumente.add(chitaraDuplicat)) {
            System.out.println("\nNu se permit duplicate.");
        }

        //  Ștergerea instrumentelor cu preț > 3000 RON
        instrumente.removeIf(instr -> instr.getPret() > 3000);
        System.out.println("\nDupă eliminarea instrumentelor scumpe:");
        instrumente.forEach(System.out::println);

        //  Afișarea detaliilor chitărilor
        System.out.println("\nDetaliile chitărilor:");
        instrumente.stream()
                .filter(instr -> instr instanceof Chitara)
                .forEach(System.out::println);

        //  Afișarea detaliilor tobelor
        System.out.println("\nDetaliile tobelor:");
        instrumente.stream()
                .filter(instr -> instr instanceof SetTobe)
                .forEach(System.out::println);

        //  Chitara cu cele mai multe corzi
        instrumente.stream()
                .filter(instr -> instr instanceof Chitara)
                .map(instr -> (Chitara) instr)
                .max(Comparator.comparingInt(Chitara::getNr_corzi))
                .ifPresent(ch -> System.out.println("\nChitara cu cele mai multe corzi: " + ch));

        //  Tobele acustice ordonate după numărul de tobe
        System.out.println("\nTobele acustice ordonate după numărul de tobe:");
        instrumente.stream()
                .filter(instr -> instr instanceof SetTobe)
                .map(instr -> (SetTobe) instr)
                .filter(tobe -> tobe.getTip_tobe() == TipTobe.ACUSTICE)
                .sorted(Comparator.comparingInt(SetTobe::getNr_tobe))
                .forEach(System.out::println);
    }
}
