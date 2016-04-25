package br.com.daydream.wtext.module.link;

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


import br.com.daydream.wtext.markup.LinkType;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by Rivaldo on 23/04/16.
 */
public final class Links {

    private static final String SECTION_SEPARATOR = "#";

    //TODO Colocar o @NotNull
    public static Link newInternalLink(String link) {
        return newInternalLink(link, "");
    }

    //TODO Colocar o @NotNull
    public static Link newInternalLink(String link, String rename) {
        return new Link(LinkType.INTERNAL.apply(link, rename));
    }

    //TODO Colocar o @NotNull
    public static Link newExternalLink(String link) {
        return newExternalLink(link, "");
    }

    //TODO Colocar o @NotNull
    public static Link newExternalLink(String link, String rename) {
        return new Link(LinkType.EXTERNAL.apply(link, rename));
    }

    //TODO Colocar o @NotNull
    public static Link newSectionLink(String section) {
        return newInternalLink(getSectionLink(section, ""));
    }

    //TODO Colocar o @NotNull
    public static Link newSectionLink(String section, String page) {
        return newInternalLink(getSectionLink(section, page));
    }

    //TODO Colocar o @NotNull
    public static Link newSectionLink(String section, String page, String rename) {
        return newInternalLink(getSectionLink(section, page), rename);
    }

    //TODO Colocar o @NotNull
    private static String getSectionLink(String section, String page) {
        String nPage = StringUtils.isNoneEmpty(page) ? page : "";
        return nPage + SECTION_SEPARATOR + section;
    }
}
