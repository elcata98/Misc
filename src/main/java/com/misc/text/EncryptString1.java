package com.misc.text;

public class EncryptString1 {

    public static String encrypt(final String input, final int n) {

        if (n <= 0 || input == null || "".equals(input.trim())) {
            return input;
        }

        String result = input;

        for (int i = 0; i < n; ++i) {
            result = stepEncrypt(result);
        }

        return result;
    }

    public static String decrypt(final String input, final int n) {

        if (n <= 0 || input == null || "".equals(input.trim())) {
            return input;
        }

        String result = input;

        for (int i = 0; i < n; ++i) {
            result = stepDecrypt(result);
        }

        return result;
    }

    private static String stepEncrypt(final String input) {

        StringBuilder odd = new StringBuilder();
        StringBuilder even = new StringBuilder();

        for (int i = 0; i < input.length(); ++i) {
            if (i % 2 == 0) {
                even.append(input.charAt(i));
            } else {
                odd.append(input.charAt(i));
            }
        }
        return odd.append(even.toString()).toString();
    }

    private static String stepDecrypt(final String input) {

        int length = input.length();

        String even = input.substring(length / 2);
        String odd = input.substring(0, length / 2);

        StringBuilder result = new StringBuilder();
        int i = 0;

        while (result.length() != length) {
            result.append(even.charAt(i));
            if (result.length() != length) {
                result.append(odd.charAt(i));
            }
            ++i;
        }
        return result.toString();
    }
}