package br.com.daydream.wtext.arq.formatter;

import br.com.daydream.wtext.formatter.WikiLinkFormatter;
import br.com.daydream.wtext.formatter.WikiListFormatter;
import br.com.daydream.wtext.formatter.WikiSectionFormatter;
import br.com.daydream.wtext.formatter.WikiTextFormatter;

/**
 * Created by Rivaldo on 01/05/16.
 */
public class FormatterFactory {

    public static TextFormatter getTextFormat() {
        return new WikiTextFormatter();
    }

    public static SectionFormatter getSectionFormatter() {
        return new WikiSectionFormatter();
    }

    public static LinkFormatter getLinkFormatter() {
        return new WikiLinkFormatter();
    }

    public static ListFormatter getListFormatter() {
        return new WikiListFormatter();
    }
}
