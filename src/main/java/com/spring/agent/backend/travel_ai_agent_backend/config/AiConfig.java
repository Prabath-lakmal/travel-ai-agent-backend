package com.spring.agent.backend.travel_ai_agent_backend.config;

import com.spring.agent.backend.travel_ai_agent_backend.tools.*;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.memory.MessageWindowChatMemory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class AiConfig {

    private final OrderTools tools;
    private final InventoryTools inventoryTools;
    private final FlightTools flightTools;
    private final HotelTool hotelTools;
    private final WhetherTools whetherTools;

    @Bean
    public ChatMemory chatMemory(){
        return MessageWindowChatMemory
                .builder()
                .maxMessages(10)
                .build();
    }

    @Bean
    public ChatClient chatClient(ChatClient.Builder builder){
        return builder
                .defaultSystem(
                        "You are a helpful travel planning agent and helpful customer support agent fo an online store." +
                                "Use the available tools to find flights, hotels, and whether information fo users" +
                                "When given a budget, suggest option that fit withing it and explain you reasoning"
                )
                .defaultAdvisors(MessageChatMemoryAdvisor.builder(chatMemory()).build())
                .defaultTools(tools, inventoryTools, flightTools, hotelTools, whetherTools)
                .build();
    }

}
