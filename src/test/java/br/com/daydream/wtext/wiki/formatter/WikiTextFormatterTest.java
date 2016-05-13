package br.com.daydream.wtext.wiki.formatter;

import br.com.daydream.wtext.arq.formatter.TextFormatter;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author rivaldo
 *         Created on 11/05/2016.
 */
public class WikiTextFormatterTest {

    private TextFormatter formatter = new WikiTextFormatter();

    @Test
    public void bold() throws Exception {
        String expected = "'''text'''";
        String result = formatter.bold("text");

        Assert.assertEquals(expected, result);
    }

    @Test
    public void italic() throws Exception {
        String expected = "''text''";
        String result = formatter.italic("text");

        Assert.assertEquals(expected, result);
    }

    @Test
    public void italicBold() throws Exception {
        String expected = "'''''text'''''";
        String result = formatter.italicBold("text");

        Assert.assertEquals(expected, result);
    }

    @Test
    public void smallCaps() throws Exception {
        String expected = "{{smallcaps|text}}";
        String result = formatter.smallCaps("text");

        Assert.assertEquals(expected, result);
    }

    @Test
    public void code() throws Exception {
        String expected = "<code>text</code>";
        String result = formatter.code("text");

        Assert.assertEquals(expected, result);
    }

    @Test
    public void small() throws Exception {
        String expected = "<small>text</small>";
        String result = formatter.small("text");

        Assert.assertEquals(expected, result);
    }

    @Test
    public void big() throws Exception {
        String expected = "<big>text</big>";
        String result = formatter.big("text");

        Assert.assertEquals(expected, result);
    }

    @Test
    public void blockQuote() throws Exception {
        String expected = "<blockquote>text</blockquote>";
        String result = formatter.blockQuote("text");

        Assert.assertEquals(expected, result);
    }

    @Test
    public void center() throws Exception {
        String expected = "<center>text</center>";
        String result = formatter.center("text");

        Assert.assertEquals(expected, result);
    }

}