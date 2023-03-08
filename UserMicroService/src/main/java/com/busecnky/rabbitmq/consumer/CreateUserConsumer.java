package com.busecnky.rabbitmq.consumer;

import com.busecnky.rabbitmq.model.CreateUser;
import com.busecnky.repository.entity.UserProfile;
import com.busecnky.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateUserConsumer {
    /**
     * Bir servis sürekli olarak belirlenen kuyrukları dinlemeli.
     */

    private final UserProfileService userProfileService;

    @RabbitListener(queues = "queue-auth-create-user")
    public void createUserConsumerListener(CreateUser createUser){
        System.out.println("Gelen mesaj...: " + createUser.toString());
        userProfileService.save(UserProfile.builder()
                        .authid(createUser.getAuthid())
                        .email(createUser.getEmail())
                        .username(createUser.getUsername())
                .build());

    }

}
