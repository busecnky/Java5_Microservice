package com.busecnky.manager;

import com.busecnky.dto.request.UserSaveRequestDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static com.busecnky.constants.RestEndPoints.SAVE;

/**
 * name => unique olmalıdır. Kopyala yapışştır yaparken insanlar unutuyorlar
 * ve isimleri aynı kullanıyorlar bu nedenle doğru çalışmıyor
 */
@FeignClient(
        name = "user-profile-service-feign",
        url = "http://localhost:9093/api/v1/user",
        decode404 = true
)
public interface IUserProfileManager {


    @PostMapping(SAVE)
    ResponseEntity<Boolean> save(@RequestBody UserSaveRequestDto dto);


}
