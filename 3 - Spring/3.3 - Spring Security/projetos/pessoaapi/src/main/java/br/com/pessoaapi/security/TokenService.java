package br.com.pessoaapi.security;

import br.com.pessoaapi.entity.UsuarioEntity;
import br.com.pessoaapi.service.UsuarioService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class TokenService {

    private final UsuarioService usuarioService;

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private String expiration;

    private static final String KEY_CARGOS = "roles";

    public String getToken(UsuarioEntity usuarioEntity) {
        Date now = new Date();
        Date exp = new Date(now.getTime() + Long.valueOf(expiration));

        List<String> listaDeCargos = usuarioEntity.getCargos().stream()
                .map(cargoEntity -> cargoEntity.getNome())
                .toList();

        String token = Jwts.builder()
                .setIssuer("pessoa-api")
                .claim(Claims.ID, usuarioEntity.getIdUsuario())
                .claim(KEY_CARGOS, listaDeCargos)
                .setIssuedAt(now)
                .setExpiration(exp)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();

        return TokenAuthenticationFilter.BEARER + token;
    }

    public UsernamePasswordAuthenticationToken isValid(String token) {
        if (token == null) {
            return null;
        }

        Claims body = Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();

        Integer idUsuario = body.get(Claims.ID, Integer.class);
        // consulta no banco

        if (idUsuario != null){
            List<String> cargos = body.get(KEY_CARGOS, List.class);

            List<SimpleGrantedAuthority> cargosGrantedAuthority = cargos.stream()
                    .map(cargo -> new SimpleGrantedAuthority(cargo))
                    .toList();

            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                    new UsernamePasswordAuthenticationToken(idUsuario, null, cargosGrantedAuthority);

            return usernamePasswordAuthenticationToken;
        }
        return null;
    }

}
