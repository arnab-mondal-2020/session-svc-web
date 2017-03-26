package com.session.svc.rest;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class SessionCookie extends Cookie {

  private static final long serialVersionUID = 1L;
  private static final String SESSION_ID_COOKIE_NAME = "sessionCookie";

  private SessionCookie(String name, String value) {
    super(name, value);
  }

  public SessionCookie(String sessionId) {
    this(SESSION_ID_COOKIE_NAME, sessionId);
  }

  public static String getSessionId(HttpServletRequest request) {
    Cookie cookie = getSessionCookie(request);
    return cookie != null ? cookie.getValue() : null;
  }

  public static Cookie getSessionCookie(HttpServletRequest request) {
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
      for (Cookie cookie : cookies) {
        System.err.println("Cookie name : " + cookie.getName() + " value : " + cookie.getValue());
        if (SESSION_ID_COOKIE_NAME.equals(cookie.getName())) {
          return cookie;
        }
      }
    }
    return null;
  }
}
