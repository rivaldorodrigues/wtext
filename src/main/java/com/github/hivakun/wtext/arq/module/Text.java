package com.github.hivakun.wtext.arq.module;

/*
 * #%L
 * WText
 * %%
 * Copyright (C) 2016 Rivaldo Rodrigues
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


import com.github.hivakun.wtext.arq.parameter.TextFormat;
import org.apache.commons.lang3.builder.EqualsBuilder;

/**
 * Represents a simple text element of the document.
 * This element can be formatted.
 *
 * @author hivakun
 * Created on 01/05/16
 */
public class Text extends Element {

    /**
     * Create a new text element.
     *
     * @param text the string that represents the text
     */
    public Text(String text) {
        super(text);
    }

    /**
     * Create a new text element with the desired format.
     *
     * @param text the string that represents the text
     * @param format the style to format the text
     */
    public Text(String text, TextFormat format) {
        super(text);
        format(format);
    }

    /**
     * Format the text.
     *
     * @param format the style to format the text
     */
    public void format(TextFormat format) {
        element = format.apply(element);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof Text)) return false;

        Text other = (Text) o;

        return new EqualsBuilder()
                .append(element, other.element)
                .isEquals();
    }
}
