package com.session.svc.init;

public interface InitializationConstants {
  String UTF_ENCODING = "UTF-8";
  String DISPATCHER = "DispatcherServlet";

  String DB_USER = "${spring.datasource.username}";
  String DB_PASSWORD = "${spring.datasource.password}";
  String DB_URL = "${spring.datasource.url}";
}
