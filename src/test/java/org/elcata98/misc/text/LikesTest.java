package org.elcata98.misc.text;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LikesTest {

    @Test
    void testNullLikes(){
        assertEquals("no one likes this", Likes.whoLikesIt((String[]) null));
    }

    @Test
    void testNobodyLikes() {
        assertEquals("no one likes this", Likes.whoLikesIt());
    }

    @Test
    void testOneLike() {

        assertEquals("Peter likes this", Likes.whoLikesIt("Peter"));
    }

    @Test
    void testTwoLikes(){
        assertEquals("Jacob and Alex like this", Likes.whoLikesIt("Jacob", "Alex"));
    }

    @Test
    void testThreeLikes(){

        assertEquals("Max, John and Mark like this", Likes.whoLikesIt("Max", "John", "Mark"));
    }

    @Test
    void testMoreThanThreeLikes(){
        assertEquals("Alex, Jacob and 2 others like this", Likes.whoLikesIt("Alex", "Jacob", "Mark", "Max"));
    }
}