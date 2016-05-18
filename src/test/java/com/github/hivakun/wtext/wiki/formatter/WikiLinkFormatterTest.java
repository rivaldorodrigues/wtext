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
 * Created on 12/05/2016.
 */
public class WikiLinkFormatterTest {

    private final String EXTERNAL_LINK = "[http://www.wikipedia.org]";
    private final String RENAMED_EXTERNAL_LINK = "[http://www.wikipedia.org Wikipedia]";

    private final String INTERNAL_LINK = "[[Texas]]";
    private final String RENAMED_INTERNAL_LINK = "[[Texas|Lone Star State]]";

    private final String SECTION = "[[#Links and URLs]]";
    private final String SECTION_PAGE = "[[Wikipedia:Manual of Style#Italics]]";
    private final String RENAMED_SECTION_PAGE = "[[Wikipedia:Manual of Style#Italics|Italics]]";

    private final String FILE_LINK = "[[:File:Overview.pdf]]";
    private final String RENAMED_FILE_LINK = "[[:File:Overview.pdf|PDF]]";

    private WikiLinkFormatter formatter = new WikiLinkFormatter();

    @Test
    public void externalLink() throws Exception {
        String result = formatter.external("http://www.wikipedia.org", "");
        Assert.assertEquals(EXTERNAL_LINK, result);
    }

    @Test
    public void renamedExternalLink() throws Exception {
        String result = formatter.external("http://www.wikipedia.org", "Wikipedia");
        Assert.assertEquals(RENAMED_EXTERNAL_LINK, result);
    }

    @Test
    public void internalLink() throws Exception {
        String result = formatter.internal("Texas", "");
        Assert.assertEquals(INTERNAL_LINK, result);
    }

    @Test
    public void renamedInternalLink() throws Exception {
        String result = formatter.internal("Texas", "Lone Star State");
        Assert.assertEquals(RENAMED_INTERNAL_LINK, result);
    }

    @Test
    public void sectionLink() throws Exception {
        String result = formatter.section("Links and URLs", "", "");
        Assert.assertEquals(SECTION, result);
    }

    @Test
    public void sectionPageLink() throws Exception {
        String result = formatter.section("Italics", "Wikipedia:Manual of Style", "");
        Assert.assertEquals(SECTION_PAGE, result);
    }

    @Test
    public void renamedSectionPageLink() throws Exception {
        String result = formatter.section("Italics", "Wikipedia:Manual of Style", "Italics");
        Assert.assertEquals(RENAMED_SECTION_PAGE, result);
    }

    @Test
    public void fileLink() throws Exception {
        String result = formatter.file("Overview.pdf", "");
        Assert.assertEquals(FILE_LINK, result);
    }

    @Test
    public void renamedFileLink() throws Exception {
        String result = formatter.file("Overview.pdf", "PDF");
        Assert.assertEquals(RENAMED_FILE_LINK, result);
    }
}