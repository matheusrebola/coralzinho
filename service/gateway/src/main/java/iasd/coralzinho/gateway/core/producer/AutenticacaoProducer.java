package iasd.coralzinho.gateway.core.producer;

import iasd.coralzinho.gateway.core.rabbitmq.AutenticacaoMQ;
import iasd.coralzinho.gateway.core.dto.CadastroReq;
import iasd.coralzinho.gateway.core.dto.LoginReq;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class AutenticacaoProducer {
    private final RabbitTemplate rabbitTemplate;

    public void efetuarLogin(LoginReq req) {
        rabbitTemplate.convertAndSend(
                AutenticacaoMQ.EXCHANGE,
                AutenticacaoMQ.ROUTING_KEY,
                req
        );
    }

    public void cadastrarUsuario(CadastroReq req) {
        rabbitTemplate.convertAndSend(
                AutenticacaoMQ.EXCHANGE,
                AutenticacaoMQ.ROUTING_KEY,
                req
        );
    }
}
