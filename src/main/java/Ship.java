import java.util.ArrayList;
import java.util.List;

public class Ship
{
    private int numberId;

    private Position location;
    private List<Marine> marines;

    public static int score;
    public final int crewMembers=0;

    public Ship(int numberId)
    {
        this.numberId=numberId;

    }

    public List<Marine> getMarines() {
        return marines;
    }

    public void setMarines(List<Marine> marines,Marine m)
    {
        this.marines = marines;
        marines = new ArrayList<>();
        marines.add(m);

    }
}
