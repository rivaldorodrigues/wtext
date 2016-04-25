package br.com.daydream.wtext.markup.table;

/**
 * @author rivaldo
 *         Created on 25/04/2016.
 */
public enum CellType {

    CAPTION("|+ ","\n"),

    HEADER("! ", "\n"),

    DATA("||", "");

    private final String initialMarkup;
    private final String finalMarkup;

    CellType(String initialMarkup, String finalMarkup) {
        this.initialMarkup = initialMarkup;
        this.finalMarkup = finalMarkup;
    }

    public String apply(String text) {
        return initialMarkup + text + finalMarkup;
    }
}
