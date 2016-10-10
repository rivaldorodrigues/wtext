package com.github.hivakun.wtext.wiki.formatter;

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

import com.github.hivakun.wtext.arq.formatter.SectionFormatter;
import com.github.hivakun.wtext.wiki.markup.WikiSectionMarkup;
import com.github.hivakun.wtext.module.section.Section;

/**
 * Implements the mediawiki section formatting strategy.
 * @see Section
 *
 * @author hivakun
 * Created on 01/05/16
 */
public class WikiSectionFormatter implements SectionFormatter {

    @Override
    public String section(String text) {
        return WikiSectionMarkup.SECTIONS.apply(text);
    }

    @Override
    public String subsection(String text) {
        return WikiSectionMarkup.SUBSECTION.apply(text);
    }

    @Override
    public String subSubsection(String text) {
        return WikiSectionMarkup.SUB_SUBSECTION.apply(text);
    }
}
