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


import br.com.daydream.wtext.markup.SectionMarkup;
import br.com.daydream.wtext.markup.TextFormat;
import br.com.daydream.wtext.module.Element;
import org.jetbrains.annotations.NotNull;

/**
 * Created by Rivaldo on 23/04/16.
 */
public class ParagraphBuilder {

    private String textCache;
    private StringBuilder builder;

    public ParagraphBuilder() {
        this("");
    }

    public ParagraphBuilder(String text) {
        this.textCache = text;
        builder = new StringBuilder();
    }

    //TODO Colocar o @NotNull
    public ParagraphBuilder append(String text) {
        builder.append(textCache);
        textCache = text;

        return this;
    }

    public ParagraphBuilder append(@NotNull Element element) {
        builder.append(textCache);
        textCache = element.toString();

        return this;
    }

    //TODO Colocar o @NotNull
    public ParagraphBuilder appendWithFormat(String text, TextFormat format) {
        builder.append(textCache);
        textCache = format.apply(text);

        return this;
    }

    public ParagraphBuilder withFormat(TextFormat format) {
        textCache = format.apply(textCache);
        return this;
    }

    public Paragraph buildParagraph() {
        builder.append(textCache);
        return new Paragraph(builder.toString());
    }

    public Paragraph buildSection() {
        builder.append(textCache);
        return new Paragraph(SectionMarkup.SECTIONS.apply(builder.toString()));
    }

    public Paragraph buildSubsection() {
        builder.append(textCache);
        return new Paragraph(SectionMarkup.SUBSECTION.apply(builder.toString()));
    }

    public Paragraph buildSubSubsection() {
        builder.append(textCache);
        return new Paragraph(SectionMarkup.SUB_SUBSECTION.apply(builder.toString()));
    }
}
