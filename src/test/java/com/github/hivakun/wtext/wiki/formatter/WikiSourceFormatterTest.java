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


import org.junit.Assert;
import org.junit.Test;

/**
 * @author hivakun
 * Created on 16/05/2016.
 */
public class WikiSourceFormatterTest {

    private WikiSourceFormatter formatter = new WikiSourceFormatter();

    @Test
    public void paramLang() throws Exception {
        String expected = "lang=\"java\"";
        String result = formatter.paramLang("java");

        Assert.assertEquals(expected, result);
    }

    @Test
    public void paramTitle() throws Exception {
        String expected = "title=\"'text'\"";
        String result = formatter.paramTitle("text");

        Assert.assertEquals(expected, result);
    }

    @Test
    public void paramHighlight() throws Exception {
        String expected = "highlight=\"[1,2]\"";
        String result = formatter.paramHighlight("1,2");

        Assert.assertEquals(expected, result);
    }

    @Test
    public void getHighlightAsText() throws Exception {
        String expected = "1,2";
        String result = formatter.getHighlightAsText(1,2);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void formatSourcer() throws Exception {
        String expected = "<source>\ntext\n</source>";
        String result = formatter.formatSourcer("text", null);

        Assert.assertEquals(expected, result);
    }
}