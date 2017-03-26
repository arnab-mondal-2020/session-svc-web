package com.session.svc.init;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.session.svc")
public class SessionSvcWebApplication {

  public static void main(String[] args) {
    SpringApplication.run(SessionSvcWebApplication.class, args);
  }
}
