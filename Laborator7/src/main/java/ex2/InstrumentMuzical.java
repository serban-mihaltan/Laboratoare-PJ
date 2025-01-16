package ex2;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

import javax.sound.midi.Instrument;
import java.io.Serializable;
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public abstract class InstrumentMuzical //implements Serializable
{
    String producator;
    int pret;
    public InstrumentMuzical(String producator, int pret)
    {
        this.producator = producator;
        this.pret = pret;
    }
    public InstrumentMuzical() {}

    public int getPret() {
        return pret;
    }
    public void setPret(int pret)
    {
        this.pret = pret;
    }
    public String getProducator()
    {
        return producator;
    }

    public void setProducator(String producator) {
        this.producator = producator;
    }
    @Override
    public String toString()
    {
        return "Producator: " + producator + ", pret: " + pret ;
    }
}
