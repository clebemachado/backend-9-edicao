package br.com.pessoaapi.criadordesenha;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class CriadorDeSenhas {
    public static void main(String[] args) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String senha = bCryptPasswordEncoder.encode("123");
        System.out.println(senha);
        //$2a$10$fP3fNbhDrkixHZHOqW4zKu9QdYiIWkhxH8NIXWcq7AQiUXAHivZEO
        //$2a$10$vKDL51CqiJohqdB4kgyzLull6PS7MCGcDa9YQEmiLHLca4HUl3KRy
        //$2a$10$fP3fNbhDrkixHZHOqW4zKu9QdYiIWkhxH8NIXWcq7AQiUXAHivZEO

        String minhaSenhaCript = "$2a$10$X.AxPaR2usWOKRyUT2ZX/.k5sdTQNkSUly3AlSibvxImFrNb9ulAu";
        boolean matches = bCryptPasswordEncoder.matches("123", minhaSenhaCript);
        System.out.println(matches);
//        //true ou false
    }
}
