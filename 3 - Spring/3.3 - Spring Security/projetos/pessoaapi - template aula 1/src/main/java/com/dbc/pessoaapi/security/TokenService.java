package com.dbc.pessoaapi.security;

import com.dbc.pessoaapi.entity.UsuarioEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TokenService {

    public String getToken(UsuarioEntity usuarioEntity) {
        // FIXME por meio do usuário, gerar um token
        return null;
    }

    public Optional<UsuarioEntity> isValid(String token) {
        // FIXME validar se o token é válido e retornar o usuário se for válido
        return Optional.empty();
    }
}
