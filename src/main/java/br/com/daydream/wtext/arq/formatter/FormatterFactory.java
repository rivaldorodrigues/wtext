package br.com.daydream.wtext.arq.formatter;

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


import br.com.daydream.wtext.formatter.*;

/**
 * Created by Rivaldo on 01/05/16.
 */
public class FormatterFactory {

    public static TextFormatter getTextFormat() {
        return new WikiTextFormatter();
    }

    public static SectionFormatter getSectionFormatter() {
        return new WikiSectionFormatter();
    }

    public static LinkFormatter getLinkFormatter() {
        return new WikiLinkFormatter();
    }

    public static ListFormatter getListFormatter() {
        return new WikiListFormatter();
    }

    public static SourceFormatter getSourceFormatter() {
        return new WikiSourceFormatter();
    }

    public static TableFormatter getTableFormatter() {
        return new WikiTableFormatter();
    }
}
