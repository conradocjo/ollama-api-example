package com.ollm.controller;

import com.ollm.Service.ServiceOllm;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiOllm {

    private ServiceOllm serviceOllm;

    public ApiOllm(ServiceOllm serviceOllm) {
        this.serviceOllm = serviceOllm;
    }

    @PostMapping("/teste")
    public String apiTeste(@RequestParam("pergunta") String pergunta) {
        return serviceOllm.gerarResposta(pergunta);
    }

}
