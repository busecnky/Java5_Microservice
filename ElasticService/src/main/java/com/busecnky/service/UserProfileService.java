package com.busecnky.service;

import com.busecnky.dto.request.UserProfileSaveRequestDto;
import com.busecnky.mapper.IUserProfileMapper;
import com.busecnky.repository.IUserProfileRepository;
import com.busecnky.repository.entity.UserProfile;
import com.busecnky.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class UserProfileService extends ServiceManager<UserProfile,String> {

    private final IUserProfileRepository repository;

    public UserProfileService(IUserProfileRepository repository) {
        super(repository);
        this.repository = repository;
    }


    public void saveDto(UserProfileSaveRequestDto dto) {
        repository.save(IUserProfileMapper.INSTANCE.toUserProfile(dto));
    }
}
