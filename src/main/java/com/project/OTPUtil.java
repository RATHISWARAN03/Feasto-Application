package com.project;

public class OTPUtil {
    public static String generateOtp() {
        return String.valueOf(100000 + (int) (Math.random() * 900000));
    }
}

