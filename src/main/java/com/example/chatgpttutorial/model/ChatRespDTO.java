package com.example.chatgpttutorial.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.*;
import java.io.Serializable;
import java.time.LocalDate;
@Getter
@NoArgsConstructor
public class ChatRespDTO implements Serializable {

    private String id;
    private String object;
    private LocalDate created;
    private String model;
    private List<SelectDTO> choices;

    @Builder
    public ChatRespDTO(String id, String object,
                              LocalDate created, String model,
                              List<SelectDTO> choices) {
        this.id = id;
        this.object = object;
        this.created = created;
        this.model = model;
        this.choices = choices;
    }
}