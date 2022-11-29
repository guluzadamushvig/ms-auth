package com.example.auth.client;

import com.example.auth.model.client.UserGetDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "ms-user",url = "http://localhost:8086")
public interface UserClient {
    @GetMapping ("v1/user")
    public UserGetDto getUserName(@RequestParam String username);
}
