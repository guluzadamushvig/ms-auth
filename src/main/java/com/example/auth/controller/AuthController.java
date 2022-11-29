package com.example.auth.controller;


import com.example.auth.model.dto.AuthPayloadDto;
import com.example.auth.model.dto.SignInDto;
import com.example.auth.model.dto.TokenDto;
import com.example.auth.service.AuthService;
import com.example.auth.service.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private TokenService tokenService;
    private final AuthService authService;

//    @PostMapping
//    public TokenDto generateToken(String userId, int refreshTokenExpirationCount){
//        return tokenService.generateToken(userId,refreshTokenExpirationCount);
//    }

    @PostMapping("/v1/generate1")
    public TokenDto generateToken1(SignInDto signInDto){
        return authService.signIn(signInDto);
    }


//    @GetMapping
//    public TokenDto refreshToken(String refreshToken){
//        return tokenService.refreshTokens(refreshToken);
//    }
//
//    @PostMapping
//    public AuthPayloadDto validateToken(String accessToken){
//        return tokenService.validateToken(accessToken);
//    }


}
