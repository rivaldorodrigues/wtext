package com.github.hivakun.wtext.arq.formatter;

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


import com.github.hivakun.wtext.document.DocumentFormat;
import com.github.hivakun.wtext.wiki.formatter.WikiFormatterFactory;
import org.jetbrains.annotations.NotNull;

/**
 * Control the document format factory.
 * @see FormatterFactory
 *
 * @author hivakun
 * Created on 16/05/16
 */
public class FormatterController {

    private static DocumentFormat currentFormat = DocumentFormat.MEDIAWIKI;
    private static FormatterFactory currentFactory = new WikiFormatterFactory();

    /**
     * Get the current document format factory.
     *
     * @return the current document format factory
     */
    public static FormatterFactory getFactory() {
        return currentFactory;
    }

    /**
     * Set the document format factory to be used.
     *
     * @param format the document format
     * @param factory the document format factory
     */
    public static void setFactory(@NotNull DocumentFormat format, @NotNull FormatterFactory factory) {
        if (!format.equals(currentFormat)) {
            currentFormat = format;
            currentFactory = factory;
        }
    }
}
