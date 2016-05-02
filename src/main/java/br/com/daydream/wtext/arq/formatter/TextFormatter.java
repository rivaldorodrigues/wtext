package br.com.daydream.wtext.arq.formatter;

/**
 * Created by Rivaldo on 01/05/16.
 */
public interface TextFormatter {

    String bold(String text);

    String italic(String text);

    String italicBold(String text);

    String smallCaps(String text);

    String code(String text);

    String small(String text);

    String big(String text);

    String blockQuote(String text);

    String center(String text);
}
