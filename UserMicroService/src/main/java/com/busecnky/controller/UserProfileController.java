package com.busecnky.controller;


import com.busecnky.dto.request.BaseRequestDto;
import com.busecnky.dto.request.UserSaveRequestDto;
import com.busecnky.repository.entity.UserProfile;
import com.busecnky.service.UserProfileService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

import static com.busecnky.constants.RestEndPoints.*;

@RestController
@RequestMapping(API+VERSION+USER)
@RequiredArgsConstructor
public class UserProfileController {

    private final UserProfileService userProfileService;
    @PostMapping(SAVE)
    public ResponseEntity<Boolean> save(@RequestBody UserSaveRequestDto dto){
        return ResponseEntity.ok(userProfileService.saveDto(dto));
    }
    @GetMapping(FINDALL)
    public ResponseEntity<List<UserProfile>> getAll(@Valid BaseRequestDto dto){
        return ResponseEntity.ok(userProfileService.findAll(dto.getToken()));
    }
    @GetMapping("/getname")
    public ResponseEntity<String> getUpperCaseName(String name){
        return ResponseEntity.ok(userProfileService.getUpperName(name));
    }

    @GetMapping("/clearcache")
    public ResponseEntity<Void> clearCache(String name){
        userProfileService.clearCache();
        return ResponseEntity.ok().build();

    }
}
