package br.com.daydream.wtext.markup.table;

import java.util.stream.IntStream;

/**
 * @author rivaldo
 * Created on 29/04/2016.
 */
public enum ListType {

    UNORDERED("*"),

    ORDERED("#");

    private final String initialMarkup;

    ListType(String initialMarkup) {
        this.initialMarkup = initialMarkup;
    }

    public String apply(int level, String text) {

        StringBuilder builder = new StringBuilder();
        level = (level > 0) ? level : 1;

        IntStream.rangeClosed(1, level).forEach(value -> builder.append(initialMarkup));

        return builder.append(text).toString();
    }
}