package ex2;

import java.io.Serializable;

enum TipTobe{ELECTRONICE, ACUSTICE}
public class SetTobe extends InstrumentMuzical //implements Serializable
{
    TipTobe tip_tobe;
    int nr_tobe;
    int nr_cinele;

    public SetTobe(){super();}
    public SetTobe(String producator, int pret, TipTobe tip_tobe, int nr_tobe, int nr_cinele)
    {
        super(producator, pret);
        this.tip_tobe = tip_tobe;
        this.nr_tobe = nr_tobe;
        this.nr_cinele = nr_cinele;
    }
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
    public TipTobe getTip_tobe()
    {
        return tip_tobe;
    }
    public void setTip_tobe(TipTobe tip_tobe)
    {
        this.tip_tobe = tip_tobe;
    }
    public int getNr_tobe()
    {
        return nr_tobe;
    }
    public void setNr_tobe(int nr_tobe)
    {
        this.nr_tobe = nr_tobe;
    }
    public int getNr_cinele()
    {
        return nr_cinele;
    }
    public void setNr_cinele(int nr_cinele)
    {
        this.nr_cinele = nr_cinele;
    }
    @Override
    public String toString()
    {
        return super.toString()+" Tip Tobe: "+tip_tobe+" Nr_tobe: "+nr_tobe+" Nr_cinele: "+nr_cinele;
    }
}
