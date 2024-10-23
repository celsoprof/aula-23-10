package br.dev.celso.games.test;

import br.dev.celso.games.config.security.TokenService;

import java.time.Instant;

public class InstantTest {

    public static void main(String[] args) {
        TokenService tokenService = new TokenService();
        Instant i = tokenService.generateExpirationTime();
        System.out.println(i.toString());
    }

}
