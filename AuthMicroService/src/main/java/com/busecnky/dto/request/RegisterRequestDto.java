package com.busecnky.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequestDto {
    @NotNull(message = "Kullanıcı adı girilmesi zorunludur.")
    @Size(min = 3,max = 18)
    String username;
    @NotNull(message = "Şifre girilmesi zorunludur.")
    @Size(min = 3,max = 64)
    String password;

    String repassword;
    @NotNull(message = "Lütfen geçerli bir email adresi giriniz.")
    String email;

}
