package br.com.daydream.wtext.markup;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by Rivaldo on 23/04/16.
 */
public enum LinkType {

    INTERNAL("[[","|", "]]"),

    EXTERNAL("["," ", "]");

    private final String initialMarkup;
    private final String separatorMarkup;
    private final String finalMarkup;

    LinkType(String initialMarkup, String separatorMarkup, String finalMarkup) {
        this.initialMarkup = initialMarkup;
        this.separatorMarkup = separatorMarkup;
        this.finalMarkup = finalMarkup;
    }

    public String apply(String link, String rename) {
        String result = initialMarkup + link;

        if (StringUtils.isNoneEmpty(rename)) {
            result += separatorMarkup + rename;
        }

        return result + finalMarkup;
    }
}
