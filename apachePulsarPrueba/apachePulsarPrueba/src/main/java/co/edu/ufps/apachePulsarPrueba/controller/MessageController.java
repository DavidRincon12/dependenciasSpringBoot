package co.edu.ufps.apachePulsarPrueba.controller;

import co.edu.ufps.apachePulsarPrueba.MessageConsumer;
import co.edu.ufps.apachePulsarPrueba.MessageProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    private final MessageProducer producer;
    private final MessageConsumer consumer;

    public MessageController(MessageProducer producer, MessageConsumer consumer) {
        this.producer = producer;
        this.consumer = consumer;
    }

    @PostMapping("/send")
    public ResponseEntity<String> sendMessage(@RequestParam String message) {
        producer.send(message);
        return ResponseEntity.ok("📤 Notificación enviada: " + message);
    }

    @GetMapping("/history")
    public ResponseEntity<List<String>> getReceivedMessages() {
        return ResponseEntity.ok(consumer.getReceivedMessages());
    }
}
