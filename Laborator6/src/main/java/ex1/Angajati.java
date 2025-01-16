package ex1;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class Angajati
{
    private String nume;
    private String postul;
    private LocalDate data_angajarii;
    private float salariu;

    public Angajati() {}
    public Angajati(String nume, String postul, LocalDate data_angajarii, float salariu)
    {
        this.nume = nume;
        this.postul = postul;
        this.data_angajarii = data_angajarii;
        this.salariu = salariu;
    }
    public String getNume() { return nume; }
    public void setNume(String nume) { this.nume = nume; }
    public String getPostul() { return postul; }
    public void setPostul(String postul) { this.postul = postul; }
    public LocalDate getData_angajarii() { return data_angajarii; }
    public void setData_angajarii(LocalDate data_angajarii) { this.data_angajarii = data_angajarii; }
    public float getSalariu() { return salariu; }
    public void setSalariu(float salariu) { this.salariu = salariu; }

    @Override
    public String toString()
    {
        return "nume: "+nume+" postul: "+postul+" data_angajarii: "+data_angajarii+" salariu: "+salariu;
    }
}
