package computacao.paralela.produtor11;


import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

    @Controller
    public class ProducerController {

        @Autowired
        private RabbitTemplate rabbitTemplate;

        @PostMapping("/sendDados")
        public ResponseEntity<String> sendAgricultureData(@RequestBody Dados dados) {
            // Envia dados para RabbitMQ
            rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_PRODUCAO, RabbitMQConfig.ROUTING_KEY_PRODUCAO, dados);
            return ResponseEntity.ok("Dados enviados com sucesso!");
        }
    }


