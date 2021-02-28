import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Navy
{
    /**
     * CREACIÓN DE ATRIBUTOS DE LA CLASE
     */
    private String name;

    /**
     * CREACIÓN DE LOS ARRAYLIST DE LAS COSAS QUE CONTINE LA NAVY
     */
    private List<Ship> ships=new ArrayList<>();
    private List<AircraftCarrier> carriers= new ArrayList<>();
    private List<Aircraft> aircrafts=new ArrayList<>();
    private List<Marine> marines=new ArrayList<>();
    private Board board=new Board();
    private ArrayList<Object> damagedMachines = new ArrayList<>();

    private static Set<String> ac = new HashSet<>();

    private int aircraftCapacity;

    public final int code=0;

    /**
     * CREACIÓN DEL CONTRUCTOR DE LA CLASE NAVY
     * @param name
     */

    public Navy(String name)
    {
        this.name=name;
    }

    /**
     * Creación de métodos getters para los arraylist de las maáquinas de la flota
     * @return los arraylist de cada tipo de maquinas que contiene la flota
     */
    public List<AircraftCarrier> getCarriers() {
        return carriers;
    }
    public List<Aircraft> getAircrafts() {
        return aircrafts;
    }
    public List<Ship> getShips(){
        return this.ships;
    }

    /**
     * Creación del método getter para el atributo del nombre de la flota
     * @return
     */
    public String getName()
    {
        return this.name;
    }

    /**
     * Ejercicio de digrama de memoria
     */


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
        int result=0;
        for(int i=0; getCarriers().size()>i;i++)
        {
            result=getCarriers().get(i).getCapacity()-getAircrafts().size();
        }
        return result;
    }
    /**
     * Consulta la placa de los aviones enemigos que están en el aire
     *
     * @returns: la placa de los aviones enemigos que están en el aire
     */
    public ArrayList<String> enAire()
    {
        ArrayList<String> ia = new ArrayList<>();

        for (int i = 0; i< getAircrafts().size();i++)
        {
            if (getAircrafts().get(i).isInAir()==true)
            {
                ia.add(getAircrafts().get(i).getLicencePlate());
            }
        }
            return ia;
    }

    /**
     * Verifica si una ubicación de ataque en agua es adecuado(destruye elementos
     * enemigos sin ocasionar bajas propias)
     *
     * Parameters:
     *   longitud - longitud de la explosion
     *   latitud - latitud de la explosion
     */
    public boolean esBuenAtaque(int latitude, int longitude)
    {
        boolean result = true;
        for (int i=0;i<this.getShips().size();i++)
        {
            if((latitude==this.getShips().get(i).getLocation().getLatitude()&&longitude==this.getShips().get(i).getLocation().getLongitude()))
            {
                result = false;
            }
        }
        for (int i=0;i<this.getCarriers().size();i++)
        {
            if(latitude==this.getCarriers().get(i).getLocation().getLatitude()&&longitude==this.getCarriers().get(i).getLocation().getLongitude())
            {
                result = false;
            }
        }
        return result;
    }
    /**
     * Mueve todos los barcos la distancia definida
     *
     * Parameters:
     *   deltaLongitud - avance en longitud
     *   deltaLatitud - avance en latitud
     */
    public void muevase(int deltaLatitud, int deltaLongitud)
    {
        for (int i = 0;i<getShips().size();i++)
        {
            if(this.board.MaxLatitude>=deltaLatitud+this.ships.get(i).getLocation().getLatitude()&&this.board.MinLatitude<=deltaLatitud+this.ships.get(i).getLocation().getLatitude())
            {
                if (this.board.MaxLongitude>=deltaLongitud&&this.board.MinLongitude<=deltaLongitud)
                {
                    getShips().get(i).setLocation(new Position(getShips().get(i).getLocation().getLatitude()+deltaLatitud,getShips().get(i).getLocation().getLongitude()+deltaLongitud));
                    System.out.println(getShips().get(i).getLocation().getLatitude()+" "+getShips().get(i).getLocation().getLongitude());

                }
            }
        }
    }
    /**
     * Consulta el numero de maquinas que tiene la flota
     *
     * @returns: numero de maquinas de la flota
     */
    public int numeroMaquinas()
    {
        return this.machinesCalculator();
    }
    /**
     * Calcula el número de máquinas que tiene las flotas
     * @return
     */
    public int machinesCalculator()
    {
        return this.getAircrafts().size()+this.getShips().size()+this.getCarriers().size();
    }
    /**
     * Consulta si puede confundir sus aviones con aviones enemigos considerando
     * las placas
     *
     * @returns: si hay problema en aire
     */
    public boolean problemaEnAire(List<String> n)
    {
        boolean result = false;

        for (int i = 0;i<n.size();i++)
        {
            result=ac.add(n.get(i));
        }

        return !result;
    }

    /**
     * Consulta si cuenta con suficientes marinos para conducir sus máquinas.
     * Un portaaviones requiere cinco marinos; un barco, 4; y un avión 2.
     *
     * @returns: si hay suficientes marinos
     */
    public boolean suficientesMarinos()
    {
        boolean a = false, ac=false,s=false;
        boolean result = false;
        for (int i = 0;i<getAircrafts().size();i++)
        {
            if (getAircrafts().get(i).getMarines().size()==getAircrafts().get(i).crewMembers)
            {
                a=true;
            }
        }
        for (int i = 0;i<getShips().size();i++)
        {
            if (getShips().get(i).getMarines().size()==getShips().get(i).crewMembers)
            {

                s=true;
            }
        }
        for (int i = 0;i<getCarriers().size();i++)
        {
            if (getCarriers().get(i).getMarines().size()==getCarriers().get(i).crewMembers)
            {
                ac=true;
            }
        }
        if (a&&s&&ac)
        {
            result = true;
        }

        return result;
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
        for(int i=0;getCarriers().size()>i;i++)
        {
            if(getCarriers().get(i).getLocation().getLongitude() == longitud && getCarriers().get(i).getLocation().getLatitude() == latitud)
            {
                this.damagedMachines.add(getCarriers().get(i));
            }
        }

        for(int i=0;getShips().size()>i;i++)
        {
            if(getShips().get(i).getLocation().getLongitude() == longitud && getShips().get(i).getLocation().getLatitude() == latitud)
            {
                this.damagedMachines.add(getShips().get(i));
            }
        }

        return this.damagedMachines;
    }

    /**
     * Override al método equals para que no compare por el espacio de memoria, si no por el nombre de la flota
     * @param o
     * @return True o false dependiendo de la comparación entre los dos objetos
     */
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
