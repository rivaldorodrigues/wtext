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


import com.github.hivakun.wtext.module.table.Cell;
import com.github.hivakun.wtext.module.table.Cells;
import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author hivakun
 * Created on 16/05/2016.
 */
public class WikiTableFormatterTest {

    private WikiTableFormatter formatter = new WikiTableFormatter();

    @Test
    public void border() throws Exception {
        String expected = "border=\"2\"";
        String result = formatter.border(2);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void cellPadding() throws Exception {
        String expected = "cellpadding=\"2\"";
        String result = formatter.cellPadding(2);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void cellSpacing() throws Exception {
        String expected = "cellspacing=\"2\"";
        String result = formatter.cellSpacing(2);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void formatTable() throws Exception {

        String expected = "{|\n" +
                "! text\n" +
                "! text\n" +
                "|-\n" +
                "||text||text\n" +
                "|-\n" +
                "|}";

        List<Cell> items = Arrays.asList(Cells.newCell("text"), Cells.newCell("text"));

        List<List<Cell>> rows = Lists.newArrayList();
        rows.add(items);

        String result = formatter.formatTable(items, "text", rows, null);

        Assert.assertEquals(expected, result);
    }

}