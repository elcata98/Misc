package org.elcata98.misc.text;


import java.util.Optional;

/*
    You probably know the "like" system from Facebook and other pages.
    People can "like" blog posts, pictures or other items.
    We want to create the text that should be displayed next to such an item.

    Implement a function
        likes :: [String] -> String
    which must take in input array, containing the names of people who like an item.
    It must return the display text as shown in the examples: (test class)
 */
public class Likes {

    private static final String LIKES = " likes this";
    private static final String LIKE = " like this";
    private static final String NOBODY = "no one";
    private static final String AND = " and ";
    private static final String AND_MORE = " and %s others";

    public static String whoLikesIt(String... names) {

        String result = NOBODY + LIKES;

        int length = Optional.ofNullable(names).map(n -> n.length).orElse(0);

        switch (length) {
            case 0:
                break;
            case 1:
                result = names[0] + LIKES;
                break;
            case 2:
                result = names[0] + AND + names[1] + LIKE;
                break;
            case 3:
                result = names[0] + ", " + names[1] + AND + names[2] + LIKE;
                break;
            default:
                result = names[0] + ", " + names[1] + String.format(AND_MORE, length - 2) + LIKE;
        }

        return result;
    }
}