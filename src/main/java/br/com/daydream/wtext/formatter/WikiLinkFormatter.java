package br.com.daydream.wtext.formatter;

import br.com.daydream.wtext.arq.formatter.LinkFormatter;
import br.com.daydream.wtext.markup.LinkType;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;

/**
 * Created by Rivaldo on 01/05/16.
 */
public class WikiLinkFormatter implements LinkFormatter {

    private static final String SECTION_SEPARATOR = "#";

    @Override
    public String internal(String text, String rename) {
        return LinkType.INTERNAL.apply(text, rename);
    }

    @Override
    public String external(String text, String rename) {
        return LinkType.EXTERNAL.apply(text, rename);
    }

    @Override
    public String file(String text, String rename) {
        return LinkType.FILE.apply(text, rename);
    }

    @Override
    public String section(String section, String page, String rename) {
        return internal(getSectionLink(section, page), rename);
    }

    private static String getSectionLink(@NotNull String section, String page) {
        String nPage = StringUtils.isNoneEmpty(page) ? page : "";
        return nPage + SECTION_SEPARATOR + section;
    }
}
