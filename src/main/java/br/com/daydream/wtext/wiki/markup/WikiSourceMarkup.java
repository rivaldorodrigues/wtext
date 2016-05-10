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


/**
 * Enum that hold all the mediawiki markup for source elements.
 * @see br.com.daydream.wtext.module.source.Source
 *
 * @author hivakun
 * Created on 26/04/16
 */
public enum WikiSourceMarkup {

    SOURCE_START("<source", ">\n"),

    SOURCE_END("", "\n</source>"),

    LANG("lang=\"", "\""),

    TITLE("title=\"\'", "\'\""),

    HIGHLIGHT("highlight=\"[", "]\"");

    private final String initialMarkup;
    private final String finalMarkup;

    /**
     * Creates the constants of mediawiki source markup.
     *
     * @param initialMarkup the initial format markup
     * @param finalMarkup the final format markup
     */
    WikiSourceMarkup(String initialMarkup, String finalMarkup) {
        this.initialMarkup = initialMarkup;
        this.finalMarkup = finalMarkup;
    }

    /**
     * Apply the desired markup to the text.
     *
     * @param text the text to be formatted
     * @return the text formatted with the source markup
     */
    public String apply(String text) {
        return initialMarkup + text + finalMarkup;
    }
}
