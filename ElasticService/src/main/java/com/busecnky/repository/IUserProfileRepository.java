package com.busecnky.repository;

import com.busecnky.repository.entity.UserProfile;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface IUserProfileRepository extends ElasticsearchRepository<UserProfile,String> {


}
