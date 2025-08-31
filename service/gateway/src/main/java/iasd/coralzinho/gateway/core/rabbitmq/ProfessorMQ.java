package iasd.coralzinho.gateway.core.rabbitmq;

import lombok.Getter;
import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class ProfessorMQ {

    // Aniversariantes Request/Response
    @Value("${spring.mq.professor.aniversariantes-req.exchange}")
    private String aniversariantesReqExchange;
    @Value("${spring.mq.professor.aniversariantes-req.routing-key}")
    private String aniversariantesReqRoutingKey;
    @Value("${spring.mq.professor.aniversariantes-req.queue}")
    private String aniversariantesReqQueue;

    @Value("${spring.mq.professor.aniversariantes-res.exchange}")
    private String aniversariantesResExchange;
    @Value("${spring.mq.professor.aniversariantes-res.routing-key}")
    private String aniversariantesResRoutingKey;
    @Value("${spring.mq.professor.aniversariantes-res.queue}")
    private String aniversariantesResQueue;

    // Horário Request
    @Value("${spring.mq.professor.horario-req.exchange}")
    private String horarioReqExchange;
    @Value("${spring.mq.professor.horario-req.routing-key}")
    private String horarioReqRoutingKey;
    @Value("${spring.mq.professor.horario-req.queue}")
    private String horarioReqQueue;

    // QR Code Request/Response
    @Value("${spring.mq.professor.qrcode-req.exchange}")
    private String qrcodeReqExchange;
    @Value("${spring.mq.professor.qrcode-req.routing-key}")
    private String qrcodeReqRoutingKey;
    @Value("${spring.mq.professor.qrcode-req.queue}")
    private String qrcodeReqQueue;

    @Value("${spring.mq.professor.qrcode-res.exchange}")
    private String qrcodeResExchange;
    @Value("${spring.mq.professor.qrcode-res.routing-key}")
    private String qrcodeResRoutingKey;
    @Value("${spring.mq.professor.qrcode-res.queue}")
    private String qrcodeResQueue;

    @Bean
    public Declarables professorBindings() {
        // Exchange
        DirectExchange professorExchange = new DirectExchange(aniversariantesReqExchange);

        // Queues
        Queue aniversariantesReqQueueBean = new Queue(aniversariantesReqQueue, true);
        Queue aniversariantesResQueueBean = new Queue(aniversariantesResQueue, true);
        Queue horarioReqQueueBean = new Queue(horarioReqQueue, true);
        Queue qrcodeReqQueueBean = new Queue(qrcodeReqQueue, true);
        Queue qrcodeResQueueBean = new Queue(qrcodeResQueue, true);

        // Bindings
        Binding aniversariantesReqBinding = BindingBuilder.bind(aniversariantesReqQueueBean)
                .to(professorExchange).with(aniversariantesReqRoutingKey);
        Binding aniversariantesResBinding = BindingBuilder.bind(aniversariantesResQueueBean)
                .to(professorExchange).with(aniversariantesResRoutingKey);
        Binding horarioReqBinding = BindingBuilder.bind(horarioReqQueueBean)
                .to(professorExchange).with(horarioReqRoutingKey);
        Binding qrcodeReqBinding = BindingBuilder.bind(qrcodeReqQueueBean)
                .to(professorExchange).with(qrcodeReqRoutingKey);
        Binding qrcodeResBinding = BindingBuilder.bind(qrcodeResQueueBean)
                .to(professorExchange).with(qrcodeResRoutingKey);

        return new Declarables(
                professorExchange,
                aniversariantesReqQueueBean,
                aniversariantesResQueueBean,
                horarioReqQueueBean,
                qrcodeReqQueueBean,
                qrcodeResQueueBean,
                aniversariantesReqBinding,
                aniversariantesResBinding,
                horarioReqBinding,
                qrcodeReqBinding,
                qrcodeResBinding
        );
    }

}
