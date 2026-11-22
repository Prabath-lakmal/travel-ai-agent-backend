package com.spring.agent.backend.travel_ai_agent_backend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Flight {

    private String airLine;
    private String source;
    private String destination;
    private String date;
    private Integer price;

}
