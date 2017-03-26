package com.session.svc.rest;

import com.session.svc.exception.SessionRESTException;

public interface SessionDAO {

  public String createSession(SessionInfo sessionInfo) throws SessionRESTException;

  public SessionInfo getSession(String sessionId) throws SessionRESTException;

  public SessionInfo updateSession(SessionInfo sessionInfo) throws SessionRESTException;

  public void deleteSession(String sessionId) throws SessionRESTException;
}
