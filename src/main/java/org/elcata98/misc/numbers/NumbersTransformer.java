package org.elcata98.misc.numbers;

import org.apache.commons.lang3.StringUtils;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class NumbersTransformer {

    private static final Pattern ROMAN_PATTERN = Pattern.compile("^M{0,3}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$");

    private static final List<List<Character>> ROMAN_MAPPINGS =
            List.of(List.of('I', 'V'), List.of('X', 'L'), List.of('C', 'D'), Collections.singletonList('M'));

    private static final Map<String, Integer> ARABIC_MAPPINGS =
            Map.of("I", 1, "V", 5, "X", 10, "L", 50, "C", 100, "D", 500, "M", 1000);


    public String adaptToRoman(final int arabic) {

        if (arabic <= 0 || arabic >= 5000) {
            return null;
        }

        StringBuilder result = new StringBuilder();

        String number = Integer.toString(arabic);

        IntStream
                .range(0, number.length())
                .forEachOrdered(
                        index -> processDigit(Integer.parseInt(String.valueOf(number.charAt(index))), number.length() - index - 1, result)
                );

        return result.toString();
    }

    public Integer adaptToArabic(String roman) {

        Integer arabic = null;

        if (StringUtils.isNotBlank(roman) && ROMAN_PATTERN.matcher(roman).matches()) {

            arabic = 0;

            if (roman.contains("IV")) {
                roman = roman.replace("IV", StringUtils.EMPTY);
                arabic += 4;
            }

            if (roman.contains("IX")) {
                roman = roman.replace("IX", StringUtils.EMPTY);
                arabic += 9;
            }

            if (roman.contains("XL")) {
                roman = roman.replace("XL", StringUtils.EMPTY);
                arabic += 40;
            }

            if (roman.contains("XC")) {
                roman = roman.replace("XC", StringUtils.EMPTY);
                arabic += 90;
            }

            if (roman.contains("CD")) {
                roman = roman.replace("CD", StringUtils.EMPTY);
                arabic += 400;
            }

            if (roman.contains("CM")) {
                roman = roman.replace("CM", StringUtils.EMPTY);
                arabic += 900;
            }

            for (int i = 0; i < roman.length(); ++i) {
                arabic += ARABIC_MAPPINGS.get(String.valueOf(roman.charAt(i)));
            }
        }

        return arabic;
    }

    private void processDigit(final int digit, final int position, final StringBuilder result) {

        List<Character> characters = ROMAN_MAPPINGS.get(position);

        Character char0 = characters.get(0);
        Character char1 = characters.size() > 1 ? characters.get(1) : null;

        switch (digit) {
            case 0:
            case 1:
            case 2:
            case 3:
                IntStream.range(0, digit).forEach((i -> result.append(char0)));
                break;
            case 4:
                result.append(char0);
                Optional.ofNullable(char1)
                        .ifPresentOrElse(result::append, () -> IntStream.range(0, 3).forEach((i -> result.append(char0))));
                break;
            case 5:
                Optional.ofNullable(char1).ifPresent(result::append);
                break;
            case 6:
            case 7:
            case 8:
                Optional.ofNullable(char1).ifPresent(
                        character -> {
                            result.append(character);
                            IntStream.range(0, digit - 5).forEach((i -> result.append(char0)));
                        });
                break;
            case 9:
                Optional.ofNullable(char1).ifPresent(
                        character -> {
                            result.append(char0);
                            result.append(ROMAN_MAPPINGS.get(position + 1).get(0));
                        });
                break;
        }
    }
}