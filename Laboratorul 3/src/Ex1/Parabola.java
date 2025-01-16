package Ex1;

public class Parabola
{
    private int a,b,c;
    public Parabola(int a, int b, int c)
    {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public float[] varf()
    {
        float[] ar=new float[2];
        ar[0]=(-b/(2*a));
        ar[1]=(((-b*b)+4*a*c)/(4*a));
        return ar;
    }
    @Override
    public String toString()
    {
        return "f(x)="+a+"x^2+"+b+"x+"+c;
    }
    public float[] varfSegment(Parabola p)
    {
        float a[]=this.varf();
        float b[]=p.varf();
        float[] ar=new float[2];
        ar[0]=(a[0]+b[0])/2;
        ar[1]=(a[1]+b[1])/2;
        return ar;
    }
    public float lungimeSegment(Parabola p)
    {
        float a[]=this.varf();
        float b[]=p.varf();
        return (float)Math.hypot((b[0]-a[0]),(b[1]-a[1]));
    }
    public static float lungimeSegmentParabole(Parabola a, Parabola b)
    {
        return a.lungimeSegment(b);
    }
}
