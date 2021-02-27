import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Board
{
    private static List<Navy>  navies=new ArrayList<>();
    public final int MaxLatitude = 100;
    public final int MinLatitude = -100;
    public final int MaxLongitude = 100;
    public final int MinLongitude = -100;
    private static int cont=0;
    private String alias;

    public Board()
    {

    }
    public Board(List<Navy> na)
    {
        navies = na;
    }
    public int countNavies(String alias)
    {
        this.alias=alias;
        cont=0;
        for (Navy n:navies)
        {
            if(n.getName().equals(alias))
            {
                cont++;
            }
        }
        return cont;
    }

    public List<Navy> getNavies() {
        return navies;
    }

    public String getAlias()
    {
        return this.alias;
    }
}
