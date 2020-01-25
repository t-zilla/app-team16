package com.psi.security.service;

import com.psi.security.dto.AuthRequestDto;
import com.psi.security.dto.AuthResponseDto;
import com.psi.security.dto.JwtAuthResponseDto;
import com.psi.security.dto.ValidateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import static java.text.MessageFormat.format;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenService jwtTokenService;

    public JwtAuthResponseDto generateToken(AuthRequestDto authRequestDto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authRequestDto.getUsername(),
                        authRequestDto.getPassword()));

        return new JwtAuthResponseDto(jwtTokenService.generateToken(authentication));
    }

    public AuthResponseDto validateToken(ValidateRequestDto validateRequestDto) {
        String jwt = validateRequestDto.getToken();
        if (StringUtils.hasText(jwt) && jwtTokenService.validateToken(jwt)) {
            String username = jwtTokenService.getUsernameFromJWT(jwt);
            return new AuthResponseDto(Boolean.TRUE, format("Valid token for username: {0}", username));
        } else {
            return new AuthResponseDto(false, "Invalid token");
        }
    }
}
