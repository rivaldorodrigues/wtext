package br.com.daydream.wtext.module.paragraph;

import br.com.daydream.wtext.markup.Sections;
import br.com.daydream.wtext.markup.TextFormat;
import com.sun.istack.internal.NotNull;

import java.io.IOException;

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

    public ParagraphBuilder append(@NotNull String text) {
        builder.append(textCache);
        textCache = text;

        return this;
    }

    public ParagraphBuilder appendWithFormat(@NotNull String text, TextFormat format) {
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
        return new Paragraph(Sections.SECTIONS.apply(builder.toString()));
    }

    public Paragraph buildSubsection() {
        builder.append(textCache);
        return new Paragraph(Sections.SUBSECTION.apply(builder.toString()));
    }

    public Paragraph buildSubSubsection() {
        builder.append(textCache);
        return new Paragraph(Sections.SUB_SUBSECTION.apply(builder.toString()));
    }
}
