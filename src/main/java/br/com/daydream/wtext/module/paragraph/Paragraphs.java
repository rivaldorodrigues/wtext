package br.com.daydream.wtext.module.paragraph;

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


import br.com.daydream.wtext.markup.TextFormat;
import org.jetbrains.annotations.NotNull;

/**
 * @author rivaldo
 * Created on 26/04/2016.
 */
public class Paragraphs {

    public static Paragraph newParagraph(@NotNull String text) {
        return new Paragraph(text);
    }

    public static Paragraph newParagraph(@NotNull String text, @NotNull TextFormat format) {
        return new Paragraph(format.apply(text));
    }
}
