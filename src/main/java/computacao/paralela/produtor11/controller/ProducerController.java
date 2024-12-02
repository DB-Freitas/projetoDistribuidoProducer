package computacao.paralela.produtor11.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import computacao.paralela.produtor11.dto.Dados;
import computacao.paralela.produtor11.RabbitMQConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import computacao.paralela.produtor11.dto.Pedido;

@Controller
public class ProducerController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    private final ObjectMapper mapper = new ObjectMapper();

    @PostMapping("/sendDados")
    public ResponseEntity<String> sendAgricultureData(@RequestBody Dados dados) throws JsonProcessingException {
        // Envia dados para RabbitMQ
        //System.out.println("Dados a serem enviados");
        //System.out.println(mapper.writeValueAsString(dados));
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_PRODUCAO, RabbitMQConfig.ROUTING_KEY_PRODUCAO, mapper.writeValueAsString(dados));
        return ResponseEntity.ok("Dados enviados com sucesso!");
    }

    @PostMapping("/sendCoffeeOrderData") // Define your endpoint for coffee order data
    public ResponseEntity<String> sendCoffeeOrderData(@RequestBody Pedido pedido) throws JsonProcessingException {
        // Envia dados de venda de café para RabbitMQ
        //System.out.println("Dados de venda de café a serem enviados");
        //System.out.println(mapper.writeValueAsString(pedido));
        // Use appropriate exchange and routing key for coffee orders
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_PRODUCAO, RabbitMQConfig.ROUTING_KEY_VENDAS, mapper.writeValueAsString(pedido));

        return ResponseEntity.ok("Dados da venda de café enviados com sucesso!");
    }
}