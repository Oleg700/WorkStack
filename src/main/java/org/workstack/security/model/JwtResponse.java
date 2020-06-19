package org.workstack.security.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class JwtResponse {
    private String jwtToken;
}
