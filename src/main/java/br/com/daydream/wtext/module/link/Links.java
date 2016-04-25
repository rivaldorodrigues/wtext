package br.com.daydream.wtext.module.link;

import br.com.daydream.wtext.markup.LinkType;
import com.sun.istack.internal.NotNull;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by Rivaldo on 23/04/16.
 */
public final class Links {

    private static final String SECTION_SEPARATOR = "#";

    public static Link newInternalLink(@NotNull String link) {
        return newInternalLink(link, "");
    }

    public static Link newInternalLink(@NotNull String link, String rename) {
        return new Link(LinkType.INTERNAL.apply(link, rename));
    }

    public static Link newExternalLink(@NotNull String link) {
        return newExternalLink(link, "");
    }

    public static Link newExternalLink(@NotNull String link, String rename) {
        return new Link(LinkType.EXTERNAL.apply(link, rename));
    }

    public static Link newSectionLink(@NotNull String section) {
        return newInternalLink(getSectionLink(section, ""));
    }

    public static Link newSectionLink(@NotNull String section, String page) {
        return newInternalLink(getSectionLink(section, page));
    }


    public static Link newSectionLink(@NotNull String section, String page, String rename) {
        return newInternalLink(getSectionLink(section, page), rename);
    }

    private static String getSectionLink(@NotNull String section, String page) {
        String nPage = StringUtils.isNoneEmpty(page) ? page : "";
        return nPage + SECTION_SEPARATOR + section;
    }
}
