package interviewbit.arrays;

import java.util.ArrayList;

/**
 * Created by mayan on 14/8/18.
 */
public class HotelBooking {
    public static void main(String[] args){
        ArrayList<Integer> arrivals = new ArrayList<>();
        arrivals.add(1);
        arrivals.add(3);
        arrivals.add(5);

        ArrayList<Integer> departure = new ArrayList<>();
        departure.add(2);
        departure.add(6);
        departure.add(8);

        HotelBooking hotelBooking = new HotelBooking();
        hotelBooking.hotel(arrivals,departure,5);
    }
    public boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {
        return false;
    }
}
