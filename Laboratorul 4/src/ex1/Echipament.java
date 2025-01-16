package ex1;

import java.io.Serializable;

enum Stare{
    achizitionat,
    vandut,
    expus
}

public class Echipament implements Serializable {
    private String denumire;
    private int nr_inv;
    private double pret;
    private String zona_mag;
    private Stare stare;
    private String tip;
    public Echipament(){super();}
    public Echipament(String denumire, int nr_inv, double pret, String zona_mag, Stare stare,String tip)
    {
        super();
        this.denumire = denumire;
        this.nr_inv = nr_inv;
        this.pret = pret;
        this.zona_mag = zona_mag;
        this.stare = stare;
        this.tip = tip;
    }

    public String getDenumire()
    {
        return denumire;
    }
    public int getNr_inv()
    {
        return nr_inv;
    }
    public double getPret()
    {
        return pret;
    }
    public String getZona_mag()
    {
        return zona_mag;
    }
    public Stare getStare()
    {
        return stare;
    }
    public void setStare(Stare stare)
    {
        this.stare = stare;
    }
    public String getTip()
    {
        return tip;
    }
    @Override
    public String toString()
    {
        return "Denumire: "+denumire+" Nr_Inv: "+nr_inv+" Pret "+pret+" Zona Mag: "+zona_mag+" Stare: "+stare;
    }
}
