package ex1;

import java.io.Serializable;

enum Sistem{
    windows,
    linux
}
public class Sistem_de_calcul extends Echipament implements Serializable {
    private String tip_mon;
    private double vit_proc;
    private int c_hdd;
    private Sistem sistem;
    public Sistem_de_calcul() {super();}
    public Sistem_de_calcul(String denumire, int nr_inv, double pret, String zona_mag, Stare stare,String tip, String tip_mon, double vit_proc, int c_hdd,Sistem sistem)
    {
        super(denumire, nr_inv, pret, zona_mag, stare, tip);
        this.tip_mon = tip_mon;
        this.vit_proc = vit_proc;
        this.c_hdd = c_hdd;
        this.sistem = sistem;
    }

    public String getTip_mon() {
        return tip_mon;
    }
    public double getVit_proc() {
        return vit_proc;
    }
    public int getC_hdd() {
        return c_hdd;
    }
    public Sistem getSistem() {
        return sistem;
    }
    public void setSistem(Sistem sistem)
    {
        this.sistem = sistem;
    }

    @Override
    public String toString()
    {
        return super.toString()+" tip mon "+ tip_mon+" vit_proc "+ vit_proc+" c_hdd "+ c_hdd+" sistem "+ sistem;
    }
}
