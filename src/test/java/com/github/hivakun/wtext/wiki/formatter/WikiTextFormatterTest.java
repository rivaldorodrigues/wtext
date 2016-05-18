package com.github.hivakun.wtext.wiki.formatter;

/*
 * #%L
 * WText
 * %%
 * Copyright (C) 2016 Daydream
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-3.0.html>.
 * #L%
 */


import com.github.hivakun.wtext.arq.formatter.TextFormatter;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author hivakun
 * Created on 11/05/2016.
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