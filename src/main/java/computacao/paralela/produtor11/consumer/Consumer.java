package computacao.paralela.produtor11.consumer;

import computacao.paralela.produtor11.RabbitMQConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @RabbitListener(queues = {RabbitMQConfig.FILA_PRODUCAO})
    public void receiveMessage(@Payload Message message) {
        System.out.println("Mensagem Recebida! \n" + message);
    }
}
