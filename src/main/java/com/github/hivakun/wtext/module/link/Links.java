package com.github.hivakun.wtext.module.link;

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


import com.github.hivakun.wtext.arq.formatter.FormatterController;
import com.github.hivakun.wtext.arq.formatter.LinkFormatter;

/**
 * Factory class to create links.
 * @see Link
 *
 * @author hivakun
 * Created on 23/04/16
 */
public final class Links {

    private static LinkFormatter formatter = FormatterController.getFactory().getLinkFormatter();

    /**
     * Create a new internal link.
     *
     * @param link the link url
     * @return the link element that make reference to the url
     */
    public static Link newInternalLink(String link) {
        return newInternalLink(link, "");
    }

    /**
     * Create a new renamed internal link.
     *
     * @param link the link url
     * @param rename the text to replace the link
     * @return the link element that make reference to the url
     */
    public static Link newInternalLink(String link, String rename) {
        return new Link(formatter.internal(link, rename));
    }

    /**
     * Create a new external link.
     *
     * @param link the link url
     * @return the link element that make reference to the url
     */
    public static Link newExternalLink(String link) {
        return newExternalLink(link, "");
    }

    /**
     * Create a new renamed external link.
     *
     * @param link the link url
     * @param rename the text to replace the link
     * @return the link element that make reference to the url
     */
    public static Link newExternalLink(String link, String rename) {
        return new Link(formatter.external(link, rename));
    }

    /**
     * Create a new file link.
     *
     * @param link the link url
     * @return the link element that make reference to the url
     */
    public static Link newFileLink(String link) {
        return newFileLink(link, "");
    }

    /**
     * Create a new renamed file link.
     *
     * @param link the link url
     * @param rename the text to replace the link
     * @return the link element that make reference to the url
     */
    public static Link newFileLink(String link, String rename) {
        return new Link(formatter.file(link, rename));
    }

    /**
     * Create a new section link.
     *
     * @param section the section name
     * @return the link element that make reference to the section
     */
    public static Link newSectionLink(String section) {
        return newSectionLink(section, "", "");
    }

    /**
     * Create a new section link.
     *
     * @param section the section name
     * @param page the page that contains the desired section
     * @return the link element that make reference to the section
     */
    public static Link newSectionLink(String section, String page) {
        return newSectionLink(section, page, "");
    }

    /**
     * Create a new renamed section link.
     *
     * @param section the section name
     * @param page the page that contains the desired section
     * @param rename the text to replace the link
     * @return the link element that make reference to the section
     */
    public static Link newSectionLink(String section, String page, String rename) {
        return new Link(formatter.section(section, page, rename));
    }
}
