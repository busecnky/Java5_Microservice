package com.busecnky.controller;

import com.busecnky.dto.request.RegisterRequestDto;
import com.busecnky.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.busecnky.constants.RestEndPoints.*;
@RestController
@RequestMapping(API+VERSION+AUTH)
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping(REGISTER)
    public ResponseEntity<Boolean> register(RegisterRequestDto dto){
        /**
         * Burda register olmaz authservice te işlemlerimizi
         * yapıyoruz hatırlatma
         */
        authService.register(dto);
        return ResponseEntity.ok(true);
    }


}
