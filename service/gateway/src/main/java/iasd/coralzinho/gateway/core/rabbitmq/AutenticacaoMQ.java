package iasd.coralzinho.gateway.core.rabbitmq;

import lombok.Getter;
import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class AutenticacaoMQ {

    // Login Request
    @Value("${spring.mq.autenticacao.login-req.exchange}")
    private String loginReqExchange;

    @Value("${spring.mq.autenticacao.login-req.routing-key}")
    private String loginReqRoutingKey;

    @Value("${spring.mq.autenticacao.login-req.queue}")
    private String loginReqQueue;

    // Login Response
    @Value("${spring.mq.autenticacao.login-res.exchange}")
    private String loginResExchange;

    @Value("${spring.mq.autenticacao.login-res.routing-key}")
    private String loginResRoutingKey;

    @Value("${spring.mq.autenticacao.login-res.queue}")
    private String loginResQueue;

    // Cadastro Request
    @Value("${spring.mq.autenticacao.cadastro-req.exchange}")
    private String cadastroReqExchange;

    @Value("${spring.mq.autenticacao.cadastro-req.routing-key}")
    private String cadastroReqRoutingKey;

    @Value("${spring.mq.autenticacao.cadastro-req.queue}")
    private String cadastroReqQueue;

    // Cadastro Response
    @Value("${spring.mq.autenticacao.cadastro-res.exchange}")
    private String cadastroResExchange;

    @Value("${spring.mq.autenticacao.cadastro-res.routing-key}")
    private String cadastroResRoutingKey;

    @Value("${spring.mq.autenticacao.cadastro-res.queue}")
    private String cadastroResQueue;

    @Bean
    public Declarables autenticacaoBindings() {
        // Exchanges
        DirectExchange autenticacaoExchange = new DirectExchange(loginReqExchange);

        // Queues
        Queue loginReqQueueBean = new Queue(loginReqQueue, true);
        Queue loginResQueueBean = new Queue(loginResQueue, true);
        Queue cadastroReqQueueBean = new Queue(cadastroReqQueue, true);
        Queue cadastroResQueueBean = new Queue(cadastroResQueue, true);

        // Bindings
        Binding loginReqBinding = BindingBuilder.bind(loginReqQueueBean)
                .to(autenticacaoExchange).with(loginReqRoutingKey);
        Binding loginResBinding = BindingBuilder.bind(loginResQueueBean)
                .to(autenticacaoExchange).with(loginResRoutingKey);
        Binding cadastroReqBinding = BindingBuilder.bind(cadastroReqQueueBean)
                .to(autenticacaoExchange).with(cadastroReqRoutingKey);
        Binding cadastroResBinding = BindingBuilder.bind(cadastroResQueueBean)
                .to(autenticacaoExchange).with(cadastroResRoutingKey);

        return new Declarables(
                autenticacaoExchange,
                loginReqQueueBean,
                loginResQueueBean,
                cadastroReqQueueBean,
                cadastroResQueueBean,
                loginReqBinding,
                loginResBinding,
                cadastroReqBinding,
                cadastroResBinding
        );
    }
}
