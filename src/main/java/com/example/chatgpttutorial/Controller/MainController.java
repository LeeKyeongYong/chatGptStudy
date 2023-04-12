package com.example.chatgpttutorial.Controller;

import com.example.chatgpttutorial.model.ChatRespDTO;
import com.example.chatgpttutorial.model.QuestReqDTO;
import com.example.chatgpttutorial.service.ChatService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/chat-gpt")
public class MainController {

    private final ChatService chatGptService;

    public MainController(ChatService chatGptService) {
        this.chatGptService = chatGptService;
    }

    @PostMapping("/question")
    public ChatRespDTO sendQuestion(@RequestBody QuestReqDTO requDto) {
        return chatGptService.askQuest(requDto);
    }
}
