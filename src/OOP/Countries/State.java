package OOP.Countries;

import java.util.List;

/**
 * Created by А on 18.10.14.
 */
public class State {
    private City stateCentre;
    private List<Region> regions;

    public State(City stateCentre) {
        this.stateCentre = stateCentre;
    }

    public City getStateCentre() {
        return stateCentre;
    }
}
