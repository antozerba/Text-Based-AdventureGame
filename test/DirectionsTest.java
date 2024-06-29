import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

class DirectionsTest {

    @Test
    void getNB() {
        Directions directions = new Directions();
        ArrayList<String> expected = new ArrayList<>(Arrays.asList("nord", "back"));
        assertEquals(expected, directions.getNB());
    }

    @Test
    void getNESOB() {
        Directions directions = new Directions();
        ArrayList<String> expected = new ArrayList<>(Arrays.asList("nord", "sud", "est", "ovest", "back"));
        assertEquals(expected, directions.getNESOB());
    }

    @Test
    void getSB() {
        Directions directions = new Directions();
        ArrayList<String> expected = new ArrayList<>(Arrays.asList("sud", "back"));
        assertEquals(expected, directions.getSB());
    }

    @Test
    void getEB() {
        Directions directions = new Directions();
        ArrayList<String> expected = new ArrayList<>(Arrays.asList("est", "back"));
        assertEquals(expected, directions.getEB());
    }

    @Test
    void getOB() {
        Directions directions = new Directions();
        ArrayList<String> expected = new ArrayList<>(Arrays.asList("ovest", "back"));
        assertEquals(expected, directions.getOB());
    }

    @Test
    void getNSB() {
        Directions directions = new Directions();
        ArrayList<String> expected = new ArrayList<>(Arrays.asList("nord", "sud", "back"));
        assertEquals(expected, directions.getNSB());
    }

    @Test
    void getNESB() {
        Directions directions = new Directions();
        ArrayList<String> expected = new ArrayList<>(Arrays.asList("nord", "sud", "est", "back"));
        assertEquals(expected, directions.getNESB());
    }

    @Test
    void getNEOB() {
        Directions directions = new Directions();
        ArrayList<String> expected = new ArrayList<>(Arrays.asList("nord", "est", "ovest", "back"));
        assertEquals(expected, directions.getNEOB());
    }

    @Test
    void getESB() {
        Directions directions = new Directions();
        ArrayList<String> expected = new ArrayList<>(Arrays.asList("est", "sud", "back"));
        assertEquals(expected, directions.getESB());
    }

    @Test
    void getESOB() {
        Directions directions = new Directions();
        ArrayList<String> expected = new ArrayList<>(Arrays.asList("est", "sud", "ovest", "back"));
        assertEquals(expected, directions.getESOB());
    }

    @Test
    void getNEB() {
        Directions directions = new Directions();
        ArrayList<String> expected = new ArrayList<>(Arrays.asList("nord", "est", "back"));
        assertEquals(expected, directions.getNEB());
    }

    @Test
    void getNOB() {
        Directions directions = new Directions();
        ArrayList<String> expected = new ArrayList<>(Arrays.asList("nord", "ovest", "back"));
        assertEquals(expected, directions.getNOB());
    }
}
