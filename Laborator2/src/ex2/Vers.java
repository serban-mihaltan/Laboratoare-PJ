package ex2;

public class Vers {
    private String vers;
    private int nr_cuv,nr_voc;
    public Vers(String vers)
    {
        this.vers=vers;
    }
    public String getVers()
    {
        return vers;
    }
    public int cuv()
    {
        String[] a=vers.split(" ");
        nr_cuv=a.length;
        return nr_cuv;
    }

    public int getNr_cuv() {
        return nr_cuv;
    }
    public int voc()
    {
        String a=vers;
        nr_voc=0;
        a.toLowerCase();
        for(int i=0;i<a.length();i++)
        {
            char c=a.charAt(i);
            if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u')
                nr_voc++;

        }
        return nr_voc;
    }
    public int getNr_voc()
    {
        return nr_voc;
    }
}
