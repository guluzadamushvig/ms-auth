package com.example.auth.model.jwt;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
public class AuthCacheData implements Serializable {

    private static final long serialVersionUID = 1L;

    private AccessTokenClaimsSet accessTokenClaimsSet;
    private String publicKey;
}
