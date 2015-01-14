package com.endoflineblog.no_more_loops.benchmark;

import com.deadcoderising.no_more_loops.Article;

import java.util.*;

public class ArticleGenerator {
    private static final char[] SYMBOLS = initSymbols();

    private static char[] initSymbols() {
        StringBuilder ret = new StringBuilder(52 + 10);
        for (char c = 'a'; c <= 'z'; c++)
            ret.append(c);
        for (char c = 'A'; c <= 'Z'; c++)
            ret.append(c);
        for (char c = '0'; c <= '9'; c++)
            ret.append(c);
        return ret.toString().toCharArray();
    }

    private static final String[] AUTHORS = new String[]{
            "William Shakespeare",
            "Agatha Christie",
            "Barbara Cartland",
            "Danielle Steel",
            "Harold Robbins",
            "Georges Simenon",
            "Sidney Sheldon",
            "Enid Blyton",
            "Dr. Seuss",
            "Gilbert Patten",
            "J. K. Rowling",
            "Leo Tolstoy",
            "Jackie Collins",
            "Horatio Alger, Jr",
            "R. L. Stine",
            "Corín Tellado",
            "Dean Koontz",
            "Alexander Pushkin",
            "Stephen King"
    };

    private static final String[] TAGS = {
            // we leave out Java on purpose to force the getFirstJavaArticle methods
            // to traverse the entire collection
//            "Java",
            "Scala",
            "Clojure",
            "Kotlin",
            "Ceylon",
            "JS",
            "Ruby",
            "C",
            "C++",
            "D",
            "Python",
            "Perl",
            "Haskell"
    };

    private final Random rng;

    public ArticleGenerator(Random rng) {
        this.rng = rng;
    }

    public List<Article> generate(int size) {
        List<Article> ret = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            ret.add(generateArticle());
        }
        return ret;
    }

    private Article generateArticle() {
        return new Article(generateTitle(), generateAuthor(), generateTags());
    }

    private String generateTitle() {
        int size = randomIntBetween(5, 45);
        char[] chars = new char[size];
        for (int i = 0; i < size; i++) {
            chars[i] = randomSymbol();
        }
        return new String(chars);
    }

    private String generateAuthor() {
        return randomArrrayElement(AUTHORS);
    }

    private List<String> generateTags() {
        int size = randomIntBetween(0, 5);
        Set<String> ret = new HashSet<>(size);
        while (ret.size() < size)
            ret.add(randomTag());
        return new ArrayList<>(ret);
    }

    private char randomSymbol() {
        return SYMBOLS[randomIntSmallerThan(SYMBOLS.length)];
    }

    private String randomTag() {
        return randomArrrayElement(TAGS);
    }

    private <T> T randomArrrayElement(T[] array) {
        return array[randomIntSmallerThan(array.length)];
    }

    private int randomIntSmallerThan(int bound) {
        return randomIntBetween(0, bound - 1);
    }

    private int randomIntBetween(int from, int to) {
        return rng.nextInt(to - from + 1) + from;
    }
}
