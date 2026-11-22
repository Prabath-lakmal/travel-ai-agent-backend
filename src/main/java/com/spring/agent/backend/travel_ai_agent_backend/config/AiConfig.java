package com.spring.agent.backend.travel_ai_agent_backend.config;

import com.spring.agent.backend.travel_ai_agent_backend.tools.InventoryTools;
import com.spring.agent.backend.travel_ai_agent_backend.tools.OrderTools;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class AiConfig {

    private final OrderTools tools;
    private final InventoryTools inventoryTools;

    @Bean
    public ChatClient chatClient(ChatClient.Builder builder){
        return builder
                .defaultSystem(
                        "You are a helpful assistance that helps users to get the status of their orders and cancel their orders.")
                .defaultTools(tools, inventoryTools)
                .build();
    }

}
