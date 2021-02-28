import jdk.swing.interop.SwingInterOpUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.management.modelmbean.InvalidTargetObjectTypeException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class NavyTest
{

    @Test
    @DisplayName("GIVEN a list of navies WHEN checking for repeated alias THEN display the number of navies with the same name ")
    public void shouldGetAliasNaviesCount()
    {
        List <Navy> navies = new ArrayList<>();

        Navy n1=new Navy("A");
        Navy n2=new Navy("B");
        Navy n3=new Navy("A");

        navies.add(n1);
        navies.add(n2);
        navies.add(n3);

        Board b= new Board(navies);

        int r1=n1.alias();
        assertEquals(1,r1);

        int r2=n2.alias();
        assertEquals(0,r2);

    }
    @Test
    @DisplayName("GIVEN a aircraft carrier with quota WHEN trying to calculate the availability THEN return the availability")
    public void shouldCalculateHowManyAircraftsCanBeAddedToAnAircraftCarrrier()
    {
        Navy n1 = new Navy("A");
        AircraftCarrier ac1 = new AircraftCarrier(1,10);
        Aircraft a2 = new Aircraft("ac1",false);

        n1.getCarriers().add(ac1);
        n1.getAircrafts().add(a2);
        assertEquals(9,n1.disponibilidadEnPortaAviones());
    }
    @Test
    @DisplayName("GIVEN a aircraft WHEN its in the air THEN return the lincencePlate")
    public void shouldCalculateIfAnAirCraftInAir()
    {
        Navy n1 = new Navy("Aliado");
        Navy n2 = new Navy("Enemigo");

        List<String> ia = new ArrayList<>();

        Aircraft a1 = new Aircraft("100A",false);
        Aircraft a2 = new Aircraft("100B",true);
        Aircraft a3 = new Aircraft("100C",true);
        Aircraft a4 = new Aircraft("100D",false);

        n2.getAircrafts().add(a1);
        n2.getAircrafts().add(a2);
        n2.getAircrafts().add(a3);
        n2.getAircrafts().add(a4);

        ia.add(a2.getLicencePlate());
        ia.add(a3.getLicencePlate());

        assertEquals(ia,n2.enAire());
    }
    @Test
    @DisplayName("GIVEN a position WHEN a navy attack THEN return if it is adecuate  or not")
    public void shouldBeDestroyed()
    {
        Navy n1 = new Navy("A");
        Navy n2 = new Navy("B");

        Ship s1 = new Ship(1,new Position(10,10));
        Ship s2 = new Ship(2,new Position(20,20));
        Ship s3 = new Ship(2,new Position(10,10));
        AircraftCarrier ac1 = new AircraftCarrier(1, 29,new Position(30,30));
        AircraftCarrier ac2 = new AircraftCarrier(2, 29,new Position(30,30));

        n1.getShips().add(s1);
        n2.getShips().add(s2);
        n2.getShips().add(s3);
        n1.getCarriers().add(ac1);
        n2.getCarriers().add(ac2);

        assertTrue(n1.esBuenAtaque(20,20));
        assertFalse(n1.esBuenAtaque(30,30));
        assertFalse(n1.esBuenAtaque(10,10));
    }


    @Test
    @DisplayName("GIVEN a ship WHEN giving coordinates THEN move to that coordinates")
    public void shouldMoveShip()
    {
        Navy n1 = new Navy("A");
        Ship s1 = new Ship(1,new Position(10,10));
        Ship s2 = new Ship(1,new Position(20,25));

        n1.getShips().add(s1);
        n1.getShips().add(s2);


        n1.muevase(10,15);

        assertEquals(20,s1.getLocation().getLatitude());
        assertEquals(25,s1.getLocation().getLongitude());
        assertEquals(30,s2.getLocation().getLatitude());
        assertEquals(40,s2.getLocation().getLongitude());

        n1.muevase(99,99);

        assertEquals(20,s1.getLocation().getLatitude());
        assertEquals(25,s1.getLocation().getLongitude());
        assertEquals(30,s2.getLocation().getLatitude());
        assertEquals(40,s2.getLocation().getLongitude());
        
    }

    @Test
    @DisplayName("GIVEN a navy WHEN calculating the number of its machines THEN return the number of machines ")
    public void shouldCalculateHowManyMachinesAreInTheNavy() {
        Navy n1 = new Navy("A");

        Aircraft a1 = new Aircraft("100A", false);
        Aircraft a2 = new Aircraft("100B", true);
        AircraftCarrier ac1 = new AircraftCarrier(1, 10);
        AircraftCarrier ac2 = new AircraftCarrier(2, 10);
        Ship s1 = new Ship(1);
        Ship s2 = new Ship(2);
        Ship s3 = new Ship(3);

        n1.getAircrafts().add(a1);
        n1.getAircrafts().add(a2);
        n1.getCarriers().add(ac1);
        n1.getCarriers().add(ac2);
        n1.getShips().add(s1);
        n1.getShips().add(s2);
        n1.getShips().add(s3);

        assertEquals(7, n1.numeroMaquinas());

        n1.getAircrafts().remove(a1);
        n1.getShips().remove(s1);
        n1.getShips().remove(s2);

        assertEquals(4,n1.numeroMaquinas());
    }
    @Test
    @DisplayName("GIVEN enemy aircraft WHEN having same lincesePlate THEN return if there are or not air problems ")
    public void shouldCalculateIfThereAreAirProblems()
    {

        Navy n1 = new Navy("Aliada");
        Navy n2 = new Navy("Enemigo");

        Aircraft n1a1 = new Aircraft("100A",true);
        Aircraft n2a1 = new Aircraft("100B",true);

        n1.getAircrafts().add(n1a1);
        n2.getAircrafts().add(n2a1);

        boolean r1=n1.problemaEnAire(n1.enAire());
        boolean r2=n2.problemaEnAire(n2.enAire());

        assertFalse(r1);
        assertFalse(r2);

        Aircraft n2a2 = new Aircraft("100A",true);
        n2.getAircrafts().add(n2a2);

        boolean r3=n2.problemaEnAire(n2.enAire());
        assertTrue(r3);

    }
    @Test
    @DisplayName("GIVEN the navy machines WHEN using a machine THEN return if there are sufficient machines")
    public void shouldCalculateIfThereAreSufficientMarines()
    {

        Navy n1 = new Navy("A");
        Aircraft a1 = new Aircraft("100",false);
        AircraftCarrier ac1= new AircraftCarrier(100,10);
        Ship s1 = new Ship(1);

        n1.getAircrafts().add(a1);
        n1.getCarriers().add(ac1);
        n1.getShips().add(s1);

        Marine m1 = new Marine("Juan",1);
        Marine m2 = new Marine ("El pana Miguel",2);
        Marine m3 = new Marine("Valentina",3);
        Marine m4 = new Marine("Sebastian",4);
        Marine m5 = new Marine("Pepe",5);
        Marine m6 = new Marine("Pedro",6);
        Marine m7 = new Marine("Armando",7);
        Marine m8 = new Marine("Roberto",8);
        Marine m9 = new Marine("Santiago",9);
        Marine m10 = new Marine("Angel",10);
        Marine m11 = new Marine("Andres",11);

        a1.getMarines().add(m1);

        ac1.getMarines().add(m2);
        ac1.getMarines().add(m3);
        ac1.getMarines().add(m4);
        ac1.getMarines().add(m5);

        s1.getMarines().add(m6);
        s1.getMarines().add(m7);
        s1.getMarines().add(m8);

        assertFalse(n1.suficientesMarinos());

        s1.getMarines().add(m11);

        assertFalse(n1.suficientesMarinos());

        a1.getMarines().add(m9);
        ac1.getMarines().add(m10);

        assertTrue(n1.suficientesMarinos());

    }
    @Test
    @DisplayName("GIVEN a position WHEN making an attack THEN return arraylist of machines affected by explosion")
    public void shouldCheckForDamageMachines()
    {
        ArrayList<Object> ouch = new ArrayList<>();

        Navy n1 = new Navy("A");
        AircraftCarrier ac1= new AircraftCarrier(100,10,new Position(5,5));
        Ship s1 = new Ship(1,new Position(10,10));

        n1.getCarriers().add(ac1);
        n1.getShips().add(s1);

        ouch.add(ac1);
        assertEquals(ouch,n1.seranDestruidas(5,5));
        ouch.add(s1);
        assertEquals(ouch,n1.seranDestruidas(10,10));
    }
}
