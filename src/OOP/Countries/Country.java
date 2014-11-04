package OOP.Countries;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by А on 18.10.14.
 */
public class Country {
    private double area;
    private City capital;
    private List<State> statesList = new ArrayList<State>();

    public Country(double area, City capital) {
        this.area = area;
        this.capital = capital;
    }

    public void printCapital() {
        System.out.println("Capital: " + capital.getName());
    }

    public void printStatesNumber() {
        System.out.println("Number of states: " + statesList.size());
    }

    public void printArea() {
        System.out.println("Country area = " + area + " sq km");
    }

    public void printStateCentres() {
        System.out.println("State centres:");
        for(State state: statesList)
            System.out.println(state.getStateCentre().getName());
    }

    public void addState(State state) {
        statesList.add(state);
    }

    public static void main(String[] args) {
        City kiev = new City("Kiev");
        City odessa = new City("Odessa");
        State kievskiy = new State(kiev);
        State odesskiy = new State(odessa);
        Country ukraine = new Country(603.549, kiev);
        ukraine.addState(kievskiy);
        ukraine.addState(odesskiy);
        ukraine.printArea();
        ukraine.printCapital();
        ukraine.printStatesNumber();
        ukraine.printStateCentres();
    }
}
