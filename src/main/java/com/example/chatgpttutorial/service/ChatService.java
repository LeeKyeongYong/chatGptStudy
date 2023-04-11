package com.example.chatgpttutorial.service;

import com.example.chatgpttutorial.config.ChatConfig;
import com.example.chatgpttutorial.model.ChatReqDTO;
import com.example.chatgpttutorial.model.ChatRespDTO;
import com.example.chatgpttutorial.model.QuestReqDTO;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ChatService {

    private static RestTemplate restTemp = new RestTemplate();
    public HttpEntity<ChatReqDTO> buildHttpEntity(ChatReqDTO reqDto) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType(ChatConfig.MEDIA_TYPE));
        headers.add(ChatConfig.AUTHORIZATION, ChatConfig.BEARER + ChatConfig.API_KEY);
        return new HttpEntity<>(reqDto, headers);
    }

    public ChatRespDTO getResponse(HttpEntity<ChatReqDTO> chatGptRequestDtoHttpEntity) {
        ResponseEntity<ChatRespDTO> responseEntity = restTemp.postForEntity(
                ChatConfig.URL,
                chatGptRequestDtoHttpEntity,
                ChatRespDTO.class);

        return responseEntity.getBody();
    }

    public ChatRespDTO askQuest(QuestReqDTO reqDto) {
        return this.getResponse(
                this.buildHttpEntity(
                        new ChatReqDTO(
                                ChatConfig.MODEL,
                                reqDto.getQuest(),
                                ChatConfig.MAX_TOKEN,
                                ChatConfig.TEMPERATURE,
                                ChatConfig.TOP_P
                        )
                )
        );
    }
}