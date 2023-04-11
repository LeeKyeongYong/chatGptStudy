package com.example.chatgpttutorial.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter
@NoArgsConstructor
public class SelectDTO implements Serializable {

    private String text;
    private Integer index;
    @JsonProperty("finish_reason")
    private String finishReason;

    @Builder
    public SelectDTO(String text, Integer index, String finishReason) {
        this.text = text;
        this.index = index;
        this.finishReason = finishReason;
    }
}