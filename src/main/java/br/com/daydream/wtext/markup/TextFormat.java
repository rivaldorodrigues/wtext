package br.com.daydream.wtext.markup;

/**
 * Created by Rivaldo on 23/04/16.
 */
public enum TextFormat {

    BOLD("'''", "'''"),

    ITALIC("''", "''"),

    ITALIC_BOLD("'''''", "'''''"),

    SMALLCAPS("{{smallcaps|", "}}"),

    CODE("<code>", "</code>"),

    SMALL("<small>", "</small>"),

    BIG("<big>", "t</big>");


    final String initialMarkup;
    final String finalMarkup;

    TextFormat(String initialMarkup, String finalMarkup) {
        this.initialMarkup = initialMarkup;
        this.finalMarkup = finalMarkup;
    }

    public String apply(String text) {
        return initialMarkup + text + finalMarkup;
    }
}