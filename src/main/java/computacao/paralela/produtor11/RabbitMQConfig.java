package computacao.paralela.produtor11;

import com.rabbitmq.client.ConnectionFactory;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;

@Configuration
public class RabbitMQConfig {

    // Fila e Exchange para Produção Agrícola
    public static final String FILA_PRODUCAO = "filaProducao";
    public static final String FILA_VENDAS = "filaVendas";
    public static final String EXCHANGE_PRODUCAO = "exchangeProducao";
    public static final String ROUTING_KEY_PRODUCAO = "filaProdução";
    public static final String EXCHANGE_VENDAS = "exchangevendas";
    public static final String ROUTING_KEY_VENDAS = "filavendas";

    // Definindo as Filas
    @Bean
    public Queue filaProducao() {
        return new Queue(FILA_PRODUCAO, true);
    }

    @Bean
    public Queue filaVendas() {
        return new Queue(FILA_VENDAS, true);
    }

    @Bean
    public  RabbitAdmin rabbitAdmin(org.springframework.amqp.rabbit.connection.ConnectionFactory connectionFactory){
        return new RabbitAdmin((org.springframework.amqp.rabbit.connection.ConnectionFactory) connectionFactory);
    }

    @Bean
    public ApplicationListener<ApplicationReadyEvent> applicationReadyEventApplicationListener (RabbitAdmin rabbitAdmin){
        return event -> rabbitAdmin.initialize();
    }

    // Definindo as Exchanges
    @Bean
    public DirectExchange exchangeProducao() {
        return new DirectExchange(EXCHANGE_PRODUCAO);
    }

    @Bean
    public DirectExchange exchangeVendas() {
        return new DirectExchange(EXCHANGE_VENDAS);
    }

    // Bindings para cada fila
    @Bean
    public Binding bindingProducao(Queue filaProducao, DirectExchange exchangeProducao) {
        return BindingBuilder.bind(filaProducao).to(exchangeProducao).with(ROUTING_KEY_PRODUCAO);
    }

    @Bean
    public Binding bindingVendas(Queue filaVendas, DirectExchange exchangeVendas) {
        return BindingBuilder.bind(filaVendas).to(exchangeVendas).with(ROUTING_KEY_VENDAS);
    }

}
