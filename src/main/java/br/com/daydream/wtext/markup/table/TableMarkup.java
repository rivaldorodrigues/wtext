package br.com.daydream.wtext.markup.table;

/**
 * @author rivaldo
 *         Created on 25/04/2016.
 */
public enum TableMarkup {

    TABLE_START("{| ", "\n"),

    TABLE_END("\n", "|}"),

    ROW("|-\n", "\n|-");

    private final String initialMarkup;
    private final String finalMarkup;

    TableMarkup(String initialMarkup, String finalMarkup) {
        this.initialMarkup = initialMarkup;
        this.finalMarkup = finalMarkup;
    }

    public String apply(String text) {
        return initialMarkup + text + finalMarkup;
    }
}
