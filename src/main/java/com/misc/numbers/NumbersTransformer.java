package com.misc.numbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class NumbersTransformer {


    private static final List<List<Character>> MAPPINGS;

    static {

//        we store possible symbols for the nth reverse position of the arabic number (0 the last one, 1 one position the left and so on)

        MAPPINGS = List.of(Arrays.asList('I', 'V'), Arrays.asList('X', 'L'), Arrays.asList('C', 'D'), Collections.singletonList('M'));
    }

    public String adaptToRoman(final int arabic) {

        if (arabic <= 0 || arabic >= 5000) {
            return null;
        }

        StringBuilder result = new StringBuilder();

        String number = Integer.toString(arabic);

        IntStream
                .range(0, number.length())
                .forEachOrdered(
                        index -> processDigit(Integer.valueOf(String.valueOf(number.charAt(index))), number.length() - index - 1, result)
                );

        return result.toString();
    }

    private void processDigit(final int digit, final int position, final StringBuilder result) {

        List<Character> characters = MAPPINGS.get(position);

        switch (digit) {
            case 0:
            case 1:
            case 2:
            case 3:
                IntStream.range(0, digit).forEach((i -> result.append(characters.get(0))));
                break;
            case 4:
                result.append(characters.get(0));
                if (characters.size() > 1) {
                    result.append(characters.get(1));
                } else {
                    IntStream.range(0, 3).forEach((i -> result.append(characters.get(0))));
                }
                break;
            case 5:
                if (characters.size() > 1) {
                    result.append(characters.get(1));
                }
                break;
            case 6:
            case 7:
            case 8:
                if (characters.size() > 1) {
                    result.append(characters.get(1));
                    IntStream.range(0, digit - 5).forEach((i -> result.append(characters.get(0))));
                }
                break;
            case 9:
                if (characters.size() > 1) {
                    result.append(characters.get(0));
                    result.append(MAPPINGS.get(position + 1).get(0));
                }
                break;
        }
    }

    private void processDigit_OLD(final int digit, final int position, final StringBuilder result) {

        List<Character> characters = MAPPINGS.get(position);

        switch (digit) {
            case 0:
                //need to jump to next digit
                break;
            case 1:
                result.append(characters.get(0));
                break;
            case 2:
                result.append(characters.get(0));
                result.append(characters.get(0));
                break;
            case 3:
                result.append(characters.get(0));
                result.append(characters.get(0));
                result.append(characters.get(0));
                break;
            case 4:
                result.append(characters.get(0));
                if (characters.size() > 1) {
                    result.append(characters.get(1));
                } else {
                    result.append(characters.get(0));
                    result.append(characters.get(0));
                    result.append(characters.get(0));
                }
                break;
            case 5:
                if (characters.size() > 1) {
                    result.append(characters.get(1));
                }
                break;
            case 6:
                if (characters.size() > 1) {
                    result.append(characters.get(1));
                    result.append(characters.get(0));
                }
                break;
            case 7:
                if (characters.size() > 1) {
                    result.append(characters.get(1));
                    result.append(characters.get(0));
                    result.append(characters.get(0));
                }
                break;
            case 8:
                if (characters.size() > 1) {
                    result.append(characters.get(1));
                    result.append(characters.get(0));
                    result.append(characters.get(0));
                    result.append(characters.get(0));
                }
                break;
            case 9:
                if (characters.size() > 1) {
                    result.append(characters.get(0));
                    result.append(MAPPINGS.get(position + 1).get(0));
                }
                break;
        }
    }
}