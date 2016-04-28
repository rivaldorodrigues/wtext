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


import br.com.daydream.wtext.markup.source.SourceParameter;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.ArrayUtils;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

/**
 * @author rivaldo
 *         Created on 26/04/2016.
 */
public class SourceBuilder {

    StringBuilder sourcer = new StringBuilder();
    Map<SourceParameter, String> parameters = Maps.newHashMap();

    public SourceBuilder withLang(String val) {
        parameters.put(SourceParameter.LANG, val);
        return this;
    }

    public SourceBuilder withTitle(String val) {
        parameters.put(SourceParameter.TITLE, val);
        return this;
    }

    public SourceBuilder withHighLight(int... val) {

        if (ArrayUtils.isNotEmpty(val)) {
            parameters.put(SourceParameter.HIGHLIGHT, getHighlightParameters(val));
        }

        return this;
    }

    public SourceBuilder append(String source) {
        sourcer.append(source);
        return this;
    }

    public SourceBuilder newLine() {
        sourcer.append("\n");
        return this;
    }

    public Source build() {
        return new Source(this);
    }

    private String getHighlightParameters(@NotNull int... val) {

        StringBuilder sBuilder = new StringBuilder();
        sBuilder.append(val[0]);

        for (int i = 1; i < val.length; ++i) {
            sBuilder.append(",").append(val[i]);
        }

        return sBuilder.toString();
    }
}
