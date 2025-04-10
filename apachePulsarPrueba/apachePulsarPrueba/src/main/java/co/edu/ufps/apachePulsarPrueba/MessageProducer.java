package co.edu.ufps.apachePulsarPrueba;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.pulsar.core.PulsarTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageProducer {

    @Autowired
    private PulsarTemplate<String> pulsarTemplate;

    public void send(String message) {
        pulsarTemplate.send("my-topic", message);
    }
}
