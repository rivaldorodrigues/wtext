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


import com.github.hivakun.wtext.arq.formatter.ListFormatter;
import com.github.hivakun.wtext.module.list.List;
import com.github.hivakun.wtext.wiki.markup.WikiListMarkup;
import com.github.hivakun.wtext.module.list.ListItem;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;

/**
 * Implements the mediawiki list formatting strategy.
 * @see List
 *
 * @author hivakun
 * Created on 01/05/16
 */
public class WikiListFormatter implements ListFormatter {

    @Override
    public String ordered(Collection<ListItem> itens) {
        return format(itens, WikiListMarkup.ORDERED);
    }

    @Override
    public String unordered(Collection<ListItem> itens) {
        return format(itens, WikiListMarkup.UNORDERED);
    }

    /**
     * Format the list of items into the desired list
     *
     * @param items the list of items
     * @param type the desired list type
     * @return a string formatted with the list markup
     */
    private String format(@NotNull Collection<ListItem> items, WikiListMarkup type) {
        StringBuilder sBuilder = new StringBuilder();
        items.forEach(item -> sBuilder.append(type.apply(item.getLevel(), item.toString())));

        return sBuilder.toString();
    }
}
