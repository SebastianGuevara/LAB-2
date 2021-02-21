import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

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

        AircraftCarrier ac1 = new AircraftCarrier(1,n1.aircraftCreation());
        Aircraft a1 = new Aircraft("100A",false);

        assertEquals(n1.aircraftCreation(),ac1.getCapacity());

        n1.getCarriers().add(ac1);
        n1.getAircrafts().add(a1);
        ac1.getAircrafts().add(a1);

        int r1 = n1.disponibilidadEnPortaAviones();
        assertEquals(n1.aircraftCreation()-1,r1);

    }

}
