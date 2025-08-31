package iasd.coralzinho.gateway.core.rabbitmq;

import lombok.Getter;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class PresencaMQ {

    // Registrar Request
    @Value("${spring.mq.presenca.registrar-req.exchange}")
    private String registrarReqExchange;

    @Value("${spring.mq.presenca.registrar-req.routing-key}")
    private String registrarReqRoutingKey;

    @Value("${spring.mq.presenca.registrar-req.queue}")
    private String registrarReqQueue;

    @Bean
    public Declarables presencaBindings() {
        // Exchange
        DirectExchange presencaExchange = new DirectExchange(registrarReqExchange);

        // Queue
        Queue registrarReqQueueBean = new Queue(registrarReqQueue, true);

        // Binding
        Binding registrarReqBinding = BindingBuilder.bind(registrarReqQueueBean)
                .to(presencaExchange).with(registrarReqRoutingKey);

        return new Declarables(
                presencaExchange,
                registrarReqQueueBean,
                registrarReqBinding
        );
    }

}
