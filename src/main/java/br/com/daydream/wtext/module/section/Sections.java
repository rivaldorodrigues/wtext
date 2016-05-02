package br.com.daydream.wtext.module.section;

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
import br.com.daydream.wtext.arq.formatter.SectionFormatter;
import br.com.daydream.wtext.arq.formatter.TextFormat;
import br.com.daydream.wtext.arq.module.Text;
import br.com.daydream.wtext.markup.SectionMarkup;
import br.com.daydream.wtext.markup.WikiTextFormat;
import org.jetbrains.annotations.NotNull;

/**
 * @author rivaldo
 * Created on 26/04/2016.
 */
public class Sections {

    private static SectionFormatter formatter = FormatterFactory.getSectionFormatter();

    public static Section newSection(@NotNull String text) {
        return new Section(formatter.section(text));
    }

    public static Section newSection(@NotNull Text text) {
        return newSection(text.toString());
    }

    public static Section newSubsection(@NotNull String text) {
        return new Section(formatter.subsection(text));
    }

    public static Section newSubsection(@NotNull Text text) {
        return newSubsection(text.toString());
    }

    public static Section newSubSubsection(@NotNull String text) {
        return new Section(formatter.subSubsection(text));
    }

    public static Section newSubSubsection(@NotNull Text text) {
        return new Section(formatter.subSubsection(text.toString()));
    }
}
