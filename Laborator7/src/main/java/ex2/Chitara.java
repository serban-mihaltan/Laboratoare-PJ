package ex2;

import java.io.Serializable;

enum TipChitara {ELECTRICA, ACUSTICA, CLASICA}
public class Chitara extends InstrumentMuzical //implements Serializable
{
    TipChitara tipChitara;
    int nr_corzi;

    public Chitara (String producator, int pret, TipChitara tipChitara,int nr_corzi)
    {
        super(producator, pret);
        this.tipChitara = tipChitara;
        this.nr_corzi = nr_corzi;
    }
    public Chitara(){super();}

    @Override
    public int getPret()
    {
        return super.getPret();
    }
    @Override
    public void setPret(int pret)
    {
        super.setPret(pret);
    }
    @Override
    public String getProducator()
    {
        return super.getProducator();
    }
    @Override
    public void setProducator(String producator)
    {
        super.setProducator(producator);
    }
    public TipChitara getTipChitara()
    {
        return tipChitara;
    }
    public void setTipChitara(TipChitara tipChitara)
    {
        this.tipChitara = tipChitara;
    }

    public int getNr_corzi()
    {
        return nr_corzi;
    }
    public void setNr_corzi(int nr_corzi)
    {
        this.nr_corzi = nr_corzi;
    }
    @Override
    public String toString()
    {
        return super.toString()+" tipChitara:"+tipChitara+" nr_corzi:"+nr_corzi;
    }
}
