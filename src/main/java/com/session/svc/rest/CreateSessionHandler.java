package com.session.svc.rest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import com.session.svc.constants.DBConstants;

public class CreateSessionHandler implements DBConstants {
  public String getQuery() {
    String query =
        "INSERT INTO SESSION_CACHE (SESSION_ID, LOGIN_TIME, USER_NUMBER) VALUES (:SESSION_ID, :LOGIN_TIME, :USER_NUMBER)";

    return query;
  }

  public Map<String, String> paramMap(SessionInfo sessionInfo) throws Exception {
    Map<String, String> map = new HashMap<String, String>();
    // SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    // SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a");
    String sessionId = prepareSessionId(sessionInfo.getSessionId());
    sessionInfo.setSessionId(sessionId);
    map.put("SESSION_ID", sessionId);
    map.put("LOGIN_TIME", sessionInfo.getLoginTime());
    map.put("USER_NUMBER", sessionInfo.getUserNumber());
    System.out.println("ParamMap >>>> " + map);
    return map;
  }

  private String prepareSessionId(String sessionId) {
    return sessionId.substring(0, 32);
  }

  public static void main(String[] args) throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String d = "2016-12-26 01:37:52";
    System.out.println(sdf.parse(d));
    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a");
    System.out.println(sdf2.format(sdf.parse(d)));
  }
}
