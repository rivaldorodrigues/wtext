package br.com.daydream.wtext.module.source;

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


import br.com.daydream.wtext.markup.source.SourceMarkup;
import br.com.daydream.wtext.markup.source.SourceParameter;
import br.com.daydream.wtext.arq.module.Element;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.Map;

/**
 * @author rivaldo
 * Created on 26/04/2016.
 */
public class Source extends Element {

    Source(SourceBuilder builder) {
        super("");
        element = format(builder);
    }

    private String format(SourceBuilder builder) {
        StringBuilder sBuilder = new StringBuilder(initSourceAndStyle(builder.parameters));
        sBuilder.append(builder.sourcer.toString());

        return SourceMarkup.SOURCE_END.apply(sBuilder.toString());
    }

    private String initSourceAndStyle(Map<SourceParameter, String> param) {

        StringBuilder sBuilder = new StringBuilder();

        if (MapUtils.isNotEmpty(param)) {
            param.forEach((k, v) -> sBuilder.append(" ").append(k.apply(v)));
        }

        return SourceMarkup.SOURCE_START.apply(sBuilder.toString());
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof Source)) return false;

        Source other = (Source) o;

        return new EqualsBuilder()
                .append(element, other.element)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(element)
                .toHashCode();
    }
}
