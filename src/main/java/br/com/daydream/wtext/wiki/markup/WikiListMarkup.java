package br.com.daydream.wtext.wiki.markup;

/*
 * #%L
 * WText
 * %%
 * Copyright (C) 2016 Daydream
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-3.0.html>.
 * #L%
 */


import java.util.stream.IntStream;

/**
 * Enum that hold all the mediawiki markups for list format.
 * @see br.com.daydream.wtext.wiki.formatter.WikiListFormatter
 *
 * @author hivakun
 * Created on 29/04/16
 */
public enum WikiListMarkup {

    UNORDERED("*", "\n"),

    ORDERED("#", "\n");

    private final String initialMarkup;
    private final String finalMarkup;

    /**
     * Creates the constants of list format markup.
     *
     * @param initialMarkup the initial format markup
     * @param finalMarkup the final format markup
     */
    WikiListMarkup(String initialMarkup, String finalMarkup) {
        this.initialMarkup = initialMarkup;
        this.finalMarkup = finalMarkup;
    }

    /**
     * Apply the specified list format.
     *
     * @param level the item level at the list hierarchy
     * @param item the item at the list
     * @return the original item with the desired list markup
     */
    public String apply(int level, String item) {

        StringBuilder builder = new StringBuilder();
        level = (level > 0) ? level : 1;

        IntStream.rangeClosed(1, level).forEach(value -> builder.append(initialMarkup));

        return builder.append(item).append(finalMarkup).toString();
    }
}