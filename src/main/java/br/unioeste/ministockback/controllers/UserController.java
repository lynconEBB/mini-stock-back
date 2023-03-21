package br.unioeste.ministockback.controllers;

import br.unioeste.ministockback.models.dtos.AuthenticationRequest;
import br.unioeste.ministockback.models.dtos.AuthenticationResponse;
import br.unioeste.ministockback.models.dtos.RegisterRequest;
import br.unioeste.ministockback.models.entities.*;
import br.unioeste.ministockback.repositories.UserRepository;
import br.unioeste.ministockback.serivces.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request) {
        User user = User.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(request.getRole())
                .build();

        userRepository.save(user);

        String jwt = jwtService.generateToken(user);
        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

        User user = userRepository.findByUsername(request.getUsername()).orElseThrow();

        String jwt = jwtService.generateToken(user);
        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }
}
