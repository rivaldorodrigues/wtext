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


import org.apache.commons.lang3.StringUtils;

/**
 * Created by Rivaldo on 23/04/16.
 */
public enum LinkType {

    INTERNAL("[[","|", "]]"),

    EXTERNAL("["," ", "]"),

    FILE("[[:File:", "|", "]]");

    private final String initialMarkup;
    private final String separatorMarkup;
    private final String finalMarkup;

    LinkType(String initialMarkup, String separatorMarkup, String finalMarkup) {
        this.initialMarkup = initialMarkup;
        this.separatorMarkup = separatorMarkup;
        this.finalMarkup = finalMarkup;
    }

    public String apply(String link, String rename) {
        String result = initialMarkup + link;

        if (StringUtils.isNoneEmpty(rename)) {
            result += separatorMarkup + rename;
        }

        return result + finalMarkup;
    }
}
