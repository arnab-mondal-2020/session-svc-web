package com.session.svc.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.session.svc.exception.SessionRESTException;

@Component
public class SessionDAOImpl implements SessionDAO {
  @Autowired
  private NamedParameterJdbcTemplate template;

  @Override
  public String createSession(SessionInfo sessionInfo) throws SessionRESTException {
    CreateSessionHandler handler = new CreateSessionHandler();
    try {
      template.update(handler.getQuery(), handler.paramMap(sessionInfo));
    } catch (DataAccessException e) {
      throw new SessionRESTException(e);
    } catch (Exception e) {
      throw new SessionRESTException(e);
    }
    return sessionInfo.getSessionId();
  }

  @Override
  public SessionInfo getSession(String sessionId) throws SessionRESTException {
    GetSessionHandler handler = new GetSessionHandler();
    try {
      List<SessionInfo> records =
          template.query(handler.query(), handler.getParamMap(sessionId), handler);
      if (records == null || records.isEmpty()) {
        throw new SessionRESTException("SESSION_INVALID");
      }
      return records.get(0);
    } catch (DataAccessException e) {
      throw new SessionRESTException(e.getMessage());
    } catch (Exception e) {
      throw new SessionRESTException(e.getMessage());
    }
  }

  @Override
  public SessionInfo updateSession(SessionInfo sessionInfo) throws SessionRESTException {
    return null;
  }

  @Override
  public void deleteSession(String sessionId) throws SessionRESTException {
    DeleteSessionHandler handler = new DeleteSessionHandler();
    try {
      template.update(handler.query(), handler.getParamMap(sessionId));
    } catch (DataAccessException e) {
      throw new SessionRESTException(e);
    } catch (Exception e) {
      throw new SessionRESTException(e);
    }
  }

}
