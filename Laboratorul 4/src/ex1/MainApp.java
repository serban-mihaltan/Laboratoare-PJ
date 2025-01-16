package ex1;

import java.io.*;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainApp {

    static void scrie(Object ecp) {
        try {
            FileOutputStream f = new FileOutputStream("echip.bin");
            ObjectOutputStream oos = new ObjectOutputStream(f);
            oos.writeObject(ecp);
            f.close();
            oos.close();

        } catch (IOException e) {
            System.out.println(e);
        }
    }
    static Object citeste() {
        try {
            FileInputStream f = new FileInputStream("echip.bin");
            ObjectInputStream ois = new ObjectInputStream(f);
            Object o = ois.readObject();
            ois.close();
            f.close();
            return o;
        } catch (IOException | ClassNotFoundException e) {
           System.out.println(e);
        }
        return null;
    }
    public static void main(String[] args) throws IOException,ClassNotFoundException
    {
        List<Echipament> echipamentList = new ArrayList<Echipament>();
        BufferedReader  br = new BufferedReader(new FileReader("src/ex1/Echipament.txt"));
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        String line;

        int opt;
        while( (line = br.readLine()) != null)
        {
            String[] data = line.split(";");
            if(data[5].equals("imprimanta"))
            {
                Imprimanta imprimanta=new Imprimanta(data[0],Integer.parseInt(data[1]),Double.parseDouble(data[2]),data[3],Stare.valueOf(data[4]),data[5],Double.parseDouble(data[6]),data[7],Double.parseDouble(data[8]),Mod.valueOf( data[9].toLowerCase()));
                echipamentList.add(imprimanta);
            }
            else if(data[5].equals("copiator"))
            {
                Copiator copiator=new Copiator(data[0],Integer.parseInt(data[1]),Double.parseDouble(data[2]),data[3],Stare.valueOf(data[4]),data[5],Double.parseDouble(data[6]), Format.valueOf(data[7]));
                echipamentList.add(copiator);
            }
            else if(data[5].equals("sistem de calcul"))
            {
                Sistem_de_calcul sistem_de_calcul=new Sistem_de_calcul(data[0],Integer.parseInt(data[1]),Double.parseDouble(data[2]),data[3],Stare.valueOf(data[4]),data[5],data[6],Double.parseDouble(data[7]),Integer.parseInt(data[8]),Sistem.valueOf(data[9]));
                echipamentList.add(sistem_de_calcul);
            }
        }
        br.close();


        do
        {
            System.out.println("1. Afisare echipamentelor:");
            System.out.println("2. Afisarea imprimantelor");
            System.out.println("3. Afisarea copiatoarelor");
            System.out.println("4. Afisarea sistemelor de calcul");
            System.out.println("5. Modificarea starii in care se afla un echipament");
            System.out.println("6. Setarea unui anumit mod de scriere pentru o imprimanta");
            System.out.println("7. Setarea unui format de copiere pentru copiatoare");
            System.out.println("8. Instalarea unui anumit sistem de operare pe un sistem de calcul");
            System.out.println("9. Afisarea echipamentelor vandute");
            System.out.println("10. Serializare");
            System.out.println("11. Deserializare");
            System.out.println("0. Iesire");
            System.out.println("Optiunea dvs. este:");
            opt = Integer.parseInt(input.readLine());
            switch(opt)
            {
                case 1:
                    for(Echipament ec : echipamentList)
                        System.out.println(ec);
                    break;

                case 2:
                    for(Echipament ec : echipamentList)
                        if(ec.getTip().toLowerCase().equals("imprimanta"))
                            System.out.println(ec);
                    break;
                case 3:
                    for(Echipament ec : echipamentList)
                        if(ec.getTip().toLowerCase().equals("copiator"))
                            System.out.println(ec);
                    break;
                case 4:
                    for(Echipament ec : echipamentList)
                        if(ec.getTip().toLowerCase().equals("sistem de calcul"))
                            System.out.println(ec);
                    break;
                case 5:
                    String num;
                    Stare st;
                    boolean ok=true;
                    System.out.print("Introduceti numele echipamentului pentru care sa se modifice starea: ");
                    num=input.readLine();
                    System.out.print("Introduceti starea(achizitionat/vandut/expus): ");
                    st=Stare.valueOf(input.readLine());
                    for(Echipament ec : echipamentList)
                        if(num.equals(ec.getDenumire()))
                        {
                            ec.setStare(st);
                            ok=false;
                        }
                    if(ok)
                        System.out.println("Echipamentul nu a fost gasit");
                    break;
                case 6:

                    Mod m;
                    ok=true;
                    System.out.print("Introduceti numele echipamentului pentru care sa se modifice starea: ");
                    num=input.readLine();
                    System.out.print("Introduceti starea(achizitionat/vandut/expus): ");
                    m=Mod.valueOf(input.readLine());
                    for(Echipament ec : echipamentList)
                        if(num.equals(ec.getDenumire())&&(ec instanceof Imprimanta imp))
                        {
                            imp.setMod(m);
                            ok=false;
                        }
                    if(ok)
                        System.out.println("Echipamentul nu a fost gasit");
                    break;
                case 7:
                    Format f;
                    ok=true;
                    System.out.print("Introduceti numele echipamentului pentru care sa se modifice starea: ");
                    num=input.readLine();
                    System.out.print("Introduceti starea(achizitionat/vandut/expus): ");
                    f=Format.valueOf(input.readLine());
                    for(Echipament ec : echipamentList)
                        if(num.equals(ec.getDenumire())&&(ec instanceof Copiator copi))
                        {
                            copi.setFormat(f);
                            ok=false;
                        }
                    if(ok)
                        System.out.println("Echipamentul nu a fost gasit");
                    break;
                case 8:
                    Sistem sd;
                    ok=true;
                    System.out.print("Introduceti numele echipamentului pentru care sa se modifice starea: ");
                    num=input.readLine();
                    System.out.print("Introduceti starea(achizitionat/vandut/expus): ");
                    sd=Sistem.valueOf(input.readLine());
                    for(Echipament ec : echipamentList)
                        if(num.equals(ec.getDenumire())&&(ec instanceof Sistem_de_calcul sistem))
                        {
                            sistem.setSistem(sd);
                            ok=false;
                        }
                    if(ok)
                        System.out.println("Echipamentul nu a fost gasit");
                    break;
                case 9:
                    for(Echipament ec : echipamentList)
                    {
                        if(ec.getStare()==Stare.valueOf("vandut"))
                            System.out.println(ec);
                    }
                    break;
                case 10:
                    scrie(echipamentList);
                    break;
                case 11:
                    List<Echipament>ecp=new ArrayList<Echipament>();
                    ecp=(List<Echipament>) citeste();
                    for(Echipament ec:ecp)
                    {
                        System.out.println(ec);
                    }
                    break;
                case 0:

                    break;
                    default:
                        System.out.println("OPT gresita");
                        break;
            }
        }while(opt!=0);
    }
}
