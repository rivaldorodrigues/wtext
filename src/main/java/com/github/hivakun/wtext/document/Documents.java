package com.github.hivakun.wtext.document;

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


import org.jetbrains.annotations.NotNull;

import java.io.OutputStream;

/**
 * Factory class to create documents.
 *
 * @author hivakun
 * Created on 16/05/2016.
 */
public class Documents {

    /**
     * Creates a new wiki page with mediawiki as default format.
     *
     * @param output the output document file
     */
    public static Document newWikiPage(@NotNull OutputStream output) {
        return newWikiPage(DocumentFormat.MEDIAWIKI, output);
    }

    /**
     * Creates a new wiki page.
     *
     * @param format the desired that format
     * @param output the output document file
     */
    public static Document newWikiPage(@NotNull DocumentFormat format, @NotNull OutputStream output) {
        format.apply();
        return new WikiPage(output);
    }
}
