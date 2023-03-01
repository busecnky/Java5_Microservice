package com.busecnky.service;

import com.busecnky.dto.request.RegisterRequestDto;
import com.busecnky.exception.AuthException;
import com.busecnky.exception.EErrorType;
import com.busecnky.mapper.IAuthMapper;
import com.busecnky.repository.IAuthRepository;
import com.busecnky.repository.entity.Auth;
import com.busecnky.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class AuthService extends ServiceManager<Auth,Long> {

    private final IAuthRepository  repository;
    public AuthService(IAuthRepository repository){
        super(repository);
        this.repository=repository;
    }

    public boolean register(RegisterRequestDto dto){
        if(repository.isUsername(dto.getUsername()))
            throw new AuthException(EErrorType.AUTH_USERNAME_ERROR);
        save(IAuthMapper.INSTANCE.fromRegisterDto(dto));
        return true;
    }

}
