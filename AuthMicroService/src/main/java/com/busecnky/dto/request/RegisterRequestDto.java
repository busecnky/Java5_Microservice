package com.busecnky.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
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
    @Size(min = 8,max = 64)
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=*!])(?=\\S+$).{8,}$",
            message = "Şifre en az 8 Karakter, Enaz bir büyük bir küçük harf, Sayı ve özel karakterden oluşmalıdır.")
    String password;
    @NotNull(message = "Şifre boş geçilemez.")
    @Size(min = 8, max = 64)
    String repassword;
    @NotNull(message = "Lütfen geçerli bir email adresi giriniz.")
    String email;

}
