package iasd.coralzinho.gateway.core.rabbitmq;

import lombok.Getter;
import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class CriancaMQ {

    // Adicionar Request/Response
    @Value("${spring.mq.crianca.adicionar-req.exchange}")
    private String adicionarReqExchange;
    @Value("${spring.mq.crianca.adicionar-req.routing-key}")
    private String adicionarReqRoutingKey;
    @Value("${spring.mq.crianca.adicionar-req.queue}")
    private String adicionarReqQueue;

    @Value("${spring.mq.crianca.adicionar-res.exchange}")
    private String adicionarResExchange;
    @Value("${spring.mq.crianca.adicionar-res.routing-key}")
    private String adicionarResRoutingKey;
    @Value("${spring.mq.crianca.adicionar-res.queue}")
    private String adicionarResQueue;

    // Atualizar Request/Response
    @Value("${spring.mq.crianca.atualizar-req.exchange}")
    private String atualizarReqExchange;
    @Value("${spring.mq.crianca.atualizar-req.routing-key}")
    private String atualizarReqRoutingKey;
    @Value("${spring.mq.crianca.atualizar-req.queue}")
    private String atualizarReqQueue;

    @Value("${spring.mq.crianca.atualizar-res.exchange}")
    private String atualizarResExchange;
    @Value("${spring.mq.crianca.atualizar-res.routing-key}")
    private String atualizarResRoutingKey;
    @Value("${spring.mq.crianca.atualizar-res.queue}")
    private String atualizarResQueue;

    // Buscar Request/Response
    @Value("${spring.mq.crianca.buscar-req.exchange}")
    private String buscarReqExchange;
    @Value("${spring.mq.crianca.buscar-req.routing-key}")
    private String buscarReqRoutingKey;
    @Value("${spring.mq.crianca.buscar-req.queue}")
    private String buscarReqQueue;

    @Value("${spring.mq.crianca.buscar-res.exchange}")
    private String buscarResExchange;
    @Value("${spring.mq.crianca.buscar-res.routing-key}")
    private String buscarResRoutingKey;
    @Value("${spring.mq.crianca.buscar-res.queue}")
    private String buscarResQueue;

    @Bean
    public Declarables criancaBindings() {
        // Exchange
        DirectExchange criancaExchange = new DirectExchange(adicionarReqExchange);

        // Queues
        Queue adicionarReqQueueBean = new Queue(adicionarReqQueue, true);
        Queue adicionarResQueueBean = new Queue(adicionarResQueue, true);
        Queue atualizarReqQueueBean = new Queue(atualizarReqQueue, true);
        Queue atualizarResQueueBean = new Queue(atualizarResQueue, true);
        Queue buscarReqQueueBean = new Queue(buscarReqQueue, true);
        Queue buscarResQueueBean = new Queue(buscarResQueue, true);

        // Bindings
        Binding adicionarReqBinding = BindingBuilder.bind(adicionarReqQueueBean)
                .to(criancaExchange).with(adicionarReqRoutingKey);
        Binding adicionarResBinding = BindingBuilder.bind(adicionarResQueueBean)
                .to(criancaExchange).with(adicionarResRoutingKey);
        Binding atualizarReqBinding = BindingBuilder.bind(atualizarReqQueueBean)
                .to(criancaExchange).with(atualizarReqRoutingKey);
        Binding atualizarResBinding = BindingBuilder.bind(atualizarResQueueBean)
                .to(criancaExchange).with(atualizarResRoutingKey);
        Binding buscarReqBinding = BindingBuilder.bind(buscarReqQueueBean)
                .to(criancaExchange).with(buscarReqRoutingKey);
        Binding buscarResBinding = BindingBuilder.bind(buscarResQueueBean)
                .to(criancaExchange).with(buscarResRoutingKey);

        return new Declarables(
                criancaExchange,
                adicionarReqQueueBean,
                adicionarResQueueBean,
                atualizarReqQueueBean,
                atualizarResQueueBean,
                buscarReqQueueBean,
                buscarResQueueBean,
                adicionarReqBinding,
                adicionarResBinding,
                atualizarReqBinding,
                atualizarResBinding,
                buscarReqBinding,
                buscarResBinding
        );
    }
}
