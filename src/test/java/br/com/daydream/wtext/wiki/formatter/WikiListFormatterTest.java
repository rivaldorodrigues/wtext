package br.com.daydream.wtext.wiki.formatter;

import org.junit.Test;

/**
 * @author rivaldo
 *         Created on 13/05/2016.
 */
public class WikiListFormatterTest {

    private WikiListFormatter formatter = new WikiListFormatter();

    @Test
    public void ordered() throws Exception {
        String expected = "*Item 1\n" + "**Sub-item 2";
    }

    @Test
    public void unordered() throws Exception {

    }

}