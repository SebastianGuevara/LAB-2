import java.util.ArrayList;
import java.util.List;

public class Ship
{
    private int numberId;

    private Position location;
    private List<Marine> marines=new ArrayList<>();

    public static int score;
    public final int crewMembers=4;

    public Ship(int numberId)
    {
        this.numberId=numberId;

    }
    public Ship(int numberId, Position location)
    {
        this.numberId=numberId;
        this.location=location;

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

    public void setLocation(Position location) {
        this.location = location;
    }

    public Position getLocation() {
        return location;
    }

}
