package com.busecnky.controller;

import com.busecnky.dto.request.UserProfileSaveRequestDto;
import com.busecnky.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.busecnky.constants.RestEndPoints.*;

@RestController
@RequiredArgsConstructor
@RequestMapping
public class UserProfileController {

    private final UserProfileService userProfileService;

    @PostMapping(SAVE)
    private ResponseEntity<Void> save(@RequestBody UserProfileSaveRequestDto dto){
        userProfileService.saveDto(dto);
        return ResponseEntity.ok().build();
    }
}
