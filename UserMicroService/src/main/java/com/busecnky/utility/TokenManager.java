package com.busecnky.utility;

import com.busecnky.exception.EErrorType;
import com.busecnky.exception.UserException;
import org.springframework.stereotype.Component;

@Component
public class TokenManager {

    public String createToken(Long id){
        String token = "tkn...:" + id;
        return token;
    }

    public Long getDecodeToken(String token){
        Long id=0L;
        try{
            id=Long.parseLong(token.substring(token.indexOf(":") + 1));
        }catch (Exception exception){
            throw new UserException(EErrorType.INVALID_TOKEN);
        }

        return id;
    }
}
