package ex1;

import java.io.Serializable;

enum Format{
    A3,
    A4
}
public class Copiator extends Echipament implements Serializable {
    private Format format;
    private double p_ton;
    public Copiator(){super();}
    public Copiator(String denumire, int nr_inv, double pret, String zona_mag, Stare stare,String tip, double p_ton, Format format) {
        super(denumire, nr_inv, pret, zona_mag, stare,tip);
        this.format = format;
        this.p_ton = p_ton;
    }

    public double getP_ton() {
        return p_ton;
    }

    public Format getFormat() {
        return format;
    }

    public void setFormat(Format format) {
        this.format = format;
    }

    @Override
    public String toString() {
        return super.toString() + ", P_ton: " + p_ton+ "Format: " + format ;
    }

}
