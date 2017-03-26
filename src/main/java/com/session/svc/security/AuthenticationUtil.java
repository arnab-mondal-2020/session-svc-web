package com.session.svc.security;

import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONException;

public final class AuthenticationUtil {
  public static String generateJWT() throws JSONException, NoSuchAlgorithmException {
    String jwt = "BPService";

    System.out.println("JWT: " + jwt);
    return jwt;

  }

  public static boolean authenticate(HttpServletRequest request) throws JSONException {
    /*String jsonToken = request.getHeader(X_BP_JWT);
    boolean isValid = jsonToken != null && jsonToken.equals("BPService");
    return isValid ? isValid : !isValid;*/
    return true;
  }

}
