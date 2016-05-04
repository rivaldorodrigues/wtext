package br.com.daydream.wtext.formatter;

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


import br.com.daydream.wtext.arq.formatter.ListFormatter;
import br.com.daydream.wtext.markup.ListType;
import br.com.daydream.wtext.module.list.ListItem;

import java.util.Collection;

/**
 * Created by Rivaldo on 01/05/16.
 */
public class WikiListFormatter implements ListFormatter {

    @Override
    public String ordered(Collection<ListItem> itens) {
        return format(itens, ListType.ORDERED);
    }

    @Override
    public String unordered(Collection<ListItem> itens) {
        return format(itens, ListType.UNORDERED);
    }

    private String format(Collection<ListItem> itens, ListType type) {
        StringBuilder sBuilder = new StringBuilder();
        itens.forEach(item -> sBuilder.append(type.apply(item.getLevel(), item.toString())));

        return sBuilder.toString();
    }
}
