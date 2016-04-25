package br.com.daydream.wtext.markup;

/**
 * Created by Rivaldo on 23/04/16.
 */
public enum Sections {

    SECTIONS("== "," =="),

    SUBSECTION("=== ", " ==="),

    SUB_SUBSECTION("====", " ====");

    private final String initialMarkup;
    private final String finalMarkup;

    Sections(String initialMarkup, String finalMarkup) {
        this.initialMarkup = initialMarkup;
        this.finalMarkup = finalMarkup;
    }

    public String apply(String text) {
        return initialMarkup + text + finalMarkup;
    }
}
