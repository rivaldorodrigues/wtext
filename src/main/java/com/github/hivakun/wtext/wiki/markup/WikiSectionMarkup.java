package com.github.hivakun.wtext.wiki.markup;

/*
 * #%L
 * WText
 * %%
 * Copyright (C) 2016 Rivaldo Rodrigues
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

import com.github.hivakun.wtext.wiki.formatter.WikiSectionFormatter;

/**
 * Enum that hold all the mediawiki markups for sections format.
 * @see WikiSectionFormatter
 *
 * @author hivakun
 * Created on 23/04/16
 */
public enum WikiSectionMarkup {

    SECTIONS("== "," =="),

    SUBSECTION("=== ", " ==="),

    SUB_SUBSECTION("==== ", " ====");

    private final String initialMarkup;
    private final String finalMarkup;

    /**
     * Creates the constants of section format markup.
     *
     * @param initialMarkup the initial format markup
     * @param finalMarkup the final format markup
     */
    WikiSectionMarkup(String initialMarkup, String finalMarkup) {
        this.initialMarkup = initialMarkup;
        this.finalMarkup = finalMarkup;
    }

    /**
     * Apply the specified section format.
     *
     * @param text the text to be formatted
     * @return the original text with the desired section markup
     */
    public String apply(String text) {
        return initialMarkup + text + finalMarkup;
    }
}
