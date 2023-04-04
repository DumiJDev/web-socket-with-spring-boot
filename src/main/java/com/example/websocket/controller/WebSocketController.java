package com.example.websocket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@EnableScheduling
@Controller
public class WebSocketController {
    private final static String LER_MENSAGEM_ROTA = "/listen/messages";

    @Autowired
    private SimpMessagingTemplate template;

    @Scheduled(cron = "0 * * * * *")
    public void responde() throws InterruptedException {
        Thread.sleep(1500);
        template.convertAndSend(LER_MENSAGEM_ROTA, "Olá são " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")));
    }
}
