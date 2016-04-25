package br.com.daydream.wtext.markup.table;

/**
 * @author rivaldo
 * Created on 25/04/2016.
 */
public enum TableParameters {

    BORDER("border=\"", "\""),

    CELL_PADDING("cellpadding=\"", "\""),

    CELL_SPACING("cellspacing=\"", "\"");

    private final String initialMarkup;
    private final String finalMarkup;

    TableParameters(String initialMarkup, String finalMarkup) {
        this.initialMarkup = initialMarkup;
        this.finalMarkup = finalMarkup;
    }

    public String apply(String text) {
        return initialMarkup + text + finalMarkup;
    }
}
