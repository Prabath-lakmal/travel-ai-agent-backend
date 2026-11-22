package com.spring.agent.backend.travel_ai_agent_backend.tools;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class InventoryTools {

    //dummy data
    private final Map<String,Integer> stock = Map.of(
            "Blutooth HeadPhone", 5,
            "Wireless Mouse",13,
            "Usb Cable", 10
    );

    @Tool(description = "Check the sock availability of a products by its name")
    public String checkStock(String productName){
        System.out.println("Calling check stock Tool");
        System.out.println("Checking stock fo product");

        Integer quantity = stock.get(productName);
        if (quantity == null){
            return "Product Not found";
        } else if (quantity > 0) {
            return "In  stock: " + quantity + "units available";
        }else {
            return "Out of stock";
        }
    }

    @Tool(description = "Get the total count of products in stock")
    public Integer getTotalProductsInStock(){
        System.out.println("Calling getTotalProductsInStock");
        return stock.size();
    }

    //Tools to get all product
    public List<String> getAllProductsInStock(){
        System.out.println("Calling getAllProductInStock");
        return stock.keySet()
                .stream()
                .filter(name -> stock.get(name) > 0)
                .collect(Collectors.toList());
    }

}
