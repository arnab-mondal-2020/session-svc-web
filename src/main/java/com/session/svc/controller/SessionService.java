package com.session.svc.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.session.svc.constants.SessionServiceConstants;
import com.session.svc.exception.ErrorMessage;
import com.session.svc.exception.ExceptionHandlerInterface;
import com.session.svc.exception.SessionRESTException;
import com.session.svc.rest.SessionBO;
import com.session.svc.rest.SessionInfo;
import com.session.svc.security.AuthenticationUtil;

@RestController
public class SessionService implements SessionServiceConstants {
  @Autowired
  private SessionBO sessionBO;
  @Autowired
  private ExceptionHandlerInterface exceptionHandlerInterface;

  /**
   *
   * @param sessionInfo
   * @param request
   * @return
   * @throws SessionRESTException
   */
  @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public SessionInfo createSession(@RequestBody SessionInfo sessionInfo, HttpServletRequest request)
      throws SessionRESTException {
    SessionInfo response = new SessionInfo();
    String sessionId = sessionBO.createSession(sessionInfo);
    response.setSessionId(sessionId);

    return response;
  }

  /**
   *
   * @param sessionInfo
   * @param request
   * @return
   * @throws SessionRESTException
   */
  @RequestMapping(value = "/get", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<SessionInfo> getSession(@RequestBody SessionInfo sessionInfo, HttpServletRequest request)
      throws SessionRESTException {
    try {
      if (!AuthenticationUtil.authenticate(request)) {
        throw new SessionRESTException("Token Authentication Failed");
      }
    } catch (JSONException e) {
      throw new SessionRESTException("Token Authentication Failed", e);
    }
    String sessionId = sessionInfo.getSessionId();
    sessionInfo = sessionBO.getSession(sessionId);
    return new ResponseEntity<SessionInfo>(sessionInfo, HttpStatus.OK);
  }

  /**
   *
   * @param sessionInfo
   * @return
   * @throws SessionRESTException
   */
  public ResponseEntity<SessionInfo> updateSession(SessionInfo sessionInfo) throws SessionRESTException {
    return null;
  }

  /**
   *
   * @param sessionInfo
   * @param request
   * @throws SessionRESTException
   */
  @RequestMapping(value = "/delete", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
  public void deleteSession(@RequestBody SessionInfo sessionInfo, HttpServletRequest request)
      throws SessionRESTException {
    try {
      if (!AuthenticationUtil.authenticate(request)) {
        throw new SessionRESTException("Token Authentication Failed");
      }
    } catch (JSONException e) {
      throw new SessionRESTException("Token Authentication Failed", e);
    }
    String sessionId = sessionInfo.getSessionId();
    sessionBO.deleteSession(sessionId);
  }

  @ExceptionHandler
  public ErrorMessage handleException(Exception e) {
    ErrorMessage message = new ErrorMessage();
    message.setExceptionId(exceptionHandlerInterface.getId(e));
    message.setExceptionMessage(e.getMessage());
    message.setType(e.getClass().getName());
    message.setTime(new Date().toString());
    return message;
  }
}
