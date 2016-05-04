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
 * Created by Rivaldo on 30/04/16.
 */
public class ListBuilder {

    private static final int DEFAULT_LEVEL = 1;

    private Collection<ListItem> itens = Lists.newArrayList();

    private static ListFormatter formatter = FormatterFactory.getListFormatter();

    public ListBuilder addItem(@NotNull String text) {
        return addItem(DEFAULT_LEVEL, text);
    }

    public ListBuilder addItem(int level, @NotNull String text) {
        itens.add(new ListItem(level, text));
        return this;
    }

    public ListBuilder addItem(@NotNull Text text) {
        return addItem(DEFAULT_LEVEL, text);
    }

    public ListBuilder addItem(int level, @NotNull Text text) {
        itens.add(new ListItem(level, text));
        return this;
    }

    public List buildUnorderedList() {
        return new List(formatter.unordered(itens));
    }

    public List buildOrderedList() {
        return new List(formatter.ordered(itens));
    }

}
