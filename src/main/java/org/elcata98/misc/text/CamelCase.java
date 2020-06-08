package org.elcata98.misc.text;

import org.apache.commons.lang3.StringUtils;

import java.util.Optional;

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
}
