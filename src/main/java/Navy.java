import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Navy
{
    private String name;

    private List<Ship> ships;
    private List<AircraftCarrier> carriers= new ArrayList<>();
    private List<Aircraft> aircrafts=new ArrayList<>();
    private List<Marine> marines;
    private Board board=new Board();

    private int aircraftCapacity;

    public final int code=0;

    public Navy(String name)
    {
        this.name=name;
    }

    public void navyCreation()
    {
        //Creation of the navies
        Navy n1 = new Navy("LA GRAN FLOTA BLANCA");
        Navy n2 = new Navy("LA GRAN ARMADA DE CASTILLA");

        //Creation of the AircraftCarrier of "LA GRAN FLOTA BLANCA"
        AircraftCarrier ac1 = new AircraftCarrier(100,aircraftCapacity/2);
        carriers = new ArrayList<>();
        n1.carriers.add(ac1);

        //Creation of the captain of the AircraftCarrier of "LA GRAN FLOTA BLANCA"
        Marine captain1 = new Marine("Sperry",0);
        ac1.setCaptain(captain1);

        //Creation of the aircrafts of "LA GRAN FLOTA BLANCA"
        Aircraft a1 = new Aircraft("HR100",false);
        Marine pilot1 = new Marine("Henry Reuterdahl",0);
        a1.setPilot(pilot1);
        Aircraft a2 = new Aircraft("JB100",false);
        Marine pilot2 = new Marine("John Charles Roach",0);
        a2.setPilot(pilot2);

        //Linking the aircrafts with "LA GRAN FLOTA BLANCA"
        aircrafts = new ArrayList<>();
        n1.aircrafts.add(a1);
        n1.aircrafts.add(a2);

        //Creation of the ship of "LA GRAN ARMADA DE CASTILLA"
        Ship s1 = new Ship(900);
        Marine m1 = new Marine("Alberto Dávila",0);
        marines=new ArrayList<>();
        s1.setMarines(marines,m1);

        //Creation of the aircraft of "LA GRAN ARMADA DE CASTILLA"
        Aircraft a3 = new Aircraft("PEACE", false);
        n2.aircrafts.add(a3);

        //Creation of the marine of "LA GRAN ARMADA DE CASTILLA"
        Marine mar1 = new Marine("Fernando Villamil",0);
        n2.marines.add(mar1);

        //Liking the ship to "LA GRAN ARMADA DE CASTILLA"
        ships = new ArrayList<>();
        n2.ships.add(s1);
    }


    public String getName()
    {
        return this.name;
    }

    /*
     * Consulta el número de flotas que tienen su mismo nombre
     *
     * @returns: numero de flotas con el mismo nombre
     */
    public int alias()
    {
        return this.board.countNavies(this.name)-1;
    }
    /**
     * Consulta la disponibilidad total de los portaaviones
     *
     * @returns: numero de nuevos aviones que podrían cargarse a los portaaviones
     */
    public int disponibilidadEnPortaAviones()
    {

        int count = 0;
        for(int i=0;i<aircrafts.size();i++)
        {
            count++;
        }
        return aircraftCreation()-count;
    }
    public int aircraftCreation()
    {
        AircraftCarrier ac = new AircraftCarrier(2,10);
        return  ac.getCapacity();
    }

    public List<AircraftCarrier> getCarriers() {
        return carriers;
    }

    public List<Aircraft> getAircrafts() {
        return aircrafts;
    }

    /**
     * Consulta la placa de los aviones enemigos que están en el aire
     *
     * @returns: la placa de los aviones enemigos que están en el aire
     */
    public ArrayList<String> enAire()
    {

        return enAire();
    }
    /**
     * Verifica si una ubicación de ataque en agua es adecuado(destruye elementos
     * enemigos sin ocasionar bajas propias)
     *
     * Parameters:
     *   longitud - longitud de la explosion
     *   latitud - latitud de la explosion
     */
    public boolean esBuenAtaque(int longitud, int latitud)
    {
        return false;
    }
    /**
     * Mueve todos los barcos la distancia definida
     *
     * Parameters:
     *   deltaLongitud - avance en longitud
     *   deltaLatitud - avance en latitud
     */
    public void muevase(int deltaLongitud, int deltaLatitud)
    {

    }
    /**
     * Consulta el numero de maquinas que tiene la flota
     *
     * @returns: numero de maquinas de la flota
     */
    public int numeroMaquinas()
    {
        return 0;
    }
    /**
     * Consulta si puede confundir sus aviones con aviones enemigos considerando
     * las placas
     *
     * @returns: si hay problema en aire
     */
    public boolean problemaEnAire()
    {
        return false;
    }
    /**
     * Consulta si cuenta con suficientes marinos para conducir sus máquinas.
     * Un portaaviones requiere cinco marinos; un barco, 4; y un avión 2.
     *
     * @returns: si hay suficientes marinos
     */
    public boolean suficientesMarinos()
    {
        return false;
    }

    /**
     * Consulta las máquinas que pueden afectarse por una explosion en agua
     *
     * Parameters:
     *   longitud - longitud de la explosion
     *   latitud - latitud de la explosion
     */
    public ArrayList<Object> seranDestruidas(int longitud,int latitud)
    {
        return seranDestruidas(0,0);
    }
    @Override
    public boolean equals(Object o)
    {
        if(o==null)
        {
            return false;
        }
        if(o instanceof Navy)
        {
            return false;
        }
        Navy n = (Navy)o;
        return this.name == board.getAlias();
    }



}
