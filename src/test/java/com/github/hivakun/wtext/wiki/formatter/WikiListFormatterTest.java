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


import com.github.hivakun.wtext.module.list.ListItem;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author hivakun
 * Created on 13/05/2016.
 */
public class WikiListFormatterTest {

    private WikiListFormatter formatter = new WikiListFormatter();

    @Test
    public void ordered() throws Exception {
        String expected = "#Item 1\n" + "##Sub-item 2\n";

        List<ListItem> items = Arrays.asList(new ListItem(1, "Item 1"), new ListItem(2, "Sub-item 2"));
        String result = formatter.ordered(items);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void unordered() throws Exception {
        String expected = "*Item 1\n" + "**Sub-item 2\n";

        List<ListItem> items = Arrays.asList(new ListItem(1, "Item 1"), new ListItem(2, "Sub-item 2"));
        String result = formatter.unordered(items);

        Assert.assertEquals(expected, result);
    }

}