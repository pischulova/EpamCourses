package OOP.TravelAgency;

import OOP.TravelAgency.Enums.*;

/**
 * Created by А on 28.10.14.
 */
public class Tour implements Comparable{

    private TravelType travelType;
    private Transport transport;
    private int duration;
    private int cost;

    public Tour (TravelType travelType, Transport transport, int duration) {
        this.travelType = travelType;
        this.transport = transport;
        this.duration = duration;
        this.cost = calculateCost();
    }

    public TravelType getTravelType() {
        return travelType;
    }

    public Transport getTransport() {
        return transport;
    }

    public int getDuration() {
        return duration;
    }

    public int getCost() {
        return cost;
    }

    private int calculateCost() {
        switch (this.travelType) {
            case EXCURSION: cost = 300;
                break;
            case BEACH: cost = 250;
                break;
            case SHOPPING: cost = 200;
                break;
        }
        switch (this.transport) {
            case AIRPLANE: cost += 200;
                break;
            case TRAIN: cost += 150;
                break;
            case BUS: cost += 120;
                break;
        }
        for (int i = 0; i < duration; i++) {
            cost += 30;
        }
        return cost;
    }

    @Override
    public int compareTo(Object obj) {
        Tour temporary = (Tour)obj;
        if (this.cost < temporary.cost)
            return -1;
        else if (this.cost > temporary.cost)
            return 1;
        return 0;
    }

    @Override
    public String toString() {
        return "Tour {" +
                "travelType: " + travelType +
                ", transport: " + transport +
                ", duration = " + duration +
                ", cost = " + cost + " USD}";
    }
}
