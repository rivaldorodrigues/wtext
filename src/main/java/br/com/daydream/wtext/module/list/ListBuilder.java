package br.com.daydream.wtext.module.list;

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


import br.com.daydream.wtext.arq.formatter.FormatterFactory;
import br.com.daydream.wtext.arq.formatter.ListFormatter;
import br.com.daydream.wtext.arq.module.Text;
import com.google.common.collect.Lists;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;

/**
 * Builder class to create lists.
 * @see List
 *
 * @author hivakun
 * Created on 30/04/16
 */
public class ListBuilder {

    private Collection<ListItem> itens = Lists.newArrayList();
    private ListFormatter formatter = FormatterFactory.getListFormatter();

    private static final int DEFAULT_LEVEL = 1;

    /**
     * Add a new item in the list at level one.
     *
     * @param item the item to be inserted
     * @return the builder itself
     */
    public ListBuilder addItem(String item) {
        return addItem(DEFAULT_LEVEL, item);
    }

    /**
     * Add a new item in the list at level one.
     *
     * @param item the item to be inserted
     * @return the builder itself
     */
    public ListBuilder addItem(@NotNull Text item) {
        return addItem(DEFAULT_LEVEL, item);
    }

    /**
     * Add a new item in the list at the specified level.
     *
     * @param level the item level at the list hierarchy
     * @param item the item to be inserted
     * @return the builder itself
     */
    public ListBuilder addItem(int level, String item) {
        itens.add(new ListItem(level, item));
        return this;
    }

    /**
     * Add a new item in the list at the specified level.
     *
     * @param level the item level at the list hierarchy
     * @param item the item to be inserted
     * @return the builder itself
     */
    public ListBuilder addItem(int level, @NotNull Text item) {
        itens.add(new ListItem(level, item.toString()));
        return this;
    }

    /**
     * Create an unordered list.
     *
     * @return the list element
     */
    public List buildUnorderedList() {
        return new List(formatter.unordered(itens));
    }

    /**
     * Create an ordered list.
     *
     * @return the list element
     */
    public List buildOrderedList() {
        return new List(formatter.ordered(itens));
    }
}
