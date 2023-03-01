package com.busecnky.controller;

import com.busecnky.dto.request.RegisterRequestDto;
import com.busecnky.exception.AuthException;
import com.busecnky.exception.EErrorType;
import com.busecnky.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static com.busecnky.constants.RestEndPoints.*;
@RestController
@RequestMapping(API+VERSION+AUTH)
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping(REGISTER)
    public ResponseEntity<Boolean> register(@RequestBody @Valid RegisterRequestDto dto){
       if (!dto.getPassword().equals(dto.getRepassword()))
           throw new AuthException(EErrorType.AUTH_PASSWORD_ERROR);

        authService.register(dto);
        return ResponseEntity.ok(true);
    }


}
