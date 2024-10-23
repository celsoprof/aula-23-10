package br.dev.celso.games.controller;

import br.dev.celso.games.config.security.TokenService;
import br.dev.celso.games.model.User;
import br.dev.celso.games.repository.UserRepository;
import br.dev.celso.games.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody User user) {

        UsernamePasswordAuthenticationToken usernamePassword =
                new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword());

        Authentication authenticate = authenticationManager.authenticate(usernamePassword);

        String token = tokenService.generateToken((User) authenticate.getPrincipal());

        return ResponseEntity.ok().body(authenticate);

    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody User user) {

        return ResponseEntity.ok().body(userService.save(user));

    }



}
