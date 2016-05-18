package com.github.hivakun.wtext.arq.module;

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


import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Represents a simple element of the document.
 *
 * @author hivakun
 * Created on 23/04/16
 */
public abstract class Element {

    protected String element;

    /**
     * Create a new element.
     * @param element the string that represents the element
     */
    protected Element(String element) {
        this.element = element;
    }

    @Override
    public String toString() {
        return element;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(element)
                .toHashCode();
    }
}
