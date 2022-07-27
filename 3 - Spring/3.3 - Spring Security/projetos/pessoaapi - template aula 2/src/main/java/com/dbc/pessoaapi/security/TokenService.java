package com.dbc.pessoaapi.security;

import com.dbc.pessoaapi.entity.UsuarioEntity;
import com.dbc.pessoaapi.service.UsuarioService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TokenService {

    // FIXME RECUPERAR O TEMPO DE EXPIRAÇÃO DOS PROPERTIES
    private String expiration;

    // FIXME RECUPERAR A CHAVE SECRETA DOS PROPERTIES
    private String secret;

    public String generateToken(UsuarioEntity usuarioEntity) {
        // FIXME gerar token jwt
        return null;
    }

    public UsernamePasswordAuthenticationToken isValid(String token) {
        // FIXME verificar se o usuário é válido pelo token JWT e recuperar o usuário e retornar
        return null;
    }
}
