package com.session.svc.exception;

public class SessionRESTException extends Exception {
  private static final long serialVersionUID = 1L;

  public SessionRESTException(){
    super();
  }
  public SessionRESTException(String message){
    super(message);
  }
  public SessionRESTException(Throwable cause){
    super(cause);
  }
  public SessionRESTException(String message, Throwable cause){
    super(message, cause);
  }
}
