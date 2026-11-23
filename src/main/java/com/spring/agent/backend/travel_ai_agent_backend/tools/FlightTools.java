package com.spring.agent.backend.travel_ai_agent_backend.tools;

import com.spring.agent.backend.travel_ai_agent_backend.model.Flight;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FlightTools {

    private final List<Flight> flights = List.of(
            new Flight("Sri lankan Air", "colombo", "India","2026-11-24", 10000),
            new Flight("Quarter Air", "colombo", "India", "2026-11-24", 11000),
            new Flight("Dubai Air", "colombo", "India", "2026-11-24", 12000)
    );

//    Search flights
    @Tool(name = "searchFlight",
            description = "Search for flights base on source, destination, date. Returns a list of availability flights with their prices.")
    public String searchFlight(String source, String destination, String date){
        List<Flight> filteredFlights = flights.stream()
                .filter(f -> f.getSource().equalsIgnoreCase(source) && f.getDestination().equalsIgnoreCase(destination) && f.getDate().equals(date))
                .toList();
        if (filteredFlights.isEmpty()){
            return "No flights found for the given criteria";
        }

        return filteredFlights.stream()
                .map(f->f.getAirLine()+ " : $ " + f.getPrice())
                .collect(Collectors.joining(","));
    }


//    public String searchFlight(String source, String destination, String date){
//        StringBuilder result = new StringBuilder();
//        for (Flight flight : flights){
//            if (flight.getSource().equalsIgnoreCase(source) &&
//                flight.getDestination().equalsIgnoreCase(destination) &&
//                flight.getDate().equals(date)){
//
//                result.append("AirLine: ").append(flight.getAirLine())
//                        .append(", Price: ").append(flight.getPrice()).append("\n");
//            }
//        }
//        return result.length() > 0 ? result.toString() : "No flights found for the given criteria.";
//    }




//    flight status

//    flight booking
}
