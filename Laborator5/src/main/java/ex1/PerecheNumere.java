package ex1;

/**
 * The PerecheNumere class represents a pair of integers and provides methods
 * to manipulate and retrieve information about the pair.
 */
public class PerecheNumere
{
    private int a;
    private int b;
    public PerecheNumere()
    {}
    public PerecheNumere(int a, int b)
    {
        this.a = a;
        this.b = b;
    }
    public int getA()
    {
        return a;
    }

    public int getB()
    {
        return b;
    }

    public void setA(int a)
    {
        this.a = a;
    }

    public void setB(int b)
    {
        this.b = b;
    }
    @Override
    public String toString()
    {
        return ""+a+" "+b;
    }

    public boolean fibonaci()
    {
        int x=1,y=1;
        while(!(y>a&&y>b))
        {
            if(y==b)
            {
                if(x==a||a==x+y)
                    return true;
            }
            else
            {
                y=y+x;
                x=y-x;
            }
        }
            return false;
    }

    public int cmmmc()
    {
        if(a==0)return a;
        if(b==0)return b;
        int x=a,y=b;
        while(x!=y)
        {
            if(x>y)x=x-y;
            else y=y-x;
        }
        return a*b/x;
    }

    public boolean sum_cif()
    {
        int na=0,nb=0,x=a,y=b;
        while (x>0)
        {
            na=na+x%10;
            x=x/10;
        }
        while (y>0)
        {
            nb=nb+y%10;
            y=y/10;
        }

        return na==nb;
    }

    public boolean nr_cif()
    {
        int na=0,nb=0,x=a,y=b;
        while (x>0)
        {
            if(x%2==0)na++;
            x=x/10;
        }
        while (y>0)
        {
            if(y%2==0)nb++;
            y=y/10;
        }

        return na==nb;
    }
}
