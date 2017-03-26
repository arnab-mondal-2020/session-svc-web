package com.session.svc.rest;

import java.util.HashMap;
import java.util.Map;

public class DeleteSessionHandler {
  public String query() {
    StringBuilder sb = new StringBuilder();
    sb.append("DELETE ");
    sb.append("FROM SESSION_CACHE ");
    sb.append("WHERE ");
    sb.append("SESSION_ID = :SESSION_ID");
    System.out.println("DeleteSession query >> " + sb.toString());
    return sb.toString();
  }

  public Map<String, Object> getParamMap(String sessionId) {
    Map<String, Object> map = new HashMap<String, Object>();
    map.put("SESSION_ID", sessionId);
    return map;
  }
}
