package com.github.hivakun.wtext.module.list;

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


import com.github.hivakun.wtext.arq.module.Text;
import org.apache.commons.lang3.builder.EqualsBuilder;

/**
 * Represents an item at a list element at the document.
 * @see List
 *
 * @author hivakun
 * Created on 30/04/16
 */
public class ListItem extends Text {

    protected int level;

    /**
     * Create a new list item element.
     *
     * @param level the level of the item in the list
     * @param item  the item
     */
    public ListItem(int level, String item) {
        super(item);
        this.level = (level > 0) ? level : 1;
    }

    /**
     * Get the item level at the list hierarchy.
     *
     * @return the item level at the list hierarchy
     */
    public int getLevel() {
        return level;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof ListItem)) return false;

        ListItem other = (ListItem) o;

        return new EqualsBuilder()
                .append(element, other.element)
                .isEquals();
    }
}
