package Ex2;

import java.time.LocalDate;

public class Produs
{
    private String denumire;
    private float pret;
    private int cantitate;
    private LocalDate data_expirare;
    private static float incasari;

    Produs(String denumire, float pret, int cantitate, LocalDate data_expirare)
    {
        this.denumire = denumire;
        this.pret = pret;
        this.cantitate = cantitate;
        this.data_expirare = data_expirare;
    }

    public int getCantitate()
    {
        return cantitate;
    }
    public void setCantitate(int cantitate)
    {
        this.cantitate = cantitate;
    }
    public static float getIncasari()
    {
        return incasari;
    }
    public static void setIncasari(float incasari)
    {
        Produs.incasari = incasari;
    }
    public LocalDate getData_expirare()
    {
        return data_expirare;
    }
    public float getPret()
    {
        return pret;
    }
    public String getDenumire()
    {
        return denumire;
    }

    @Override
    public String toString()
    {
        return this.denumire+","+this.pret+","+this.cantitate+","+this.data_expirare;
    }

}
