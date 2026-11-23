package com.spring.agent.backend.travel_ai_agent_backend.controller;

import com.spring.agent.backend.travel_ai_agent_backend.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.asm.Handle;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/chat")
@RequiredArgsConstructor

public class ChatController {

    private final ChatService chatService;

    @GetMapping
    public ResponseEntity<String> chat(@RequestHeader("Conversation Id")String conversationId, @RequestBody String message){

        return ResponseEntity.ok(chatService.chat(conversationId, message));
    }
}
