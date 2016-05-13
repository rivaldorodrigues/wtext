package br.com.daydream.wtext.wiki.formatter;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author rivaldo
 *         Created on 12/05/2016.
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