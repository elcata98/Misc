package org.elcata98.misc.numbers;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

public class NumbersTransformer {

    private static final List<List<Character>> MAPPINGS =
            List.of(List.of('I', 'V'), List.of('X', 'L'), List.of('C', 'D'), Collections.singletonList('M'));

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

    private void processDigit(final int digit, final int position, final StringBuilder result) {

        List<Character> characters = MAPPINGS.get(position);

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
                            result.append(MAPPINGS.get(position + 1).get(0));
                        });
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