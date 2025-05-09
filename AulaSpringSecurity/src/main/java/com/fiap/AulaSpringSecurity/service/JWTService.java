package com.fiap.AulaSpringSecurity.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

@Service
public class JWTService {

    //Chave sercreta para assinar o token(em producao, deve ser guardada em um ambiente seguro)
    //Esta é uma chave HMAC-SHA 256bits codificada em Base64
    private static final String FINAL_KEY = "404E635266556A586E3272357538782F413F4428472B4B6250645367566B5970";

    //Metodo para extrair o username(email) do token JWT
    public String extractUsername(String token) {
        //extrair o subject(username) do token usando a funcao Claims: getSubject,000
        //Token no formato Bearer
        //Token JWT --> junção de 3 partes: Header/Payload/Signature
        //No payload que é um objeto JSON é onde contém as CLAIMS(informações do token)
        //CLAIMS -- pode conter entidade a quem o token pertence
        //Emissor do token
        //Timestamp do token
        return extractClaim(token, Claims::getSubject);

    }

    //Metodo genérico para extrair qualquer claim do token JWT
    public <T> T extractClaim(String token, Function<Claims,T> claimsResolver){
        //extrai todos os claims do token
        final Claims claims = extractAllClaims(token);
        //aplica a função claimsResolver para extrair o claim específico
        return claimsResolver.apply(claims);
    }

    //Metodo para gerar token JWT apenas com o UserDetails(sem claims extras)
    public String generateToken(UserDetails userDetails) {
        //chama o método generateToken com um mapa vazio de claims extras
        return generateToken(new HashMap<>(), userDetails);
    }

    //Método para gerar token JWT com claims extras
    public String generateToken(
            Map<String, Object> extraClaims, //Claims customizadas para incluir no token
            UserDetails userDetails //detalhes do usuário para incluir no token
    ) {
        //Construir o token JWT usando o builder o JWTs
        return Jwts
                .builder() // Inicia a construção do token
                .setClaims(extraClaims) // Define os claims customizados
                .setSubject(userDetails.getUsername()) // Define o subject (normalmente o email)
                .setIssuedAt(new Date(System.currentTimeMillis())) // Define data de criação
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24)) // Expira em 24 horas
                .signWith(getSignInKey(), SignatureAlgorithm.HS256) // Assina com a chave secreta usando HS256
                .compact(); // Finaliza e retorna o token como String
    }
}
