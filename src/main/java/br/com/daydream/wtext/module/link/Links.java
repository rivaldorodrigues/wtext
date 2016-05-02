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


import br.com.daydream.wtext.arq.formatter.FormatterFactory;
import br.com.daydream.wtext.arq.formatter.LinkFormatter;
import br.com.daydream.wtext.markup.LinkType;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;

import java.net.URL;

/**
 * Created by Rivaldo on 23/04/16.
 */
public final class Links {

    private static LinkFormatter formatter = FormatterFactory.getLinkFormatter();

    public static Link newInternalLink(@NotNull String link) {
        return newInternalLink(link, "");
    }

    public static Link newInternalLink(@NotNull String link, String rename) {
        return new Link(formatter.internal(link, rename));
    }

    public static Link newExternalLink(@NotNull String link) {
        return newExternalLink(link, "");
    }

    public static Link newExternalLink(@NotNull String link, String rename) {
        return new Link(formatter.external(link, rename));
    }

    public static Link newFileLink(@NotNull String link) {
        return newFileLink(link, "");
    }

    public static Link newFileLink(@NotNull String link, String rename) {
        return new Link(formatter.file(link, rename));
    }

    public static Link newSectionLink(@NotNull String section) {
        return newSectionLink(section, "", "");
    }

    public static Link newSectionLink(@NotNull String section, String page) {
        return newSectionLink(section, page, "");
    }

    public static Link newSectionLink(@NotNull String section, String page, String rename) {
        return new Link(formatter.section(section, page, rename));
    }
}
