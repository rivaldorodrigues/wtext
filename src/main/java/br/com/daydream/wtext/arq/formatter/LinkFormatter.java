package br.com.daydream.wtext.arq.formatter;

/**
 * Created by Rivaldo on 01/05/16.
 */
public interface LinkFormatter {

    String internal(String link, String rename);

    String external(String link, String rename);

    String file(String link, String rename);

    String section(String section, String page, String rename);

}
