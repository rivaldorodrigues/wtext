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


import com.github.hivakun.wtext.arq.module.DataContainer;
import com.github.hivakun.wtext.arq.module.Element;
import org.apache.commons.lang3.builder.EqualsBuilder;

/**
 * Represents a list element at the document.
 * @see ListItem
 *
 * @author hivakun
 * Created on 30/04/16
 */
public class List extends Element implements DataContainer {

    /**
     * Create a new list element.
     *
     * @param element the string that represents the element
     */
    protected List(String element) {
        super(element);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof List)) return false;

        List other = (List) o;

        return new EqualsBuilder()
                .append(element, other.element)
                .isEquals();
    }
}
