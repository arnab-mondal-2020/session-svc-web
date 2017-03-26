package com.session.svc.rest;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;

public class GetSessionHandler implements RowMapper<SessionInfo> {
  public String query() {
    StringBuilder sb = new StringBuilder();
    sb.append("SELECT SESSION_ID, USER_NUMBER, LOGIN_TIME ");
    sb.append("FROM SESSION_CACHE ");
    sb.append("WHERE ");
    sb.append("SESSION_ID = :SESSION_ID");
    System.out.println("GetSession query >> " + sb.toString());
    return sb.toString();
  }
  @Override
  public SessionInfo mapRow(ResultSet rs, int arg1) throws SQLException {
    SessionInfo info = new SessionInfo();
    info.setSessionId(rs.getString("SESSION_ID"));
    info.setUserNumber(rs.getString("USER_NUMBER"));
    info.setLoginTime(rs.getString("LOGIN_TIME"));
    return info;
  }

  public Map<String, Object> getParamMap(String sessionId) {
    Map<String, Object> map = new HashMap<String, Object>();
    map.put("SESSION_ID", sessionId);
    return map;
  }

}
