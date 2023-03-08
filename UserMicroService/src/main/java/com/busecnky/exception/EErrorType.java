package com.busecnky.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum EErrorType {
    /**
     *
     */

    BAD_REQUEST_ERROR(1201, "Geçersiz Parametre Girişi Yaptınız", BAD_REQUEST),
    AUTH_PASSWORD_ERROR(1301, "Şifreler uyuşmuyor", BAD_REQUEST),
    AUTH_USERNAME_ERROR(1302, "Kullanıcı adı zaten kayıtlıdır.", BAD_REQUEST),
    INTERNAL_ERROR(3000, "Sunucuda beklenmeyen hata", INTERNAL_SERVER_ERROR),
    INVALID_TOKEN(3001, "Geçersiz token", INTERNAL_SERVER_ERROR),
    KULLANICI_BULUNAMADI(2301, "Aradığınız id ye ait kullanıcı bulunamamıştır", INTERNAL_SERVER_ERROR);

    private int code;
    private String message;
    private HttpStatus httpStatus;

}
