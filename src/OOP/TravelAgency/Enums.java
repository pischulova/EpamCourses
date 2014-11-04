package OOP.TravelAgency;

import java.util.Random;

/**
 * Created by А on 28.10.14.
 */
public class Enums {
    public enum TravelType {
        EXCURSION, BEACH, SHOPPING;

        public static TravelType randomTravelType(){
            Random generator = new Random();
            int x = generator.nextInt(3);
            return TravelType.values()[x];
        }
    }

    public enum Transport {
        AIRPLANE, TRAIN, BUS;

        public static Transport randomTransport(){
            Random generator = new Random();
            int x = generator.nextInt(3);
            return Transport.values()[x];
        }
    }

}
