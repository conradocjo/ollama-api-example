package com.ollm.Service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class ServiceOllm {

    private final RestTemplate restTemplate = new RestTemplate();
    private static final String OLLAMA_URL = "http://localhost:11434/api/generate";

    public String gerarResposta(String prompt) {

        ResponseEntity<Map> response = restTemplate.postForEntity(OLLAMA_URL, getHttpEntity(prompt), Map.class);

        if (response.getStatusCode() == HttpStatus.OK && response.getBody() != null) {
            return (String) response.getBody().get("response");
        }

        throw new RuntimeException("Erro ao chamar Ollama");

    }

    private static HttpEntity<Map<String, Object>> getHttpEntity(String prompt) {
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("model", "llama3");
        requestBody.put("prompt", prompt);
        requestBody.put("stream", false); // se quiser resposta completa de uma vez
        return new HttpEntity<>(requestBody, getHttpHeaders());
    }

    private static HttpHeaders getHttpHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }

}
