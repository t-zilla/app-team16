package com.psi.resource;

import com.psi.security.dto.AuthRequestDto;
import com.psi.security.dto.AuthResponseDto;
import com.psi.security.dto.JwtAuthResponseDto;
import com.psi.security.dto.ValidateRequestDto;
import com.psi.security.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static java.text.MessageFormat.format;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthResource implements RestResource{

    private final AuthService authService;

    @PostMapping("/generate-token")
    public JwtAuthResponseDto generateToken(@RequestBody AuthRequestDto authRequestDto) {
        log.info(format("Request for JWT Token: {0}", authRequestDto));

        return authService.generateToken(authRequestDto);
    }

    @PostMapping("/validate-token")
    public AuthResponseDto validateToken(@RequestBody ValidateRequestDto validateToken) {
        log.info(format("Request for JWT Token validation: {0}", validateToken));

        return authService.validateToken(validateToken);
    }
}
