package com.session.svc.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.session.svc.exception.SessionRESTException;

@Component
public class SessionBO {
  @Autowired
  private SessionDAO sessionDAO;

  public String createSession(SessionInfo sessionInfo) throws SessionRESTException {
    return sessionDAO.createSession(sessionInfo);
  }


  public SessionInfo getSession(String sessionId) throws SessionRESTException {
    return sessionDAO.getSession(sessionId);
  }


  public SessionInfo updateSession(SessionInfo sessionInfo) throws SessionRESTException {
    return sessionDAO.updateSession(sessionInfo);
  }


  public void deleteSession(String sessionId) throws SessionRESTException {
    sessionDAO.deleteSession(sessionId);
  }
}
