package com.github.hivakun.wtext.module.section;

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
import com.github.hivakun.wtext.arq.formatter.SectionFormatter;
import com.github.hivakun.wtext.module.link.Link;

/**
 * Factory class to create links.
 * @see Link
 *
 * @author hivakun
 * Created on 26/04/16
 */
public class Sections {

    private static SectionFormatter formatter = FormatterController.getFactory().getSectionFormatter();

    /**
     * Create a new section.
     *
     * @param text the desired section text
     * @return the section element
     */
    public static Section newSection(String text) {
        return new Section(formatter.section(text));
    }

    /**
     * Create a new subsection.
     *
     * @param text the desired subsection text
     * @return the subsection element
     */
    public static Section newSubsection(String text) {
        return new Section(formatter.subsection(text));
    }

    /**
     * Create a new sub-subsection.
     *
     * @param text the desired sub-subsection text
     * @return the sub-subsection element
     */
    public static Section newSubSubsection(String text) {
        return new Section(formatter.subSubsection(text));
    }
}
