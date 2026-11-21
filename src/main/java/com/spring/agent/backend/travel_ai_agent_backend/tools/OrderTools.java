package com.spring.agent.backend.travel_ai_agent_backend.tools;

import java.util.HashMap;
import java.util.Map;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Component;

@Component
public class OrderTools {

    private final Map<String, String> orders= Map.of(
        "1", "Shipped - arriving tomorrow",
        "2", "Processing - not yet shipped",
        "3", "Cancelled - out of stock",
        "4", "Shipped - arriving next week"
    );

    @Tool(description = "Get the status of an order by its ID")
    public String getOrderStatus(String orderId) {
        System.out.println("calling getOrder status Tool");
        System.out.println("Fetching order status for order ID: " + orderId);
        return orders.getOrDefault(orderId, "Order not found");
    }

    @Tool(description = "Cancel a customer orders by its orders ID ")
    public String cancelOrder(String orderId){
        System.out.println("calling cancelOrder Tool");
        System.out.println("Attempting to cancel order with ID: " + orderId);
        if (orders.containsKey(orderId)){
            return "Order " + orderId + "has been cancelled.";
        }else {
            return "Ordes not found!";
        }
    }

//    Orders tools create

}
