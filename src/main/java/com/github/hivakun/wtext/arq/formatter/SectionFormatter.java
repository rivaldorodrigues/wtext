package com.github.hivakun.wtext.arq.formatter;

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


import com.github.hivakun.wtext.module.section.Section;

/**
 * Interface to all classes that implement the section formatting strategy.
 * @see Section
 *
 * @author hivakun
 * Created on 01/05/16
 */
public interface SectionFormatter {

    /**
     * Apply the section markup to the text.
     *
     * @param text the text to be formated
     * @return the original text with section markup
     */
    String section(String text);

    /**
     * Apply the subsection markup to the text.
     *
     * @param text the text to be formated
     * @return the original text with subsection markup
     */
    String subsection(String text);

    /**
     * Apply the sub-subsection markup to the text.
     *
     * @param text the text to be formated
     * @return the original text with sub-subsection markup
     */
    String subSubsection(String text);
}
