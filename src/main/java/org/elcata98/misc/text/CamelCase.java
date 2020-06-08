package org.elcata98.misc.text;

import org.apache.commons.lang3.StringUtils;

import java.util.Optional;
import java.util.stream.Collectors;

public class CamelCase {

    public static String camelCase(String camelCasing) {

        String toCamelCase = Optional.ofNullable(camelCasing).orElse(StringUtils.EMPTY);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < toCamelCase.length(); ++i) {

            char c = toCamelCase.charAt(i);
            if(Character.isUpperCase(c)){
                sb.append(StringUtils.SPACE);
            }
            sb.append(c);
        }

        return sb.toString();
    }

    public static String camelCaseFunctional(String camelCasing) {

        return Optional.ofNullable(camelCasing)
                .orElse(StringUtils.EMPTY)
                .chars()
                .mapToObj(c -> (char) c)
                .map(String::valueOf)
                .map(character -> {
                    if (Character.isUpperCase(character.charAt(0))) {
                        return StringUtils.SPACE + character;
                    } else {
                        return character;
                    }
                }).collect(Collectors.joining());
    }

    public static String camelCaseF2(String camelCasing) {

        StringBuilder sb = new StringBuilder();

        Optional.ofNullable(camelCasing)
                .orElse(StringUtils.EMPTY)
                .chars()
                .mapToObj(c -> (char) c)
                .forEach(character -> {
                    if (Character.isUpperCase(character)) {
                        sb.append(StringUtils.SPACE);
                    }
                    sb.append(character);
                });

        return sb.toString();
    }
}
