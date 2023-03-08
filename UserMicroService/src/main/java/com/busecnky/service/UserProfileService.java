package com.busecnky.service;

import com.busecnky.dto.request.UserSaveRequestDto;
import com.busecnky.exception.EErrorType;
import com.busecnky.exception.UserException;
import com.busecnky.mapper.IUserProfileMapper;
import com.busecnky.repository.IUserProfileRepository;
import com.busecnky.repository.entity.UserProfile;
import com.busecnky.utility.JwtTokenManager;
import com.busecnky.utility.ServiceManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserProfileService extends ServiceManager<UserProfile,Long> {

    private final IUserProfileRepository repository;
    private final JwtTokenManager jwtTokenManager;

    public UserProfileService(IUserProfileRepository repository, JwtTokenManager jwtTokenManager){
        super(repository);
        this.repository = repository;
        this.jwtTokenManager = jwtTokenManager;
    }


    public Boolean saveDto(UserSaveRequestDto dto) {
        save(IUserProfileMapper.INSTANCE.toUserProfile(dto));
        return true;
    }

    public List<UserProfile> findAll(String token){
        Optional<Long> authid = jwtTokenManager.getIdFromToken(token);
        if (authid.isEmpty())
            throw new UserException(EErrorType.INVALID_TOKEN);

        Optional<UserProfile> userProfile = repository.findOptionalByAuthid(authid.get());
        if(userProfile.isEmpty())
            throw new UserException(EErrorType.INVALID_TOKEN, "Token için gönderilen kullanıcı sistemde kayıtlı değildir");
        return findAll();

    }
    @Cacheable(value = "getUpperName")
    public String getUpperName(String name){
        try {
            Thread.sleep(3000);
        }catch (Exception e){

        }
        return name.toUpperCase();
    }

    //Oluşturlan cache leri silmek temizkemek için:
    @CacheEvict
    public void clearCache(){
        System.out.println("Tüm cache temizlendi");
    }
}
