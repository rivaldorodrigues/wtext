package br.com.daydream.wtext.formatter;

import br.com.daydream.wtext.arq.formatter.SectionFormatter;
import br.com.daydream.wtext.markup.SectionMarkup;

/**
 * Created by Rivaldo on 01/05/16.
 */
public class WikiSectionFormatter implements SectionFormatter {

    @Override
    public String section(String text) {
        return SectionMarkup.SECTIONS.apply(text);
    }

    @Override
    public String subsection(String text) {
        return SectionMarkup.SUBSECTION.apply(text);
    }

    @Override
    public String subSubsection(String text) {
        return SectionMarkup.SUB_SUBSECTION.apply(text);
    }
}
