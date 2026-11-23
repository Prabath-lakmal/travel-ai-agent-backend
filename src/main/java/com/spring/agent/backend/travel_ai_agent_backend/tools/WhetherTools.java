package com.spring.agent.backend.travel_ai_agent_backend.tools;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Component;

@Component
public class WhetherTools {

//    getForecast

//    apis to get forecast
    @Tool(name = "getForecast",description = "Get the whether forecast for a specific city and date. ")
    public String getForecast(String city, String date){
        return "The whether forecast for " + city + "on" + date + "is sunny with a high of 30`C.";
    }
}
