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


import br.com.daydream.wtext.arq.formatter.FormatterFactory;
import br.com.daydream.wtext.arq.formatter.SourceFormatter;
import br.com.daydream.wtext.arq.parameter.SourceParameter;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.ArrayUtils;

import java.util.Map;

/**
 * Builder class to create source.
 * @see Source
 *
 * @author hivakun
 * Created on 23/04/16
 */
public class SourceBuilder {

    private StringBuilder sourcer = new StringBuilder();
    private Map<SourceParameter, Object> parameters = Maps.newHashMap();

    private SourceFormatter formatter = FormatterFactory.getSourceFormatter();

    /**
     * Define the source language.
     *
     * @param val the desired source language
     * @return the builder itself
     */
    public SourceBuilder withLang(String val) {
        parameters.put(SourceParameter.LANG, val);
        return this;
    }

    /**
     * Define the source title.
     *
     * @param val the desired source title
     * @return the builder itself
     */
    public SourceBuilder withTitle(String val) {
        parameters.put(SourceParameter.TITLE, val);
        return this;
    }

    /**
     * Define the source line to be highlighted.
     *
     * @param val the desired source lines
     * @return the builder itself
     */
    public SourceBuilder withHighLight(int... val) {

        if (ArrayUtils.isNotEmpty(val)) {
            parameters.put(SourceParameter.HIGHLIGHT, formatter.getHighlightAsText(val));
        }

        return this;
    }

    /**
     * Append a text to the source.
     *
     * @param text the text to be appended
     * @return the builder itself
     */
    public SourceBuilder append(String text) {
        sourcer.append(text);
        return this;
    }

    /**
     * Create a source.
     *
     * @return the source element
     */
    public Source buildSource() {
        return new Source(formatter.formatSourcer(sourcer.toString(), parameters));
    }

}
