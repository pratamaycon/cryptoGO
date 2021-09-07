package com.desenvolvimento.aplicacoes.corp20212.CryptoGO.core.security;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import com.desenvolvimento.aplicacoes.corp20212.CryptoGO.core.security.token.CustomTokenEnhancer;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

	@Autowired
    @Qualifier("authenticationManagerBean")
    private AuthenticationManager authenticationManager;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.inMemory()
				.withClient("crypto")
				.secret(passwordEncoder.encode("crpt0G0"))
				.scopes("all")
				.authorizedGrantTypes("password", "authorization_code", "refresh_token")
				.accessTokenValiditySeconds(60*10*6)
				.refreshTokenValiditySeconds(24 * 3600);
	}
	
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
		tokenEnhancerChain.setTokenEnhancers(Arrays.asList(tokenEnhancer(), accessTokenConverter()));
		
		endpoints
			.tokenStore(tokenStore())
			.tokenEnhancer(tokenEnhancerChain)
			.reuseRefreshTokens(false)
			.accessTokenConverter(this.accessTokenConverter())
			.authenticationManager(this.authenticationManager);
	}
	
	@Bean
	public JwtAccessTokenConverter accessTokenConverter() {
		JwtAccessTokenConverter accessTokenConverter = new JwtAccessTokenConverter();
		accessTokenConverter.setSigningKey("cryptoGO");
		return accessTokenConverter;
	}

	@Bean
	public TokenStore tokenStore() {
		return new JwtTokenStore(this.accessTokenConverter());
	}
	
	@Bean
	public TokenEnhancer tokenEnhancer() {
		return new CustomTokenEnhancer();
	}
	
}
