package com.gridnine.testing.filter;

import com.gridnine.testing.testClasses.Flight;
import com.gridnine.testing.testClasses.Segment;


import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/*
Класс фильтра для исключения опредленных перелетов из списка тестового набора.
 */
public class FlightFilter {



    // Метод исключения перелетов, у которых вылет до текущего момента времени
    public static List<Flight> departureBeforeTheCurrentTime(List<Flight> flights) {
        LocalDateTime currentTime = LocalDateTime.now();
        List<Flight> excluded = new ArrayList<>(flights);
        for (Flight flight : flights){
            List<Segment> segments = flight.getSegments();
            for (Segment segment : segments){
                if (segment.getDepartureDate().isBefore(currentTime)){
                    excluded.remove(flight);
                }
            }
        }
        return excluded;
    }

    //Метод исключения перелетов, у которых имеются сегменты с датой прилёта раньше даты вылета
    public static List<Flight> arrivalEarlierThanDeparture(List<Flight> flights){
        List<Flight> excluded = new ArrayList<>(flights);
        for (Flight flight : flights){
            List<Segment> segments = flight.getSegments();
            for (Segment segment : segments){
                if (segment.getArrivalDate().isBefore(segment.getDepartureDate())){
                    excluded.remove(flight);
                }
            }
        }
        return excluded;
    }

    //Метод исключения перелетов, у которых общее время, проведённое на земле превышает два часа
    public static List<Flight> moreThanTwoHoursOnTheGround(List<Flight> flights){
        List<Flight> excluded = new ArrayList<>(flights);
        for (Flight flight : flights){
            List<Segment> segments = flight.getSegments();
            int groundTime = 0;
            if (segments.size() > 1) {
                for (int i = 0; i < segments.size() - 1; i++) {
                    groundTime += Math.abs(Duration.between(segments.get(i).getArrivalDate(), segments.get(i + 1).getDepartureDate()).toHours());
                }
                if (groundTime > 2) {
                    excluded.remove(flight);
                }
            }
        }
        return excluded;
    }
}
