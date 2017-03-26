package com.session.svc.util;

import org.springframework.util.DigestUtils;

public final class EncryptionUtil {
  private EncryptionUtil() {}

  public static String generateSalt(String id) {
    String salt = md5Hex(id);
    return salt;
  }

  public static String encrypt(String toEncrypt, String salt) {
    String encrypted = md5Hex(toEncrypt + salt);
    return encrypted;
  }

  public static String encrypt(String toEncrypt) {
    String encrypted = md5Hex(toEncrypt);
    return encrypted;
  }

  private static String md5Hex(String password) {
    String enryptedPassword = DigestUtils.md5DigestAsHex(password.getBytes());
    return enryptedPassword;
  }

  public static void main(String[] args) {
    System.out.println(encrypt("12345"));
  }
}
