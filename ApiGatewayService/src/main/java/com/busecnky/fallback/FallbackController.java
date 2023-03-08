package com.busecnky.fallback;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class FallbackController {

    @GetMapping("/fallbackauth")
    public ResponseEntity<String> fallbackauth(){
        return ResponseEntity.ok("Auth Service geçici bir süre devre dışıdır lütfen daha sonra tekrar deneyiniz!");
    }
    @GetMapping("/fallbackuser")
    public ResponseEntity<String> fallbackuser(){
        return ResponseEntity.ok("User Service geçici bir süre devre dışıdır lütfen daha sonra tekrar deneyiniz!");
    }
    @GetMapping("/fallbacketicaret")
    public ResponseEntity<String> fallbacketicaret(){
        return ResponseEntity.ok("E-ticaret Service geçici bir süre devre dışıdır lütfen daha sonra tekrar deneyiniz!");
    }
    @GetMapping("/fallbackurun")
    public ResponseEntity<String> fallbackurun(){
        return ResponseEntity.ok("Urun Service geçici bir süre devre dışıdır lütfen daha sonra tekrar deneyiniz!");
    }
}
