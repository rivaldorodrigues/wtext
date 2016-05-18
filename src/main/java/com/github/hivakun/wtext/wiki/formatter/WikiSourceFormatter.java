package com.github.hivakun.wtext.wiki.formatter;

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


import com.github.hivakun.wtext.arq.formatter.SourceFormatter;
import com.github.hivakun.wtext.wiki.markup.WikiSourceMarkup;
import com.github.hivakun.wtext.arq.parameter.SourceParameter;
import com.github.hivakun.wtext.module.source.Source;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

/**
 * Implements the mediawiki source formatting strategy.
 * @see Source
 *
 * @author hivakun
 * Created on 01/05/16
 */
public class WikiSourceFormatter implements SourceFormatter {

    private static final String HIGHLIGHT_SEPARATOR = ",";

    @Override
    public String paramLang(@NotNull Object val) {
        return WikiSourceMarkup.LANG.apply(val.toString());
    }

    @Override
    public String paramTitle(@NotNull Object val) {
        return WikiSourceMarkup.TITLE.apply(val.toString());
    }

    @Override
    public String paramHighlight(@NotNull Object val) {
        return WikiSourceMarkup.HIGHLIGHT.apply(val.toString());
    }

    @Override
    public String getHighlightAsText(int... val) {

        StringBuilder sBuilder = new StringBuilder();

        if (ArrayUtils.isNotEmpty(val)) {
            sBuilder.append(val[0]);

            for (int i = 1; i < val.length; ++i) {
                sBuilder.append(HIGHLIGHT_SEPARATOR).append(val[i]);
            }
        }

        return sBuilder.toString();
    }

    @Override
    public String formatSourcer(String sourcer, Map<SourceParameter, Object> param) {
        StringBuilder sBuilder = new StringBuilder(initSourceAndStyle(param));
        sBuilder.append(sourcer);

        return WikiSourceMarkup.SOURCE_END.apply(sBuilder.toString());
    }

    /**
     * Initialize the source markup with the specified parameters.
     *
     * @param param the desired parameters
     * @return a string formatted with the source markup
     */
    private String initSourceAndStyle(Map<SourceParameter, Object> param) {

        StringBuilder sBuilder = new StringBuilder();

        if (MapUtils.isNotEmpty(param)) {
            param.forEach((k, v) -> sBuilder.append(" ").append(k.apply(v.toString())));
        }

        return WikiSourceMarkup.SOURCE_START.apply(sBuilder.toString());
    }
}
