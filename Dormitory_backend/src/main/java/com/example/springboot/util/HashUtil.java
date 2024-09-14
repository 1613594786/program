package com.example.springboot.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

/**
 * @author zzp
 * @create 2024/8/30-11:05
 */
public class HashUtil {
    public static String hashPassword(String password, String salt) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashedPassword = md.digest((salt+password).getBytes());
            return salt+":"+bytesToHex(hashedPassword);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
    public static String generateSalt() {
        return UUID.randomUUID().toString();
    }
    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
    public static boolean checkPassword(String providedPassword, String storedPassword){
        String salt = storedPassword.split(":")[0];
        String confirmPassword = hashPassword(providedPassword, salt);
        System.out.println(confirmPassword);
        return confirmPassword.equals(storedPassword);
    }

}
