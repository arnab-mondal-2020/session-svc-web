package com.session.svc.rest;

import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Arnab
 *
 */
@RestController
public class SessionRESTController {
  /**
   *
   * @param sessionInfo
   * @return
   */
  public String createSession(SessionInfo sessionInfo) {
    return null;
  }

  /**
   *
   * @param sessionId
   * @return
   */
  public SessionInfo getSession(String sessionId) {
    return null;
  }

  /**
   *
   * @param sessionInfo
   * @return
   */
  public SessionInfo updateSession(SessionInfo sessionInfo) {
    return null;
  }

  /**
   *
   * @param sessionId
   */
  public void deleteSession(String sessionId) {

  }
}
