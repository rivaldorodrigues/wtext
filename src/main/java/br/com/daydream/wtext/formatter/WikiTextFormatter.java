package br.com.daydream.wtext.formatter;

import br.com.daydream.wtext.arq.formatter.TextFormatter;
import br.com.daydream.wtext.markup.WikiTextFormat;

/**
 * Created by Rivaldo on 01/05/16.
 */
public class WikiTextFormatter implements TextFormatter {

    @Override
    public String bold(String text) {
        return WikiTextFormat.BOLD.apply(text);
    }

    @Override
    public String italic(String text) {
        return WikiTextFormat.ITALIC.apply(text);
    }

    @Override
    public String italicBold(String text) {
        return WikiTextFormat.ITALIC_BOLD.apply(text);
    }

    @Override
    public String smallCaps(String text) {
        return WikiTextFormat.SMALLCAPS.apply(text);
    }

    @Override
    public String code(String text) {
        return WikiTextFormat.CODE.apply(text);
    }

    @Override
    public String small(String text) {
        return WikiTextFormat.SMALL.apply(text);
    }

    @Override
    public String big(String text) {
        return WikiTextFormat.BIG.apply(text);
    }

    @Override
    public String blockQuote(String text) {
        return WikiTextFormat.BLOCKQUOTE.apply(text);
    }

    @Override
    public String center(String text) {
        return WikiTextFormat.CENTER.apply(text);
    }
}
