package com.example.chatgpttutorial.Controller;

import com.example.chatgpttutorial.model.ChatRespDTO;
import com.example.chatgpttutorial.model.QuestReqDTO;
import com.example.chatgpttutorial.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/chat-gpt")
public class MainController {
    private final ChatService chatService;

    public MainController(ChatService chatService) {
        this.chatService = chatService;
    }



    @PostMapping("/question")
    public ChatRespDTO sendQuestion(@RequestBody QuestReqDTO reqDto) {
        return chatService.askQuest(reqDto);
    }
}
