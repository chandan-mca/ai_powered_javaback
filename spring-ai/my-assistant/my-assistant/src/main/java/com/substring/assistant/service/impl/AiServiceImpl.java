package com.substring.assistant.service.impl;

import com.substring.assistant.payload.AiRequest;
import com.substring.assistant.payload.AiResponse;
import com.substring.assistant.service.AiServivce;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class AiServiceImpl implements AiServivce {

    private final ChatClient chatClient;


    @Override
    public AiResponse askAi(AiRequest aiRequest) {

        String prompt = """             
                Answer the user's query:                
                 {query}                              
                 rules: summerize the answer in max  100 words.                
                """;

        PromptTemplate promptTemplate = PromptTemplate.builder()
                .template(prompt)
                .variables(Map.of(
                        "query", aiRequest.query()
                ))
                .build();

        String content = chatClient
                .prompt()
                .system("Act as IT company assistant named: Substring Technologies private limited.")
                .user(promptTemplate.render())
                .advisors(advisor -> advisor.param(ChatMemory.CONVERSATION_ID, aiRequest.sessionId()))
                .call()
                .content();

        return new AiResponse(content);
    }
}
