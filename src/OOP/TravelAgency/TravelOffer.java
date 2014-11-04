package OOP.TravelAgency;

import java.util.*;
import OOP.TravelAgency.Enums.*;

/**
 * Created by А on 28.10.14.
 */
public class TravelOffer {
    List<Tour> travelOffer = new ArrayList<>();

    public void createStandardOffer() {
        Tour Austria = new Tour(TravelType.EXCURSION, Transport.BUS, 10);
        Tour Germany = new Tour(TravelType.SHOPPING, Transport.AIRPLANE, 8);
        Tour Italy = new Tour(TravelType.BEACH, Transport.TRAIN, 16);
        Tour France = new Tour(TravelType.BEACH, Transport.AIRPLANE, 2);
        Tour Norway = new Tour(TravelType.EXCURSION, Transport.TRAIN, 6);
        travelOffer.add(Austria);
        travelOffer.add(Germany);
        travelOffer.add(Italy);
        travelOffer.add(France);
        travelOffer.add(Norway);

        Collections.sort(travelOffer);
        for (Tour tour: travelOffer) {
            System.out.println(tour.toString());
        }
    }

    public void createRandomOffer() {
        for (int i = 0; i < 30; i++) {
            Random generator = new Random();
            int duration = 1 + generator.nextInt(31);
            TravelType travelType = TravelType.randomTravelType();
            Transport transport = Transport.randomTransport();
            travelOffer.add(new Tour(travelType, transport, duration));
        }
        Collections.sort(travelOffer);
        for (Tour tour: travelOffer) {
            System.out.println(tour.toString());
        }
    }

    public List<Tour> chooseTour(TravelType travelType, Transport transport, int moneyLimit) {
        List<Tour> result = new ArrayList<>();
        for (Tour tour : travelOffer) {
            if (tour.getTravelType().equals(travelType) && tour.getTransport().equals(transport) &&
                    tour.getCost() <= moneyLimit)
                result.add(tour);
        }
        System.out.println("*****");
        if (result.size() == 0)
            System.out.println("No tour found for you");
        else {
            for (Tour tour : result) {
                System.out.println(tour.toString());
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TravelOffer offer = new TravelOffer();
        offer.createRandomOffer();
        offer.chooseTour(TravelType.EXCURSION, Transport.AIRPLANE, 1000);

    }
}
