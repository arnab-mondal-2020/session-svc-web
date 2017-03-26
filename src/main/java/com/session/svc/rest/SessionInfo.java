package com.session.svc.rest;

import java.io.Serializable;

public class SessionInfo implements Serializable {
  private static final long serialVersionUID = 1L;
  private String sessionId;
  private String userNumber;
  private String loginTime;
  //	private SessionFault fault;

  public String getSessionId() {
    return sessionId;
  }

  public void setSessionId(String sessionId) {
    this.sessionId = sessionId;
  }

  public String getUserNumber() {
    return userNumber;
  }

  public void setUserNumber(String userNumber) {
    this.userNumber = userNumber;
  }

  public String getLoginTime() {
    return loginTime;
  }

  public void setLoginTime(String loginTime) {
    this.loginTime = loginTime;
  }

  /*public SessionFault getFault() {
		return fault;
	}

	public void setFault(SessionFault fault) {
		this.fault = fault;
	}*/
}
