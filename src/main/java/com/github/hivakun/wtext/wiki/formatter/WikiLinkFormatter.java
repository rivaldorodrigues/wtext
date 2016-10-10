package com.github.hivakun.wtext.wiki.formatter;

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


import com.github.hivakun.wtext.arq.formatter.LinkFormatter;
import com.github.hivakun.wtext.module.link.Link;
import com.github.hivakun.wtext.wiki.markup.WikiLinkMarkup;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;

/**
 * Implements the mediawiki link formatting strategy.
 * @see Link
 *
 * @author hivakun
 * Created on 01/05/16
 */
public class WikiLinkFormatter implements LinkFormatter {

    private static final String SECTION_SEPARATOR = "#";

    @Override
    public String internal(String url, String rename) {
        return WikiLinkMarkup.INTERNAL.apply(url, rename);
    }

    @Override
    public String external(String url, String rename) {
        return WikiLinkMarkup.EXTERNAL.apply(url, rename);
    }

    @Override
    public String file(String url, String rename) {
        return WikiLinkMarkup.FILE.apply(url, rename);
    }

    @Override
    public String section(String section, String page, String rename) {
        return internal(getSectionLink(section, page), rename);
    }

    /**
     * Get the url for a section link.
     *
     * @param section the section which the link should point
     * @param page the page that contains the desired section
     * @return the section link url
     */
    private static String getSectionLink(@NotNull String section, String page) {
        String nPage = StringUtils.isNoneEmpty(page) ? page : "";
        return nPage + SECTION_SEPARATOR + section;
    }
}
