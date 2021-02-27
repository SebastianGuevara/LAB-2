import java.util.ArrayList;
import java.util.List;

public class AircraftCarrier
{
    private int numberId;
    private int capacity;
    private Marine captain;

    private List<Marine> marines=new ArrayList<>();
    private List<Aircraft> aircrafts=new ArrayList<>();
    private Position location;


    public static int score;
    public final int crewMembers=5;

    public AircraftCarrier(int numberId,int capacity)
    {
        this.numberId=numberId;
        this.capacity=capacity;
    }
    public AircraftCarrier(int numberId,int capacity,Position location)
    {
        this.numberId=numberId;
        this.capacity=capacity;
        this.location=location;
    }
    public void setCaptain(Marine captain)
    {
        this.captain = captain;
    }
    public List<Aircraft> getAircrafts()
    {
        return aircrafts;
    }

    public int getCapacity()
    {
        return capacity;
    }

    public Position getLocation() {
        return location;
    }
    public List<Marine> getMarines() {
        return marines;
    }
}
