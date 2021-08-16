package com.desenvolvimento.aplicacoes.corp20212.CryptoGO.api.resource;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/tokens")
@Api(value = "Resource Token")
public class TokenResource {
	
	@DeleteMapping("/revoke")
	@ApiOperation(value = "Endpoint para encenrar sessão do Token")
	public void revoke(HttpServletRequest req, HttpServletResponse res) {
		Cookie cookie = new Cookie("refreshToken", null);
		cookie.setHttpOnly(true);
		cookie.setSecure(false);
		cookie.setPath(req.getContextPath() + "/oauth/token");
		cookie.setMaxAge(0);
		
		
		res.addCookie(cookie);
		res.setStatus(HttpStatus.NO_CONTENT.value());
	}
}
