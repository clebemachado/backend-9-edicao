package br.com.pessoaapi.controller;

import br.com.pessoaapi.dto.LoginDTO;
import br.com.pessoaapi.entity.UsuarioEntity;
import br.com.pessoaapi.exception.RegraDeNegocioException;
import br.com.pessoaapi.security.TokenService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
@Validated
@RequiredArgsConstructor
@Slf4j
public class AuthController {
    private final TokenService tokenService;
    private final AuthenticationManager authenticationManager;

    @PostMapping
    public String auth(@RequestBody @Valid LoginDTO login) throws RegraDeNegocioException {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(
                        login.getLogin(),
                        login.getSenha()
                );

        try {
            Authentication authentication = authenticationManager
                    .authenticate(usernamePasswordAuthenticationToken);
            log.info("Autenticado com sucesso!");
            Object usuarioLogado = authentication.getPrincipal();
            UsuarioEntity usuarioEntity = (UsuarioEntity) usuarioLogado;


            String token = tokenService.getToken(usuarioEntity);
            return token;
        } catch (Exception ex){
            throw new RegraDeNegocioException(ex.getMessage());
        }
    }
}
