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


/**
 * Factory responsible for creating the document formatting classes.
 *
 * @author hivakun
 * Created on 01/05/16
 */
public interface FormatterFactory {

    /**
     * Get the default implementation of the {@code TextFormatter} interface to be used to format text.
     * @return the default implementation of {@code TextFormatter}
     */
    TextFormatter getTextFormat();

    /**
     * Get the default implementation of the {@code SectionFormatter} interface to be used to format sections.
     * @return the default implementation of {@code SectionFormatter}
     */
    SectionFormatter getSectionFormatter();

    /**
     * Get the default implementation of the {@code LinkFormatter} interface to be used to format links.
     * @return the default implementation of {@code LinkFormatter}
     */
    LinkFormatter getLinkFormatter();

    /**
     * Get the default implementation of the {@code ListFormatter} interface to be used to format lists.
     * @return the default implementation of {@code ListFormatter}
     */
    ListFormatter getListFormatter();

    /**
     * Get the default implementation of the {@code SourceFormatter} interface to be used to format sources.
     * @return the default implementation of {@code SourceFormatter}
     */
    SourceFormatter getSourceFormatter();

    /**
     * Get the default implementation of the {@code TableFormatter} interface to be used to format tables.
     * @return the default implementation of {@code TableFormatter}
     */
    TableFormatter getTableFormatter();

    /**
     * Get the default implementation of the {@code TableFormatter} interface to be used to format tables.
     * @return the default implementation of {@code TableFormatter}
     */
    TableRowFormatter getTableRowFormatter();

    /**
     * Get the default implementation of the {@code TableFormatter} interface to be used to format tables.
     * @return the default implementation of {@code TableFormatter}
     */
    TableCellFormatter getTableCellFormatter();


}
