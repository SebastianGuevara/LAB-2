import java.util.ArrayList;
import java.util.List;

public class Aircraft
{
    private String licencePlate;
    private boolean inAir;

    private Marine copilot;
    private Marine pilot;
    private Position location;
    private List<Marine> marines = new ArrayList<>();

    public static int score;
    public final int crewMembers=2;


    public Aircraft(String licencePlate,boolean inAir)
    {
        this.licencePlate=licencePlate;
        this.inAir=inAir;
    }
    public Aircraft(String licencePlate,boolean inAir,List<Marine> marines)
    {
        this.licencePlate=licencePlate;
        this.inAir=inAir;
        this.marines=marines;
    }
    public Aircraft(String licencePlate,boolean inAir,Position location)
    {
        this.licencePlate=licencePlate;
        this.inAir=inAir;
    }
    public Aircraft(String licencePlate,boolean inAir,Marine marines)
    {
        this.licencePlate=licencePlate;
        this.inAir=inAir;
    }


    public void setPilot(Marine pilot)
    {
        this.pilot = pilot;
    }

    public boolean isInAir() {
        return inAir;
    }

    public String getLicencePlate() {
        return licencePlate;
    }

    public List<Marine> getMarines() {
        return marines;
    }
}
