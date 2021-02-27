public class Position
{
    private int latitude;
    private int longitude;

    public Position(int latitude, int longitude)
    {
        this.latitude=latitude;
        this.longitude=longitude;
    }

    public int getLatitude() {
        return this.latitude;
    }

    public int getLongitude() {
        return this.longitude;
    }
}
