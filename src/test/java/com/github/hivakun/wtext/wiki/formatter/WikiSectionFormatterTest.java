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
public class WikiSectionFormatterTest {

    private WikiSectionFormatter formatter = new WikiSectionFormatter();

    @Test
    public void section() throws Exception {
        String expected = "== text ==";
        String result = formatter.section("text");

        Assert.assertEquals(expected, result);
    }

    @Test
    public void subsection() throws Exception {
        String expected = "=== text ===";
        String result = formatter.subsection("text");

        Assert.assertEquals(expected, result);
    }

    @Test
    public void subSubsection() throws Exception {
        String expected = "==== text ====";
        String result = formatter.subSubsection("text");

        Assert.assertEquals(expected, result);
    }

}