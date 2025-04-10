package co.edu.ufps.apachePulsarPrueba;

import org.springframework.pulsar.annotation.PulsarListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MessageConsumer {

    private final List<String> receivedMessages = new ArrayList<>();

    @PulsarListener(subscriptionName = "my-subscription", topics = "my-topic")
    public void listen(String message) {
        System.out.println("🔔 Notificación recibida: " + message);
        receivedMessages.add(message);
    }

    public List<String> getReceivedMessages() {
        return receivedMessages;
    }
}
