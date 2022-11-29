package com.example.auth.service;

import com.example.auth.client.UserClient;
import com.example.auth.model.dto.SignInDto;
import com.example.auth.model.dto.TokenDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final TokenService tokenService;
    private final UserClient userClient;

    public TokenDto signIn(SignInDto signInDto){
        var user = userClient.getUserName(signInDto.getUsername());
        return tokenService.generateToken(user.getId(),50);
    }
}
