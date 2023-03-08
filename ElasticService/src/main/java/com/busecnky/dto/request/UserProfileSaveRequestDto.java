package com.busecnky.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserProfileSaveRequestDto {

    //Burdaki long idyi entity deki long userid ye eşlememiz gerekiyor.
    //bunu da mapper da yapıyoruz
    Long id;
    Long authid;

    String username;

    String email;

    String photo;

    String about;

    String phone;

    String age;

    String website;
}
