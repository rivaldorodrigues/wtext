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


import com.github.hivakun.wtext.wiki.formatter.WikiLinkFormatter;
import org.apache.commons.lang3.StringUtils;

/**
 * Enum that hold all the mediawiki markups for link format.
 * @see WikiLinkFormatter
 *
 * @author hivakun
 * Created on 23/04/16
 */
public enum WikiLinkMarkup {

    INTERNAL("[[","|", "]]"),

    EXTERNAL("["," ", "]"),

    FILE("[[:File:", "|", "]]");

    private final String initialMarkup;
    private final String separatorMarkup;
    private final String finalMarkup;

    /**
     * Creates the constants of link format markup.
     *
     * @param initialMarkup the initial format markup
     * @param separatorMarkup the middle markup to separate the link and the replace name
     * @param finalMarkup the final format markup
     */
    WikiLinkMarkup(String initialMarkup, String separatorMarkup, String finalMarkup) {
        this.initialMarkup = initialMarkup;
        this.separatorMarkup = separatorMarkup;
        this.finalMarkup = finalMarkup;
    }

    /**
     * Apply the specified link format.
     *
     * @param link the link text to be formatted
     * @param rename the name to replace the link
     * @return the original link with the desired link markup
     */
    public String apply(String link, String rename) {
        String result = initialMarkup + link;

        if (StringUtils.isNoneEmpty(rename)) {
            result += separatorMarkup + rename;
        }

        return result + finalMarkup;
    }
}
