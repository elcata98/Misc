package com.misc.text;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class TrollText {

    private static final Set<String> VOWELS = new HashSet<>(Arrays.asList("a", "e", "i", "o", "u"));

    public static String disemvowel(final String original) {

        return
                original
                        .chars()
                        .mapToObj(i -> String.valueOf((char) i))
                        .filter(s -> !VOWELS.contains(s.toLowerCase()))
                        .collect(Collectors.joining());
    }
}