package com.busecnky.mapper;

import com.busecnky.dto.request.UserProfileSaveRequestDto;
import com.busecnky.repository.entity.UserProfile;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-08T16:55:04+0300",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.1.jar, environment: Java 17.0.5 (Oracle Corporation)"
)
@Component
public class IUserProfileMapperImpl implements IUserProfileMapper {

    @Override
    public UserProfile toUserProfile(UserProfileSaveRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        UserProfile.UserProfileBuilder<?, ?> userProfile = UserProfile.builder();

        userProfile.userid( dto.getId() );
        if ( dto.getId() != null ) {
            userProfile.id( String.valueOf( dto.getId() ) );
        }
        userProfile.authid( dto.getAuthid() );
        userProfile.username( dto.getUsername() );
        userProfile.email( dto.getEmail() );
        userProfile.photo( dto.getPhoto() );
        userProfile.about( dto.getAbout() );
        userProfile.phone( dto.getPhone() );
        userProfile.age( dto.getAge() );
        userProfile.website( dto.getWebsite() );

        return userProfile.build();
    }
}
