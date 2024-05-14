import java.util.ArrayList;
import java.util.Arrays;

public class Directions {

    private final ArrayList<String> N = new ArrayList<String>(Arrays.asList("nord"));
    private final ArrayList<String> NESOB = new ArrayList<String>(Arrays.asList("nord", "sud", "est", "ovest", "back"));
    private final ArrayList<String> SB = new ArrayList<String>(Arrays.asList("sud", "back"));
    private final ArrayList<String> EB = new ArrayList<String>(Arrays.asList("est", "back"));
    private final ArrayList<String> OB = new ArrayList<String>(Arrays.asList("ovest", "back"));
    private final ArrayList<String> NSB = new ArrayList<String>(Arrays.asList("nord", "sud", "back"));
    private final ArrayList<String> NESB = new ArrayList<String>(Arrays.asList("nord", "sud", "est", "back"));
    private final ArrayList<String> NEOB = new ArrayList<String>(Arrays.asList("nord", "est", "sud", "back"));
    private final ArrayList<String> ESB = new ArrayList<String>(Arrays.asList("est", "sud", "back"));
    private final ArrayList<String> ESOB = new ArrayList<String>(Arrays.asList("est", "sud", "ovest", "back"));
    private final ArrayList<String> NEB = new ArrayList<String>(Arrays.asList("nord", "est", "back"));
    private final ArrayList<String> NOB = new ArrayList<String>(Arrays.asList("nord", "ovest", "back"));

    public Directions() {};

    public ArrayList<String> getN() {
        return N;
    }

    public ArrayList<String> getNESOB() {
        return NESOB;
    }

    public ArrayList<String> getSB() {
        return SB;
    }

    public ArrayList<String> getEB() {
        return EB;
    }

    public ArrayList<String> getOB() {
        return OB;
    }

    public ArrayList<String> getNSB() {
        return NSB;
    }

    public ArrayList<String> getNESB() {
        return NESB;
    }

    public ArrayList<String> getNEOB() {
        return NEOB;
    }

    public ArrayList<String> getESB() {
        return ESB;
    }

    public ArrayList<String> getESOB() {
        return ESOB;
    }

    public ArrayList<String> getNEB() {
        return NEB;
    }

    public ArrayList<String> getNOB() {
        return NOB;
    }
}