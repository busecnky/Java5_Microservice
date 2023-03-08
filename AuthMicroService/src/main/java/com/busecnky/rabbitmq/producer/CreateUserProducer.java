package com.busecnky.rabbitmq.producer;

import com.busecnky.rabbitmq.model.CreateUser;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateUserProducer {
    /**
     * Nasıl ki posta göndermek için belli koşullar gerekli(posta pulu,gönderen,alıcı)
     * bunun gibi rabbit ile iletişim içinde bir yapıya ihtiyacınız var.
     */
    private final RabbitTemplate rabbitTemplate;

    public void createSendMessage(CreateUser createUser){
        rabbitTemplate.convertAndSend("exchange-direct-auth","key-auth", createUser);
    }


}
