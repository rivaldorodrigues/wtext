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


/**
 * Interface to all classes that implement the link formatting strategy.
 * @see br.com.daydream.wtext.module.link.Link
 *
 * @author hivakun
 * Created on 01/05/16
 */
public interface LinkFormatter {

    /**
     * Apply the internal link markup to the text.
     *
     * @param url the url link to be formatted
     * @param rename the text to rename the url
     * @return the original link with renamed internal link markup
     */
    String internal(String url, String rename);

    /**
     * Apply the external link markup to the text.
     *
     * @param url the url link to be formatted
     * @param rename the text to rename the url
     * @return the original link with renamed external link markup
     */
    String external(String url, String rename);

    /**
     * Apply the file link markup to the text.
     *
     * @param url the url link to be formatted
     * @param rename the text to rename the url
     * @return the original link with renamed file link markup
     */
    String file(String url, String rename);

    /**
     * Apply the section link markup to the text.
     *
     * @param section the section which the link should point
     * @param page the page that contains the desired section
     * @param rename the text to rename the url
     * @return the original section link with renamed section link markup
     */
    String section(String section, String page, String rename);
}
