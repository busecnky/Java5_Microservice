package com.busecnky.mapper;

import com.busecnky.dto.request.UserProfileSaveRequestDto;
import com.busecnky.repository.entity.UserProfile;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IUserProfileMapper {

    IUserProfileMapper INSTANCE = Mappers.getMapper(IUserProfileMapper.class);
    @Mapping(source = "id", target = "userid")
    UserProfile toUserProfile(final UserProfileSaveRequestDto dto);

}