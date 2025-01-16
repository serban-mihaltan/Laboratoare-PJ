package ex4;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Persoana {
    private final String nume;
    private final String cnp;

    public Persoana(String nume, String cnp) {
        this.nume = nume;
        this.cnp = cnp;
    }

    public int getVarsta() {
        int an, luna, zi;
        int sec = Character.getNumericValue(cnp.charAt(0));

        if (sec == 1 || sec == 2) {
            an = 1900 + Integer.parseInt(cnp.substring(1, 3));
        } else if (sec == 5 || sec == 6) {
            an = 2000 + Integer.parseInt(cnp.substring(1, 3));
        } else {
            return -1; // Sec invalid
        }

        luna = Integer.parseInt(cnp.substring(3, 5));
        zi = Integer.parseInt(cnp.substring(5, 7));

        LocalDate dataNasterii = LocalDate.of(an, luna, zi);
        LocalDate dataCurenta = LocalDate.now();

        return (int) ChronoUnit.YEARS.between(dataNasterii, dataCurenta);
    }

    public static boolean validareCNP(String cnp) {
        if (cnp.length() != 13) {
            return false;
        }

        if (!cnp.matches("\\d+")) {
            return false;
        }

        int primaCifra = Character.getNumericValue(cnp.charAt(0));
        if (primaCifra != 1 && primaCifra != 2 && primaCifra != 5 && primaCifra != 6) {
            return false;
        }

        // Calcularea cifrei de control
        int[] coeficienti = {2, 7, 9, 1, 4, 6, 3, 5, 8, 2, 7, 9};
        int suma = 0;
        for (int i = 0; i < 12; i++) {
            suma += Character.getNumericValue(cnp.charAt(i)) * coeficienti[i];
        }
        int rest = suma % 11;
        int cifraControl = rest == 10 ? 1 : rest;

        return cifraControl == Character.getNumericValue(cnp.charAt(12));
    }


    public String info() {
        return "Nume: " + nume + ", CNP: " + cnp + ", Vârsta: " + getVarsta();
    }
}
