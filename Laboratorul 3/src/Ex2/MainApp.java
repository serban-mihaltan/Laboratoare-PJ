package Ex2;

import java.io.*;
import java.text.BreakIterator;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainApp
{
    public static void main(String[] args)throws IOException
    {
        BufferedReader br = new BufferedReader(new FileReader("src/Ex2/produse.csv"));
        List<Produs> produse = new ArrayList<Produs>();
        String line;
        while((line=br.readLine())!=null)
        {
            String[] data = line.split(",");
            produse.add(new Produs(data[0],Float.parseFloat(data[1]),Integer.parseInt(data[2]), LocalDate.parse(data[3])));

        }
        br.close();
        br=new BufferedReader(new InputStreamReader(System.in));
        do {
            System.out.println("Afisare produse: 1");
            System.out.println("Afisare produse expirate: 2");
            System.out.println("Vanzare produs: 3");
            System.out.println("Afisare produse cu pret minim: 4");
            System.out.println("Salvare in fisier: 5");
            System.out.println("Iesire: 0");
            line = br.readLine();

            switch (line) {
                case "1":
                    for (Produs produs : produse) {
                        System.out.println(produs);
                    }
                    break;

                case "2":
                    for (Produs produs : produse) {
                        if (produs.getData_expirare().isBefore(LocalDate.now())) {
                            System.out.println(produs);
                        }
                    }
                    break;

                case "3":
                    System.out.println("Denumire Produs: ");
                    String denumire = br.readLine();
                    System.out.println("Cantitate: ");
                    int cantitate = Integer.parseInt(br.readLine());
                    boolean ok = true;

                    for (Produs produs : produse) {
                        if (produs.getDenumire().equals(denumire)) {
                            if (produs.getCantitate() >= cantitate) {
                                Produs.setIncasari(Produs.getIncasari() + cantitate * produs.getPret());
                                produs.setCantitate(produs.getCantitate() - cantitate);
                                System.out.println("Tranzactie reusita.\n Incasari totale: " + Produs.getIncasari());

                                if (produs.getCantitate() == 0) {
                                    // Use an iterator to safely remove from the list
                                    produse.remove(produs);

                                }
                            } else {
                                System.out.println("Stoc insuficient");
                            }
                            ok = false;
                        }
                    }
                    if (ok) {
                        System.out.println("Produsul nu a fost gasit");
                    }
                    break;

                case "4":
                    if (!produse.isEmpty()) {
                        Produs pret_min = Collections.min(produse, Comparator.comparing(Produs::getPret));
                        for (Produs produs : produse) {
                            if (produs.getPret() == pret_min.getPret()) {
                                System.out.println(produs);
                            }
                        }
                    } else {
                        System.out.println("Nu sunt produse disponibile.");
                    }
                    break;

                case "5":
                    System.out.println("Cantitate: ");
                    cantitate = Integer.parseInt(br.readLine());
                    BufferedWriter bw = new BufferedWriter(new FileWriter("src/Ex2/iesire.csv"));
                    for (Produs produs : produse) {
                        if (produs.getCantitate() <= cantitate) {
                            bw.write(produs + "\n");
                        }
                    }
                    bw.close();
                    break;

                case "0":
                    break;

                default:
                    System.out.println("Optiune invalida. Te rog incearca din nou.");
                    break;
            }
        } while (!line.equals("0"));

    }

}
