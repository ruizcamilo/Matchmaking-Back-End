//Powered by: https://github.com/awaters1
package com.atomiclab.socialgamerbackend.security.model;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class FirebaseAuthenticationToken extends UsernamePasswordAuthenticationToken {
	private static final long serialVersionUID = 1L;
	private final String token;

	public FirebaseAuthenticationToken(final String token) {
		super(null, null);
		this.token = token;
	}
	public String getToken() {
		return token;
	}
}
