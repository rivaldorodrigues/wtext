package br.com.daydream.wtext.formatter;

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


import br.com.daydream.wtext.arq.formatter.LinkFormatter;
import br.com.daydream.wtext.markup.LinkType;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;

/**
 * Created by Rivaldo on 01/05/16.
 */
public class WikiLinkFormatter implements LinkFormatter {

    private static final String SECTION_SEPARATOR = "#";

    @Override
    public String internal(String text, String rename) {
        return LinkType.INTERNAL.apply(text, rename);
    }

    @Override
    public String external(String text, String rename) {
        return LinkType.EXTERNAL.apply(text, rename);
    }

    @Override
    public String file(String text, String rename) {
        return LinkType.FILE.apply(text, rename);
    }

    @Override
    public String section(String section, String page, String rename) {
        return internal(getSectionLink(section, page), rename);
    }

    private static String getSectionLink(@NotNull String section, String page) {
        String nPage = StringUtils.isNoneEmpty(page) ? page : "";
        return nPage + SECTION_SEPARATOR + section;
    }
}
