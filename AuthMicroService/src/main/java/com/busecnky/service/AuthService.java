package com.busecnky.service;

import com.busecnky.dto.request.DoLoginRequestDto;
import com.busecnky.dto.request.RegisterRequestDto;
import com.busecnky.dto.request.UserSaveRequestDto;
import com.busecnky.exception.AuthException;
import com.busecnky.exception.EErrorType;
import com.busecnky.manager.IUserProfileManager;
import com.busecnky.mapper.IAuthMapper;
import com.busecnky.rabbitmq.model.CreateUser;
import com.busecnky.rabbitmq.producer.CreateUserProducer;
import com.busecnky.repository.IAuthRepository;
import com.busecnky.repository.entity.Auth;
import com.busecnky.utility.JwtTokenManager;
import com.busecnky.utility.ServiceManager;
import com.busecnky.utility.TokenManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService extends ServiceManager<Auth,Long> {

    private final IAuthRepository  repository;
    private final IUserProfileManager userProfileManager;
    private final CreateUserProducer createUserProducer;
    @Autowired
    private TokenManager tokenManager;
    @Autowired
    private JwtTokenManager jwtTokenManager;
    public AuthService(IAuthRepository repository, IUserProfileManager userProfileManager, CreateUserProducer createUserProducer){
        super(repository);
        this.repository=repository;
        this.userProfileManager = userProfileManager;

        this.createUserProducer = createUserProducer;
    }

    public boolean register(RegisterRequestDto dto){
        if(repository.isUsername(dto.getUsername()))
            throw new AuthException(EErrorType.AUTH_USERNAME_ERROR);
        Auth auth = save(IAuthMapper.INSTANCE.fromRegisterDto(dto));
        /*userProfileManager.save(UserSaveRequestDto.builder()
                        .authid(auth.getId())
                        .email(auth.getEmail())
                        .username(auth.getUsername())
                        .build());*/
        createUserProducer.createSendMessage(CreateUser.builder()
                        .authid(auth.getId())
                        .email(auth.getEmail())
                        .username(auth.getUsername())
                .build());
        return true;
    }

    public String doLogin(DoLoginRequestDto dto){
        Optional<Auth> auth = repository.findOptionalByUsernameAndPassword(dto.getUsername(), dto.getPassword());
        if (auth.isEmpty())
            throw new AuthException(EErrorType.AUTH_LOGIN_ERROR);

        Optional<String> token = jwtTokenManager.createToken(auth.get().getId());
        if (token.isEmpty())
            throw new AuthException(EErrorType.TOKEN_ERROR);

        return token.get();

    }

}
