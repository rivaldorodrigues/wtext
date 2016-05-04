package br.com.daydream.wtext.markup;

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
 * @author rivaldo
 * Created on 29/04/2016.
 */
public enum ListType {

    UNORDERED("*", "\n"),

    ORDERED("#", "\n");

    private final String initialMarkup;
    final String finalMarkup;

    ListType(String initialMarkup, String finalMarkup) {
        this.initialMarkup = initialMarkup;
        this.finalMarkup = finalMarkup;
    }

    public String apply(int level, String text) {

        StringBuilder builder = new StringBuilder();
        level = (level > 0) ? level : 1;

        IntStream.rangeClosed(1, level).forEach(value -> builder.append(initialMarkup));

        return builder.append(text).append(finalMarkup).toString();
    }
}