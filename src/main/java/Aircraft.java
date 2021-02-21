public class Aircraft
{
    private String licencePlate;
    private boolean inAir;

    private Marine copilot;
    private Marine pilot;
    private Position location;

    public static int score;
    public final int crewMembers=0;


    public Aircraft(String licencePlate,boolean inAir)
    {
        this.licencePlate=licencePlate;
        this.inAir=inAir;
    }

    public void setPilot(Marine pilot)
    {
        this.pilot = pilot;
    }
}
