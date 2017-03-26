package com.session.svc.rest;

import java.io.Serializable;

public class SessionFault implements Serializable {
  private static final long serialVersionUID = 1L;
  private String faultType;
  private String faultDesc;
  private String faultTime;
  private String faultCode;

  public String getFaultType() {
    return faultType;
  }
  public void setFaultType(String faultType) {
    this.faultType = faultType;
  }
  public String getFaultDesc() {
    return faultDesc;
  }
  public void setFaultDesc(String faultDesc) {
    this.faultDesc = faultDesc;
  }
  public String getFaultTime() {
    return faultTime;
  }
  public void setFaultTime(String faultTime) {
    this.faultTime = faultTime;
  }
  public String getFaultCode() {
    return faultCode;
  }
  public void setFaultCode(String faultCode) {
    this.faultCode = faultCode;
  }
}
