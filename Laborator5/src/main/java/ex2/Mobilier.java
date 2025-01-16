package ex2;

import java.util.List;

/**
 * A class representing furniture with a name and a list of Placa objects.
 */
public class Mobilier {
    private String nume;
    private List<Placa> placi;
    public Mobilier() {}
    public Mobilier(String nume, List<Placa> placi)
    {
        this.nume = nume;
        this.placi = placi;
    }
    public String getNume()
    {
        return nume;
    }
    public void setNume(String nume)
    {
        this.nume = nume;
    }
    public List<Placa> getPlaci()
    {
        return placi;
    }
    public void setPlaci(List<Placa> placi)
    {
        this.placi = placi;
    }
    public long supPlaci()
    {
        long sup=0;
        for(Placa p : placi)
        {
            sup+= (long) p.getLungime() * p.getLatime() * p.getNr_bucati();

        }
        return sup;
    }
    @Override
    public String toString()
    {
        return "Nume: "+nume+"\n"+"Placi:\n "+placi+"\n";
    }
}
