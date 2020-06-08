package org.elcata98.misc.text;


import java.util.ArrayList;
import java.util.List;

/**
 * Complete the solution so that it splits the string into pairs of two characters.
 * If the string contains an odd number of characters then it should replace
 * the missing second character of the final pair with an underscore ('_').
 * <p>
 * SplitStrings.solution("abc") // should return {"ab", "c_"}
 * SplitStrings.solution("abcdef") // should return {"ab", "cd", "ef"}
 */
public class SplitStrings {

    private static final String[] EMPTY_ARRAY = new String[0];

    public static String[] solution(String input) {

        List<String> split = new ArrayList<>();

        if (input != null && !input.isEmpty()) {

            String sanitized = input.replace(' ', '_');

            if (sanitized.length() % 2 == 1) {
                sanitized += "_";
            }

            for (int i = 0; i < sanitized.length(); i = i + 2) {

                String item = String.valueOf(sanitized.charAt(i)) + sanitized.charAt(i + 1);
                if (!"__".equals(item)) {
                    split.add(item);
                }
            }
        }

        return split.toArray(EMPTY_ARRAY);
    }
}
