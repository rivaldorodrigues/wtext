package br.com.daydream.wtext.module.section;

import br.com.daydream.wtext.markup.SectionMarkup;
import br.com.daydream.wtext.markup.TextFormat;
import org.jetbrains.annotations.NotNull;

/**
 * @author rivaldo
 * Created on 26/04/2016.
 */
public class Sections {

    public static Section newSection(@NotNull String text) {
        return newSection(text, null, SectionMarkup.SECTIONS);
    }

    public static Section newSection(@NotNull String text, TextFormat format) {
        return newSection(text, format, SectionMarkup.SECTIONS);
    }

    public static Section newSubsection(@NotNull String text) {
        return newSection(text, null, SectionMarkup.SUBSECTION);
    }

    public static Section newSubsection(@NotNull String text, TextFormat format) {
        return newSection(text, format, SectionMarkup.SUBSECTION);
    }

    public static Section newSubSubsection(@NotNull String text) {
        return newSection(text, null, SectionMarkup.SUB_SUBSECTION);
    }

    public static Section newSubSubsection(@NotNull String text, TextFormat format) {
        return newSection(text, format, SectionMarkup.SUB_SUBSECTION);
    }

    private static Section newSection(@NotNull String text, TextFormat format, SectionMarkup section) {

        String result = text;

        if (format != null) {
            result = format.apply(result);
        }

        if (section != null) {
            result = section.apply(result);
        }

        return new Section(result);
    }
}
