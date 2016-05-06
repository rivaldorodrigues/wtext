package br.com.daydream.wtext.arq.formatter;

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


import br.com.daydream.wtext.module.list.ListItem;

import java.util.Collection;

/**
 * Interface to all classes that implement the list formatting strategy.
 * @see br.com.daydream.wtext.module.list.List
 *
 * @author hivakun
 * Created on 01/05/16
 */
public interface ListFormatter {

    /**
     * Apply the ordered list markup to the collection of {@code ListItem}.
     *
     * @param items the collection of the list elements
     * @return an ordered list with all desired elements
     */
    String ordered(Collection<ListItem> items);

    /**
     * Apply the unordered list markup to the collection of {@code ListItem}.
     *
     * @param items the collection of the list elements
     * @return an ordered list with all desired elements
     */
    String unordered(Collection<ListItem> items);
}
