package Ex1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;
import java.time.LocalDate;
import java.util.Date;

public class MainApp {
    public static void adaugarePersoana(Connection con,String numePersoana, int varsta )
    {
        String sql="insert into persoane values (?,?,?)";
        try(PreparedStatement pst=con.prepareStatement(sql))
        {
            pst.setInt(1,0);
            pst.setString(2,numePersoana);
            pst.setInt(3,varsta);
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println(sql);
            e.printStackTrace();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

    }
    public static void adaugareExcursie(Connection con,int id_pers,String destinatie, int anul )
    {
        String sql="insert into excursii values (?,?,?,?)";
        try(PreparedStatement pst=con.prepareStatement(sql))
        {
            pst.setInt(1,id_pers);
            pst.setInt(2,0);
            pst.setString(3,destinatie);
            pst.setInt(4,anul);
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println(sql);
            e.printStackTrace();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

    }
    public static void stergerePersoana(Connection connection,int id){
        String sql="delete from persoane where id=?";
        try(PreparedStatement ps=connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            int nr_randuri=ps.executeUpdate();
            System.out.println("\nNumar randuri afectate de stergere="+nr_randuri);
        }
        catch (SQLException e) {
            System.out.println(sql);
            e.printStackTrace();
        }
    }
    public static void stergereExcursie(Connection connection,int id){
        String sql="delete from excursii where id_excursie=?";
        try(PreparedStatement ps=connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            int nr_randuri=ps.executeUpdate();
            System.out.println("\nNumar randuri afectate de stergere="+nr_randuri);
        }
        catch (SQLException e) {
            System.out.println(sql);
            e.printStackTrace();
        }
    }

    public static void main(String[] args)throws Exception
    {
        String url="jdbc:mysql://localhost:3306/lab8";
        Connection con= DriverManager.getConnection(url,"root","Fr05tD3lt4");
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        Statement stmt=con.createStatement();

        boolean cnt;

        int ok;
        do {
            System.out.println("\n1. Adaugare Persoana");
            System.out.println("2. Adaugare Excursie");
            System.out.println("3. Afisare persoane+ excursii");
            System.out.println("4. Afisare Excursie a unei persoane");
            System.out.println("5. Afisarea persoanelor  care au vizitat o destinatie");
            System.out.println("6. Afisare persoanelor care au facut excursii intr-un anumit an");
            System.out.println("7. Stergerea unei excursii");
            System.out.println("8. Stergerea unei persoane ");
            ok=Integer.parseInt(br.readLine());
            switch(ok)
            {
                case 1:
                    System.out.println("Nume: ");
                    String nume=br.readLine();
                    System.out.println("Varsta: ");
                    int varsta=Integer.parseInt(br.readLine());
                    try
                    {
                        if(varsta<0||varsta>100)throw new ExceptieVartsa();
                        adaugarePersoana(con,nume,varsta);
                    }
                    catch(ExceptieVartsa e)
                    {
                        System.out.println(e);
                    }
                    break;
                case 2:
                    System.out.println("ID persoana: ");
                    int id=Integer.parseInt(br.readLine());
                    System.out.println("Destinatie: ");
                    String dest=br.readLine();
                    System.out.println("Anul: ");
                    int anul=Integer.parseInt(br.readLine());
                    try(PreparedStatement pstmt = con.prepareStatement("SELECT * FROM persoane WHERE id = ? ");
                    )
                    {
                        pstmt.setInt(1, id);
                        ResultSet rust = pstmt.executeQuery();
                        rust.next();
                        if(anul< LocalDate.now().getYear()-rust.getInt("varsta")||anul>LocalDate.now().getYear())throw new ExceptieAnExcursie();
                        adaugareExcursie(con,id,dest,anul);
                    }
                    catch(ExceptieAnExcursie e)
                    {
                        System.out.println(e);
                    }


                    break;
                case 3:
                    ResultSet rs=stmt.executeQuery("select A.id, A. nume, A. varsta, B.id_excursie, B.destinatia, B.anul from persoane A left join  excursii B ON A.id=B.id_persoana");
                    while (rs.next())
                    {
                        System.out.println(rs.getInt("id")+" "+rs.getString("nume")+" "+rs.getInt("varsta")+" "+rs.getString("destinatia")+" "+rs.getInt("anul"));
                    }
                    rs.close();
                    break;
                case 4:
                    System.out.println("Nume: ");
                    nume=br.readLine();
                    PreparedStatement pstmt = con.prepareStatement("SELECT e.* FROM excursii e JOIN persoane p ON e.id_persoana = p.id WHERE p.nume = ?");
                    pstmt.setString(1, nume);
                    ResultSet rust = pstmt.executeQuery();
                    cnt=true;

                    while(rust.next())
                    {
                        System.out.println(rust.getInt("id_excursie")+" "+rust.getString("destinatia")+" "+rust.getInt("anul"));
                        cnt=false;
                    };
                    if(cnt)System.out.println("Nu s-au gasit excursii");
                    pstmt.close();
                    rust.close();
                    break;
                case 5:
                    System.out.println("Destinatie: ");
                    dest=br.readLine();
                    pstmt = con.prepareStatement("SELECT DISTINCT p.* FROM persoane p JOIN excursii e ON  p.id=e.id_persoana  WHERE e.destinatia = ?");
                    pstmt.setString(1, dest);

                    rust = pstmt.executeQuery();
                   cnt=true;
                        while(rust.next())
                        {
                            System.out.println(rust.getInt("id")+" "+rust.getString("nume")+" "+rust.getInt("varsta"));
                            cnt=false;
                        }
                        if(cnt)System.out.println("Nu s-au gasit excursii");
                    break;
                case 6:
                    System.out.println("Anul: ");
                    anul=Integer.parseInt(br.readLine());
                    pstmt = con.prepareStatement("SELECT DISTINCT p.* FROM persoane p JOIN excursii e ON  p.id=e.id_persoana  WHERE e.anul = ?");
                    pstmt.setInt(1, anul);
                    rust = pstmt.executeQuery();
                    cnt=true;
                        while(rust.next())
                        {
                            System.out.println(rust.getInt("id")+" "+rust.getString("nume")+" "+rust.getInt("varsta"));
                            cnt=false;
                        }
                        if(cnt)System.out.println("Nu s-au gasit excursii");
                    break;
                case 7:
                    System.out.println("id excursie: ");
                    id=Integer.parseInt(br.readLine());
                    stergereExcursie(con,id);

                    break;
                case 8:
                    System.out.println("id persoana: ");
                    id=Integer.parseInt(br.readLine());
                    stergerePersoana(con,id);
                    break;
                case 0:
                    con.close();
                    stmt.close();
                    break;
                default:
                    System.out.println("OPT gresita");
                    break;
            }

        }
        while(ok!=0);
    }
}
