package com.busecnky.service;

import com.busecnky.dto.request.RegisterRequestDto;
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
        repository.save(IAuthMapper.INSTANCE.fromRegisterDto(dto));
        return true;
    }

}
