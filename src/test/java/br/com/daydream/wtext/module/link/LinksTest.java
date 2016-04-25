package br.com.daydream.wtext.module.link;

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
 * Created by Rivaldo on 23/04/16.
 */
public class LinksTest {

    private static final String EXTERNAL_LINK = "[http://www.wikipedia.org]";
    private static final String RENAMED_EXTERNAL_LINK = "[http://www.wikipedia.org Wikipedia]";

    private static final String INTERNAL_LINK = "[[Texas]]";
    private static final String RENAMED_INTERNAL_LINK = "[[Texas|Lone Star State]]";

    private static final String SECTION = "[[#Links and URLs]]";
    private static final String SECTION_PAGE = "[[Wikipedia:Manual of Style#Italics]]";
    private static final String RENAMED_SECTION_PAGE = "[[Wikipedia:Manual of Style#Italics|Italics]]";

    @Test
    public void externalLink() throws Exception {
        Link link = Links.newExternalLink("http://www.wikipedia.org");
        Assert.assertTrue(EXTERNAL_LINK.equals(link.toString()));
    }

    @Test
    public void renamedExternalLink() throws Exception {
        Link link = Links.newExternalLink("http://www.wikipedia.org", "Wikipedia");
        Assert.assertTrue(RENAMED_EXTERNAL_LINK.equals(link.toString()));
    }

    @Test
    public void internalLink() throws Exception {
        Link link = Links.newInternalLink("Texas");
        Assert.assertTrue(INTERNAL_LINK.equals(link.toString()));
    }

    @Test
    public void renamedInternalLink() throws Exception {
        Link link = Links.newInternalLink("Texas", "Lone Star State");
        Assert.assertTrue(RENAMED_INTERNAL_LINK.equals(link.toString()));
    }

    @Test
    public void sectionLink() throws Exception {
        Link link = Links.newSectionLink("Links and URLs");
        Assert.assertTrue(SECTION.equals(link.toString()));
    }

    @Test
    public void sectionPageLink() throws Exception {
        Link link = Links.newSectionLink("Italics", "Wikipedia:Manual of Style");
        Assert.assertTrue(SECTION_PAGE.equals(link.toString()));
    }

    @Test
    public void renamedSectionPageLink() throws Exception {
        Link link = Links.newSectionLink("Italics", "Wikipedia:Manual of Style", "Italics");
        Assert.assertTrue(RENAMED_SECTION_PAGE.equals(link.toString()));
    }
}