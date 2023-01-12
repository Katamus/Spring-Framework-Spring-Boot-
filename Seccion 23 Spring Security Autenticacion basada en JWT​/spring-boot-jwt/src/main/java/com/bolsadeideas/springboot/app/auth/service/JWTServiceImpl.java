package com.bolsadeideas.springboot.app.auth.service;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import com.bolsadeideas.springboot.app.auth.SimpleGrantedAutorityMixin;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JWTServiceImpl implements JWTService {
	
	
	public static final String SECRET = "alguna.clave.secreta.clave.secreta.clave.secreta.clave.secreta.clave.secreta";
	
	public static final long EXPIRATION_DATE = 14000000L;
	
	public static final String TOKEM_PREFIX = "Bearer ";
	
	public static final String HEADER_STRING = "Authorization";
	

	@Override
	public String create(Authentication authResult	) throws JsonProcessingException {
		
		String username = ((User) authResult.getPrincipal()).getUsername();
		Collection<? extends GrantedAuthority> roles = authResult.getAuthorities();
		Claims claims = Jwts.claims();
		claims.put("authorities", new ObjectMapper().writeValueAsString(roles));
		String token =Jwts.builder()
				.setClaims(claims)
				.setSubject(username)
				.signWith(SignatureAlgorithm.HS512,SECRET.getBytes())
				.setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis()+EXPIRATION_DATE))
				.compact();
		
		return token;
	}

	@Override
	public boolean validate(String token) {
		try{
			getClaims(token);
			return true;
		} catch (JwtException | IllegalArgumentException e) {
			return false;
		}
	}

	@Override
	public Claims getClaims(String token) {
		return Jwts.parser()
				.setSigningKey(SECRET.getBytes())
				.parseClaimsJws(resolve(token)).getBody();
	}

	@Override
	public String getUsername(String token) {
		return getClaims(token).getSubject();
	}

	@Override
	public Collection<? extends GrantedAuthority> getRoles(String token) throws IOException {
		Object roles = getClaims(token).get("authorities");
		
		Collection<? extends GrantedAuthority> authorities = Arrays.asList(new ObjectMapper()
				.addMixIn(SimpleGrantedAuthority.class, SimpleGrantedAutorityMixin.class)
				.readValue(roles.toString().getBytes(), SimpleGrantedAuthority[].class));
		
		return authorities;
	}

	@Override
	public String resolve(String token) {
		if(token != null && token.startsWith(TOKEM_PREFIX)) {
			return token.replace(TOKEM_PREFIX, "");
		}
		return null;
	}

}
