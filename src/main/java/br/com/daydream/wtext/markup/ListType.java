package br.com.daydream.wtext.markup;

import com.sun.istack.internal.NotNull;

import java.util.stream.IntStream;

/**
 * Created by Rivaldo on 30/04/16.
 */
public enum ListType {

    UNORDERED("*", "\n"),

    ORDERED("#", "\n");

    private final String initialMarkup;
    private final String finalMarkup;

    ListType(String initialMarkup, String finalMarkup) {
        this.initialMarkup = initialMarkup;
        this.finalMarkup = finalMarkup;
    }

    public String apply(int level, @NotNull String text) {

        level = (level > 0) ? level : 1;

        StringBuilder builder = new StringBuilder();
        IntStream.range(0, level).forEach(value -> builder.append(initialMarkup));

        return builder.append(text).append(finalMarkup).toString();
    }
}
