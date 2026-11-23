package com.spring.agent.backend.travel_ai_agent_backend.tools;

import com.spring.agent.backend.travel_ai_agent_backend.model.Hotel;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HotelTool {

    private final List<Hotel> hotels = List.of(
            new Hotel("Shangilla", "colombo", 5000, 9.5),
            new Hotel("Cinnamon Life", "colombo", 4700, 8.5),
            new Hotel("Cinnamon Lake Side", "colombo", 4500, 8.8),
            new Hotel("Araliya", "Kandy", 3500, 7.6),
            new Hotel("Cinnamon red", "Kollpity", 2700, 6.9)
    );

//    search hotel
    @Tool(name = "searchHotel", description = "Seach fo hotels base on city and maximum pice pe night. Returns a list of avilable hotels with their price and ratings.")
    public String searchHotel(String city, int maxPrice){
        StringBuilder result = new StringBuilder();
        for (Hotel hotel:hotels){
            if (hotel.city().equalsIgnoreCase(city) && hotel.pricePerNightUSD() <= maxPrice){
                result.append("Hotel name: ").append(hotel.name())
                        .append(", Price per Night: ").append(hotel.pricePerNightUSD())
                        .append(", Rating: ").append(hotel.rating())
                        .append(", ");
            }
        }
        return result.length() > 0 ? result.toString() : "No hotels found fo the given criteria.";
    }

//    hotel  status

//    hotel Booking
}
