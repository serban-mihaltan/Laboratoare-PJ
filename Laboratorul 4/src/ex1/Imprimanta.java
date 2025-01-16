package ex1;

import java.io.Serializable;

enum Mod{
    color,
    alb_negru
}
public class Imprimanta extends Echipament implements Serializable {

    private double ppm;
    private String rezolutie;
    private double p_car;
    private Mod mod;
    public Imprimanta(){super();}
    public Imprimanta(String denumire, int nr_inv, double pret, String zona_mag, Stare stare,String tip, double ppm,String rezolutie,double p_car, Mod mod)
    {
        super(denumire,nr_inv,pret,zona_mag,stare,tip);
        this.ppm = ppm;
        this.rezolutie = rezolutie;
        this.p_car = p_car;
        this.mod = mod;
    }

    public double getPpm()
    {
        return ppm;
    }

    public String getRezolutie()
    {
        return rezolutie;
    }

    public double getP_car()
    {
        return p_car;
    }
    public Mod getMod()
    {
        return mod;
    }
    public void setMod(Mod mod)
    {
        this.mod = mod;
    }
    @Override
    public String toString()
    {
        return super.toString()+" Ppm: "+ppm+" Rezolutie: "+rezolutie+" P_car "+p_car+" Mod: "+mod;
    }

}
